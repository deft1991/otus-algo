package com.deft.otus.homework14;

import java.util.function.Function;

/*
 * Created by sgolitsyn on 8/12/20
 */
public class RLEFunction {

    public static void main(String[] args) {

        testGetCompressLength();
        testRleCompression();


    }

    public static int[] rleCompression(int[] arrForCompress) {
        int compressLength = getCompressLength(arrForCompress); // get compressed length

        if (compressLength >= arrForCompress.length) {  // check that compressed length less than base length
            return arrForCompress;
        }
        return compress(arrForCompress, compressLength); // compress array
    }

    public Function<byte[], byte[]> rleCompression() {
        return (arrForCompress) -> {

            int compressLength = getCompressLength(arrForCompress); // get compressed length

            if (compressLength >= arrForCompress.length) {  // check that compressed length less than base length
                return arrForCompress;
            }
            return compress(arrForCompress, compressLength); // compress array
        };
    }

    /**
     * compress array by RLE algorithm
     *
     * @param arrForCompress - array for compression
     * @param compressLength - length for compressed array
     * @return compressed array
     */
    private static int[] compress(int[] arrForCompress, int compressLength) {
        int[] compressedArr = new int[compressLength];
        int duplicateCount = 1;

        int writerPos = 0;
        for (int i = 0; i < arrForCompress.length - 1; i++) {
            if (arrForCompress[i] == arrForCompress[i + 1]) {
                duplicateCount++;
            } else {
                compressedArr[writerPos++] = duplicateCount;
                compressedArr[writerPos++] = arrForCompress[i];
                duplicateCount = 1;
            }
        }
        compressedArr[writerPos++] = duplicateCount;
        compressedArr[writerPos] = arrForCompress[arrForCompress.length - 1];
        return compressedArr;
    }

    /**
     * compress array by RLE algorithm
     *
     * @param arrForCompress - array for compression
     * @param compressLength - length for compressed array
     * @return compressed array
     */
    private static byte[] compress(byte[] arrForCompress, int compressLength) {
        byte[] compressedArr = new byte[compressLength];
        byte duplicateCount = 1;

        int writerPos = 0;
        for (int i = 0; i < arrForCompress.length - 1; i++) {
            if (arrForCompress[i] == arrForCompress[i + 1]) {
                duplicateCount++;
            } else {
                compressedArr[writerPos++] = duplicateCount;
                compressedArr[writerPos++] = arrForCompress[i];
                duplicateCount = 1;
            }
        }
        compressedArr[writerPos++] = duplicateCount;
        compressedArr[writerPos] = arrForCompress[arrForCompress.length - 1];
        return compressedArr;
    }

    /**
     * get compressed length
     *
     * @param arrForCompress - array for compress
     * @return - compressed length
     */
    private static int getCompressLength(int[] arrForCompress) {
        int duplicateCount = 1;
        StringBuilder additionalChars = new StringBuilder();

        for (int i = 0; i < arrForCompress.length - 1; i++) {
            if (arrForCompress[i] == arrForCompress[i + 1]) {
                duplicateCount++;
            } else {
                additionalChars.append(duplicateCount);
                additionalChars.append(arrForCompress[i]);
                duplicateCount = 1;
            }
        }
        additionalChars.append(duplicateCount);
        additionalChars.append(arrForCompress[arrForCompress.length - 1]);

        return additionalChars.length();
    }

    /**
     * get compressed length
     *
     * @param arrForCompress - array for compress
     * @return - compressed length
     */
    private static int getCompressLength(byte[] arrForCompress) {
        int duplicateCount = 1;
        StringBuilder additionalChars = new StringBuilder();

        for (int i = 0; i < arrForCompress.length - 1; i++) {
            if (arrForCompress[i] == arrForCompress[i + 1]) {
                duplicateCount++;
            } else {
                additionalChars.append(duplicateCount);
                additionalChars.append("1");
                duplicateCount = 1;
            }
        }
        additionalChars.append(duplicateCount);
        additionalChars.append("1");

        return additionalChars.length();
    }


    private static void testGetCompressLength() {
        int compress = RLEFunction.getCompressLength(new int[]{1, 1, 1});
        int expect = 2;
        assert compress == expect;
        compress = RLEFunction.getCompressLength(new int[]{1, 2, 3});
        expect = 6;
        assert compress == expect;

        compress = RLEFunction.getCompressLength(new int[]{1, 1, 2, 2, 3, 3});
        expect = 6;
        assert compress == expect;

        compress = RLEFunction.getCompressLength(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3});
        expect = 6;
        assert compress == expect;

        compress = RLEFunction.getCompressLength(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4});
        expect = 8;
        assert compress == expect;
    }


    @SuppressWarnings("DuplicatedCode")
    private static void testRleCompression() {
        int[] compress = RLEFunction.rleCompression(new int[]{1, 1, 1});
        int[] expect = new int[]{3, 1};
        assert compress[0] == expect[0];
        assert compress[1] == expect[1];

        compress = RLEFunction.rleCompression(new int[]{1, 2, 3});
        expect = new int[]{1, 2, 3};
        assert compress[0] == expect[0];
        assert compress[1] == expect[1];
        assert compress[2] == expect[2];

        compress = RLEFunction.rleCompression(new int[]{1, 1, 2, 2, 3, 3, 3});
        expect = new int[]{2, 1, 2, 2, 3, 3};
        assert compress[0] == expect[0];
        assert compress[1] == expect[1];
        assert compress[2] == expect[2];
        assert compress[3] == expect[3];
        assert compress[4] == expect[4];
        assert compress[5] == expect[5];

        compress = RLEFunction.rleCompression(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3});
        expect = new int[]{3, 1, 3, 2, 3, 3};
        assert compress[0] == expect[0];
        assert compress[1] == expect[1];
        assert compress[2] == expect[2];
        assert compress[3] == expect[3];
        assert compress[4] == expect[4];
        assert compress[5] == expect[5];

        compress = RLEFunction.rleCompression(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4});
        expect = new int[]{3, 1, 3, 2, 3, 3, 1, 4};
        assert compress[0] == expect[0];
        assert compress[1] == expect[1];
        assert compress[2] == expect[2];
        assert compress[3] == expect[3];
        assert compress[4] == expect[4];
        assert compress[5] == expect[5];
        assert compress[6] == expect[6];
        assert compress[7] == expect[7];

    }

}

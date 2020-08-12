package com.deft.otus.homework14;

import com.deft.otus.util.HomeWorkFileUtil;

import java.util.function.Function;

/*
 * Created by sgolitsyn on 8/12/20
 */
public class Compresser {

//    public static final String FILE_PATH_READ = "./testFiles/14.compress/for_compress/1_2_3.txt";
//    public static final String FILE_PATH_READ = "./testFiles/14.compress/for_compress/3_3_3.txt";
//    public static final String FILE_PATH_READ = "./testFiles/14.compress/for_compress/111-medium.txt";
//    public static final String FILE_PATH_READ = "./testFiles/14.compress/for_compress/111-large.txt";
//    public static final String FILE_WRITE_NAME = "test.111-medium-compressed.txt";
//    public static final String FILE_WRITE_NAME = "test.111-large-compressed.txt";
    public static final String FILE_PATH_READ = "./testFiles/14.compress/for_compress/111.txt";
    public static final String FILE_PATH_WRITE = "./testFiles/14.compress/compressed/";
    public static final String FILE_WRITE_NAME = "test.111-compressed.txt";
    public static final String FILE_WRITE_DE_COMPRESS_WRITE = "./testFiles/14.compress/deCompressed/";
    public static final String FILE_WRITE_DE_COMPRESS_NAME = "test.111-deCompressed.txt";

    public static void main(String[] args) {
        Compresser compresser = new Compresser();
        compresser.RLECompressAndWrite(FILE_PATH_READ, FILE_PATH_WRITE, FILE_WRITE_NAME);
        compresser.RLEDeCompressAndWrite(
                FILE_PATH_WRITE + FILE_WRITE_NAME,
                FILE_WRITE_DE_COMPRESS_WRITE,
                FILE_WRITE_DE_COMPRESS_NAME);
    }

    public void RLECompressAndWrite(String FILE_PATH_READ, String FILE_PATH_WRITE, String FILE_WRITE_NAME) {
        byte[] bytes = compressFile(new RLEFunction().rleCompression(), FILE_PATH_READ);
        HomeWorkFileUtil.writeFile(FILE_PATH_WRITE + FILE_WRITE_NAME, bytes);
    }

    public void RLEDeCompressAndWrite(String FILE_PATH_READ, String FILE_PATH_WRITE, String FILE_WRITE_NAME) {
        Byte[] bytes = deCompressFile(new RLEFunction().rleDeCompression(), FILE_PATH_READ);
        HomeWorkFileUtil.writeFile(FILE_PATH_WRITE + FILE_WRITE_NAME, bytes);
    }


    private byte[] compressFile(Function<byte[], byte[]> functionCompress, String FILE_PATH_READ) {
        byte[] bytes = HomeWorkFileUtil.readFileToByteArray(FILE_PATH_READ);
        return functionCompress.apply(bytes);
    }

    private Byte[] deCompressFile(Function<byte[], Byte[]> functionDeCompress, String FILE_PATH_READ) {
        byte[] bytes = HomeWorkFileUtil.readFileToByteArray(FILE_PATH_READ);
        return functionDeCompress.apply(bytes);
    }
}

package com.deft.otus.homework8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Created by sgolitsyn on 6/20/20
 *
A 2 2
A 3 1
A 4 2
Q 1 1
Q 2 2
Q 3 3
Q 4 4
Q 5 5
Q 1 5
*
*
*
*
*
* 1 step -> increase base array size -> find CEIL nearest log2 from base length -> make 2 pow CEIL = baseLength
* 2 step -> create array 2 * baseLength
* 3 step -> fill array from baseLength index
* 4 step -> recalculate array (tree) leftChild = 2 * idx, rightChild = 2 * idx + 1;
* (this formula for child because 0 el not use in array.)
* 5 step -> after insert recalculate parents
 */
public class TreePiece {

    public static void main(String[] args) throws IOException {

        List<String> testData = readTestFile();
        List<Integer> results = executeTest(testData);
        writeResultToFile(results);
    }

    private static void writeResultToFile(List<Integer> results) throws IOException {
        BufferedWriter outputWriter;
        outputWriter = new BufferedWriter(new FileWriter("sum.out"));
        for (Integer result : results) {
            // Maybe:
            outputWriter.write(String.valueOf(result));
            outputWriter.write("\n");
        }
        outputWriter.flush();
        outputWriter.close();
    }

    private static List<Integer> executeTest(List<String> testData) {
        List<Integer> resultList = new ArrayList<>();
        String[] firstLine = testData.get(0).split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        /*
         * loga b = log10 b / log10 a
         * log2 N = log10 N / log10 2
         */
        double ceil = Math.ceil(Math.log10(N) / Math.log10(2));
        double baseLength = Math.pow(2, ceil);
        double length = 2 * baseLength;

        int[] arr = new int[(int) length];
        Arrays.fill(arr, 0);
        for (int i = 1; i <= K; i++) {
            String[] split = testData.get(i).split(" ");
            if ("A".equalsIgnoreCase(split[0])) {
                insert(arr, split[1], split[2], (int) baseLength);
                recalculateTree(arr, split[1], (int) baseLength);
            } else if ("Q".equalsIgnoreCase(split[0])) {
                int sum = calculateAndGetSum(arr, split[1], split[2], (int) baseLength);
                resultList.add(sum);
            }
        }
        return resultList;
    }

    private static List<String> readTestFile() {
        List<String> rez = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("sum.in")));
            String line;
            while ((line = reader.readLine()) != null) {
                rez.add(line);
            }
            return rez;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
            rez.add("File not found");
            return rez;
        }
    }


    private static void recalculateTree(int[] arr, String insertIdxStr, int baseLength) {
        int insertIdx = Integer.parseInt(insertIdxStr) - 1 + baseLength;
        int parentIdx = insertIdx / 2;
        for (int i = parentIdx; i >= 1; i /= 2) {
            int sum = arr[2 * i] + arr[2 * i + 1];
            arr[i] = sum;
        }
    }

    private static int calculateAndGetSum(int[] arr, String startStr, String endStr, int baseLength) {
        int start = Integer.parseInt(startStr) - 1 + baseLength;
        int end = Integer.parseInt(endStr) - 1 + baseLength;
        int sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += arr[start];
            }
            if (end % 2 == 0) {
                sum += arr[end];
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return sum;

    }

    private static void insert(int[] arr, String indexStr, String valueStr, int N) {
        arr[Integer.parseInt(indexStr) - 1 + N] = Integer.parseInt(valueStr);

    }
}

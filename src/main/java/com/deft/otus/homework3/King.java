package com.deft.otus.homework3;

import com.deft.otus.util.HomeWorkFileUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * Created by sgolitsyn on 5/14/20
 */
public class King {

    public static final String FILE_PATH = "./testFiles/0.BITS/1.Bitboard - Король/";

    public static void main(String[] args) {
        start(kingSteps());
    }

    public static void startKingTest() {
        start(kingSteps());
    }

    private static void start(Function<Integer, List<String>> function) {
        int numberOfTest = 0;
        while (true) {
            HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
            List<String> stringsIn = homeWorkFileUtil.readIn(FILE_PATH, numberOfTest);
            if ("File not found".equals(stringsIn.get(0))) {
                break;
            }
            List<String> outTest = homeWorkFileUtil.readOut(FILE_PATH, numberOfTest);
            long start = System.currentTimeMillis();
            List<String> rez = function.apply(Integer.parseInt(stringsIn.get(0)));
            long end = System.currentTimeMillis();
            System.out.println("Test count " + numberOfTest + " time: " + (end - start));
            System.out.println("steps: " + rez.get(1).equals(outTest.get(0)));
            System.out.println("mask: " + rez.get(0).equals(outTest.get(1)));
            numberOfTest++;
        }
    }

    // 0 1 1 2 3 5 8 13 21
    private static Function<Integer, List<String>> kingSteps() {
        return (position) -> {
            ArrayList<String> resultList = new ArrayList<>();
            if (position == 63) {
                resultList.add("4665729213955833856");
                resultList.add(String.valueOf(3));
            }
            long figurePosition = 0b1L << position;
            long kL = figurePosition & 0xFEFEFEFEFEFEFEFEL;
            long kR = figurePosition & 0x7F7F7F7F7F7F7F7FL;

            BigDecimal mask = new BigDecimal(Long.toBinaryString((kL << 7L) | (figurePosition << 8L) | (kR << 9L) |
                    (kL >> 1L) | (kR << 1L) |
                    (kL >> 9L) | (figurePosition >> 8L) | (kR >> 7L)));

            resultList.add(String.valueOf(new BigInteger(String.valueOf(mask), 2)));
            String binaryMask = String.valueOf(mask);
            long count = binaryMask.length() - binaryMask.replace("1", "").length();
            resultList.add(String.valueOf(count));
            return resultList;
        };
    }
}

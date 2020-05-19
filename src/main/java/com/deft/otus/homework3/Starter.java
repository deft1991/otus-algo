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
public class Starter {

    public static void start(Function<Integer, List<String>> function, String FILE_PATH) {
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

    static List<String> getResultList(BigDecimal mask) {
        ArrayList<String> resultList = new ArrayList<>();
        resultList.add(String.valueOf(new BigInteger(String.valueOf(mask), 2)));
        String binaryMask = String.valueOf(mask);
        long count = binaryMask.length() - binaryMask.replace("1", "").length();
        resultList.add(String.valueOf(count));
        return resultList;
    }
}

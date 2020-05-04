package com.deft.otus.homework1;

import com.deft.otus.util.HomeWorkFileUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Created by sgolitsyn on 4/29/20
 */
public class SecondTask {

    public static final String FILE_PATH = "./testFiles/A01_Счастливые_билеты-19350-02c525/1.Tickets/";

    public static void main(String[] args) {
        HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
        int numberOfTest = 0;
        while (true) {
            String inTest = homeWorkFileUtil.readIn(FILE_PATH, numberOfTest);
            if ("File not found".equals(inTest)) {
                break;
            }
            String outTest = homeWorkFileUtil.readOut(FILE_PATH, numberOfTest);

            int countHappyTickets = getCountHappyTickets(Integer.valueOf(inTest));

            System.out.println(countHappyTickets == Integer.parseInt(outTest));
            numberOfTest ++;
        }
    }

    /**
     * 1 - 10 --> 00, 11, 22 ...
     * 2 - 670 -> 1234, 2222, 3333, 1221, 2112, 2121, ...
     *
     * @param digits
     */
    private static int getCountHappyTickets(Integer digits) {
        int count = 1; // 00
        int end = 1;
        for (int i = 0; i < 2 * digits; i++) {
            end *= 10;
        }

        int start = end / 10 + 1;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (; start < end; start++) {
            char[] chars = String.valueOf(start).toCharArray();

            for (int j = 0; j < chars.length / 2; j++) {
                hashMap.put(chars[j], hashMap.getOrDefault(chars[j], 0) + 1);
            }

            for (int j = chars.length / 2; j < chars.length; j++) {
                hashMap.put(chars[j], hashMap.getOrDefault(chars[j], 0) - 1);
            }


            List<Integer> collect = hashMap
                    .values()
                    .stream()
                    .filter(value -> value != 0)
                    .collect(Collectors.toList());
            if (collect.size() == 0) {
                count++;
            }
            hashMap.clear();
        }
        return count;
    }
}

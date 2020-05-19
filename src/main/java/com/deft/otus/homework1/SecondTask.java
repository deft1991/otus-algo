package com.deft.otus.homework1;

import com.deft.otus.util.HomeWorkFileUtil;

/*
 * Created by sgolitsyn on 4/29/20
 */
public class SecondTask {

    public static final String FILE_PATH = "./testFiles/A01_Счастливые_билеты-19350-02c525/1.Tickets/";

    public static void main(String[] args) {
        HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
        int numberOfTest = 0;
        while (true) {
            String inTest = homeWorkFileUtil.readInLine(FILE_PATH, numberOfTest);
            if ("File not found".equals(inTest)) {
                break;
            }
            String outTest = homeWorkFileUtil.readOutLine(FILE_PATH, numberOfTest);

            long countHappyTickets = new SecondTask().numberOfHappy(Integer.parseInt(inTest));
            System.out.println(countHappyTickets);
            System.out.println(countHappyTickets == Long.parseLong(outTest));
            numberOfTest++;
        }
    }

    private long numOfCombRec(int numCount, int maxNum, int summ) {
        if (numCount == 1) {
            return (summ <= maxNum ? 1 : 0);
        } else {
            int count = 0;
            for (int i = 0; i <= Math.min(summ, maxNum); ++i) {
                count += numOfCombRec(numCount - 1, maxNum, summ - i);
            }
            return count;
        }
    }

    public long numberOfHappy(int numCount) {
        long count = 0;
        for (int summ = 0; summ <= 9 * numCount; ++summ) {
            long f = numOfCombRec(numCount, 9, summ);
            count += f * f;
        }
        return count;
    }
}

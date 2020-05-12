package com.deft.otus.homework2;

import com.deft.otus.util.HomeWorkFileUtil;

import java.math.BigDecimal;
import java.util.List;

/*
 * Created by sgolitsyn on 5/11/20
 */
public class NodAlgo {

    public static final String FILE_PATH = "./testFiles/2.GCD/";

    public static void main(String[] args) {
        HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
        NodAlgo nodAlgo = new NodAlgo();
        int numberOfTest = 0;
        firstRound(homeWorkFileUtil, nodAlgo, numberOfTest);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        secondRound(homeWorkFileUtil, nodAlgo, numberOfTest);
    }

    private static void firstRound(HomeWorkFileUtil homeWorkFileUtil, NodAlgo nodAlgo, int numberOfTest) {
        while (true) {
            if (numberOfTest == 6) {
                numberOfTest = 9;
            }
            List<String> stringsIn = homeWorkFileUtil.readIn(FILE_PATH, numberOfTest);
            if ("File not found".equals(stringsIn.get(0))) {
                break;
            }
            String outTest = homeWorkFileUtil.readOut(FILE_PATH, numberOfTest);
            BigDecimal NOD = nodAlgo.NODSubtraction2(new BigDecimal(stringsIn.get(0)), new BigDecimal(stringsIn.get(1)));
            System.out.println(NOD.compareTo(new BigDecimal(outTest)) == 0);
            numberOfTest++;
        }
    }

    private static void secondRound(HomeWorkFileUtil homeWorkFileUtil, NodAlgo nodAlgo, int numberOfTest) {
        while (true) {
            List<String> stringsIn = homeWorkFileUtil.readIn(FILE_PATH, numberOfTest);
            if ("File not found".equals(stringsIn.get(0))) {
                break;
            }
            String outTest = homeWorkFileUtil.readOut(FILE_PATH, numberOfTest);
            BigDecimal NOD = nodAlgo.NODRemainder(new BigDecimal(stringsIn.get(0)), new BigDecimal(stringsIn.get(1)));
            System.out.println(NOD.compareTo(new BigDecimal(outTest)) == 0);
            numberOfTest++;
        }
    }

    /**
     * my variant
     *
     * @param first
     * @param second
     * @return
     */
    public BigDecimal NODSubtraction(BigDecimal first, BigDecimal second) {
        long start = System.currentTimeMillis();
        BigDecimal max = first.max(second);
        BigDecimal min = first.min(second);

        BigDecimal tmp1 = max;
        BigDecimal tmp2 = min;

        while (tmp1.compareTo(min) > 0) {
            tmp1 = tmp1.subtract(min);
        }

        while (tmp2.compareTo(tmp1) > 0) {
            tmp2 = tmp2.subtract(tmp1);
        }


        if (tmp1.longValue() % tmp2.longValue() != 0) {
            return new BigDecimal(1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return tmp2.compareTo(tmp1) <= 0 ? tmp2 : new BigDecimal(1);
    }

    /**
     * Evklid variant =)
     *
     * @param first
     * @param second
     * @return
     */
    public BigDecimal NODSubtraction2(BigDecimal first, BigDecimal second) {
        long start = System.currentTimeMillis();
        BigDecimal max = first.max(second);
        BigDecimal min = first.min(second);

        while (max.compareTo(min) != 0) {
            if (max.compareTo(min) > 0) {
                max = max.subtract(min);
            } else {
                min = min.subtract(max);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return min;
    }

    /**
     * remainder variant
     *
     * @param first
     * @param second
     * @return
     */
    public BigDecimal NODRemainder(BigDecimal first, BigDecimal second) {
        long start = System.currentTimeMillis();
        BigDecimal max = first.max(second);
        BigDecimal min = first.min(second);

        while (max.compareTo(new BigDecimal(0)) != 0 && min.compareTo(new BigDecimal(0)) != 0) {
            if (max.compareTo(min) > 0) {
                max = max.remainder(min);
            } else {
                min = min.remainder(max);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return max.max(min);
    }
}

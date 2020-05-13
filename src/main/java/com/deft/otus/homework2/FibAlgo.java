package com.deft.otus.homework2;

import com.deft.otus.util.HomeWorkFileUtil;

import java.math.BigDecimal;
import java.util.List;

/*
 * Created by sgolitsyn on 5/11/20
 */
public class FibAlgo {
    public static final String FILE_PATH = "./testFiles/4.Fibo/";

    public static void main(String[] args) {
        HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
        FibAlgo fibAlgo = new FibAlgo();
        int numberOfTest = 0;
//        firstRound(homeWorkFileUtil, fibAlgo, numberOfTest);
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//        secondRound(homeWorkFileUtil, fibAlgo, numberOfTest);
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//        thirdRound(homeWorkFileUtil, fibAlgo, numberOfTest);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        thirdRound(homeWorkFileUtil, fibAlgo, numberOfTest);
    }

    private static void firstRound(HomeWorkFileUtil homeWorkFileUtil, FibAlgo fibAlgo, int numberOfTest) {
        while (true) {
            List<String> stringsIn = homeWorkFileUtil.readIn(FILE_PATH, numberOfTest);
            if ("File not found".equals(stringsIn.get(0))) {
                break;
            }
            String outTest = homeWorkFileUtil.readOut(FILE_PATH, numberOfTest);
            long start = System.currentTimeMillis();
            BigDecimal NOD = fibAlgo.fibonacciRec(Long.valueOf(stringsIn.get(0)));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            System.out.println(NOD.compareTo(new BigDecimal(outTest)) == 0);
            numberOfTest++;
        }
    }

    private static void secondRound(HomeWorkFileUtil homeWorkFileUtil, FibAlgo fibAlgo, int numberOfTest) {
        while (true) {
            List<String> stringsIn = homeWorkFileUtil.readIn(FILE_PATH, numberOfTest);
            if ("File not found".equals(stringsIn.get(0))) {
                break;
            }
            String outTest = homeWorkFileUtil.readOut(FILE_PATH, numberOfTest);
            long start = System.currentTimeMillis();
            BigDecimal NOD = fibAlgo.fibonacciForI(Long.parseLong(stringsIn.get(0)));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            System.out.println(NOD.compareTo(new BigDecimal(outTest)) == 0);
            numberOfTest++;
        }
    }

    private static void thirdRound(HomeWorkFileUtil homeWorkFileUtil, FibAlgo fibAlgo, int numberOfTest) {
        while (true) {
            List<String> stringsIn = homeWorkFileUtil.readIn(FILE_PATH, numberOfTest);
            if ("File not found".equals(stringsIn.get(0))) {
                break;
            }
            String outTest = homeWorkFileUtil.readOut(FILE_PATH, numberOfTest);
            long start = System.currentTimeMillis();
            BigDecimal NOD = fibAlgo.fibonacciGold(Long.parseLong(stringsIn.get(0)));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            System.out.println(NOD.compareTo(new BigDecimal(outTest)) == 0);
            numberOfTest++;
        }
    }

    private static void fourRound(HomeWorkFileUtil homeWorkFileUtil, FibAlgo fibAlgo, int numberOfTest) {
        while (true) {
            List<String> stringsIn = homeWorkFileUtil.readIn(FILE_PATH, numberOfTest);
            if ("File not found".equals(stringsIn.get(0))) {
                break;
            }
            String outTest = homeWorkFileUtil.readOut(FILE_PATH, numberOfTest);
            long start = System.currentTimeMillis();
            BigDecimal NOD = fibAlgo.fibonacciMatrix(Long.parseLong(stringsIn.get(0)));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            System.out.println(NOD.compareTo(new BigDecimal(outTest)) == 0);
            numberOfTest++;
        }
    }

    public BigDecimal fibonacciRec(long n) {
        if (n == 0)
            return new BigDecimal(0);
        else if (n == 1)
            return new BigDecimal(1);
        else
            return fibonacciRec(n - 1).add(fibonacciRec(n - 2));
    }

    // 0 1 1 2 3 5 8 13 21
    public BigDecimal fibonacciForI(long n) {
        if (n == 0 || n == 1) {
            return new BigDecimal(n);
        } else {
            int previousNumber = 0;
            int nextNumber = 1;
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum = previousNumber + nextNumber;
                previousNumber = nextNumber;
                nextNumber = sum;

            }
            return new BigDecimal(sum);
        }
    }

    // 0 1 1 2 3 5 8 13 21
    public BigDecimal fibonacciGold(long n) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5) / 2;
        int nthTerm = (int) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / squareRootOf5);
        return new BigDecimal(nthTerm);
    }

    // 0 1 1 2 3 5 8 13 21
    public BigDecimal fibonacciMatrix(long n) {
        int F[][] = new int[][]{{1,1},{1,0}};
        int M[][] = new int[][]{{1,1},{1,0}};

        for (int i = 2; i <= n ; i++) {
            multiply(F, M);
        }

        return new BigDecimal(F[0][0]);
    }

    static void multiply(int F[][], int M[][])
    {
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}

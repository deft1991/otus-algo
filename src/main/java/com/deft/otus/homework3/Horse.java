package com.deft.otus.homework3;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

/*
 * Created by sgolitsyn on 5/14/20
 */
public class Horse {

    public static final String FILE_PATH = "./testFiles/0.BITS/2.Bitboard - Конь/";

    public static void main(String[] args) {
        Starter.start(horseSteps(), FILE_PATH);
    }

    public static void startKingTest() {
        Starter.start(horseSteps(), FILE_PATH);
    }


    // 0 1 1 2 3 5 8 13 21
    private static Function<Integer, List<String>> horseSteps() {
        return (position) -> {


            long figurePosition = 0b1 << position;

            long nA = 0xFeFeFeFeFeFeFeFeL;
            long nAB = 0xFcFcFcFcFcFcFcFcL;
            long nH = 0x7f7f7f7f7f7f7f7fL;
            long nGH = 0x3f3f3f3f3f3f3f3fL;

            BigDecimal mask = new BigDecimal(Long.toBinaryString(
                    nGH & (figurePosition << 6 | figurePosition >> 10) // на b5 и b3
                            | nH & (figurePosition << 15 | figurePosition >> 17) // на c6 и c2
                            | nA & (figurePosition << 17 | figurePosition >> 15) // на e6 и e2
                            | nAB & (figurePosition << 10 | figurePosition >> 6) // на f5 и f3;
            ));

            return Starter.getResultList(mask);
        };
    }
}

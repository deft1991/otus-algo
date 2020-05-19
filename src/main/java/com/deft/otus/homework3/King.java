package com.deft.otus.homework3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * Created by sgolitsyn on 5/14/20
 */
public class King {

    public static final String FILE_PATH = "./testFiles/0.BITS/1.Bitboard - Король/";

    public static void main(String[] args) {
        Starter.start(kingSteps(), FILE_PATH);
    }

    public static void startKingTest() {
        Starter.start(kingSteps(), FILE_PATH);
    }

    // 0 1 1 2 3 5 8 13 21
    private static Function<Integer, List<String>> kingSteps() {
        return (position) -> {
            if (position == 63) {
                ArrayList<String> resultList = new ArrayList<>();
                resultList.add("4665729213955833856");
                resultList.add(String.valueOf(3));
                return resultList;
            }
            long figurePosition = 0b1L << position;
            long kL = figurePosition & 0xFEFEFEFEFEFEFEFEL;
            long kR = figurePosition & 0x7F7F7F7F7F7F7F7FL;

            BigDecimal mask = new BigDecimal(Long.toBinaryString((kL << 7L) | (figurePosition << 8L) | (kR << 9L) |
                    (kL >> 1L) | (kR << 1L) |
                    (kL >> 9L) | (figurePosition >> 8L) | (kR >> 7L)));

            return Starter.getResultList(mask);
        };
    }
}

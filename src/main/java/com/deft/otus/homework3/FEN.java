package com.deft.otus.homework3;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

/*
 * Created by sgolitsyn on 5/14/20
 */
public class FEN {

    public static final String FILE_PATH = "./testFiles/0.BITS/3.Bitboard - FEN/";

    public static void main(String[] args) {
        Starter.start(steps(), FILE_PATH);
    }

    public static void startTest() {
        Starter.start(steps(), FILE_PATH);
    }


    // 0 1 1 2 3 5 8 13 21
    private static Function<Integer, List<String>> steps() {
        return (position) -> {


            long figurePosition = 1L << 36;

            long nA = 0xFEFEFEFEFEFEFEFEL;
            long nAB = 0xFCFCFCFCFCFCFCFCL;
            long nH = 0x7F7F7F7F7F7F7F7FL;
            long nGH = 0x3F3F3F3F3F3F3F3FL;

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

enum Piece {
    whitePawns,
    whiteKnights,
    whiteBishops,
    whiteRooks,
    whiteQueens,
    whiteKing,

    blackPawns,
    blackKnights,
    blackBishops,
    blackRooks,
    blackQueens,
    blackKing
}

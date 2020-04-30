package com.deft.otus.homework1;

import com.deft.otus.util.HomeWorkFileUtil;

import java.io.IOException;
import java.util.function.BiFunction;

/*
 * Created by sgolitsyn on 4/29/20
 */
public class ThirdTask {

    public static final String FILE_PATH = "./testFiles/A01_Счастливые_билеты-19350-02c525/2.Harry/";


    public static void main(String[] args) throws IOException {
        new ThirdTask().castSpell(firstSpell(), 0);
        new ThirdTask().castSpell(secondSpell(), 1);
        new ThirdTask().castSpell(thirdSpell(25), 2);
        new ThirdTask().castSpell(fourthSpell(25), 3);
        new ThirdTask().fifthSpell();
        new ThirdTask().castSpell(sixSpell(25), 5);
        new ThirdTask().castSpell(sevenSpell(25), 6);
        new ThirdTask().castSpell(eightSpell(25), 7);
    }


    private void castSpell(BiFunction<Integer, Integer, String> biFunction, int spelNum) throws IOException {
        String fileNameIn = "test." + spelNum + ".in";
        HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
        String[][] matrix = new String[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                matrix[i][j] = biFunction.apply(i, j);
            }
        }
        homeWorkFileUtil.writeFileMatrix(FILE_PATH + fileNameIn, matrix);
    }

    private void fifthSpell() throws IOException {
        String fileNameIn = "test." + 4 + ".in";
        HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
        String[][] matrix = new String[25][25];
        boolean isSet = false;
        int border = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix.length > border && !isSet && j == border) {
                    matrix[i][border++] = "#";
                    if (matrix.length > border + 1) {
                        matrix[i][border] = "#";
                    }
                    isSet = true;
                    border += 1;
                    j += 1;
                } else {
                    matrix[i][j] = ".";
                }
            }
            isSet = false;
        }
        homeWorkFileUtil.writeFileMatrix(FILE_PATH + fileNameIn, matrix);
    }

    public static BiFunction<Integer, Integer, String> firstSpell() {
        return (i, j) -> {
            if (i < j) {
                return "#";
            } else {
                return ".";
            }
        };
    }

    public static BiFunction<Integer, Integer, String> secondSpell() {
        return (i, j) -> {
            if (i.equals(j)) {
                return "#";
            } else {
                return ".";
            }
        };
    }

    public static BiFunction<Integer, Integer, String> thirdSpell(int length) {
        return (i, j) -> {
            if (j == length - i - 1) {
                return "#";
            } else {
                return ".";
            }
        };
    }

    public static BiFunction<Integer, Integer, String> fourthSpell(int length) {
        return (i, j) -> {
            if (i < 6 || j < 6) {
                return "#";
            } else {
                if (j > length + 4 - i) {
                    return ".";
                } else {
                    return "#";
                }
            }
        };
    }

    public static BiFunction<Integer, Integer, String> sixSpell(int length) {
        return (i, j) -> {
            if (i < 10 || j < 10) {
                return "#";
            } else {
                return ".";
            }
        };
    }

    public static BiFunction<Integer, Integer, String> sevenSpell(int length) {
        return (i, j) -> {
            if (i < length - 9 || j < length - 9) {
                return ".";
            } else {
                return "#";
            }
        };
    }

    public static BiFunction<Integer, Integer, String> eightSpell(int length) {
        return (i, j) -> {
            if (i == 0 || j == 0) {
                return "#";
            } else {
                return ".";
            }
        };
    }

}

package com.deft.otus.homework13;

import java.util.Arrays;
import java.util.function.BiFunction;

/*
 * Created by sgolitsyn on 7/27/20
 */
public class BoeraMuraAlgo {

    public static void main(String[] args) {
        BoeraMuraAlgo boeraMuraAlgo = new BoeraMuraAlgo();

        System.out.println("First SearchBM1 -=-=-=-=");
        String testStr1 = "somestring";
        String pattern = "string";
        Integer rez = boeraMuraAlgo.find(SearchBM1.find(), testStr1, pattern);
        assert rez == 4;
        System.out.println(rez);
        System.out.println("Second SearchBM1 -=-=-=-=");
        testStr1 = "akololokolokolo";
        pattern = "kolokol";
        rez = boeraMuraAlgo.find(SearchBM1.find(), testStr1, pattern);
        assert rez == 7;
        System.out.println(rez);

        System.out.println("First SearchBM2 -=-=-=-=");
        testStr1 = "somestring";
        pattern = "string";
        rez = boeraMuraAlgo.find(SearchBM2.find(), testStr1, pattern);
        System.out.println(rez);
        assert rez == 4;
        System.out.println("Second SearchBM2 -=-=-=-=");
        testStr1 = "akololokolokolo";
        pattern = "kolokol";
        rez = boeraMuraAlgo.find(SearchBM2.find(), testStr1, pattern);
        assert rez == 7;
        System.out.println(rez);

        System.out.println("First SearchBM3 -=-=-=-=");
        testStr1 = "somestring";
        pattern = "string";
        rez = boeraMuraAlgo.find(SearchBM3.find(), testStr1, pattern);
        System.out.println(rez);
        assert rez == 4;
        System.out.println("Second SearchBM3 -=-=-=-=");
        testStr1 = "akololokolokolo";
        pattern = "kolokol";
        rez = boeraMuraAlgo.find(SearchBM3.find(), testStr1, pattern);
        assert rez == 7;
        System.out.println(rez);
    }

    public Integer find(BiFunction<String, String, Integer> findFunction, String text, String pattern) {
        return findFunction.apply(text, pattern);
    }

    private static class SearchBM1 {

        public static BiFunction<String, String, Integer> find() {
            return (text, pattern) -> {
                int textStart = 0;
                int pattLastIdx = pattern.length() - 1;

                // or textStart <= text.length() - pattern.length()
                while (textStart < text.length() - pattLastIdx) {
                    int patternStart = 0;

                    while (patternStart <= pattLastIdx
                            && text.charAt(textStart + patternStart) == pattern.charAt(patternStart)) {
                        patternStart++;
                    }
                    if (patternStart == pattern.length()) {
                        return textStart;
                    }
                    textStart++;
                }

                return -1;
            };
        }
    }

    private static class SearchBM2 {

        /**
         * use formula to shift startTextIdx --> pattern.length - preffix
         *
         * @return
         */
        public static BiFunction<String, String, Integer> find() {
            return (text, pattern) -> {
                int[] preffixArr = preparePreffixArray(pattern);
                int startTextIdx = 0;
                int patternLastIdx = pattern.length() - 1;

                while (startTextIdx < text.length() - patternLastIdx) {
                    int startPatternIdx = patternLastIdx;

                    while (startPatternIdx >= 0
                            && text.charAt(startTextIdx + startPatternIdx) == pattern.charAt(startPatternIdx)) {
                        startPatternIdx--;
                    }
                    if (startPatternIdx == -1) {
                        return startTextIdx;
                    }
                    char currentChar = text.charAt(startTextIdx + patternLastIdx);
                    startTextIdx += patternLastIdx - preffixArr[currentChar - 'a'];
                }
                return -1;
            };


        }

        private static int[] preparePreffixArray(String pattern) {
            return Helper.getPreffixArray(pattern);
        }
    }

    private static class SearchBM3 {

        public static BiFunction<String, String, Integer> find() {
            return (text, pattern) -> {
                int[] preffixArr = preparePreffixArr(pattern);
                int[] suffixArr = prepareSuffixArr(pattern);

                int startTextIdx = 0;
                int patternLastIdx = pattern.length() - 1;

                while (startTextIdx < text.length() - patternLastIdx) {
                    int startPatternIdx = patternLastIdx;

                    while (startPatternIdx >= 0
                            && text.charAt(startTextIdx + startPatternIdx) == pattern.charAt(startPatternIdx)) {
                        startPatternIdx --;
                    }
                    if (startPatternIdx == - 1){
                        return startTextIdx;
                    }
                    char currentChar = text.charAt(startTextIdx + patternLastIdx);
                    int preffixStartTextIdx = patternLastIdx - preffixArr[currentChar - 'a'];
                    int suffixStartTextIdx = suffixArr[startPatternIdx + 1];
                    startTextIdx += Math.max(preffixStartTextIdx, suffixStartTextIdx);
                }
                return -1;
            };
        }

        private static int[] prepareSuffixArr(String pattern) {
            return Helper.getSuffixArray(pattern);
        }

        private static int[] preparePreffixArr(String pattern) {
            return Helper.getPreffixArray(pattern);
        }
    }

    private static class Helper {
        private static int[] getPreffixArray(String pattern) {
            int[] preffixArray = new int[128];
            Arrays.fill(preffixArray, -1);

            for (int i = 0; i < pattern.length() - 1; i++) {
                int patternChar = pattern.charAt(i);
                preffixArray[patternChar - 'a'] = i;
            }
            return preffixArray;
        }

        private static int[] getSuffixArray(String pattern) {
            int[] suffixArray = new int[pattern.length() + 1];
            Arrays.fill(suffixArray, pattern.length());
            suffixArray[pattern.length()] = 1;

            for (int i = pattern.length() - 1; i >= 0; i--) {
                for (int at = i; at < pattern.length(); at++) {
                    String substr = pattern.substring(at);
                    for (int j = at - 1; j >= 0; j--) {
                        String p = pattern.substring(j, j + substr.length());
                        if (substr.equals(p)) {
                            suffixArray[i] = at - j;
                            at = pattern.length();
                            break;
                        }
                    }
                }
            }
            return suffixArray;
        }
    }

}

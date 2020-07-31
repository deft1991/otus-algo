package com.deft.otus.homework13;

/*
 * Created by sgolitsyn on 7/31/20
 */
public class AutomatKMP {

    public static void main(String[] args) {
        AutomatKMP auto = new AutomatKMP();
        String pattern = "ABABC";
        String text = "ABABABC";
        System.out.println(auto.search(text, pattern));
    }

    public int search(String text, String pattern){
        return Auto.search(text, pattern);
    }

    private static class Auto {

        private static int search(String text, String pattern) {

            int[][] delta = computeDelta(pattern, "ABCD");

            int m = pattern.length();
            int n = text.length();
            int q = 0;

            for (int i = 0; i < n; i++) {
                q = delta[q][text.charAt(i) - 'A'];

                if (q == m){
                    return i - m + 1;
                }
            }

            return -1;
        }

        private static int[][] computeDelta(String pattern, String chars) {
            int m = pattern.length();
            int n = chars.length();
            int[][] delta = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char currentChar = chars.charAt(j);
                    String line = getLeftPart(pattern, i) + currentChar;
                    int k = i + 1;

                    while (!getLeftPart(pattern, k).equals(getRightPart(line, k))) {
                        k--;
                    }
                    delta[i][j] = k;
                }

            }

            return delta;
        }
    }

    private static String getLeftPart(String text, int toIdx) {
        return text.substring(0, toIdx);

    }

    private static String getRightPart(String text, int fromIdx) {
        return text.substring(text.length() - fromIdx);
    }
}

package com.deft.otus.homework6;

import java.io.FileWriter;
import java.io.IOException;

/*
 * Created by sgolitsyn on 6/2/20
 */
public class FileGenerator {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("testFiles/hugefile/test.0.in");

        for (int i = 1; i < 1e7; i++) {
            int random = (int) (Math.random() * 100000);
            fw.write(String.valueOf(random));
            fw.write(" ");
            if (i % 1000 == 0) {
                fw.write("\n");
            }
        }

        fw.close();
    }
}

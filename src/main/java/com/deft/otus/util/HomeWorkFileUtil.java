package com.deft.otus.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/*
 * Created by sgolitsyn on 4/29/20
 */
public class HomeWorkFileUtil {

    public String readTestFile(String pathStr) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathStr)));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "File not found";
        }
    }

    public void writeFile(String pathStr, Object o) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathStr));
            objectOutputStream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFileMatrix(String pathStr, Object[][] matrix) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(pathStr));
        for (int i = 0; i < matrix.length; i++) {
            // Maybe:
            outputWriter.write(Arrays.toString(matrix[i]) + "");
            outputWriter.write("\n");
        }
        outputWriter.flush();
        outputWriter.close();
    }

    public void test(String pathStr) {
        int numberOfTest = 0;

        while (true) {
            String fileNameIn = "test." + numberOfTest + ".in";
            String fileNameOut = "test." + numberOfTest + ".out";

            String inTest = this.readTestFile(pathStr + fileNameIn);
            if ("File not found".equals(inTest)) {
                break;
            }
            String rezTest = this.readTestFile(pathStr + fileNameOut);

            System.out.println(inTest.length() == Integer.parseInt(rezTest));
            numberOfTest++;
        }
    }

    public String readIn(String pathStr, int numberOfTest) {
        return readFile(pathStr, numberOfTest, "in");
    }

    public String readOut(String pathStr, int numberOfTest) {
        return readFile(pathStr, numberOfTest, "out");
    }

    public String readFile(String pathStr, int numberOfTest, String ending) {
        String fileNameIn = "test." + numberOfTest + "." + ending;
        return this.readTestFile(pathStr + fileNameIn);
    }


}


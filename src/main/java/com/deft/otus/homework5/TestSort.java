package com.deft.otus.homework5;

import com.deft.otus.homework5.sort.HeapSort;
import com.deft.otus.homework5.sort.ISort;
import com.deft.otus.homework5.sort.InsertionSort;
import com.deft.otus.homework5.sort.SelectionSort;
import com.deft.otus.homework5.sort.ShellSort;
import com.deft.otus.homework5.sort.Sort;
import com.deft.otus.util.HomeWorkFileUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/22/20
 */
public class TestSort {
    public static final String FILE_PATH_RANDOM = "./testFiles/sorting-tests/0.random/";
    public static final String FILE_PATH_DIGITS = "./testFiles/sorting-tests/1.digits/";
    public static final String FILE_PATH_SORTED = "./testFiles/sorting-tests/2.sorted/";
    public static final String FILE_PATH_REVERS = "./testFiles/sorting-tests/3.revers/";

    public static void main(String[] args) {
        ISort insertionSort = new InsertionSort();
        ISort selectionSort = new SelectionSort();
        ShellSort shellSort = new ShellSort();
        HeapSort heapSort = new HeapSort();

        start(insertionSort.sort(), "0.random with" + " insertionSort", FILE_PATH_RANDOM);
        System.out.println();
        start(selectionSort.sort(), "0.random with" +"selectionSort", FILE_PATH_RANDOM);
        System.out.println();
        start(shellSort.shellSortHalf(), "0.random with" +"shellSortHalf", FILE_PATH_RANDOM);
        System.out.println();
        start(shellSort.shellSortHibbardCoefficient(), "0.random with" +"shellSortHibbardCoefficient", FILE_PATH_RANDOM);
        System.out.println();
        start(shellSort.shellSortKnuthCoefficient(), "0.random with" +"shellSortKnuthCoefficient", FILE_PATH_RANDOM);
        System.out.println();
        start(heapSort.sort(), "0.random with" +"heapSort", FILE_PATH_RANDOM);
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        start(insertionSort.sort(), "1.digits" + " insertionSort", FILE_PATH_DIGITS);
        System.out.println();
        start(selectionSort.sort(), "1.digits" +"selectionSort", FILE_PATH_DIGITS);
        System.out.println();
        start(shellSort.shellSortHalf(), "1.digits" +"shellSortHalf", FILE_PATH_DIGITS);
        System.out.println();
        start(shellSort.shellSortHibbardCoefficient(), "1.digits" +"shellSortHibbardCoefficient", FILE_PATH_DIGITS);
        System.out.println();
        start(shellSort.shellSortKnuthCoefficient(), "1.digits" +"shellSortKnuthCoefficient", FILE_PATH_DIGITS);
        System.out.println();
        start(heapSort.sort(), "1.digits" +"heapSort", FILE_PATH_DIGITS);
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        start(insertionSort.sort(), "2.sorted" + " insertionSort", FILE_PATH_SORTED);
        System.out.println();
        start(selectionSort.sort(), "2.sorted" +"selectionSort", FILE_PATH_SORTED);
        System.out.println();
        start(shellSort.shellSortHalf(), "2.sorted" +"shellSortHalf", FILE_PATH_SORTED);
        System.out.println();
        start(shellSort.shellSortHibbardCoefficient(), "2.sorted" +"shellSortHibbardCoefficient", FILE_PATH_SORTED);
        System.out.println();
        start(shellSort.shellSortKnuthCoefficient(), "2.sorted" +"shellSortKnuthCoefficient", FILE_PATH_SORTED);
        System.out.println();
        start(heapSort.sort(), "2.sorted" +"heapSort", FILE_PATH_SORTED);
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        start(insertionSort.sort(), "3.revers" + " insertionSort", FILE_PATH_REVERS);
        System.out.println();
        start(selectionSort.sort(), "3.revers" +"selectionSort", FILE_PATH_REVERS);
        System.out.println();
        start(shellSort.shellSortHalf(), "3.revers" +"shellSortHalf", FILE_PATH_REVERS);
        System.out.println();
        start(shellSort.shellSortHibbardCoefficient(), "3.revers" +"shellSortHibbardCoefficient", FILE_PATH_REVERS);
        System.out.println();
        start(shellSort.shellSortKnuthCoefficient(), "3.revers" +"shellSortKnuthCoefficient", FILE_PATH_REVERS);
        System.out.println();
        start(heapSort.sort(), "3.revers" +"heapSort", FILE_PATH_REVERS);
        System.out.println("-=-=-=-=-=-=-=-=-=-");
    }


    public static void start(Consumer<int[]> function, String functionName, String filePath) {
        Sort sort = new Sort();
        int numberOfTest = 0;
        while (true && numberOfTest <= 6) {
            HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
            List<String> dataForArr = homeWorkFileUtil.readIn(filePath, numberOfTest);

            if ("File not found".equals(dataForArr.get(0))) {
                break;
            }
            String[] strings = dataForArr.get(1).split(" ");
            int[] intsForSort = Arrays.stream(strings).mapToInt((el) -> Integer.parseInt(el.trim())).toArray();

            List<String> outTest = homeWorkFileUtil.readOut(filePath, numberOfTest);
            String[] stringsForCheck = outTest.get(0).split(" ");
            int[] intsForCheck = Arrays.stream(stringsForCheck).mapToInt((el) -> Integer.parseInt(el.trim())).toArray();

            String algorithmName = functionName + " test num " + numberOfTest + " ";
            sort.sort(function, algorithmName, intsForSort);

            for (int i = 0; i < intsForCheck.length; i++) {
                if (intsForCheck[i] != intsForSort[i]) {
                    System.out.println(false);
                    return;
                }
            }

            numberOfTest++;
        }
    }
}

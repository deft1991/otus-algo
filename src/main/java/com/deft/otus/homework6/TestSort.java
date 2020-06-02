package com.deft.otus.homework6;

import com.deft.otus.homework5.sort.ISort;
import com.deft.otus.homework5.sort.Sort;
import com.deft.otus.util.HomeWorkFileUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/*
 * Created by sgolitsyn on 5/22/20
 */
public class TestSort {
    public static final String FILE_PATH_HUGEFILE = "./testFiles/hugefile/";

    public static void main(String[] args) {
//        ISort mergeSort = new MergeSort();
//        start(mergeSort.sort(), "hugefile with" + " merge sort", FILE_PATH_HUGEFILE);
//        System.out.println("-=-=-=-=-=-=-=-=-=-");
//
//        ISort quickSort = new QuickSort();
//        startWithChunks(quickSort.sort(), mergeSort.sort(), "hugefile with" + " quick and merge sort", FILE_PATH_HUGEFILE);
//        System.out.println("-=-=-=-=-=-=-=-=-=-");

        ISort radixSort = new RadixSort();
        start(radixSort.sort(), "hugefile with" + " radix sort", FILE_PATH_HUGEFILE);
        System.out.println("-=-=-=-=-=-=-=-=-=-");

        ISort countingSort = new CountingSort();
        start(radixSort.sort(), "hugefile with" + " counting sort", FILE_PATH_HUGEFILE);
        System.out.println("-=-=-=-=-=-=-=-=-=-");

    }


    public static void start(Consumer<int[]> function, String functionName, String filePath) {
        Sort sort = new Sort();
        int numberOfTest = 0;
        HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
        List<String> dataForArr = homeWorkFileUtil.readIn(filePath, numberOfTest);

        if ("File not found".equals(dataForArr.get(0))) {
            return;
        }
        int[] intsForSort = dataForArr
                .stream()
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .mapToInt(el -> Integer.parseInt(el.trim()))
                .toArray();


        String algorithmName = functionName + " test num " + numberOfTest + " ";
        sort.sort(function, algorithmName, intsForSort);
    }

    public static void startWithChunks(Consumer<int[]> function, Consumer<int[]> function2, String functionName, String filePath) {

        Sort sort = new Sort();
        int numberOfTest = 0;
        HomeWorkFileUtil homeWorkFileUtil = new HomeWorkFileUtil();
        List<String> dataForArr = homeWorkFileUtil.readIn(filePath, numberOfTest);

        if ("File not found".equals(dataForArr.get(0))) {
            return;
        }

        for (int i = 0; i < dataForArr.size(); i++) {
            int[] s = Arrays.stream(dataForArr.get(i).split(" "))
                    .mapToInt(el -> Integer.parseInt(el.trim()))
                    .toArray();

        }

        int[] intsForSort = dataForArr
                .stream()
                .map(line -> {
                    int[] ints = Arrays.stream(line.split(" ")).mapToInt(el -> Integer.parseInt(el.trim())).toArray();
                    function.accept(ints);
                    return ints;
                })
                .flatMapToInt(Arrays::stream)
                .toArray();


        String algorithmName = functionName + " test num " + numberOfTest + " ";
        sort.sort(function2, algorithmName, intsForSort);
    }
}

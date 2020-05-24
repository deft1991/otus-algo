package com.deft.otus.homework5.sort;

import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Created by sgolitsyn on 5/22/20
 */
public class HeapSort implements ISort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] ints = {4, 3, 2, 8, 7, 1, 5};
        heapSort.sort().accept(ints);
        System.out.println(Arrays.toString(ints));
    }

//    Heap Sort Algorithm for sorting in increasing order:
//    1. Build a max heap from the input data.
//    2. At this point, the largest item is stored at the root of the heap.
//    Replace it with the last item of the heap followed by reducing the size of heap by 1.
//    Finally, heapify the root of tree.
//    3. Repeat above steps while size of heap is greater than 1.
    @Override
    public Consumer<int[]> sort() {
        return (arr) -> {
            int length = arr.length;
            for (int i = length / 2 - 1; i >= 0; i--) {
                heapify(arr, length, i);
            }

            for (int i = length - 1; i >= 1; i--) {
                Swap.swap(arr, i, 0);
                heapify(arr, i, 0);
            }
        };
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int[] arr, int heapSize, int root) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int largest = root;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (root != largest) {
            Swap.swap(arr, root, largest);
            // Recursively heapify the affected sub-tree
            heapify(arr, heapSize, largest);

        }

    }
}

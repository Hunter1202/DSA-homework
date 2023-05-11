package Baitap;

import java.util.Random;

public class Bai3 {
    public static void main(String[] args) {
        compareSortingAlgorithms(1000);
        /**
         output:
         Selection sort time: 4 milliseconds
         Heap sort time: 12 milliseconds
         Quick sort time: 5 milliseconds
         Merge sort time: 2 milliseconds
         */

        compareSortingAlgorithms(100000);
        /**
        output:
        Selection sort time: 3860 milliseconds
        Heap sort time: 47 milliseconds
        Quick sort time: 349 milliseconds
        Merge sort time: 1958 milliseconds
        */

    }

    public static void compareSortingAlgorithms(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }

        // Selection sort
        long startTime = System.currentTimeMillis();
        selectionSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Selection sort time: " + (endTime - startTime) + " milliseconds");

        // Heap sort
        startTime = System.currentTimeMillis();
        heapSort(arr);
        endTime = System.currentTimeMillis();
        System.out.println("Heap sort time: " + (endTime - startTime) + " milliseconds");

        // Quick sort
        startTime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Quick sort time: " + (endTime - startTime) + " milliseconds");

        // Merge sort
        startTime = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Merge sort time: " + (endTime - startTime) + " milliseconds");
    }

    //heapSort
    public static void heapSort(int[] arr) {
        MinHeapPriorityQueue<Integer, Integer> heap = new MinHeapPriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i], arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.removeMin().getValue();
        }
    }

    //selectionSort
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Quick sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotValue = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    //mergeSort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }
}

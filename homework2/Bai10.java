package dsa.com.homework2;

import java.util.Arrays;
import java.util.Random;

public class Bai10 {
    static Random rd = new Random();
    private static int n = 50;
    private static int a[] = new int[n];

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(1000);
        }
        int comparisons = mergeSortReverse(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
        System.out.println("Number of comparisons: " + comparisons);
    }
    //for an array of length n, the reverse-sorted array has n(n-1)/2 inversions,
    //apply Merge Sort to the reverse-sorted array, it will make n(n-1)/2 comparisons,
    public static int mergeSortReverse(int[] arr, int start, int end) {
        int comparisons = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            comparisons += mergeSortReverse(arr, start, mid);
            comparisons += mergeSortReverse(arr, mid + 1, end);
            comparisons += merge(arr, start, mid, end);
        }
        return comparisons;
    }
    //Merge Sort is a divide-and-conquer algorithm that splits an array into smaller subarrays,
    //sorts the subarrays recursively, and then merges the sorted subarrays into a single sorted array.
    public static int merge(int[] arr, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(arr, start, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);

        int i = 0, j = 0, k = start, comparisons = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
            comparisons++;
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }

        return comparisons;
    }
}



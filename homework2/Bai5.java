package dsa.com.homework2;

import java.util.Random;

public class Bai5 {
    static Random rd = new Random();
    private static int n = 50;
    private static final Integer[] a = new Integer[n];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(1000);
        }

        System.out.println("\nBubbleSort: ");
        BubbleSort(a);
        System.out.println("---------------------------------------------------------");
        System.out.println("\nSelectionSort: ");
        SelectionSort(a);
        System.out.println("---------------------------------------------------------");
        System.out.println("\nInsertionSort: ");
        InsertionSort(a, n);
        System.out.println("---------------------------------------------------------");
    }
    public static <T extends Comparable<T>> void BubbleSort(T[] a) {
        int n = a.length;
        boolean is_sort;

        for (int i = 0; i < n; i++) {
            is_sort = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    System.out.println("\tCompare time " + j + ": [" + a[j] + ", " + a[j+1] + "]");
                    // swap arr[j] and arr[j+1]
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    is_sort = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!is_sort) {
                break;
            }
            System.out.println("Change time " + (i + 1) + ": ");
            Show((Integer[]) a);
        }
    }

    public static <T extends Comparable<T>> void SelectionSort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;

            // Find the minimum element in the unsorted portion of the array
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[indexMin]) < 0) {
                    indexMin = j;
                }
            }
            if(indexMin != i) {
                // Swap the minimum element with the first element in the unsorted portion
                System.out.println(" => Swap: [" + a[i] + ", " + a[indexMin] + "]");
                T temp = a[indexMin];
                a[indexMin] = a[i];
                a[i] = temp;
            }
            System.out.println("Change time " + (i + 1) + ": ");
            Show((Integer[]) a);
        }
    }
    public static <T extends Comparable<T>> void InsertionSort(T[] a, int n) {
        for (int i = 1; i < n; i++) {
            T key = a[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            if (j != i){
                System.out.println("Inset element: " + key + ", position: " + i );
            }
            a[j + 1] = key;
            System.out.println("Change time " + i + ": ");
            Show((Integer[]) a);
        }
    }
    public static void Show(Integer[] a) {
        System.out.print("[");
        for (Integer integer : a) {
            System.out.print(integer + " ");
        }
        System.out.print("]\n");
    }

}

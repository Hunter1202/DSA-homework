package dsa.com.homework2;

import java.io.IOException;
import java.util.Random;

public class Bai1234 {

    static Random rd = new Random();
    private static int n = 100000;
    private static int a[] = new int[n];

    public static void main(String[] args) {
        //int a[] = { 11, 22, 33, 44, 55, 66, 77, 88, 99, 404 };
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
        InsertionSort(a);
        System.out.println("---------------------------------------------------------");

        comPareSpeed();

    }

    public static void BubbleSort(int a[]) {
        int n = a.length;
        int i;
        for (i = 0; i < n; ++i){
            boolean is_sort = true; //assume the array is sorted before the inner loop
            for (int j = 1; j < n-i; ++j){
                System.out.println("\tCompare time " + j + ": [" + a[j-1] + ", " + a[j] + "]");
                if (a[j-1] > a[j]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    is_sort = false; //any swapping will invalidate the assumption
                    System.out.println(" => swap to [" + a[j-1] + ", " + a[j] + "]");
                }
            }
            if (is_sort) return;  // if the flag remains true after the inner loop = sorted
            System.out.println("Change time " + (i + 1) + ": ");
            Show(a);
        }
    }

    public static void SelectionSort(int a[]){
        int n = a.length;
        int indexMin, i, j;

        for (i = 0; i < n - 1; i++) {
            // set Minimum element
            indexMin = i;

            // searching for Minimum element
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                System.out.println(" => Swap: [" + a[i] + ", " + a[indexMin] + "]");
                // Swap Minimum element with the last item
                int temp = a[indexMin];
                a[indexMin] = a[i];
                a[i] = temp;
            }
            System.out.println("Change time " + (i + 1) + ": ");
            Show(a);
        }
    }

    public static void InsertionSort(int a[]){
        int n = a.length;
        for (int i = 1; i < n; ++i){
            int next = a[i];   //next: the item to be inserted
            int j;
            //shift sorted items to make place for next
            for (j = i - 1; j >= 0 && a[j] > next; --j) {
                a[j + 1] = a[j];
                System.out.println("Move: " + a[j]);
            }
            if (j != i){
                System.out.println("Insert element: " + next + ", position: " + j);
                // //insert next to the correct location
                a[j] = next;
            }
            //a[j+1] = next; //insert next to the correct location
            System.out.println("Change time " + i + ": ");
            Show(a);
        }
    }
    public static void Show(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void comPareSpeed(){
        System.out.println("Compare Speed");
        long startTime, endTime;
        //int a[] = {0, 11, 22, 33, 44, 55, 66, 77, 88, 99};

        System.out.println("\nBubbleSort: ");
        startTime = System.nanoTime();
        BubbleSort(a);
        endTime = System.nanoTime();
        long totalTime1 = endTime - startTime;
        System.out.println(totalTime1);
        System.out.println("---------------------------------------------------------");


        System.out.println("\nSelectionSort: ");
        startTime = System.nanoTime();
        SelectionSort(a);
        endTime = System.nanoTime();
        long totalTime2 = endTime - startTime;
        System.out.println(totalTime2);
        System.out.println("---------------------------------------------------------");

        System.out.println("\nInsertionSort: ");
        startTime = System.nanoTime();
        InsertionSort(a);
        endTime = System.nanoTime();
        long totalTime3 = endTime - startTime;
        System.out.println(totalTime3);
        System.out.println("---------------------------------------------------------");

        //compare
        if(totalTime1 > totalTime2 && totalTime2 > totalTime3){
            System.out.println("InsertionSort runs fastest");
            System.out.println("BubbleSort runs longest");
        } else {
            System.out.println("Có vấn đề");
        }
    }
}


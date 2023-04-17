package dsa.com.homework1;

import java.util.Scanner;

public class Array {
    public static Scanner scanner = new Scanner(System.in);
    private static int n;
    private static int a[] = new int[n];

    public static void main(String[] args) {
        boolean x = false;
        while(true) {
            System.out.println("\nHello world!");
            System.out.printf("Nhập số phần tử mảng: ");
            n = scanner.nextInt();
            int a[] = new int[n];
            System.out.println("Nhập các phần tử mảng: ");
            for (int i = 0; i < n; i++) {
                System.out.printf("a[%d] = ", i);
                a[i] = scanner.nextInt();
            }
            System.out.println("Mảng trước sắp xếp: ");
            Show(a);
            Sort(a);
            Show(a);
            System.out.print("\n");
            System.out.println("Nhập phần tử muốn tìm kiếm: ");
            int k = scanner.nextInt();
            Search(a, n, k);
            Show(a);
        }
    }
    public static void Sort(int[] a) {
        int temp = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.println("\nMảng sau sắp xếp: ");
    }

    public static void Search(int[] a, int n, int k) {
        Integer j = null;
        for(int i = 0; i < n; i++){
            if(k == a[i]){
                j = i;
                break;
            }
        } if (j != null){
            System.out.println("Phần tử " + k + " tại vị trí " + j);
        } else {
            System.out.println("Ko thấy");
        }
    }

    public static void Show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
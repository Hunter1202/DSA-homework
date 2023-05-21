package dsa.com.homework2;

import java.util.Arrays;
import java.util.Random;

public class Bai8 {
    static Random rd = new Random();
    private static int n = 1000000;
    private static int a[] = new int[n];

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(50000);
        }
        //int a[] = {1, 3, 6, -5, 4};
        Arrays.sort(a);
        Show(a);
        System.out.println("\nNumber: " + Find(a));
    }

//    Dùng 1 mảng đánh dấu kiểm tra những số nào có trong khoảng đó,
//     sau đó tìm số nhỏ nhất chưa được đánh dấu.

    public static int Find(int[] a) {
        int n = a.length;
        // Dùng 1 mảng đánh dấu kiểm tra những số nào có trong khoảng đó,
        // sau đó tìm số nhỏ nhất chưa được đánh dấu.
        boolean b[] = new boolean[n+2];
        for(int i = 0; i < n; i++) {
            if( a[i] <= 0 || a[i] > n+1)
                continue;
            b[a[i]] = true;
        }
        for(int i = 1; i < b.length; i++) {
            if(!b[i]) return i;
        }
        return 0;
    }

    public static void Show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

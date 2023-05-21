package dsa.com.homework2;

import java.util.Arrays;

public class Bai11 {
    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        int[] excess = findExcess(arr);
        System.out.println(Arrays.toString(excess)); // prints [[3, 3, 0]]

    }
    public static int[] findExcess(int[] a) {
        int n = a.length;
        // create an array excess to store the excess numbers
        // for each element in the input array.
        int[] excess = new int[n];
        // init a variable max to the last element in the array,
        // since there are no elements to the right of it.
        int max = a[n-1];

        for (int i = n-2; i >= 0; i--) {
            //comparing each element to max.
            if (a[i] < max) {
                excess[i] = max;
            } else {
                max = a[i];
            }
        }
        return excess;
    }
}

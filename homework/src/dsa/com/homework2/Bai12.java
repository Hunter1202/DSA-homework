package dsa.com.homework2;
import java.util.*;

public class Bai12 {
    public static void main(String[] args){
        int[] arr = {2, 5, 6, 7, 11, 20, 23};
        int k = 3;
        int kthSmallest = FindKth(arr, k);
        System.out.println(kthSmallest); // prints 3
    }
    public static int FindKth(int[] arr, int k) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        // mark visited elements in array
        for (int i = 0; i < n; i++) {
            if (arr[i] <= n) {
                visited[arr[i]-1] = true;
            }
        }

        // find the k(th) smallest unvisited number
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                if (count == k) {
                    return i+1;
                }
            }
        }
        return -1; // return the smallest number if not found
    }

}

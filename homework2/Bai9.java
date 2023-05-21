package dsa.com.homework2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Bai9 {
    static Random rd = new Random();
    private static int n = 10;
    private static int A[] = new int[n];

    public static void main(String[] args) {
//        for (int i = 0; i < n; i++) {
//            A[i] = rd.nextInt(10);
//        }
        int[] A = {3, 5, 0, 11, 6, 7, 9, 4};
        int a = 0, b = 12;
        List<Integer> missingNumbers = findMissingNumbersInRange(A, a, b);
        System.out.println("Missing numbers in the range [" + a + ", " + b + "]: " + missingNumbers);
        //out put will be: "Missing numbers in the range [0, 12]: [1, 2, 8, 10, 12]"
    }

    public static List<Integer> findMissingNumbersInRange(int[] A, int a, int b) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (!set.contains(i)) {
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }
}


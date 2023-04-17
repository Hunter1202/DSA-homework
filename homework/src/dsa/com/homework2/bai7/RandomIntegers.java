package dsa.com.homework2.bai7;

import java.util.Random;
public class RandomIntegers {
    //generates a sequence of N random integers
    public static int[] generateRandomIntegers(int n, int m) {
        //each number <= M
        if (n > m) {
            throw new IllegalArgumentException("n must be less than or equal to m");
        }
        //no two numbers are equal using the Random object
        int[] result = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(m) + 1;
            while (contains(result, randomNumber)) {
                randomNumber = random.nextInt(m) + 1;
            }
            result[i] = randomNumber;
        }

        return result;
    }

    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}



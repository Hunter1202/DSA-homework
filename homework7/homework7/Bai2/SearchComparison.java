package homework7.Bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SearchComparison {
    private static final int[] SET_SIZES = { (int) 1e6, (int) 1e7, (int) 1e8 };
    private static final int NUM_RUNS = 5;

    public static void main(String[] args) {
        for (int setSize : SET_SIZES) {
            System.out.println("Set Size: " + setSize);
            List<Integer> integerSet = generateRandomSet(setSize);

            // Sequential Search
            long sequentialTime = measureSequentialSearch(integerSet);
            System.out.println("Sequential Search Time: " + sequentialTime + " ms");

            // Binary Search
            long binaryTime = measureBinarySearch(integerSet);
            System.out.println("Binary Search Time: " + binaryTime + " ms");

            // Search Tree Search
            long treeTime = measureSearchTreeSearch(integerSet);
            System.out.println("Search Tree Search Time: " + treeTime + " ms");

            System.out.println();
        }
    }

    private static List<Integer> generateRandomSet(int setSize) {
        List<Integer> integerSet = new ArrayList<>(setSize);
        Random random = new Random();

        for (int i = 0; i < setSize; i++) {
            integerSet.add(random.nextInt(setSize)); // Adding random integers to the set
        }

        Collections.shuffle(integerSet); // Shuffling the set

        return integerSet;
    }

    private static long measureSequentialSearch(List<Integer> integerSet) {
        long totalTime = 0;

        for (int run = 0; run < NUM_RUNS; run++) {
            int target = integerSet.get(run % integerSet.size()); // Target element to search
            long startTime = System.currentTimeMillis();

            for (int num : integerSet) {
                if (num == target) {
                    break; // Element found
                }
            }

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }

        return totalTime / NUM_RUNS; // Average time over multiple runs
    }

    private static long measureBinarySearch(List<Integer> integerSet) {
        long totalTime = 0;

        for (int run = 0; run < NUM_RUNS; run++) {
            int target = integerSet.get(run % integerSet.size()); // Target element to search
            Collections.sort(integerSet); // Sorting the set for binary search
            long startTime = System.currentTimeMillis();

            int result = Collections.binarySearch(integerSet, target);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }

        return totalTime / NUM_RUNS; // Average time over multiple runs
    }

    private static long measureSearchTreeSearch(List<Integer> integerSet) {
        long totalTime = 0;

        for (int run = 0; run < NUM_RUNS; run++) {
            int target = integerSet.get(run % integerSet.size()); // Target element to search
            BinarySearchTree<Integer> bst = new BinarySearchTree();

            for (int num : integerSet) {
                bst.insert(num); // Constructing the binary search tree
            }

            long startTime = System.currentTimeMillis();

            bst.insert(target);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }

        return totalTime / NUM_RUNS; // Average time over multiple runs
    }
}

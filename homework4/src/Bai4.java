import Bai1.ArrayStack;
import Bai2.ArrayQueue;

import java.util.*;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        Queue<Character> queue = new LinkedList<>();
        ArrayStack<Character> stack = new ArrayStack<Character>();

        // Add each character of input string to queue and stack
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        // Compare characters in queue and stack
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }
    }
}
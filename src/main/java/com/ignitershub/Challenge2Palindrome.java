package com.ignitershub;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Challenge2Palindrome {

    public void run(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().trim();

        boolean isPalindrome = isPalindrome(input);

        if (isPalindrome) {
            System.out.println("The string '" + input + "' is a palindrome.");
        } else {
            System.out.println("The string '" + input + "' is not a palindrome.");
        }
    }

    public boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

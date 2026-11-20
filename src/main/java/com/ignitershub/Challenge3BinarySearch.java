package com.ignitershub;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Challenge3BinarySearch {

    private final int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    public void run(Scanner scanner) {
        System.out.print("Enter target element: ");
        int target = scanner.nextInt();

        int index = search(target);

        if (index >= 0) {
            System.out.println("Element " + target + " is found at index " + index + ".");
        } else {
            System.out.println("Element " + target + " is not in the array.");
        }
    }

    public int search(int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] == target) {
                return mid;
            }
            if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

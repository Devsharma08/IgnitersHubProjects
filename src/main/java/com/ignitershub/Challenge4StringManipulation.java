package com.ignitershub;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Challenge4StringManipulation {

    public void run(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine().trim();

        if (sentence == null || sentence.isBlank()) {
            System.out.println("No sentence provided.");
            return;
        }

        String[] words = sentence.split("\\s+");

        System.out.println("Number of words: " + words.length);

        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        System.out.println("Reversed sentence: " + reversed.toString());

        StringBuilder hyphenated = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            hyphenated.append(words[i]);
            if (i < words.length - 1) {
                hyphenated.append("-");
            }
        }
        System.out.println("Modified sentence: " + hyphenated.toString());
    }
}

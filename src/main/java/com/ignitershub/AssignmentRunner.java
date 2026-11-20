package com.ignitershub;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AssignmentRunner implements CommandLineRunner {

    private final Challenge1EmailSender emailSender;
    private final Challenge2Palindrome palindromeChecker;
    private final Challenge3BinarySearch binarySearch;
    private final Challenge4StringManipulation stringManipulation;

    @Autowired
    public AssignmentRunner(Challenge1EmailSender emailSender,
                            Challenge2Palindrome palindromeChecker,
                            Challenge3BinarySearch binarySearch,
                            Challenge4StringManipulation stringManipulation) {
        this.emailSender = emailSender;
        this.palindromeChecker = palindromeChecker;
        this.binarySearch = binarySearch;
        this.stringManipulation = stringManipulation;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Intern Assignment - Java Set 2 ===");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        palindromeChecker.run(scanner);
        System.out.println();

        binarySearch.run(scanner);
        scanner.nextLine();
        System.out.println();

        stringManipulation.run(scanner);
        scanner.close();
        System.out.println();

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        emailSender.sendAssignmentEmail(baos.toByteArray(), "test.png");

        System.out.println();
        System.out.println("All challenges completed, including Challenge 1 email send attempt.");
    }
}

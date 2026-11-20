package com.ignitershub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;

@Component
public class Challenge1EmailSender {

    private final JavaMailSender mailSender;
    private final String to;
    private final String subject;
    private final String name;
    private final String semester;
    private final String branch;
    private final String rollNumber;
    private final String college;
    private final String repoUrl;

    public Challenge1EmailSender(JavaMailSender mailSender,
                                 @Value("${assignment.email.to}") String to,
                                 @Value("${assignment.email.subject}") String subject,
                                 @Value("${assignment.sender.name}") String name,
                                 @Value("${assignment.sender.semester}") String semester,
                                 @Value("${assignment.sender.branch}") String branch,
                                 @Value("${assignment.sender.roll-number}") String rollNumber,
                                 @Value("${assignment.sender.college:}") String college,
                                 @Value("${assignment.repo.url}") String repoUrl) {
        this.mailSender = mailSender;
        this.to = to;
        this.subject = subject;
        this.name = name;
        this.semester = semester;
        this.branch = branch;
        this.rollNumber = rollNumber;
        this.college = college;
        this.repoUrl = repoUrl;
    }

    public void sendAssignmentEmail(byte[] imageBytes, String imageFileName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);

            String body = buildBody();
            helper.setText(body, false);

            if (imageBytes != null && imageFileName != null) {
                helper.addAttachment(imageFileName,
                        new ByteArrayDataSource(imageBytes, "image/jpeg"));
            }

            mailSender.send(message);
            System.out.println("Email sent successfully to " + to);
        } catch (Exception ex) {
            System.err.println("Failed to send email: " + ex.getMessage());
        }
    }

    private String buildBody() {
        StringBuilder body = new StringBuilder();
        body.append("Dear HR Team,\n\n");
        body.append("I hope you are doing well.\n\n");
        body.append("I am writing to submit my Java coding assignment for the Igniters Hub internship (Java Set 2).\n");
        body.append("All four mandatory challenges have been completed and pushed to my GitHub repository.\n\n");
        body.append("Student Details:\n");
        body.append("Name: ").append(name).append("\n");
        body.append("Semester: ").append(semester).append("\n");
        body.append("Branch: ").append(branch).append("\n");
        body.append("Roll Number: ").append(rollNumber).append("\n");
        if (college != null && !college.isBlank()) {
            body.append("College: ").append(college).append("\n");
        }
        body.append("\n");
        body.append("GitHub Repository: ").append(repoUrl).append("\n\n");
        body.append("Please find the attached image as part of this submission.\n\n");
        body.append("Thank you for your time and consideration.\n\n");
        body.append("Best regards,\n");
        body.append(name);
        return body.toString();
    }
}

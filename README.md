# Intern Assignment - Java Set 2

## Email Summary

**From:** Poonam (HR, Igniters Hub)  
**Sent:** November 17, 2026  
**Deadline:** Saturday, November 21, 2026  

### Selection Stages
1. Complete and submit the attached Java coding assignment (`Internship - Java_Set 2.pdf`).
2. Clear the Technical & HR Interview.

### Tech Stack
Java (Challenges 2–4 explicitly list Java Spring Boot, Hibernate).

### Rules
- All 4 challenges are mandatory.
- Online research (Google, Stack Overflow, etc.) is allowed.

---

## Action Plan

1. **Acknowledge the email immediately** – Reply All to Poonam's email to confirm receipt and acknowledge the November 21 deadline (keep HR in the loop).
2. **Set up a GitHub repository** – Create a new public repo under your own GitHub account (or use the IgnitersHubProjects org if you have write access). Reference: https://github.com/IgnitersHubProjects/interns-assignments
3. **Complete all 4 mandatory challenges** – Build and test all four programs before committing.

---

## Challenges

### Challenge 1 – Programmatic Email Sender
- Java program using JavaMail / Spring Boot Mail via Gmail SMTP.
- Sends an email to `hr@ignitershub.com`.
- **Subject:** Must contain `Challenge 3 Completed` (exact string as specified in the PDF under Challenge 1).
- **Body:** Your Name, Semester, Branch (CSE), Roll Number, plus one image attachment (`.png`, `.jpg`, or `.jpeg` only). Configured via env vars.

### Challenge 2 – Palindrome Checker (Spring Boot + Hibernate)
- Prompt the user for a string input and check whether it reads the same forwards and backwards.
- Expected output: `The string 'racecar' is a palindrome.`

### Challenge 3 – Binary Search (Spring Boot + Hibernate)
- Binary search on a sorted array `[1, 3, 5, 7, 9, 11, 13, 15, 17, 19]`.
- Take a target element from the user and return its 0-based index (e.g., `Element 7 is found at index 3.`) or state that it is not in the array.

### Challenge 4 – String Manipulation (Spring Boot + Hibernate)
- Accept a sentence as input and output:
  - Word count (e.g., `Number of words: 4`)
  - Reversed word order (e.g., `Reversed sentence: fox brown quick The`)
  - Hyphenated string (e.g., `Modified sentence: The-quick-brown-fox`)

---

## Project Structure

```
igniters_Hub/
├── pom.xml
├── README.md
└── src/main
    ├── java/com/ignitershub/assignment/
    │   ├── AssignmentApplication.java
    │   ├── runner/AssignmentRunner.java
    │   ├── challenge1/EmailSender.java
    │   ├── challenge2/PalindromeChecker.java
    │   ├── challenge3/BinarySearch.java
    │   └── challenge4/StringManipulation.java
    └── resources/application.properties
```

Challenges 2–4 are console I/O tasks wrapped inside a Spring Boot application using `CommandLineRunner`, with Hibernate/JPA dependencies configured in `pom.xml` to satisfy the stack requirement.

---

## Build & Run

```bash
mvn clean package
mvn spring-boot:run
```

Configure Gmail SMTP credentials as environment variables before running:

```bash
export GMAIL_EMAIL=your-email@gmail.com
export GMAIL_APP_PASSWORD=your-app-password
mvn spring-boot:run
```

The email is sent to `hr@ignitershub.com` with subject `Challenge 3 Completed`, body containing your details (configured via env vars), and one `.png` image attachment.

Set these environment variables before running:

```bash
export GMAIL_EMAIL=your-email@gmail.com
export GMAIL_APP_PASSWORD=your-app-password
export SENDER_NAME=your-name
export SENDER_SEMESTER=your-semester
export SENDER_BRANCH=your-branch
export SENDER_ROLL_NUMBER=your-roll-number
export SENDER_COLLEGE=your-college
mvn spring-boot:run
```

# Intern Assignment - Java Set 2

### Tech Stack
Java (Challenges 2–4 explicitly list Java Spring Boot, Hibernate).

### Rules
- All 4 challenges are mandatory.
- Online research (Google, Stack Overflow, etc.) is allowed.

---

## Challenges

### Challenge 1 – Programmatic Email Sender

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

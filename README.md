# Simple Quiz Program

## Description
This project is a command-line interface (CLI) application built in Java, created as the final project for our Object-Oriented Programming (OOP) class.
Demonstration and class explanations link : https://youtu.be/I18K35mfbyY
## Features
- Demonstrates core OOP principles.
- Reads questions from external files.
- Supports customizable quiz questions.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/alvinskylers/java-group-project.git
   ```
2. Open the project in your preferred IDE.
3. Run the `Main.java` class.

## Changing the Question Source
To use your own question file, follow these steps:

1. Create a file (e.g., `myfile.txt` or `questions.txt`).
2. Place the file in the `/src/main/resources` directory.
3. Open the file in a text editor and format it as described below.

## Question File Format
The question file should follow a specific format:

1. The first two lines are metadata:
   - **First line**: Quiz title
   - **Second line**: Quiz description
2. Starting from the third line, add your questions in one of the supported formats: Multiple Choice Questions (MCQs) or True or False (TOF).

### MCQ Format
Each MCQ should follow this format:
```
question, answer a, answer b, answer c, answer d, correct answer (number)
```
**Example:**
```
Object-Oriented Programming Quiz          // First line: Quiz title
Simple OOP Quiz to test your knowledge   // Second line: Quiz description
Which of the following isn't an OOP pillar?, Inheritance, Abstraction, Polymorphism, Nihilism, 4
... // More questions
```
Each question is converted into an object and stored in an ArrayList.

### TOF Format
Each TOF question should follow this format:
```
statement, answer (true/false)
```
**Example:**
```
Object-Oriented Programming Quiz          // First line: Quiz title
Simple OOP Quiz to test your knowledge   // Second line: Quiz description
Spoiled milk tastes great, false
... // More questions
```

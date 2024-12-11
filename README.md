# CourseGradebook: A Java-Based Grade Management System

## Overview
CourseGradebook is a Java application designed to manage and retrieve student grades efficiently. It implements an abstract `Gradebook` class and provides functionalities for adding, updating, and retrieving scores for assignments and students. The project demonstrates core object-oriented programming concepts such as abstraction, inheritance, and efficient use of Java collections.

## Features
- **Add or Update Scores**: Easily set or update a student’s score for a specific assignment.
- **Retrieve Scores**:
  - Get a specific student's score for an assignment.
  - Retrieve all scores for a specific assignment.
  - Retrieve all scores for a specific student.
- **Sort Data**:
  - Get all distinct assignment names sorted in ascending order.
  - Get all distinct student IDs sorted in ascending order.

## Classes

### `Gradebook` (Abstract Class)
Defines the structure and methods that any gradebook implementation must support, including:
- `getScore`: Retrieve a student's score for a specific assignment.
- `setScore`: Add or update a student's score.
- `getAssignmentScores`: Get all scores for a specific assignment.
- `getSortedAssignmentNames`: Retrieve a sorted list of all assignment names.
- `getSortedStudentIDs`: Retrieve a sorted list of all student IDs.
- `getStudentScores`: Retrieve all scores for a specific student.

### `CourseGradebook` (Concrete Class)
Implements the `Gradebook` interface with the following functionality:
- Stores grades using a `HashMap` where:
  - Keys are assignment names.
  - Values are another `HashMap` mapping student IDs to their scores.
- Provides methods to manage and query the gradebook.

## Technologies
- **Language**: Java
- **Libraries Used**: Java Collections (`HashMap`, `ArrayList`, `HashSet`)

## Getting Started

### Prerequisites
- Java Development Kit (JDK) version 8 or above.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or VS Code).

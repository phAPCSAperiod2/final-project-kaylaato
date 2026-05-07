# 📚 Assignment Manager

A command-line productivity application built in Java to help users organize, prioritize, and track assignments efficiently.

---

# 1. Project Description

Assignment Manager is a terminal-based Java application designed to help students and other users stay organized by managing assignments and deadlines in one place. Users can add assignments, sort them by due date or priority, mark tasks as completed, edit assignment details, and view assignments through a visual priority dashboard. The project demonstrates object-oriented programming concepts, data structures, sorting algorithms, and scheduling logic while providing a practical solution for time management and productivity.

---

# 2. Features

- Add new assignments with:
  - Assignment name
  - Due date
  - Priority level
- View all assignments in a structured list
- Sort assignments by:
  - Priority
  - Due date
- Edit assignment information
- Mark assignments as completed
- Remove assignments from the list
- Visualize assignments using a **2D priority dashboard**
- Generate **suggested start dates** based on urgency and priority
- Menu-driven user interaction through the terminal
- Dynamic assignment storage using `ArrayList`

---

# 3. Code Structure and Design

The project follows an object-oriented design with separate classes responsible for different parts of the program.

## Main Classes

### `Assignment`
Represents a single assignment object.

Responsibilities:
- Stores assignment data:
  - Name
  - Due date
  - Priority level
  - Completion status
- Provides getter and setter methods
- Formats assignment information for display

---

### `AssignmentManager`
Handles assignment storage and management.

Responsibilities:
- Stores assignments using an `ArrayList<Assignment>`
- Adds, removes, edits, and displays assignments
- Sorts assignments by priority and due date
- Maintains the 2D priority dashboard

Data Structures Used:
- `ArrayList<Assignment>` for dynamic assignment storage
- `Assignment[][] priorityGrid` for dashboard visualization
- `int[] rowCounts` to track assignments in each row

---

### `Scheduler`
Responsible for scheduling logic.

Responsibilities:
- Calculates suggested start dates
- Uses Java `LocalDate` methods for date calculations
- Recommends earlier start dates for higher-priority assignments

---

### `Main`
Controls the user interface and program flow.

Responsibilities:
- Displays menus
- Handles user input and validation
- Connects all program components together
- Executes user-selected actions

---

## Object-Oriented Design Concepts

This project demonstrates several important AP Computer Science A concepts:

- **Encapsulation**
  - Assignment data is stored in private variables with controlled access through methods.

- **Abstraction**
  - Complex scheduling and management logic is separated into dedicated classes.

- **Object Interaction**
  - `Main` communicates with `AssignmentManager` and `Scheduler`, which interact with `Assignment` objects.

- **Data Structures**
  - Uses both `ArrayList` collections and 2D arrays for organization and visualization.

---

## UML Diagram

The UML class diagram for this project is included below:

![Class Diagram](images/class-diagram.png)

https://drive.google.com/file/d/1bd7gBZffEQFyYFdfDoXVMdpjZRodydNz/view?usp=sharing

Example relationship flow:

```text
Main → Scheduler → AssignmentManager → Assignment
```

---

# 4. How to Run the Program

## Requirements

- Java JDK 8 or higher
- Terminal, Command Prompt, or Java IDE
  - VS Code
  - IntelliJ IDEA
  - Eclipse

---

## Step-by-Step Instructions

### 1. Clone the Repository

```bash
git clone <your-repository-link>
```

---

### 2. Open the Project Folder

```bash
cd <your-project-folder>
```

---

### 3. Compile the Program

```bash
javac Main.java
```

---

### 4. Run the Program

```bash
java Main
```

---

## Example User Actions

When the program starts, users can choose menu options such as:

```text
1. Add Assignment
2. View Assignments
3. Sort by Priority
4. Sort by Due Date
5. Mark Assignment Complete
6. Edit Assignment
7. View Dashboard
8. Exit
```

Example input:

```text
Enter assignment name: Math Homework
Enter due date (YYYY-MM-DD): 2026-05-15
Enter priority (1-5): 5
```

---

# 5. Development Process

One challenge during development was organizing assignments visually using a 2D array dashboard while still maintaining a flexible assignment list. This was solved by combining an `ArrayList` for storage with a separate 2D array for visualization purposes.

A feature I am especially proud of is the suggested start-date system, which helps users plan ahead instead of waiting until the last minute to begin assignments.

If more development time were available, I would add persistent file storage so assignments could be saved and loaded automatically between sessions. I would also improve input validation and potentially create a graphical user interface using JavaFX.

---

# 6. Use of AI Tools

## AI Assistance

ChatGPT and Gemini was used to help brainstorm project organization ideas, improve README formatting, debug logic issues, and refine explanations for documentation. All AI-assisted suggestions and code were reviewed, tested, modified as needed, and fully understood by the student before being included in the project.

---

# 7. Author Information

**Student Name:** *Kayla To*
**Course:** AP Computer Science A

This project helped strengthen my understanding of object-oriented programming, data structures, class design, and building user-focused software applications in Java.

# 📚 Assignment Manager

## 🔹 What This Software Does
Assignment Manager is a command-line Java application designed to help users organize, track, and prioritize their academic or personal assignments.

Users can:
- Add and manage assignments with due dates and priority levels
- View assignments sorted by priority or due date
- Mark assignments as completed
- Edit assignment details
- Visualize tasks using a **2D priority dashboard**
- Get **suggested start dates** based on urgency

The program focuses on improving productivity and time management through structured organization.

---

## 🔹 Who It’s For
This software is designed for:
- Students managing multiple assignments and deadlines
- Anyone who wants a simple, structured task tracker
- Users who prefer a lightweight, terminal-based productivity tool

It solves the problem of:
> Losing track of deadlines and not knowing when to start assignments.

---

## 🔹 How to Run the Program

### ✅ Requirements
- Java JDK (version 8 or higher)
- A terminal or IDE (VS Code, IntelliJ, etc.)

### ▶️ Steps
1. Clone the repository:
   ```bash
   git clone <your-repo-link>
   ```

2. Navigate into the project folder:
   ```bash
   cd <your-folder-name>
   ```

3. Compile the program:
   ```bash
   javac Main.java
   ```

4. Run the program:
   ```bash
   java Main
   ```

---

## 🔹 Technical Overview

### 🧩 Main Classes

**`Assignment`**
- Represents a single task
- Stores:
  - Name
  - Due date (YYYY-MM-DD)
  - Priority (1–5)
  - Completion status
- Includes getters/setters and formatted display output

**`AssignmentManager`**
- Manages all assignments using an `ArrayList`
- Handles:
  - Adding/removing assignments
  - Sorting (priority and due date using Bubble Sort)
  - Display formatting
- Implements a **2D array (5x10)** as a priority dashboard

**`Scheduler`**
- Calculates suggested start dates
- Uses `LocalDate` to subtract days based on priority
- Higher priority = earlier start recommendation

**`Main`**
- Controls user interaction
- Handles:
  - Menu navigation
  - Input/output
  - Editing and completing assignments

---

### 🗂️ Key Data Structures
- `ArrayList<Assignment>` → dynamic storage of assignments
- `Assignment[][] priorityGrid` → 2D dashboard organized by priority levels
- `int[] rowCounts` → tracks how many assignments are in each priority row

---

### ⚙️ Core Features
- Sorting algorithms (Bubble Sort)
- 2D array visualization
- Input validation and menu navigation
- Object-oriented design with encapsulation
- Date calculations using `LocalDate`

---

## 🔹 Class Diagram
![Class Diagram](images/class-diagram.png)

Example:
```
Main → Scheduler → AssignmentManager → Assignment
```

---

## 🔹 Known Limitations / Future Improvements

### ⚠️ Current Limitations
- No persistent storage (data is lost when program exits)
- User must type exact assignment names to edit or complete
- Limited input validation (e.g., date format is assumed correct)
- Fixed 2D array size (max 10 assignments per priority level)

### 🚀 Future Improvements
- Save/load data from a file
- Add GUI (JavaFX or Swing)
- Improve search (ID system instead of name matching)
- Replace Bubble Sort with more efficient algorithms
- Add categories or tags for assignments
- Allow flexible dashboard sizing

---

## 🎯 Final Notes
This project demonstrates:
- Object-oriented programming
- Data structure implementation (ArrayList + 2D arrays)
- Algorithmic thinking (sorting, scheduling logic)
- User-focused software design

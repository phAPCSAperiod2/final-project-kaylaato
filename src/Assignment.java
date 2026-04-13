public class Assignment {
    // INSTANCE VARIABLES
    String name;                // name of assignemnt
    String dueDate;             // due date of assignment (format: year-month-date, ex. 2026-04-13)
    int priority;               // prioirty of assignment (1-5)
    boolean isCompleted;        // completion of assignment

    // CONSTRUCTOR
    public Assignment(String name, String dueDate, int priority){
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        isCompleted = false;
    }

    // METHODS
    public void markComplete(){
        isCompleted = true;
    }

    public String toString() {
        return  "Assignment: " + name + "\nDue Date: " + dueDate + "\nPriority: " + priority +
                "\nCompleted: " + (isCompleted ? "Yes" : "No") + "\n";
    }


    // GETTERS
    public String getName(){
        return name;
    }

    public String getDueDate(){
        return dueDate;
    }

    public int getPriority(){
        return priority;
    }


    // SETTERS
    public String setName(String newName){
        name = newName;
        return name;
    }

    public String setDueDate(String newDueDate){
        dueDate = newDueDate;
        return dueDate;
    }

    public int newPriority(int newPriority){
        priority = newPriority;
        return priority;
    }
}

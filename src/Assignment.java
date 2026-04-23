/**
 * Represents an academic or personal assignment with tracking for due dates and priority levels.
 *
 * @author Kayla To
 * @collaborators Gemini
 * @version 4/14/2026
 */
public class Assignment {
    // INSTANCE VARIABLES ---------------------------------------------------------------------------------------------------------
    private String name;                // name of assignemnt
    private String dueDate;             // due date of assignment (format: year-month-date, ex. 2026-04-13)
    private int priority;               // prioirty of assignment (1-5)
    private boolean isCompleted;        // completion of assignment

    // CONSTRUCTOR ----------------------------------------------------------------------------------------------------------------
    /**
     * Constructs a new Assignment with a name, due date, and priority.
     * By default, the assignment is marked as not completed.
     *
     * @param name      The title of the assignment.
     * @param dueDate   The date the assignment is due.
     * @param priority  The importance level (1-5).
     */
    public Assignment(String name, String dueDate, int priority){
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = false;
    }

    // METHODS --------------------------------------------------------------------------------------------------------------------
    /**
     * Marks the assignment as completed.
     */
    public void markComplete(){
        isCompleted = true;
    }

    /**
     * Returns a string representation of the assignment details.
     * * @return A formatted string containing the name, due date, priority, and status.
     */
    public String toString() {
        return "Assignment: " + name + ", " + dueDate + ", " + priority + " priority level, " + isCompleted;
        //return  "Assignment: " + name + "\nDue Date: " + dueDate + "\nPriority: " + priority +       "\nCompleted: " + (isCompleted ? "Yes" : "No") + "\n";
    }


    // GETTERS ---------------------------------------------------------------------------------------------------------------------
    /**
     * Gets the name of the assignment.
     * @return The assignment name.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the due date of the assignment.
     * @return The due date string.
     */
    public String getDueDate(){
        return dueDate;
    }

    /**
     * Gets the priority level of the assignment.
     * @return The priority integer.
     */
    public int getPriority(){
        return priority;
    }

    /**
     * Gets the status of the assignment.
     * @return if assignment is completed
     */
    public boolean getStatus(){
        return isCompleted;
    }


    // SETTERS ---------------------------------------------------------------------------------------------------------------------
    /**
     * Updates the name of the assignment.
     * * @param newName The new name to set.
     * @return The updated name.
     */
    public String setName(String newName){
        name = newName;
        return name;
    }

    /**
     * Updates the due date of the assignment.
     * * @param newDueDate The new due date (YYYY-MM-DD).
     * @return The updated due date.
     */
    public String setDueDate(String newDueDate){
        dueDate = newDueDate;
        return dueDate;
    }

    /**
     * Updates the priority level of the assignment.
     * @param newPriority The new priority level (1-5).
     */
    public void setPriority(int newPriority) {
        this.priority = newPriority;
    }
}

import java.util.ArrayList;

/**
 * Manages a collection of Assignment objects.
 * Provides functionality to add, remove, and retrieve assignments.

 * @author Kayla To
 * @collaborators Gemini
 * @version 4/14/2026
 */
public class AssignmentManager {
    // INSTANCE VARIABLES ---------------------------------------------------------------------------------------------------------
    public ArrayList<Assignment> assignmentList; // The list storing all assignment objects
    private Assignment[][] priorityGrid = new Assignment[5][10];
    private int[] rowCounts = new int[5]; // how many assignments are in each prioirty

    // CONSTRUCTOR ----------------------------------------------------------------------------------------------------------------
    /**
     * Constructs an empty AssignmentManager with an initialized list.
     */
    public AssignmentManager() {
        this.assignmentList = new ArrayList<>();
    }

    // METHODS --------------------------------------------------------------------------------------------------------------------
    /**
     * Adds a new assignment to the manager.
     *
     * @param assignment The Assignment object to be added.
     */
    public void addAssignment(Assignment assignment){
        assignmentList.add(assignment);
    }

    /**
     * Removes an assignment from the list based on its position.
     * Validates the index to prevent errors.
     *
     * @param index The position of the assignment to remove (0-based).
     */
    public void removeAssignment(int index) {
        if (index >= 0 && index < assignmentList.size()) {
            assignmentList.remove(index);
        } else {
            System.out.println("Invalid index. Could not remove assignment.");
        }
    }

    public void removeAssignment(Assignment a) {
    if (a != null) {
        assignmentList.remove(a);
    }
    }

    /**
     * Retrieves the entire list of assignments.
     *
     * @return An ArrayList containing all current assignments.
     */
    public ArrayList<Assignment> getAllAssignments() {
        return assignmentList;
    }

    /**
     * Generates a string summary of all assignments in the list.
     * Each assignment's details are separated by a newline.
     *
     * @return A formatted string representation of the full assignment list.
     */
    public String toString() {
        String output = "\n--- Assignment List ---\n";
        for (int i = 0; i < assignmentList.size(); i++) {
            output += assignmentList.get(i).toString() + "\n";
        }
        return output;
    }

    public String toStringCompleted(){
        String output = "\n--- Assignment List ---\n";
        for (int i = 0; i < assignmentList.size(); i++) {
            if (assignmentList.get(i).getStatus() == true) {
                output += assignmentList.get(i).toString() + "\n";
            }
        }
        return output;
    }

    /**
     * Sorts the assignment list by priority in ascending order (1 to 5)
     * using a Bubble Sort algorithm.
     *
     * @author Gemini
     */
    public void sortByPriorityLow() {
        int n = assignmentList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare priority of current assignment with the next one
                if (assignmentList.get(j).getPriority() > assignmentList.get(j + 1).getPriority()) {
                    // Swap assignments
                    Assignment temp = assignmentList.get(j);
                    assignmentList.set(j, assignmentList.get(j + 1));
                    assignmentList.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Sorts the assignment list by priority in ascending order (1 to 5)
     * using a Bubble Sort algorithm.
     *
     * @author Gemini
     * @collaborator Kayla To
     */
    public void sortByPriorityHigh() {
        int n = assignmentList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare priority of current assignment with the next one
                if (assignmentList.get(j).getPriority() < assignmentList.get(j + 1).getPriority()) {
                    // Swap assignments
                    Assignment temp = assignmentList.get(j);
                    assignmentList.set(j, assignmentList.get(j + 1));
                    assignmentList.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Sorts the assignment list by due date chronologically
     * using a Bubble Sort algorithm.
     *
     * @author Gemini
     */
    public void sortByDueDate() {
        int n = assignmentList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Use compareTo to check alphabetical order of date strings
                if (assignmentList.get(j).getDueDate().compareTo(assignmentList.get(j + 1).getDueDate()) > 0) {
                    // Swap assignments
                    Assignment temp = assignmentList.get(j);
                    assignmentList.set(j, assignmentList.get(j + 1));
                    assignmentList.set(j + 1, temp);
                }
            }
        }
    }

    // 2D ARRAY IMPLEMENTATION --------------------------------------------------------------------------------------------------
    /**
     * Places an assignment into the 2D dashboard grid based on its priority.
     * * @param a The assignment to add to the grid.
     * @return true if successfully added, false if the priority level is full.
     *
     * @author Gemini
     */
    public boolean addAssignmentToGrid(Assignment a) {
        int row = a.getPriority() - 1; // Map priority 1-5 to index 0-4

        if (rowCounts[row] < 10) {
            priorityGrid[row][rowCounts[row]] = a;
            rowCounts[row]++;
            return true;
        }
        return false;
    }

    /**
     * Returns a formatted string of the 2D Priority Dashboard.
     * @return A string representation of the grid.
     *
     * @author Gemini
     */
    public String getDashboardString() {
        String layout = "=== PRIORITY DASHBOARD ===\n";
        for (int i = 0; i < priorityGrid.length; i++) {
            layout += "Level " + (i + 1) + ": ";
            for (int j = 0; j < rowCounts[i]; j++) {
                layout += "[" + priorityGrid[i][j].getName() + "] ";
            }
            layout += "\n";
        }
        return layout;
    }

    

}

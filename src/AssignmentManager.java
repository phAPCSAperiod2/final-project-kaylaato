import java.util.ArrayList;

/**
 * Manages a collection of Assignment objects.
 * Provides functionality to add, remove, and retrieve assignments.

 * @author Kayla To
 * @collaborators Gemini
 * @version 5/5/2026
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
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Sorted Assignment List ---\n");
        sb.append(String.format("%-4s %-20s | %-17s | %-10s\n", "ST", "NAME", "DUE DATE", "PRIORITY"));
        sb.append("------------------------------------------------------------\n");
        for (Assignment a : assignmentList) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Generates a simple numbered list of assignment names.
     *
     * @return A vertically formatted string of assignment names for menus.
     */
    public String toStringList() {
        if (assignmentList.isEmpty()) {
            return "[ No assignments found ]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("");

        for (int i = 0; i < assignmentList.size(); i++) {
            sb.append(String.format(" %d. %s\n", (i + 1), assignmentList.get(i).getName()));
        }

        return sb.toString();
    }

    /**
     * Sorts the assignment list by priority in ascending order (1 to 5)
     * using a Bubble Sort algorithm.
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
     * @param The assignment to add to the grid.
     * @return true if successfully added, false if the priority level is full.
     *
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

    /**
     * Synchronizes the 2D Priority Grid with the current Assignment List.
     * This should be called whenever an assignment is edited, added, or removed.
     */
    public void refreshGrid() {
        this.priorityGrid = new Assignment[5][10];
        this.rowCounts = new int[5];

        for (Assignment a : assignmentList) {
            addAssignmentToGrid(a);
        }
    }


}

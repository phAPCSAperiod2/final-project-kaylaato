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
        String output = "--- Assignment List ---\n";
        for (int i = 0; i < assignmentList.size(); i++) {
            output += assignmentList.get(i).toString() + "\n";
        }
        return output;
    }

    public String toStringCompleted(){
        for(int i = 0; i < assignmentList.size(); i++){
            if (assignmentList.get(i).getStatus() = true){
                assignmentList.removeAssignment(i);
            }
        }
    }

    /**
     * Sorts the assignment list by priority in ascending order (1 to 5)
     * using a Bubble Sort algorithm.
     *
     * @author Gemini
     */
    public void sortByPriority() {
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

}

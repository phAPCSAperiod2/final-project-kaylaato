import java.util.ArrayList;
public class AssignmentManager {
    // INSTANCE VARIABLES
    private ArrayList<Assignment> assignmentList;

    // CONSTRUCTOR
    public AssignmentManager() {
        this.assignmentList = new ArrayList<>();
    }

    // METHODS
    public void addAssignment(Assignment assignment){
        assignmentList.add(assignment);
    }

    public void removeAssignment(int index) {
        if (index >= 0 && index < assignmentList.size()) {
            assignmentList.remove(index);
        } else {
            System.out.println("Invalid index. Could not remove assignment.");
        }
    }

    public ArrayList<Assignment> getAllAssignments() {
        return assignmentList;
    }

    public String toString() {
        String output = "--- Assignment List ---\n";
        for (int i = 0; i < assignmentList.size(); i++) {
            output += assignmentList.get(i).toString() + "\n";
        }
        return output;
    }

    // public void sortByPriority() {

    // }

    // public void sortByDueDate() {

    // }

}

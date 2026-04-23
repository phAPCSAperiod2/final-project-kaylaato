import java.time.LocalDate; //formats date in YYYY-MM-DD

/**
 * Handles scheduling assignments, provides recommended start times
 *
 * @author Kayla To
 * @collaborators Gemini
 * @version 4/22/2026
 */
public class Scheduler {
    // INSTANCE VARIABLES ---------------------------------------------------------------------------------------------------------
    public AssignmentManager manager;

    // CONSTRUCTOR ----------------------------------------------------------------------------------------------------------------
    public Scheduler() {
        this.manager = new AssignmentManager();
    }

    // METHODS --------------------------------------------------------------------------------------------------------------------
    /**
     * Recommends a start date based on the priority of the assignment.
     * High priority (1) suggests starting 7 days early.
     * Low priority (5) suggests starting 1 day early.
     * @param assignment The assignment to calculate for.
     * @return A String representing the suggested start date.
     */
    public String getSuggestedStartDate(Assignment assignment) {
        LocalDate date = LocalDate.parse(assignment.getDueDate()); // parse year-month-date into LocalDate object

        int daysToSubtract = 6 - assignment.getPriority(); // determine how soon to start depending on priority of assignmnet
        if (daysToSubtract < 1){ // if less than 1, set to 1
            daysToSubtract = 1;
        }

        LocalDate startDate = date.minusDays(daysToSubtract); //use minusDays method to determine when to start assignment
        return startDate.toString(); //return startDate as a String
    }
}

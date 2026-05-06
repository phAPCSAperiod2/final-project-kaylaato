import java.util.Scanner;

/**
 * The entry point for the Assignment Manager application.
 * This class handles user interaction, application flow, and coordinates
 * between the Scheduler and AssignmentManager.
 * @author Kayla To
 * @collaborators Gemini
 * @version 4/14/2026
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scheduler myScheduler = new Scheduler();
        AssignmentManager manager = myScheduler.manager;

        // welcome message
        System.out.println("\nWelcome to the Assignment Manager 📚");

        runInitialSetup(input, manager, myScheduler);
        runMainMenu(input, manager, myScheduler);

        // closing message
        System.out.println("\nGoodbye! Stay productive! 🤓");
        input.close();
    }

    /**
     * Handles the first-time setup phase where the user can bulk-add assignments.
     * @param input The Scanner object for user input.
     * @param manager The AssignmentManager to store the assignments.
     * @param myScheduler The Scheduler to coordinate with.
     */
    public static void runInitialSetup(Scanner input, AssignmentManager manager, Scheduler myScheduler){
        System.out.println("\n========================================");
        System.out.println("             INITIAL SETUP             ");
        System.out.println("========================================");
        boolean done = false;
        // add assignments until user is done
        while(!done){
            addSingleAssignment(input, manager, myScheduler);

            System.out.print("Add more assignments? (yes/no) ");
            String answer = input.nextLine().trim().toLowerCase();
            if(answer.equals("no") || answer.equals("n")){
                done = true;
            }
        }
    }

    /**
     * Prompts the user for details and creates a single Assignment object.
     * * @param input The Scanner object for user input.
     * @param manager The AssignmentManager to update.
     * @param myScheduler The Scheduler to update.
     */
    private static void addSingleAssignment(Scanner input, AssignmentManager manager, Scheduler myScheduler) {
        System.out.print("Enter assignment name: ");
        String name = input.nextLine();
        System.out.print("Enter due date (format: YYYY-MM-DD): ");
        String due = input.nextLine();
        System.out.print("Enter priority level (1-5, 1 highest, 5 lowest): ");
        int priority = Integer.parseInt(input.nextLine()); //suggestion from Gemini

        // add assignment to scheduler, manager, and 2D array
        Assignment a1 = new Assignment(name, due, priority);
        myScheduler.manager.addAssignment(a1);
        manager.addAssignmentToGrid(a1);
    }

    /**
     * Displays and manages the primary navigation menu of the application.
     * @param input The Scanner object for user input.
     * @param manager The manager handling assignments.
     * @param myScheduler The scheduler handling start dates.
     */
    public static void runMainMenu(Scanner input, AssignmentManager manager, Scheduler myScheduler) {
        boolean running = true;
        while(running == true){
        System.out.println("\n========================================");
        System.out.println("               MAIN MENU               ");
        System.out.println("========================================");
            System.out.println("1. Update Assignment\n2. View Assignments \n3. Suggested Schedule \n0. Exit Program");
            System.out.print("Enter number: ");
            String choice = input.nextLine();

            switch(choice){
                case "1":
                    runEditMenu(input, manager);
                    break;

                case "2":
                    changeViewMenu(input, manager, myScheduler);
                    break;

                case "3":
                    suggestedSchedule(manager, myScheduler);
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Provides options to modify an existing assignment's details or status.
     * @param input The Scanner object for user input.
     * @param manager The AssignmentManager containing assignments.
     */
    private static void runEditMenu(Scanner input, AssignmentManager manager){
        System.out.println("\n=== Editing Options ===");
        System.out.println("1. Edit Assignment | 2. Change to Completed | 3. Return to Main Menu");
        System.out.print("Enter number: ");
        String choice = input.nextLine();
        if(choice.equals("1")){
            editAssignment(input, manager);
        }
        else if(choice.equals("2")){
            completeAssignment(input, manager);
        }
    }

    /**
     * Prints a list of assignments with their calculated suggested start dates.
     * @param manager The manager providing the list of assignments.
     * @param myScheduler The scheduler performing the start date calculations.
     */
    private static void suggestedSchedule(AssignmentManager manager, Scheduler myScheduler) {
        System.out.println("\n=== SUGGESTED START DATE ===");
        for (Assignment a : myScheduler.manager.getAllAssignments()) {
            System.out.println(a.getName() + " -> Start by: " + myScheduler.getSuggestedStartDate(a));
        }
    }

    /**
     * Displays a menu to sort and view assignments in different formats.
     * @param input The Scanner object for user input.
     * @param manager The AssignmentManager to sort and retrieve data from.
     * @param myScheduler The scheduler (contextual access).
     */
    private static void changeViewMenu(Scanner input, AssignmentManager manager, Scheduler myScheduler){
        System.out.println("\n=== View Options ===");
        System.out.println("1. View by Prioirty | 2. View by Due Date | 3. Show Prioirty Dashboard | 4. Return to Main Menu");
        System.out.print("Enter number: ");
        String choice = input.nextLine();

        if(choice.equals("1")){
            manager.sortByPriorityHigh();
            System.out.println(manager.toString());
        }
        else if(choice.equals("2")){
            manager.sortByDueDate();;
            System.out.println(manager.toString());
        }
        else if(choice.equals("3")){
            System.out.println();
            System.out.println(manager.getDashboardString());
        }
        else if(choice.equals("4")){
            return;
        }
        else{
            System.out.print("Choice invalid. Returning to main menu. ");
        }
    }

    /**
     * Facilitates the editing of an assignment's specific attributes.
     * Allows skipping fields by pressing Enter.
     * @param input The Scanner object for user input.
     * @param manager The AssignmentManager to update.
     */
    private static void editAssignment(Scanner input, AssignmentManager manager){
        System.out.println("\n=== Edit Assignment ===");
        System.out.println("Current List: \n" + manager.toStringList());
        System.out.print("Enter the name to edit: ");
        String targetName = input.nextLine();

        // Find the assignment in manager
        Assignment target = null;
        for (Assignment a : manager.getAllAssignments()) {
            if (a.getName().equalsIgnoreCase(targetName)) {
                target = a;
                break;
            }
        }

        if (target == null) {
            System.out.println("Assignment not found!");
                return;
        }
        System.out.println("Editing: " + target.getName());
        System.out.println("[Press Enter to keep the current value]");

        // Edit Name
        System.out.print("New name (" + target.getName() + "): ");
        String newName = input.nextLine();
        if (!newName.trim().isEmpty()) {
            target.setName(newName);
        }

        // Edit Due Date
        System.out.print("New due date (" + target.getDueDate() + "): ");
        String newDate = input.nextLine();
        if (!newDate.trim().isEmpty()) {
            target.setDueDate(newDate);
        }

        // Edit Priority
        System.out.print("New priority 1-5 (" + target.getPriority() + "): ");
        String prioInput = input.nextLine();
        if (!prioInput.trim().isEmpty()) {
            try {
                int newPrio = Integer.parseInt(prioInput);
                if (newPrio >= 1 && newPrio <= 5) {
                    target.setPriority(newPrio);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Priority unchanged.");
            }
        }
        manager.refreshGrid();
        System.out.println("Update complete!");
    }

    /**
     * Marks a specific assignment as completed and refreshes the priority grid.
     * @param input The Scanner object for user input.
     * @param manager The AssignmentManager to update.
     */
    private static void completeAssignment(Scanner input, AssignmentManager manager){
        System.out.println("\n=== Mark as Completed ===");
        System.out.println("Current List: \n" + manager.toStringList());
        System.out.print("Enter the name of assignment completed: ");
        String targetName = input.nextLine();

        Assignment toRemove = null;
        for (Assignment a : manager.getAllAssignments()) {
            if (a.getName().equalsIgnoreCase(targetName)) {
                toRemove = a;
                break;
            }
        }

        if (toRemove != null) {
            toRemove.markComplete();
            manager.refreshGrid();
            System.out.println("Good job! '" + toRemove.getName() + "' is now marked as completed. 🎉");
        } else {
            System.out.println("Assignment not found. Check the spelling and try again.");
        }
    }
}

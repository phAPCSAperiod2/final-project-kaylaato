import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scheduler myScheduler = new Scheduler();
        AssignmentManager manager = myScheduler.manager;

        // welcome message
        System.out.println("Welcome to the Assignment Manager 📚");

        // inital setup
        runInitialSetup(input, manager, myScheduler);

        runMainMenu(input, manager, myScheduler);


    }

        public static void runInitialSetup(Scanner input, AssignmentManager manager, Scheduler myScheduler){
            System.out.println("=== Add Assignments ===");
            boolean done = false;
            while(done == false){
                addSingleAssignment(input, manager, myScheduler);

                System.out.print("Add more assignments? ");
                String answer = input.nextLine();
                if(answer.toLowerCase().equals("no")){
                    done = true;
                }
            }
        }

        private static void addSingleAssignment(Scanner input, AssignmentManager manager, Scheduler myScheduler) {
            System.out.print("Enter assignment name: ");
            String name = input.nextLine();
            System.out.print("Enter due date (format: YYYY-MM-DD): ");
            String due = input.nextLine();
            System.out.print("Enter priority level (1-5, 1 highest, 5 lowest): ");
            int priority = input.nextInt();
            input.nextLine();

            Assignment a1 = new Assignment(name, due, priority);
            myScheduler.manager.addAssignment(a1);
            manager.addAssignmentToGrid(a1);
        }

        public static void runMainMenu(Scanner input, AssignmentManager manager, Scheduler myScheduler) {
            boolean contin = true;
            while(contin == true){
                System.out.println("\n=== Main Menu ===");
                System.out.println("1. Edit Assignment | 2. Change View | 3. Suggested Schedule");
                System.out.print("Enter number: ");
                int option = input.nextInt();
                input.nextLine();

                if(option == 1){
                    System.out.println("\n=== Editing Options ===");
                    System.out.println("1. Edit Assignment | 2. Change to Completed");
                    System.out.print("Enter number: ");
                    int option3 = input.nextInt();
                    input.nextLine();
                    if(option3 == 1){
                        editAssignment(input, manager);
                    }
                    if(option3 == 2){
                        completeAssignment(input, manager);
                    }

                }

                else if(option == 2){
                    viewOptions(input, manager, myScheduler);
                }

                else if(option == 3){
                    showSuggestions(manager, myScheduler);
                }

                else{
                    System.out.print("Choice invalid. Enter number: ");
                    option = input.nextInt();
                    input.nextLine();
                }
            }
        }

        private static void showSuggestions(AssignmentManager manager, Scheduler myScheduler) {
            System.out.println("\n=== SUGGESTED START DATE ===");
            for (Assignment a : myScheduler.manager.getAllAssignments()) {
                System.out.println(a.getName() + " -> Start by: " + myScheduler.getSuggestedStartDate(a));
            }
        }

        private static void viewOptions(Scanner input, AssignmentManager manager, Scheduler myScheduler){
            System.out.println("\n=== View Options ===");
            System.out.println("1. View by Prioirty | 2. View by Due Date | 3. Show Prioirty Dashboard | 4. Return to Main Menu");
            System.out.print("Enter number: ");
            int option2 = input.nextInt();
            input.nextLine();

            if(option2 == 1){
                manager.sortByPriorityHigh();
                System.out.println(manager.toString());
            }

            else if(option2 == 2){
                manager.sortByDueDate();;
                System.out.println(manager.toString());
            }

            else if(option2 == 3){
                System.out.println(manager.getDashboardString());
            }

            else if(option2 == 4){
                return;
            }

            else{
                System.out.print("Choice invalid. Returning to main menu. ");
            }
        }

        private static void editAssignment(Scanner input, AssignmentManager manager){
            System.out.println("\n=== Edit Assignment ===");
            System.out.print("Enter the name of the assignment to edit: ");
            String targetName = input.nextLine();

            // Find the assignment in your manager
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

            System.out.println("Found: " + target.getName() + " (Due: " + target.getDueDate() + ")");
            System.out.println("Leave blank to keep current value, or enter new details:");

            // Edit Name
            System.out.print("New name (or press Enter to skip): ");
            String newName = input.nextLine();
            if (!newName.isEmpty()) {
                target.setName(newName);
            }

            // Edit Due Date
            System.out.print("New due date YYYY-MM-DD (or press Enter to skip): ");
            String newDate = input.nextLine();
            if (!newDate.isEmpty()) {
                target.setDueDate(newDate);
            }

            // Edit Priority
            System.out.print("New priority 1-5 (or enter 0 to skip): ");
            int newPrio = input.nextInt();
            input.nextLine(); // clear buffer
            if (newPrio >= 1 && newPrio <= 5) {
                target.setPriority(newPrio);
            }

            System.out.println("Assignment updated successfully!");
        }

        private static void completeAssignment(Scanner input, AssignmentManager manager){
            System.out.println("\n=== Mark as Completed ===");
            System.out.print("Enter the name of the assignment you finished: ");
            String targetName = input.nextLine();

            // 1. Find the assignment
            Assignment toRemove = null;
            for (Assignment a : manager.getAllAssignments()) {
                if (a.getName().equalsIgnoreCase(targetName)) {
                    toRemove = a;
                    break;
                }
            }

            // 2. Remove it if found
            if (toRemove != null) {
                manager.removeAssignment(toRemove); // Make sure your manager has a remove method!
                System.out.println("Great job! '" + targetName + "' has been removed from your list. 🎉");
            } else {
                System.out.println("Assignment not found. Check the spelling and try again.");
            }
        }
    }

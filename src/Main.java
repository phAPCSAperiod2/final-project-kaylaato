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
                System.out.println("=== Choose Option ===");
                System.out.println("1. Edit Assignment | 2. Change View | 3. Suggested Schedule");
                System.out.print("Enter number: ");
                int option = input.nextInt();
                input.nextLine();

                if(option == 1){
                    System.out.println("1. ");
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
            System.out.println("=== SUGGESTED START DATE ===");
            for (Assignment a : myScheduler.manager.getAllAssignments()) {
                System.out.println(a.getName() + " -> Start by: " + myScheduler.getSuggestedStartDate(a));
            }
        }

        private static void viewOptions(Scanner input, AssignmentManager manager, Scheduler myScheduler){
            System.out.println("1. View by Prioirty");
            System.out.println("2. View by Due Date");
            System.out.println("3. Show Prioirty Dashboard");
            System.out.print("Enter number: ");
            int option2 = input.nextInt();
            input.nextLine();
        }
}

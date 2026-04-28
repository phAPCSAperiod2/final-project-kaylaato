import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scheduler myScheduler = new Scheduler();
        AssignmentManager manager = myScheduler.manager;

        // welcome message
        System.out.println("Welcome to the Assignment Manager 📚");
        System.out.println("=== Add Assignments ===");
        boolean done = false;
        while(done == false){
            System.out.print("Enter assignment name: ");
            String name = input.nextLine();
            System.out.print("Enter due date (format: YYYY-MM-DD): ");
            String due = input.nextLine();
            System.out.print("Enter priority level (1-5, 1 highest, 5 lowest): ");
            int priority = input.nextInt();
            input.nextLine();

            Assignment a1 = new Assignment(name, due, priority);

            System.out.print("Add more assignments?");
            String answer = input.nextLine();
            if(answer.toLowerCase().equals("no")){
                done = true;
            }
        }

        // // 1) test adding assignments
        // Assignment a1 = new Assignment("Math Review", "2026-04-20", 3);
        // myScheduler.manager.addAssignment(a1);
        // Assignment a2 = new Assignment("CSA Final Project", "2026-04-15", 4);
        // myScheduler.manager.addAssignment(a2);
        // Assignment a3 = new Assignment("Psychology Reading 5.6b", "2026-04-16", 2);
        // myScheduler.manager.addAssignment(a3);
        // manager.addAssignmentToGrid(a1);
        // manager.addAssignmentToGrid(a2);
        // manager.addAssignmentToGrid(a3);

        // System.out.println("--- INITIAL LIST ---");
        // System.out.println(manager.toString());

        // // 2) test sorting by priority
        // System.out.println("--- SORTED BY PRIORITY (Low to High) ---");
        // manager.sortByPriorityLow();
        // System.out.println(manager.toString());

        // // 2) test sorting by priority
        // System.out.println("--- SORTED BY PRIORITY (High to Low) ---");
        // manager.sortByPriorityHigh();
        // System.out.println(manager.toString());

        // // 3) test sorting by due date
        // System.out.println("--- SORTED BY DUE DATE ---");
        // myScheduler.manager.sortByDueDate();
        // System.out.println(myScheduler.manager.toString());

        // // 4) test suggested start times
        // System.out.println("--- SUGGESTED START TIMES ---");
        // for (Assignment a : myScheduler.manager.getAllAssignments()) {
        //      System.out.println(a.getName() + " -> Start by: " + myScheduler.getSuggestedStartDate(a));
        // }

        // // 5) test 2D array implementation
        // System.out.println(manager.getDashboardString());

    }
}

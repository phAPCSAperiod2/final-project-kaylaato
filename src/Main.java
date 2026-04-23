public class Main {
    public static void main(String[] args) {
        // create assignment manager object
        AssignmentManager manager = new AssignmentManager();

        // create scheduler object
        Scheduler myScheduler = new Scheduler();

        // 1) test adding assignments
        Assignment assign1 = new Assignment("Math Review", "2026-04-20", 3);
        myScheduler.manager.addAssignment(assign1);
        Assignment assign2 = new Assignment("CSA Final Project", "2026-04-15", 4);
        myScheduler.manager.addAssignment(assign2);
        Assignment assign3 = new Assignment("Psychology Reading 5.6b", "2026-04-16", 2);
        myScheduler.manager.addAssignment(assign3);

        System.out.println("--- INITIAL LIST ---");
        System.out.println(manager.toString());

        // 2) test sorting by priority
        System.out.println("--- SORTED BY PRIORITY (Low to High) ---");
        manager.sortByPriorityLow();
        System.out.println(manager.toString());

        // 2) test sorting by priority
        System.out.println("--- SORTED BY PRIORITY (High to Low) ---");
        manager.sortByPriorityHigh();
        System.out.println(manager.toString());

        // 3) test sorting by due date
        System.out.println("--- SORTED BY DUE DATE ---");
        myScheduler.manager.sortByDueDate();
        System.out.println(myScheduler.manager.toString());

        // 4) test suggested start times
        System.out.println("--- SUGGESTED START TIMES ---");
        for (Assignment a : myScheduler.manager.getAllAssignments()) {
             System.out.println(a.getName() + " -> Start by: " + myScheduler.getSuggestedStartDate(a));
        }
    }
}

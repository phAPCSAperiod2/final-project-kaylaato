public class Main {
    public static void main(String[] args) {
        // create assignment manager object
        AssignmentManager manager = new AssignmentManager();

        // add assignments
        Assignment assign1 = new Assignment("Math Unit 4 Review", "2026-04-20", 3);
        manager.addAssignment(assign1);
        Assignment assign2 = new Assignment("CSA Final Project", "2026-04-15", 4);
        manager.addAssignment(assign2);
        Assignment assign3 = new Assignment("Psychology Reading 5.6b", "2026-04-16", 2);
        manager.addAssignment(assign3);

        // print out assignments
        System.out.println(manager.toString());
    }
}

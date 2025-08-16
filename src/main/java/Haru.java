import java.util.ArrayList;
import java.util.Scanner;

public class Haru {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<Task> tasks = new ArrayList<>();
        String logo = """
   ___ ___
 /   |   \\_____ _______ __ __
/    ~    \\__  \\\\_  __ \\  |  \\
\\    Y    // __ \\|  | \\/  |  /
 \\___|_  /(____  /__|  |____/
       \\/      \\/
""";

        System.out.println("    --------------------------------------");
        System.out.println("    Hello! I'm \n" + logo);
        System.out.println("    What can I do for you today? \n");
        System.out.println("    --------------------------------------");

        while (true) {
            System.out.println();
            input = sc.nextLine().trim();
            System.out.println();
            System.out.println("    --------------------------------------");

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("    Bye. Hope to see you again soon! \n");
                System.out.println("    --------------------------------------");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                int size = tasks.size();
                if (size != 0) {
                    System.out.println("    Here are the tasks in your list:");
                    for (int i = 0; i < size; i++) {
                        System.out.println("    " + (i + 1) + ". " + tasks.get(i).toString());
                    }
                    System.out.println();
                    System.out.println("    --------------------------------------");
                } else {
                    System.out.println("    No task found :(");
                }
            } else if (input.toLowerCase().startsWith("mark")) {
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    int index = Integer.parseInt(parts[1]);
                    if (index >= tasks.size()) {
                        System.out.println("    Please enter a valid task number");
                    }
                    tasks.get(index - 1).mark();
                    System.out.println("    Nice! I've marked this task as done:");
                    System.out.println("        " + tasks.get(index - 1).toString());
                } else {
                    System.out.println("    Failed to mark task");
                }
                System.out.println();
                System.out.println("    --------------------------------------");
            } else if (input.toLowerCase().startsWith("unmark")) {
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    int index = Integer.parseInt(parts[1]);
                    if (index >= tasks.size()) {
                        System.out.println("    Please enter a valid task number");
                    }
                    tasks.get(index - 1).unmark();
                    System.out.println("    OK, I've unmarked this task as not done yet:");
                    System.out.println("        " + tasks.get(index - 1).toString());
                } else {
                    System.out.println("    Failed to unmark task");
                }
                System.out.println();
                System.out.println("    --------------------------------------");
            } else {
                tasks.add(new Task(input));
                System.out.println("    added: " + input);
                System.out.println();
                System.out.println("    --------------------------------------");
            }
        }
        sc.close();
    }
}

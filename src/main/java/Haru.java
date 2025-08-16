import java.util.ArrayList;
import java.util.Scanner;

public class Haru {
    public static void main(String[] args) throws HaruException {
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
        System.out.println("    Hello! I'm");
        System.out.println(logo);
        System.out.println("    What can I do for you today?");
        System.out.println();
        System.out.println("    --------------------------------------");

        while (true) {
            try {
                System.out.println();
                input = sc.nextLine().trim();
                System.out.println();
                System.out.println("    --------------------------------------");

                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("    Bye. Hope to see you again soon!");
                    System.out.println();
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
                            throw new HaruException("Please enter a valid task number");
                        }
                        tasks.get(index - 1).mark();
                        System.out.println("    Nice! I've marked this task as done:");
                        System.out.println("        " + tasks.get(index - 1).toString());
                    } else {
                        throw new HaruException("Please specify which task number you want to mark");
                    }
                    System.out.println();
                    System.out.println("    --------------------------------------");
                } else if (input.toLowerCase().startsWith("unmark")) {
                    String[] parts = input.split(" ");
                    if (parts.length > 1) {
                        int index = Integer.parseInt(parts[1]);
                        if (index >= tasks.size()) {
                            throw new HaruException("Please enter a valid task number");
                        }
                        tasks.get(index - 1).unmark();
                        System.out.println("    OK, I've unmarked this task as not done yet:");
                        System.out.println("        " + tasks.get(index - 1).toString());
                    } else {
                        throw new HaruException("Please specify which task number you want to unmark");
                    }
                    System.out.println();
                    System.out.println("    --------------------------------------");
                } else if (input.toLowerCase().startsWith("todo")) {
                    String name = input.substring(5);
                    if (name.isEmpty()) {
                        throw new HaruException("Please specify the name of the task");
                    }
                    Task task = new ToDo(name);
                    tasks.add(task);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("        " + task);
                    System.out.println("    Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println();
                    System.out.println("    --------------------------------------");
                } else if (input.toLowerCase().startsWith("deadline")) {
                    String[] parts = input.substring(9).split("/by");
                    String name = parts[0].trim();
                    if (name.isEmpty()) {
                        throw new HaruException("Please specify the name of the task");
                    }
                    String end = parts.length > 1 ? parts[1].trim() : "";
                    if (end.isEmpty()) {
                        throw new HaruException("Please specify the end date/time of the task");
                    }
                    Task task = new Deadline(name, end);
                    tasks.add(task);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("        " + task);
                    System.out.println("    Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println();
                    System.out.println("    --------------------------------------");
                } else if (input.toLowerCase().startsWith("event")) {
                    String[] parts = input.substring(6).split("/from|/to");
                    String name = parts[0].trim();
                    if (name.isEmpty()) {
                        throw new HaruException("Please specify the name of the task");
                    }
                    String start = parts.length > 1 ? parts[1].trim() : "";
                    if (start.isEmpty()) {
                        throw new HaruException("Please specify the start date/time of the task");
                    }
                    String end = parts.length > 2 ? parts[2].trim() : "";
                    if (end.isEmpty()) {
                        throw new HaruException("Please specify the end date/time of the task");
                    }
                    Task task = new Event(name, end, start);
                    tasks.add(task);
                    System.out.println("    Got it. I've added this task:");
                    System.out.println("        " + task);
                    System.out.println("    Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println();
                    System.out.println("    --------------------------------------");
                } else {
                    throw new HaruException("Please specify the type of your task");

                }
            } catch (HaruException err) {
                System.out.println("    " + err.getMessage());
                System.out.println();
                System.out.println("    --------------------------------------");
            }
        }
        sc.close();
    }
}

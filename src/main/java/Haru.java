import java.util.ArrayList;
import java.util.Scanner;

public class Haru {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<String> tasks = new ArrayList<>();
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
                    for (int i = 0; i < size; i++) {
                        System.out.println("    " + (i + 1) + ". " + tasks.get(i));
                    }
                    System.out.println();
                    System.out.println("    --------------------------------------");
                } else {
                    System.out.println("    No task found :(");
                }
            } else {
                tasks.add(input);
                System.out.println("    added: " + input);
                System.out.println();
                System.out.println("    --------------------------------------");
            }
        }
        sc.close();
    }
}

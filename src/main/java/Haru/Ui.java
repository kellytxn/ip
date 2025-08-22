package Haru;

import java.util.Scanner;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public void showWelcome(String logo) {
        System.out.println("    --------------------------------------");
        System.out.println("    Hello! I'm");
        System.out.println(logo);
        System.out.println("    What can I do for you today?");
        System.out.println("    --------------------------------------");
    }

    public void showGoodbye() {
        System.out.println();
        System.out.println("    --------------------------------------");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    --------------------------------------");
    }

    public void showError(String message) {
        System.out.println();
        System.out.println("    --------------------------------------");
        System.out.println("    " + message);
        System.out.println("    --------------------------------------");
    }

    public void showMessage(String message) {
        System.out.println();
        System.out.println("    --------------------------------------");
        System.out.println(message);
        System.out.println("    --------------------------------------");
    }

    public String readCommand() {
        System.out.println();
        return sc.nextLine().trim();
    }

    public void close() {
        sc.close();
    }
}


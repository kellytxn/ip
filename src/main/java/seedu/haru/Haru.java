package seedu.haru;

import java.util.ArrayList;
import java.time.format.DateTimeParseException;

/**
 * The main class of the Haru Chatbot application.
 * Handles the main program loop, user input, and command execution.
 */
public class Haru {
    public static void main(String[] args) {
        String logo = """
                   ___ ___
                 /   |   \\_____ _______ __ __
                /    ~    \\__  \\\\_  __ \\  |  \\
                \\    Y    // __ \\|  | \\/  |  /
                 \\___|_  /(____  /__|  |____/
                       \\/      \\/
                """;

        Ui ui = new Ui();
        Storage storage = new Storage("./data/duke.txt");
        TaskList taskList = new TaskList(new ArrayList<>(storage.loadTasks()));

        ui.showWelcome(logo);

        while (true) {
            try {
                String input = ui.readCommand();
                if (input.equalsIgnoreCase("bye")) {
                    ui.showGoodbye();
                    break;
                }

                String command = Parser.getCommand(input);
                String arg = Parser.getArguments(input);

                switch (command) {
                case "list":
                    if (taskList.size() == 0) ui.showMessage("    No task found :(");
                    else {
                        StringBuilder sb = new StringBuilder("    Here are the tasks in your list:\n");
                        for (int i = 0; i < taskList.size(); i++) {
                            sb.append("    ").append(i + 1).append(". ").append(taskList.getTasks().get(i)).append("\n");
                        }
                        ui.showMessage(sb.toString());
                    }
                    break;

                case "todo":
                    if (arg.isEmpty()) throw new HaruException("Please specify the name of the task");
                    Task todo = new ToDo(arg, Type.TODO);
                    taskList.add(todo);
                    storage.saveTasks(taskList.getTasks());
                    ui.showMessage("    Got it. I've added this task:\n        " + todo + "\n    Now you have " + taskList.size() + " tasks in the list.");
                    break;

                case "deadline":
                    String[] deadlineParts = Parser.parseDeadline(arg);
                    Task deadlineTask;
                    try {
                        deadlineTask = new Deadline(deadlineParts[0], deadlineParts[1], Type.DEADLINE);
                    } catch (DateTimeParseException e) {
                        throw new HaruException("    Invalid date format! Use yyyy-MM-dd, e.g., 2019-12-02");
                    }
                    taskList.add(deadlineTask);
                    storage.saveTasks(taskList.getTasks());
                    ui.showMessage("    Got it. I've added this task:\n        " + deadlineTask + "\n    Now you have " + taskList.size() + " tasks in the list.");
                    break;

                case "event":
                    String[] eventParts = Parser.parseEvent(arg);
                    Task eventTask = new Event(eventParts[0], eventParts[2], eventParts[1], Type.EVENT);
                    taskList.add(eventTask);
                    storage.saveTasks(taskList.getTasks());
                    ui.showMessage("    Got it. I've added this task:\n        " + eventTask + "\n    Now you have " + taskList.size() + " tasks in the list.");
                    break;

                case "mark":
                    int markIndex = Integer.parseInt(arg) - 1;
                    taskList.mark(markIndex);
                    storage.saveTasks(taskList.getTasks());
                    ui.showMessage("    Nice! I've marked this task as done:\n        " + taskList.getTasks().get(markIndex));
                    break;

                case "unmark":
                    int unmarkIndex = Integer.parseInt(arg) - 1;
                    taskList.unmark(unmarkIndex);
                    storage.saveTasks(taskList.getTasks());
                    ui.showMessage("    OK, I've unmarked this task as not done yet:\n        " + taskList.getTasks().get(unmarkIndex));
                    break;

                case "delete":
                    int delIndex = Integer.parseInt(arg) - 1;
                    Task removed = taskList.remove(delIndex);
                    storage.saveTasks(taskList.getTasks());
                    ui.showMessage("    Noted. I've removed this task:\n        " + removed);
                    break;

                case "find":
                    if (arg.isEmpty()) throw new HaruException("Please specify what you are trying to find");
                    TaskList result = taskList.find(arg);
                    if (result.size() == 0) ui.showMessage("    No task found :(");
                    else {
                        StringBuilder sb = new StringBuilder("    Here are the matching tasks in your list:\n");
                        for (int i = 0; i < taskList.size(); i++) {
                            sb.append("    ").append(i + 1).append(". ").append(taskList.getTasks().get(i)).append("\n");
                        }
                        ui.showMessage(sb.toString());
                    }
                    break;

                default:
                    throw new HaruException("Please specify the type of your task");
                }

            } catch (HaruException e) {
                ui.showError(e.getMessage());
            }
        }
        ui.close();
    }
}
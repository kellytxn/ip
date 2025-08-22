package seedu.haru;

/**
 * Represents a task in the Haru chatbot.
 * A task has a name, completion status and type.
 */
public class Task {
    protected boolean isDone;
    protected String name;
    protected Type type;

    /**
     * Creates a new Task with the given description and type.
     *
     * @param name name of the task
     * @param type type of the task
     */
    public Task(String name, Type type) {
        this.name = name;
        this.isDone = false;
        this.type = type;
    }

    /**
     * Marks this task as done.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Unmarks this task as undone.
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return the string representation of the task
     */
    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + name;
        } else {
            return "[ ] " + name;
        }
    }

    /**
     * Converts the task to a format suitable for saving in storage.
     *
     * @return a string representation of the task
     */
    public String toFileString() {
        return (isDone ? 1 : 0) + " | " + name;
    }

    public static Task fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        switch (type) {
            case "T":
                Task todo = new ToDo(description, Type.TODO);
                if (isDone) {
                    todo.mark();
                }
                return todo;
            case "D":
                String by = parts[3];
                Task deadline = new Deadline(description, by, Type.DEADLINE);
                if (isDone) {
                    deadline.mark();
                }
                return deadline;
            case "E":
                String from = parts[3];
                String to = parts[4];
                Task event = new Event(description, from, to, Type.EVENT);
                if (isDone) {
                    event.mark();
                }
                return event;
            default:
                return null;
        }
    }
}

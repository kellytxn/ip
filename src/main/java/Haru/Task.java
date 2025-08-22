package Haru;

public class Task {
    protected boolean isDone;
    protected final String name;
    protected final Type type;

    public Task(String name, Type type) {
        this.name = name;
        this.isDone = false;
        this.type = type;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + name;
        } else {
            return "[ ] " + name;
        }
    }

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

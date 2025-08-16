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

}

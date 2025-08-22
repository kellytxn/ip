package Haru;

public class ToDo extends Task {
    public ToDo(String name, Type type) {
        super(name, type);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileString() {
        return "T | " + super.toFileString();
    }
}

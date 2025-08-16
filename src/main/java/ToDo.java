public class ToDo extends Task {
    public ToDo(String name, Type type) {
        super(name, type);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

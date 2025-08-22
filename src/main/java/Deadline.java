public class Deadline extends Task{
    protected String end;

    public Deadline(String name, String end, Type type) {
        super(name, type);
        this.end = end;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.end + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + super.toFileString() + " | " + this.end;
    }
}

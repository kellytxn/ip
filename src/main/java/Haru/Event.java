package Haru;

public class Event extends Task {
    protected String start;
    protected String end;

    public Event(String name, String end, String start, Type type) {
        super(name, type);
        this.end = end;
        this.start = start;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.end +  " to: " + this.start + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + super.toFileString() + " | " + this.start + " | " + this.end;
    }
}

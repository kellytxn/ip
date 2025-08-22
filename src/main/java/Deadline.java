import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    protected LocalDate end;

    private static final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String name, String end, Type type) {
        super(name, type);
        this.end = LocalDate.parse(end, inputFormat);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.end.format(outputFormat) + ")";
    }

    @Override
    public String toFileString() {

        return "D | " + super.toFileString() + " | " + this.end;
    }
}

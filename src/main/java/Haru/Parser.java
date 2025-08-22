package Haru;

public class Parser {

    public static String getCommand(String input) {
        return input.split(" ")[0].toLowerCase();
    }

    public static String getArguments(String input) {
        int firstSpace = input.indexOf(" ");
        return firstSpace == -1 ? "" : input.substring(firstSpace + 1).trim();
    }

    public static String[] parseDeadline(String args) throws HaruException {
        String[] parts = args.split("/by");
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new HaruException("Please specify the end date in yyyy-mm-dd format");
        }
        return new String[]{parts[0].trim(), parts[1].trim()};
    }

    public static String[] parseEvent(String args) throws HaruException {
        String[] parts = args.split("/from|/to");
        if (parts.length < 3 || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
            throw new HaruException("Please specify start and end date/time for the event");
        }
        return new String[]{parts[0].trim(), parts[1].trim(), parts[2].trim()};
    }
}


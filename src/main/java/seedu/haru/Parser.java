package seedu.haru;

/**
 * Handles parsing of user input into commands and arguments.
 */
public class Parser {

    /**
     * Extracts the command word from the user input.
     *
     * @param input the full user input string
     * @return the command word in lowercase
     */
    public static String getCommand(String input) {
        return input.split(" ")[0].toLowerCase();
    }

    /**
     * Extracts the arguments from the user input.
     *
     * @param input the full user input string
     * @return the arguments string, or an empty string if none
     */
    public static String getArguments(String input) {
        int firstSpace = input.indexOf(" ");
        return firstSpace == -1 ? "" : input.substring(firstSpace + 1).trim();
    }

    /**
     * Parses the arguments for a Deadline command.
     *
     * @param args the argument string
     * @return a string array: [name, end]
     * @throws HaruException if the format is invalid or due date is missing
     */
    public static String[] parseDeadline(String args) throws HaruException {
        String[] parts = args.split("/by");
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new HaruException("Please specify the end date in yyyy-mm-dd format");
        }
        return new String[]{parts[0].trim(), parts[1].trim()};
    }

    /**
     * Parses the arguments for an Event command.
     *
     * @param args the argument string
     * @return a string array: [description, end, start]
     * @throws HaruException if the format is invalid or start/end times are missing
     */
    public static String[] parseEvent(String args) throws HaruException {
        String[] parts = args.split("/from|/to");
        if (parts.length < 3 || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
            throw new HaruException("Please specify start and end date/time for the event");
        }
        return new String[]{parts[0].trim(), parts[1].trim(), parts[2].trim()};
    }
}


package seedu.haru;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Storage {
    private Path filePath;

    public Storage(String filePathStr) {
        this.filePath = Paths.get(filePathStr);
        try {
            File file = filePath.toFile();
            File dir = file.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error initializing storage: " + e.getMessage());
        }
    }

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(filePath.toFile())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Task.fromFileString(line); // implement in Haru.Task class
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(filePath.toFile())) {
            for (Task task : tasks) {
                writer.write(task.toFileString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}

import java.util.*;

public class TaskList {
    private List<Task> tasks;

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task remove(int index) throws HaruException {
        if (index < 0 || index >= tasks.size()) throw new HaruException("Invalid task number");
        return tasks.remove(index);
    }

    public void mark(int index) throws HaruException {
        if (index < 0 || index >= tasks.size()) throw new HaruException("Invalid task number");
        tasks.get(index).mark();
    }

    public void unmark(int index) throws HaruException {
        if (index < 0 || index >= tasks.size()) throw new HaruException("Invalid task number");
        tasks.get(index).unmark();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int size() {
        return tasks.size();
    }
}

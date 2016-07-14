package ua.goit.homework8ee;

/**
 * Created by user on 14.07.2016.
 */
public class Task {
    private String taskName;
    private String taskCategory;

    public Task(String taskName, String taskCategory) {
        this.taskName = taskName;
        this.taskCategory = taskCategory;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskCategory() {
        return taskCategory;
    }
}

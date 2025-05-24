package org.example.assignment;

/**
 * Task class represents a single task within a project.
 * This class is composed inside the Project class.
 */
public class Task {
    // Attributes
    private int taskId;
    private String description;
    private boolean completed;
    private char taskType; // 'A' (Admin), 'L' (Logistics), 'S' (Support)
    private int taskDuration; // in hours

    /**
     * Constructor initializes a Task with all required attributes.
     */
    public Task(int taskId, String description, boolean completed, char taskType, int taskDuration) {
        this.taskId = taskId;
        this.description = description;
        this.completed = completed;
        this.taskType = Character.toUpperCase(taskType); // Normalize input
        this.taskDuration = taskDuration;
    }

    // ----------------------
    // Getters and Setters
    // ----------------------

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public char getTaskType() {
        return taskType;
    }

    public void setTaskType(char taskType) {
        this.taskType = Character.toUpperCase(taskType);
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    /**
     * Returns a formatted string for task status.
     * @return "Completed" or "Pending"
     */
    public String getStatus() {
        return completed ? "Completed" : "Pending";
    }
}

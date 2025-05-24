package org.example.assignment;

/**
 * Project class manages tasks based on its project type capacity.
 * Uses composition to hold Task objects.
 */
public class Project {
    private int projectId;
    private String projectName;
    private Task[] tasks; // Task composition
    private String projectType; // Small, Medium, Large

    public Project(int projectId, String projectName, String projectType) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectType = normalizeProjectType(projectType);
        this.tasks = new Task[getTaskLimit(this.projectType)];
    }

    // Normalize and validate project type
    private String normalizeProjectType(String type) {
        if (type == null) return "Small";
        type = type.trim().toLowerCase();
        switch (type) {
            case "small": return "Small";
            case "medium": return "Medium";
            case "large": return "Large";
            default: return "Small";
        }
    }

    private int getTaskLimit(String type) {
        switch (type) {
            case "Small": return 1;
            case "Medium": return 2;
            case "Large": return 3;
            default: return 1;
        }
    }

    // Getters
    public int getProjectId() { return projectId; }
    public String getProjectName() { return projectName; }
    public String getProjectType() { return projectType; }

    public void setProjectName(String name) {
        this.projectName = name;
    }

    // Add task if there's space and no duplicate ID
    public boolean addTask(Task task) {
        // Check for duplicate task ID
        for (Task t : tasks) {
            if (t != null && t.getTaskId() == task.getTaskId()) {
                return false;
            }
        }
        // Insert into first available slot
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                return true;
            }
        }
        return false; // No space
    }

    // Remove task by ID
    public boolean removeTask(int taskId) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].getTaskId() == taskId) {
                tasks[i] = null;
                return true;
            }
        }
        return false;
    }

    // Return task by ID
    public Task getTask(int taskId) {
        for (Task task : tasks) {
            if (task != null && task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    // Return number of current tasks
    public int getNumberOfTasks() {
        int count = 0;
        for (Task task : tasks) {
            if (task != null) count++;
        }
        return count;
    }

    // Return array of tasks
    public Task[] getTasks() {
        return tasks;
    }

    // Display full project and task details
    public void displayProjectDetails() {
        System.out.println("Project ID: " + projectId + ", Project Name: " + projectName +
                ", Project Type: " + projectType + ", Num of tasks: " + getNumberOfTasks());
        System.out.println("Tasks:");
        boolean hasTasks = false;
        for (Task task : tasks) {
            if (task != null) {
                displayTaskDetails(task);
                hasTasks = true;
            }
        }
        if (!hasTasks) {
            System.out.println("  No tasks available.");
        }
        System.out.println("----------------------------------------------------------");
    }

    private void displayTaskDetails(Task task) {
        System.out.println("* Task ID: " + task.getTaskId() + ", Description: " + task.getDescription() +
                ", Type: " + task.getTaskType() + ", Duration: " + task.getTaskDuration() +
                ", Status: " + (task.isCompleted() ? "Completed" : "Pending"));
    }

    // Display only completed tasks
    public void displayCompletedTasks() {
        boolean hasCompleted = false;
        System.out.println("Completed tasks in Project ID: " + projectId);
        for (Task task : tasks) {
            if (task != null && task.isCompleted()) {
                displaySimpleTask(task);
                hasCompleted = true;
            }
        }
        if (!hasCompleted) {
            System.out.println("  No completed tasks found.");
        }
    }

    // Short format display
    private void displaySimpleTask(Task task) {
        System.out.println("* Task ID: " + task.getTaskId() + ", Description: " + task.getDescription() +
                ", Type: " + task.getTaskType() + ", Duration: " + task.getTaskDuration());
    }

    // Filter tasks by type (A/L/S) and display with grouping
    public void filterTasksByType(char type) {
        int count = 0;
        for (Task task : tasks) {
            if (task != null && Character.toUpperCase(task.getTaskType()) == Character.toUpperCase(type)) {
                count++;
            }
        }

        if (count > 0) {
            System.out.println("Project ID: " + projectId + ", Project Name: " + projectName +
                    ", Project Type: " + projectType + ", Num of " + getTypeName(type) + " tasks: " + count);
            System.out.println("Tasks:");
            for (Task task : tasks) {
                if (task != null && Character.toUpperCase(task.getTaskType()) == Character.toUpperCase(type)) {
                    displayTaskDetails(task);
                }
            }
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Project ID: " + projectId + " has no " + getTypeName(type) + " tasks.");
        }
    }

    private String getTypeName(char type) {
        switch (Character.toUpperCase(type)) {
            case 'A': return "administrative";
            case 'L': return "logistics";
            case 'S': return "support";
            default: return "unknown";
        }
    }

    // Average duration for specific task type
    public double averageDurationByType(char type) {
        int total = 0;
        int count = 0;
        for (Task task : tasks) {
            if (task != null && Character.toUpperCase(task.getTaskType()) == Character.toUpperCase(type)) {
                total += task.getTaskDuration();
                count++;
            }
        }
        return count == 0 ? 0 : (double) total / count;
    }
}

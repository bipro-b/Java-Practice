package org.example.assignment;

import java.io.*;
import java.util.Scanner;

public class UserInterface {
    private Project[] projects = new Project[10];
    private Scanner scannerInput = new Scanner(System.in);

    public static void main(String[] args) {
        new UserInterface().run();
    }

    public void run() {
        while (true) {
            displayMenu();
            String choice = scannerInput.nextLine().trim();
            switch (choice) {
                case "1": createProject(); break;
                case "2": removeProject(); break;
                case "3": addTask(); break;
                case "4": removeTask(); break;
                case "5": markTaskCompleted(); break;
                case "6": displayAllProjects(); break;
                case "7": displayCompletedTasks(); break;
                case "8": filterTasksByType(); break;
                case "9": displayDurationSummary(); break;
                case "10": loadFromFile(); break;
                case "11": saveToFile(); break;
                case "0": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===== Project Management Menu =====");
        System.out.println("1. Create a Project");
        System.out.println("2. Remove a Project");
        System.out.println("3. Add a Task to a Project");
        System.out.println("4. Remove a Task from a Project");
        System.out.println("5. Mark a Task as Completed");
        System.out.println("6. Display All Projects Details");
        System.out.println("7. Display Completed Tasks");
        System.out.println("8. Filter Tasks by Type");
        System.out.println("9. Project Task Duration Summary");
        System.out.println("10. Load from File");
        System.out.println("11. Save to File");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private Project findProjectById(int id) {
        for (Project project : projects) {
            if (project != null && project.getProjectId() == id) return project;
        }
        return null;
    }

    private void createProject() {
        try {
            int index = findEmptySlot();
            if (index == -1) {
                System.out.println("Max project limit reached.");
                return;
            }

            System.out.print("Enter Project ID: ");
            int id = Integer.parseInt(scannerInput.nextLine());

            if (findProjectById(id) != null) {
                System.out.println("Duplicate ID entered!");
                do {
                    id = (int) (Math.random() * 9000) + 1000;
                } while (findProjectById(id) != null);
                System.out.println("A new unique Project ID has been assigned: " + id);
            }

            System.out.print("Enter Project Name: ");
            String name = scannerInput.nextLine();

            System.out.print("Enter Project Type (Small/Medium/Large): ");
            String type = scannerInput.nextLine();

            projects[index] = new Project(id, name, type);
            System.out.println("Project created with ID: " + id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Project ID must be a number.");
        }
    }



    private int findEmptySlot() {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) return i;
        }
        return -1;
    }

    private void removeProject() {
        try {
            System.out.print("Enter Project ID to remove: ");
            int id = Integer.parseInt(scannerInput.nextLine());

            for (int i = 0; i < projects.length; i++) {
                if (projects[i] != null && projects[i].getProjectId() == id) {
                    projects[i] = null;
                    System.out.println("Project removed.");
                    return;
                }
            }
            System.out.println("Project not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void addTask() {
        try {
            System.out.print("Enter Project ID: ");
            int projectId = Integer.parseInt(scannerInput.nextLine());
            Project project = findProjectById(projectId);

            if (project == null) {
                System.out.println("Project not found.");
                return;
            }

            System.out.print("Enter Task ID: ");
            int taskId = Integer.parseInt(scannerInput.nextLine());

            if (project.getTask(taskId) != null) {
                System.out.println("Duplicate Task ID detected.");
                do {
                    taskId = (int)(Math.random() * 9000) + 1000;
                } while (project.getTask(taskId) != null);
                System.out.println("Assigned new unique Task ID: " + taskId);
            }

            System.out.print("Enter Description: ");
            String desc = scannerInput.nextLine();

            System.out.print("Enter Task Type (A/L/S): ");
            char type = scannerInput.nextLine().toUpperCase().charAt(0);

            System.out.print("Enter Duration (hours): ");
            int duration = Integer.parseInt(scannerInput.nextLine());

            Task task = new Task(taskId, desc, false, type, duration);
            if (project.addTask(task)) {
                System.out.println("Task added with ID: " + taskId);
            } else {
                System.out.println("Task limit reached for this project.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values for IDs and duration.");
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
    }


    private void removeTask() {
        try {
            System.out.print("Enter Project ID: ");
            int pid = Integer.parseInt(scannerInput.nextLine());
            Project p = findProjectById(pid);
            if (p == null) {
                System.out.println("Project not found.");
                return;
            }
            System.out.print("Enter Task ID to remove: ");
            int tid = Integer.parseInt(scannerInput.nextLine());
            if (p.removeTask(tid)) {
                System.out.println("Task removed.");
            } else {
                System.out.println("Task not found.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    private void markTaskCompleted() {
        try {
            System.out.print("Enter Project ID: ");
            int pid = Integer.parseInt(scannerInput.nextLine());
            Project p = findProjectById(pid);
            if (p == null) {
                System.out.println("Project not found.");
                return;
            }
            System.out.print("Enter Task ID: ");
            int tid = Integer.parseInt(scannerInput.nextLine());
            Task t = p.getTask(tid);
            if (t != null) {
                t.setCompleted(true);
                System.out.println("Task marked complete.");
            } else {
                System.out.println("Task not found.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    private void displayAllProjects() {
        for (Project p : projects) {
            if (p != null) p.displayProjectDetails();
        }
    }

    private void displayCompletedTasks() {
        try {
            System.out.print("Enter Project ID: ");
            int pid = Integer.parseInt(scannerInput.nextLine());
            Project p = findProjectById(pid);
            if (p != null) p.displayCompletedTasks();
            else System.out.println("Project not found.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    private void filterTasksByType() {
        try {
            System.out.print("Enter Task Type (A/L/S): ");
            char type = scannerInput.nextLine().toUpperCase().charAt(0);
            for (Project p : projects) {
                if (p != null) p.filterTasksByType(type);
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    private void displayDurationSummary() {
        System.out.println("----- Average Duration Summary -----");
        displayAverageByType('A');
        displayAverageByType('L');
        displayAverageByType('S');

        for (Project p : projects) {
            if (p != null) {
                System.out.println("Project ID: " + p.getProjectId());
                System.out.println("* A: " + p.averageDurationByType('A') + " hrs");
                System.out.println("* L: " + p.averageDurationByType('L') + " hrs");
                System.out.println("* S: " + p.averageDurationByType('S') + " hrs");
            }
        }
    }

    private void displayAverageByType(char type) {
        int total = 0, count = 0;
        for (Project p : projects) {
            if (p != null) {
                for (Task t : p.getTasks()) {
                    if (t != null && t.getTaskType() == type) {
                        total += t.getTaskDuration();
                        count++;
                    }
                }
            }
        }
        if (count > 0)
            System.out.println("* " + getTypeName(type) + ": " + (total / count) + " hrs");
    }

    private String getTypeName(char type) {
        if (type == 'A') return "administrative";
        if (type == 'L') return "logistics";
        if (type == 'S') return "support";
        return "unknown";
    }

    private void loadFromFile() {
        try {
            System.out.print("Enter file name to load (e.g. data.txt): ");
            String filename = scannerInput.nextLine();
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            Project currentProject = null;

            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int pid = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String type = parts[2].trim();
                    currentProject = new Project(pid, name, type);
                    projects[index++] = currentProject;
                } else if (parts.length == 5 && currentProject != null) {
                    int tid = Integer.parseInt(parts[0].trim());
                    String desc = parts[1].trim();
                    char ttype = parts[2].trim().toUpperCase().charAt(0);
                    int dur = Integer.parseInt(parts[3].trim());
                    boolean comp = Boolean.parseBoolean(parts[4].trim());
                    currentProject.addTask(new Task(tid, desc, comp, ttype, dur));
                }
            }
            br.close();
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try {
            System.out.print("Enter file name to save (e.g. data.txt): ");
            String filename = scannerInput.nextLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            for (Project p : projects) {
                if (p != null) {
                    bw.write(p.getProjectId() + "," + p.getProjectName() + "," + p.getProjectType());
                    bw.newLine();
                    for (Task t : p.getTasks()) {
                        if (t != null) {
                            bw.write(t.getTaskId() + "," + t.getDescription() + "," +
                                    t.getTaskType() + "," + t.getTaskDuration() + "," + t.isCompleted());
                            bw.newLine();
                        }
                    }
                }
            }
            bw.close();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

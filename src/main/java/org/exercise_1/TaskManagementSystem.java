package org.exercise_1;

import org.exercise_1.service.TaskManager;

import java.util.Scanner;

public class TaskManagementSystem {

    private static final TaskManager tasks = new TaskManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection;

        TaskManager taskmanager = new TaskManager();
        taskmanager.loadTasks();

        taskmanager.printTasks();

        do {
            System.out.println(menu());
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1 -> tasks.addTask();
                case 2 -> tasks.markTaskCompleted();
                case 3 -> tasks.getTasksByPriority();
                case 4 -> tasks.getTasksByCategory();
                case 5 -> tasks.getPendingTasks();
                case 0 -> System.out.println("Goodbye. May your tasks be easy and fulfilling");
                default -> System.out.println("Incorrect selection. Choose a number between 0 and 5");
            }

        } while (selection != 0);

        scanner.close();
    }

    public static String menu() {
        return """
                Task Management System
                =====================
                1 - Add new task
                2 - Mark task as completed
                3 - View tasks by priority
                4 - View tasks by category
                5 - View pending tasks
                0 - Exit
                
                Select an option:""";
    }

}
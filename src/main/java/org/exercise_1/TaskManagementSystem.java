package org.exercise_1;

import org.exercise_1.service.TaskManager;

import java.util.Scanner;

public class TaskManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int selection;
        TaskManager tasks = new TaskManager();

        do {
            System.out.println(menu());
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    tasks.addTask();
                    break;
                case 2:
                    tasks.markTaskCompleted();
                    break;
                case 3:
                    tasks.getTasksByPriority();
                    break;
                case 4:
                    tasks.getTasksByCategory();
                    break;
                case 5:
                    tasks.getPendingTasks();
                    break;
                case 0:
                    System.out.println("bye");
                default:
                    System.out.println("Incorrect selection. Choose a number between 0 and 5");
            }

        } while (selection != 0);


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
package org.exercise_1.service;

import org.exercise_1.model.Task;
import org.exercise_1.model.TaskCategory;
import org.exercise_1.model.TaskPriority;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskManager {

    private PriorityQueue<Task> tasks;
    private Scanner scanner = new Scanner(System.in);

    public void addTask() {
        String description = getTaskDescription();
        TaskPriority taskPriority = getTaskPriority();
        TaskCategory taskCategory = getTaskCategory();
        LocalDateTime deadline = getTaskDeadline();

        tasks.add(new Task(description, taskPriority, taskCategory, deadline));
        System.out.println("Task added! Good luck");
    }

    private String getTaskDescription() {
        System.out.println("What's the description of the task you want to add?");
        return scanner.nextLine();
    }

    private TaskPriority getTaskPriority() {
        System.out.println("""
                And the priority? Choose a number:
                1 - High
                2 - Medium
                3 - Low
                """);
        int prioritySelection = scanner.nextInt();
        scanner.nextLine();

        return switch (prioritySelection) {
            case 1 -> TaskPriority.HIGH;
            case 2 -> TaskPriority.MEDIUM;
            case 3 -> TaskPriority.LOW;
            default -> {
                System.out.println("Incorrect selection. Choose a number between 1 and 3");
                yield getTaskPriority();
            }
        };
    }

    private TaskCategory getTaskCategory() {
                System.out.println("""
                What's the category? Choose a number:
                1 - Work
                2 - Personal
                3 - Study
                """);
        int categorySelection = scanner.nextInt();
        scanner.nextLine();

        return switch (categorySelection) {
            case 1 -> TaskCategory.WORK;
            case 2 -> TaskCategory.PERSONAL;
            case 3 -> TaskCategory.STUDY;
            default -> {
                System.out.println("Incorrect selection. Choose a number between 1 and 3");
                yield getTaskCategory();
            }
        };
    }

    // AHORA MISMO DA ERROR
    // Creo que es porque se espera también la hora, no solo la fecha
    // Pero yo quiero poner solo la fecha (año, mes y día, vamos), pinta que no puedo usar DateTimeFormatter
    // Buscar
    private LocalDateTime getTaskDeadline() {
        System.out.println("Let's set the deadline. Be realistic, please :)\n" +
                "Enter the deadline following this structure (YYYY-MM-DD):");
        String deadlineInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.parse(deadlineInput, formatter);
    }

    public void markTaskCompleted() {

    }

    public void getTasksByPriority() {

    }

    public void getTasksByCategory() {

    }

    public void getPendingTasks() {

    }

}

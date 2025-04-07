package org.exercise_1.service;

import org.exercise_1.model.SampleTasks;
import org.exercise_1.model.Task;
import org.exercise_1.model.TaskCategory;
import org.exercise_1.model.TaskPriority;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {

    private final PriorityQueue<Task> tasks = new PriorityQueue<>
            // This is used because otherwise you'd get a ClassCastException when trying to add a task
            // That's because PriorityQueue needs to know how to sort the elements when added
            (Comparator.comparingInt((Task t) -> t.getTaskPriority().ordinal())
                    .thenComparing(Task::getDeadline));
    private final Scanner scanner = new Scanner(System.in);

    public void loadTasks() {
        SampleTasks.addSampleTasks(tasks);
    }

    public void printTasks() {
        System.out.println(tasks);
    }

    public void addTask() {
        try {
            String description = getTaskDescription();
            TaskPriority taskPriority = getTaskPriority();
            TaskCategory taskCategory = getTaskCategory();
            LocalDate deadline = getTaskDeadline();
            tasks.add(new Task(description, taskPriority, taskCategory, deadline));
            System.out.println("Task added! Good luck");
        } catch (ClassCastException e) {
            System.out.println("ClassCastException! Error when trying to add a new task" + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException! Error when trying to add a new task" + e.getMessage());
        }
    }

    // añadir exceptions
    public String getTaskDescription() {
        System.out.println("What's the description of the task you want to add?");
        return scanner.nextLine();
    }

    // añadir exceptions
    public TaskPriority getTaskPriority() {
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

    // añadir exceptions
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

    public LocalDate getTaskDeadline() {
        System.out.println("Let's set the deadline. Be realistic, please :)\n" +
                "Enter the deadline following this structure (YYYY-MM-DD):");

        while (true) {
            try {
                String deadlineString = scanner.nextLine().trim();
                return LocalDate.parse(deadlineString);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Please enter a valid date in YYYY-MM-DD format.");
                System.out.println("Example: " + LocalDate.now());
            }
        }
    }

    public void markTaskCompleted() {
        System.out.println("Which task do you want to mark as completed?");
        System.out.println(showUncompletedTasks(tasks));
    }

    // AHORA MISMO NO FUNCIONA. Devuelve []
    // VALE MENTIRA
    // Funciona, pero solo con las tasks que añado nuevas. Con las que estoy cargando no
    public String showUncompletedTasks(PriorityQueue<Task> tasks) {
        List<Task> uncompletedTasks = tasks.stream()
                .filter(task -> !task.getCompleted())
                .toList();

        return uncompletedTasks.toString();
    }

    public void getTasksByPriority() {

    }

    public void getTasksByCategory() {

    }

    public void getPendingTasks() {

    }

}

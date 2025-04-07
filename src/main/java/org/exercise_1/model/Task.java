package org.exercise_1.model;

import java.time.LocalDate;

public class Task {

    private final String description;
    private final TaskPriority taskPriority;
    private final TaskCategory taskCategory;
    private final LocalDate deadline;
    private boolean completed;

    public Task(String description, TaskPriority taskPriority, TaskCategory taskCategory, LocalDate deadline) {
        this.description = description;
        this.taskPriority = taskPriority;
        this.taskCategory = taskCategory;
        this.deadline = deadline;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public String toString() {
        return "Task description: " + description + "\nWith a priority of " + taskPriority + ", in the " + taskCategory
                + " category and with its deadline on " + deadline + ". Completed: " + completed;
    }

}
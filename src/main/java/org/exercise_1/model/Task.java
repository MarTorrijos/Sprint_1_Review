package org.exercise_1.model;

import java.time.LocalDateTime;

public class Task<T extends Object> {

    private String description;
    private TaskPriority taskPriority;
    private TaskCategory taskCategory;
    private LocalDateTime deadLine;
    private boolean completed;

    public Task(String description, TaskPriority taskPriority, TaskCategory taskCategory, LocalDateTime deadLine) {
        this.description = description;
        this.taskPriority = taskPriority;
        this.taskCategory = taskCategory;
        this.deadLine = deadLine;
        this.completed = false;
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Methods
    public void markCompleted() {
        this.completed = true;
    }

}
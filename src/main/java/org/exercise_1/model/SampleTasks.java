package org.exercise_1.model;

import java.time.LocalDateTime;

public class SampleTasks {

    public void loadTasks() {

        Task task1 = new Task("First task and it's high priority. Chop chop",
                TaskPriority.HIGH,
                TaskCategory.WORK,
                LocalDateTime.now().plusDays(1));

        Task task2 = new Task("Walk the turtle",
                TaskPriority.LOW,
                TaskCategory.PERSONAL,
                LocalDateTime.now().plusDays(20));

        Task task3 = new Task("Finish homework :(",
                TaskPriority.MEDIUM,
                TaskCategory.STUDY,
                LocalDateTime.now().plusDays(7));

        Task task4 = new Task("Do the dishes. Let's pretend it's low priority",
                TaskPriority.LOW,
                TaskCategory.PERSONAL,
                LocalDateTime.now().plusDays(4));

        Task task5 = new Task("Presentation about latest project",
                TaskPriority.MEDIUM,
                TaskCategory.WORK,
                LocalDateTime.now().plusDays(5));

        Task task6 = new Task("Read about testing",
                TaskPriority.LOW,
                TaskCategory.STUDY,
                LocalDateTime.now().plusDays(8));

    }

}
package org.exercise_1.model;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class SampleTasks {

    public static void addSampleTasks(PriorityQueue<Task> tasks) {
        tasks.add(new Task("First task and it's high priority. Chop chop",
                TaskPriority.HIGH,
                TaskCategory.WORK,
                LocalDate.now().plusDays(1)));

        tasks.add(new Task("Walk the turtle",
                TaskPriority.LOW,
                TaskCategory.PERSONAL,
                LocalDate.now().plusDays(20)));

        tasks.add(new Task("Finish homework :(",
                TaskPriority.MEDIUM,
                TaskCategory.STUDY,
                LocalDate.now().plusDays(7)));

        tasks.add(new Task("Do the dishes. Let's pretend it's low priority",
                TaskPriority.LOW,
                TaskCategory.PERSONAL,
                LocalDate.now().plusDays(4)));

        tasks.add(new Task("Presentation about latest project",
                TaskPriority.MEDIUM,
                TaskCategory.WORK,
                LocalDate.now().plusDays(5)));

        tasks.add(new Task("Read about testing",
                TaskPriority.LOW,
                TaskCategory.STUDY,
                LocalDate.now().plusDays(8)));
    }

}
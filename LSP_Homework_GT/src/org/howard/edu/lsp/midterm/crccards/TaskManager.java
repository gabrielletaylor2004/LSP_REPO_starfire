package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects.
 * Supports adding tasks, finding tasks by ID, and retrieving tasks by status.
 *
 * Author: Gabrielle Taylor
 */
public class TaskManager {
    private Map<String, Task> tasks;

    /**
     * Constructs an empty TaskManager.
     */
    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    /**
     * Adds a task to the manager.
     * Duplicate task IDs are not allowed.
     *
     * @param task the task to add
     * @throws IllegalArgumentException if a task with the same task ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its task ID.
     *
     * @param taskId the task ID to search for
     * @return the matching Task if found, otherwise null
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns all tasks whose status matches the specified value.
     *
     * @param status the status to match
     * @return a list of tasks with the matching status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> matchingTasks = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                matchingTasks.add(task);
            }
        }

        return matchingTasks;
    }
}
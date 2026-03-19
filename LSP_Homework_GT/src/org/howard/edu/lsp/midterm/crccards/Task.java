package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task in the Task Management System.
 * A task stores an ID, description, and status.
 *
 * Author: Gabrielle Taylor
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with the given task ID and description.
     * The default status is OPEN.
     *
     * @param taskId the unique ID of the task
     * @param description the description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task status.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * Valid values are OPEN, IN_PROGRESS, and COMPLETE.
     * If the status is invalid, it is set to UNKNOWN.
     *
     * @param status the new status of the task
     */
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns the task details in the required format:
     * taskId description [status]
     *
     * @return the formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
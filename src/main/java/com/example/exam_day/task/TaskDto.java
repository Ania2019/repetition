package com.example.exam_day.task;

import com.example.exam_day.task.enums.TaskStatus;
import com.example.exam_day.task.enums.TaskType;
import com.example.exam_day.user.User;

import javax.persistence.Enumerated;
import java.time.LocalDateTime;

public class TaskDto {
    private String title;
    private LocalDateTime date_start;
    private TaskStatus status;
    private TaskType type;
    private User user;

    public TaskDto(String title, LocalDateTime date_start, TaskStatus status, TaskType type, User user) {
        this.title = title;
        this.date_start = date_start;
        this.status = status;
        this.type = type;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDateTime date_start) {
        this.date_start = date_start;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

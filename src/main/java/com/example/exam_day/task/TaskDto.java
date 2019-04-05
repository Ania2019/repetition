package com.example.exam_day.task;

import com.example.exam_day.task.enums.TaskStatus;
import com.example.exam_day.task.enums.TaskType;
import com.example.exam_day.user.User;

import javax.persistence.Enumerated;
import java.time.LocalDateTime;

public class TaskDto {
    private String title;
    private TaskStatus status;
    private TaskType type;
    private Long user_id;

    public TaskDto(String title, TaskStatus status, TaskType type) {
        this.title = title;
        this.status = status;
        this.type = type;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

}

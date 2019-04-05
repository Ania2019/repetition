package com.example.exam_day.task;

import com.example.exam_day.task.enums.TaskStatus;
import com.example.exam_day.task.enums.TaskType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private LocalDateTime date_start;
    @Enumerated
    private TaskStatus status;
    @Enumerated
    private TaskType type;

    public Task() { }
    public Task(String title, LocalDateTime date_start, TaskStatus status, TaskType type) {
        this.title = title;
        this.date_start = date_start;
        this.status = status;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

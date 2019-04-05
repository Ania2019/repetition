package com.example.exam_day.user;

import com.example.exam_day.task.Task;
import lombok.Data;
import org.hibernate.annotations.OnDelete;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    public User() { }
    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    @OneToMany( cascade = CascadeType.ALL,
                fetch = FetchType.EAGER,
                mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

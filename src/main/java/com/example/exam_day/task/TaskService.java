package com.example.exam_day.task;

import com.example.exam_day.user.User;
import com.example.exam_day.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    TaskRepository taskRepository;
    UserRepository userRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    public TaskDto saveUser(TaskDto taskDto){
        User user = userRepository.getOne(taskDto.getUser_id());
        Task task = new Task(
                taskDto.getTitle(),
                taskDto.getStatus(),
                taskDto.getType(),
                user);
        taskRepository.save(task);
        return taskDto;
    }
    public TaskDto getTaskById(Long task_id){
        Task task = taskRepository.getOne(task_id);
        return new TaskDto(task.getTitle(),task.getStatus(),task.getType());
    }
}

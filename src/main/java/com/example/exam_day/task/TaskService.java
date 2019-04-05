package com.example.exam_day.task;

import com.example.exam_day.task.enums.TaskStatus;
import com.example.exam_day.user.User;
import com.example.exam_day.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<TaskDto> getAllTasksForUser(Long user_id){
        List<Task> tasks = taskRepository.findAllByUser(userRepository.getOne(user_id));
        return taskToDtoConverter(tasks);
    }
    public List<TaskDto> getAllTasksForUserAndStatus(Long user_id, TaskStatus taskStatus){
        List<Task> tasks = taskRepository.findAllByUserAndStatus(
                userRepository.getOne(user_id), taskStatus);
        return taskToDtoConverter(tasks);
    }

    public TaskDto deleteTaskById(Long id){
        Task task = taskRepository.getOne(id);
        taskRepository.delete(task);
        TaskDto taskDto =new TaskDto(task.getTitle(),task.getStatus(),task.getType());
        taskDto.setUser_id(task.getUser().getId());
        return  taskDto;
    }

    public TaskDto updateTaskUser(Long task_id,Long user_id){
        Task task = taskRepository.getOne(task_id);
        User user = userRepository.getOne(user_id);
        task.setUser(user);
        taskRepository.save(task);
        TaskDto taskDto = new TaskDto(task.getTitle(),task.getStatus(),task.getType());
        taskDto.setUser_id(task.getUser().getId());
        return  taskDto;
    }

    public List<TaskDto> getSortedTask(){
        return taskToDtoConverter(taskRepository.findAll().
                stream().sorted(Comparator.comparing(Task::getDate_start).
                reversed()).collect(Collectors.toList()));

    }



    private List<TaskDto> taskToDtoConverter(List<Task> tasks){
        List<TaskDto> tasksDto = new ArrayList<>();
        for(Task task : tasks){
            TaskDto taskDto = new TaskDto(task.getTitle(),task.getStatus(),task.getType());
            taskDto.setUser_id(task.getUser().getId());
            tasksDto.add(taskDto);
        }
        return tasksDto;
    }




}

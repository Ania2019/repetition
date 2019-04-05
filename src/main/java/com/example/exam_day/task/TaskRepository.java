package com.example.exam_day.task;

import com.example.exam_day.task.enums.TaskStatus;
import com.example.exam_day.task.enums.TaskType;
import com.example.exam_day.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUser(User user);
    List<Task> findAllByUserAndStatus(User user, TaskStatus taskStatus);
    List<Task> findAllByUserAndType(User user, TaskType taskType);
    List<Task> findAllByUserAndTypeAndStatus(User user, TaskType taskType, TaskStatus taskStatus);

}

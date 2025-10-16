package com.taskmanager.backend.services;

import com.taskmanager.backend.models.AuditLog;
import com.taskmanager.backend.models.Task;
import com.taskmanager.backend.repositories.AuditLogRepository;
import com.taskmanager.backend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service // Marks this as a Spring service component
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Transactional // Ensures both operations (save task and save log) succeed or fail together
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        Task savedTask = taskRepository.save(task);

        // --- AUDIT LOG LOGIC ---
        AuditLog log = new AuditLog();
        log.setTimestamp(LocalDateTime.now());
        log.setAction("Create Task");
        log.setTaskId(savedTask.getId());
        // For CREATE, log the initial content
        String content = String.format("title: \"%s\", description: \"%s\"", savedTask.getTitle(), savedTask.getDescription());
        log.setUpdatedContent(content);
        auditLogRepository.save(log);
        // --- END AUDIT LOG LOGIC ---

        return savedTask;
    }

    @Transactional
    public Optional<Task> updateTask(Long id, Task taskDetails) {
        return taskRepository.findById(id).map(existingTask -> {
            // --- AUDIT LOG LOGIC ---
            String oldContent = String.format("title: \"%s\", description: \"%s\"", existingTask.getTitle(), existingTask.getDescription());
            existingTask.setTitle(taskDetails.getTitle());
            existingTask.setDescription(taskDetails.getDescription());
            Task updatedTask = taskRepository.save(existingTask);
            String newContent = String.format("title: \"%s\", description: \"%s\"", updatedTask.getTitle(), updatedTask.getDescription());

            AuditLog log = new AuditLog();
            log.setTimestamp(LocalDateTime.now());
            log.setAction("Update Task");
            log.setTaskId(updatedTask.getId());
            // For UPDATE, show what changed (simple version)
            log.setUpdatedContent("Updated from: " + oldContent + " to: " + newContent);
            auditLogRepository.save(log);
            // --- END AUDIT LOG LOGIC ---

            return updatedTask;
        });
    }

    @Transactional
    public boolean deleteTask(Long id) {
        return taskRepository.findById(id).map(task -> {
            // --- AUDIT LOG LOGIC ---
            AuditLog log = new AuditLog();
            log.setTimestamp(LocalDateTime.now());
            log.setAction("Delete Task");
            log.setTaskId(task.getId());
            // For DELETE, updatedContent can be empty
            log.setUpdatedContent(String.format("Deleted task with title: \"%s\"", task.getTitle()));
            auditLogRepository.save(log);
            // --- END AUDIT LOG LOGIC ---

            taskRepository.delete(task);
            return true;
        }).orElse(false);
    }
}
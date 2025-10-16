package com.taskmanager.backend.controllers;

import com.taskmanager.backend.models.Task;
import com.taskmanager.backend.services.TaskService; // Import the new service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService; // Inject the service, not the repository

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails)
                .map(ResponseEntity::ok) // If task is found and updated, return 200 OK
                .orElse(ResponseEntity.notFound().build()); // If not found, return 404 Not Found
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTask(id)) {
            return ResponseEntity.noContent().build(); // Return 204 No Content on success
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if task didn't exist
        }
    }
}
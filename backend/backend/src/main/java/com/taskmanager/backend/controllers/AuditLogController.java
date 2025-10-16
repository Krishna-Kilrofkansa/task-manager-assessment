package com.taskmanager.backend.controllers;

import com.taskmanager.backend.models.AuditLog;
import com.taskmanager.backend.repositories.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AuditLogController {

    @Autowired
    private AuditLogRepository auditLogRepository;

    // This method will handle GET requests to /api/logs
    @GetMapping("/logs")
    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAll();
    }
}
package com.taskmanager.backend.repositories;

import com.taskmanager.backend.models.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
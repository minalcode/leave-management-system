package com.leave.leave_management.Model;

import com.leave.leave_management.Enum.LeaveStatus;
import com.leave.leave_management.Enum.LeaveType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "leave_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
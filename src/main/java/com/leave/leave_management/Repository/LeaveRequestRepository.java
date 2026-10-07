package com.leave.leave_management.Repository;

import com.leave.leave_management.Model.LeaveRequest;
import com.leave.leave_management.Enum.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByStatus(LeaveStatus status);

    List<LeaveRequest> findByEmployeeId(Long employeeId);
}
package com.leave.leave_management.Service;

import com.leave.leave_management.Enum.LeaveStatus;
import com.leave.leave_management.Model.LeaveRequest;
import com.leave.leave_management.Repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {

        leaveRequest.setStatus(LeaveStatus.PENDING);
        leaveRequest.setCreatedAt(LocalDateTime.now());
        leaveRequest.setUpdatedAt(LocalDateTime.now());

        return leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest getLeaveRequestById(Long id) {

        return leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));
    }

    public List<LeaveRequest> getLeavesByStatus(LeaveStatus status) {
        return leaveRequestRepository.findByStatus(status);
    }

    public List<LeaveRequest> getLeavesByEmployee(Long employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }

    public LeaveRequest updateLeaveStatus(Long id, LeaveStatus status) {

        LeaveRequest leaveRequest = getLeaveRequestById(id);

        leaveRequest.setStatus(status);
        leaveRequest.setUpdatedAt(LocalDateTime.now());

        return leaveRequestRepository.save(leaveRequest);
    }
}
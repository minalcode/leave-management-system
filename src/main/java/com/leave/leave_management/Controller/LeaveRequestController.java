package com.leave.leave_management.Controller;

import com.leave.leave_management.Enum.LeaveStatus;
import com.leave.leave_management.Model.LeaveRequest;
import com.leave.leave_management.Service.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public LeaveRequest createLeaveRequest(
            @RequestBody LeaveRequest leaveRequest
    ) {
        return leaveRequestService.createLeaveRequest(leaveRequest);
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @GetMapping("/{id}")
    public LeaveRequest getLeaveRequestById(
            @PathVariable Long id
    ) {
        return leaveRequestService.getLeaveRequestById(id);
    }

    @GetMapping("/status/{status}")
    public List<LeaveRequest> getLeavesByStatus(
            @PathVariable LeaveStatus status
    ) {
        return leaveRequestService.getLeavesByStatus(status);
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getLeavesByEmployee(
            @PathVariable Long employeeId
    ) {
        return leaveRequestService.getLeavesByEmployee(employeeId);
    }

    @PutMapping("/{id}/status/{status}")
    public LeaveRequest updateLeaveStatus(
            @PathVariable Long id,
            @PathVariable LeaveStatus status
    ) {
        return leaveRequestService.updateLeaveStatus(id, status);
    }
}
package com.example.empattendance.service;

import com.example.empattendance.model.*;
import com.example.empattendance.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveService {
    private final LeaveRepository leaveRepo;
    private final EmployeeRepository employeeRepo;

    public LeaveService(LeaveRepository l, EmployeeRepository e) {
        this.leaveRepo = l;
        this.employeeRepo = e;
    }

    @Transactional
    public LeaveRequest applyLeave(Long employeeId, LocalDate from, LocalDate to, String reason) {
        Employee emp = employeeRepo.findById(employeeId).orElseThrow();
        LeaveRequest lr = LeaveRequest.builder()
            .employee(emp)
            .fromDate(from)
            .toDate(to)
            .reason(reason)
            .status("PENDING")
            .build();
        return leaveRepo.save(lr);
    }

    public List<LeaveRequest> getPendingLeaves() {
        return leaveRepo.findByStatus("PENDING");
    }
}

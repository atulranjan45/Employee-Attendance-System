package com.example.empattendance.service;

import com.example.empattendance.model.*;
import com.example.empattendance.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepo;
    private final EmployeeRepository employeeRepo;

    public AttendanceService(AttendanceRepository a, EmployeeRepository e) {
        this.attendanceRepo = a;
        this.employeeRepo = e;
    }

    @Transactional
    public Attendance punch(Long employeeId, String status, String note) {
        Employee emp = employeeRepo.findById(employeeId).orElseThrow();
        Attendance a = Attendance.builder()
            .employee(emp)
            .status(status)
            .timestamp(LocalDateTime.now())
            .note(note)
            .build();
        return attendanceRepo.save(a);
    }
}

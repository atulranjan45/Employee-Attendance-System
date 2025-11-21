package com.example.empattendance.controller;

import com.example.empattendance.model.Attendance;
import com.example.empattendance.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService service;

    public AttendanceController(AttendanceService s) { this.service = s; }

    @PostMapping("/punch")
    public Attendance punch(@RequestParam Long employeeId,
                            @RequestParam(defaultValue="IN") String status,
                            @RequestParam(required=false) String note) {
        return service.punch(employeeId, status, note);
    }
}

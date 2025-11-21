package com.example.empattendance.controller;

import com.example.empattendance.model.LeaveRequest;
import com.example.empattendance.service.LeaveService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController @RequestMapping("/api/leaves")
public class LeaveController {
    private final LeaveService service;

    public LeaveController(LeaveService s) { this.service = s; }

    @PostMapping("/apply")
    public LeaveRequest apply(@RequestParam Long employeeId,
                              @RequestParam String from,
                              @RequestParam String to,
                              @RequestParam String reason) {
        return service.applyLeave(employeeId, LocalDate.parse(from), LocalDate.parse(to), reason);
    }

    @GetMapping("/pending")
    public List<LeaveRequest> pending() {
        return service.getPendingLeaves();
    }
}

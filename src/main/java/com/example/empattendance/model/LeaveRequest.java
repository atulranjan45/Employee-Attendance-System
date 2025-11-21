package com.example.empattendance.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Table(name="leaves")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class LeaveRequest {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name="employee_id")
    private Employee employee;

    private LocalDate fromDate;
    private LocalDate toDate;
    private String status;
    private String reason;
    private String managerComment;
}

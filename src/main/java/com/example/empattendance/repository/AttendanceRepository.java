package com.example.empattendance.repository;

import com.example.empattendance.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> { }

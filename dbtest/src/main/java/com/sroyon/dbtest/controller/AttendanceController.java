package com.sroyon.dbtest.controller;

import com.sroyon.dbtest.model.Attendance;
import com.sroyon.dbtest.model.Person;
import com.sroyon.dbtest.repo.AttendanceRepo;
import com.sroyon.dbtest.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @GetMapping("/attendance")
    public List<Attendance> getAttendance() {

        return attendanceService.getAllAttendance();
    }

    @GetMapping("/attendance/mark/{id}")
    public Attendance markPresent(@PathVariable int id){
        return attendanceService.markPresent(id);
    }

}

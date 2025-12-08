package com.sroyon.dbtest.controller;

import com.sroyon.dbtest.model.Person;
import com.sroyon.dbtest.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AttendanceRecordController {

    @Autowired
    private AttendanceRecordService attendanceRecordService;

    @GetMapping("/{date}")
    public List<Person> findAttendanceRecord(@PathVariable String date){
        return attendanceRecordService.findAttendanceRecordByDate(LocalDate.parse(date));
    }

}

package com.sroyon.dbtest.service;

import com.sroyon.dbtest.model.Attendance;
import com.sroyon.dbtest.model.Person;
import com.sroyon.dbtest.repo.AttendanceRecordRepo;
import com.sroyon.dbtest.repo.AttendanceRepo;
import com.sroyon.dbtest.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private AttendanceRecordService attendanceRecordService;

    public Attendance markPresent(int personId)
    {
        Person person = personRepo.findById(personId).orElseThrow(()->new RuntimeException("Person not found"));

        Attendance attendance = new Attendance(true, person);

        attendanceRecordService.addPerson(LocalDate.now(),person);

        return attendanceRepo.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepo.findAll();
    }

}

package com.sroyon.dbtest.service;

import com.sroyon.dbtest.model.AttendanceRecord;
import com.sroyon.dbtest.model.Person;
import com.sroyon.dbtest.repo.AttendanceRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceRecordService {

    @Autowired
    private AttendanceRecordRepo attendanceRecordRepo;

    public List<Person> findAttendanceRecordByDate(LocalDate date)
    {
           return attendanceRecordRepo.findById(date)
            .map(AttendanceRecord::getPeople).orElse(List.of());
    }

    public void addPerson(LocalDate date, Person person) {
        AttendanceRecord attendanceRecord = attendanceRecordRepo.findById(date)
                .orElseGet(() -> new AttendanceRecord(date, new ArrayList<>()));

        attendanceRecord.getPeople().add(person);
        attendanceRecordRepo.save(attendanceRecord);


    }
}

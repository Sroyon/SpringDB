package com.sroyon.dbtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRecord{

    @Id
    private LocalDate date;

    @ManyToMany
    @JoinTable(
            name = "attendance_record_people",
            joinColumns = @JoinColumn(name="attendance_date"),
            inverseJoinColumns = @JoinColumn(name="person_id")
    )
    private List<Person> people;

}

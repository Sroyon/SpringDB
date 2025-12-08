package com.sroyon.dbtest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendance_id;

    private boolean present;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    public Attendance(boolean present, Person person) {
        this.present = present;
        this.person = person;
    }

}

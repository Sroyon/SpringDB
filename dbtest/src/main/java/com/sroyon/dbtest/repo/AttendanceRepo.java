package com.sroyon.dbtest.repo;

import com.sroyon.dbtest.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance,Integer>
{
}

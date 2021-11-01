package com.example.appointment.dao;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.example.appointment.entity.appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<appointment,Integer> {

	
	 public List<appointment> findByreservationdate(LocalDateTime  today);
	 public List<appointment> findBypatient(String  name);
	 public List<appointment> findBypatientAndLessThanreservationdate(String  name ,  LocalDateTime  today );
}

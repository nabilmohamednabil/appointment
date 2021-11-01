package com.example.appointment.service;

 

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.appointment.entity.appointment;

 

public interface AppointmentService {


             public List<appointment> findAll();
             
             public appointment findById(int theId);

             public void save(appointment theappointment);

             public void deleteById(int theId);
             
             public List<appointment> findByreservationdate(LocalDateTime  today);
             
             public List<appointment> findBypatient(String  name);
             
             public List<appointment> findBypatientAndLessThanreservationdate(String  name ,  LocalDateTime  today );

}
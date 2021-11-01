package com.example.appointment.service;

 

import java.time.LocalDateTime;
import java.util.List;

import com.example.appointment.dao.AppointmentRepository;
import com.example.appointment.entity.appointment;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import com.example.appointment.entity.appointment;


@Service
public class appointmentServiceImplem implements AppointmentService {

              private AppointmentRepository appointmentRepository;  
              
              @Autowired
              public appointmentServiceImplem(AppointmentRepository appointmentRepository) {
                             this.appointmentRepository = appointmentRepository;
              }
             
              @Override
              public List<appointment> findAll() {                           
                                	  
					return StreamSupport
							  .stream(appointmentRepository.findAll().spliterator(), false)
							  .collect(Collectors.toList());
              }

              @Override
              public appointment findById(int theId) {            
                           Optional<appointment> result = appointmentRepository.findById(theId);                         
                           appointment theappointment = null;
                             if (result.isPresent()) {
                            	 theappointment = result.get();
                             }
                             else {
                                           throw new RuntimeException("Did not find appointment id - " + theId);
                             }
                             return theappointment;
              }

              @Override
              public void save(appointment cus) {

                  appointmentRepository.save(cus);
              }
              
              @Override
              public void deleteById(int theId) {
                             appointmentRepository.deleteById(theId);
              }

			@Override
			public List<appointment> findByreservationdate(LocalDateTime today) {
				return      appointmentRepository.findByreservationdate(today);
				
			}

			@Override
			public List<appointment> findBypatient(String name) {
				return appointmentRepository.findBypatient(name);
				 
			}
 
			@Override
			public List<appointment> findBypatientAndLessThanreservationdate(String  name ,  LocalDateTime  today )
			{
				
				return appointmentRepository.findBypatientAndLessThanreservationdate(  name ,    today );
			}

}
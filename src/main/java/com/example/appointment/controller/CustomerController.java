package com.example.appointment.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import  com.example.appointment.entity.* ;
import com.example.appointment.service.* ;


@RestController
@RequestMapping("/patient")
@CrossOrigin(origins="*")
public class CustomerController {

	   @Autowired
       private AppointmentService AppointmentService;     
           
       public CustomerController(AppointmentService AppointmentService   ) {
             this.AppointmentService = AppointmentService;
       }

       @GetMapping("/list")
       public  List<appointment> listpatient(Model theModel) {
    	   LocalDateTime lt= LocalDateTime.now();  	    
    	    List<appointment> FirstEntityList       = AppointmentService.findByreservationdate(lt);
           // theModel.addAttribute("FinalEnity", FirstEntityList);
            return FirstEntityList;
       }
       
       
       @PostMapping("/adding")
       public void savingPurchaseOrder(@RequestBody appointment NewAppointment) {
              
    	   System.out.println("the new appointment object" + NewAppointment );
           this.AppointmentService.save(NewAppointment);

       }
       
       @GetMapping("/filterbydate/{thedate}")
       public  List<appointment> listpatientbydate(@PathVariable LocalDateTime thedate) {
     
    	    List<appointment> FirstEntityList     = AppointmentService.findByreservationdate(thedate);
 
            return FirstEntityList;
       }
       
       @GetMapping("/filterbyname/{thename}")
       public  List<appointment> listpatientbyname(@PathVariable String thename) {

    	    List<appointment> FirstEntityList       = AppointmentService.findBypatient(thename);
         
            return FirstEntityList;
       }

       
       @DeleteMapping("/deleteAppointment/{theID}")
       public  void DeleteAppointment(@PathVariable int theID) {

    	     AppointmentService.deleteById(theID);
     
       }
       
       @GetMapping("/Historybyname/{thename}")
       public  List<appointment> Historybyname(@PathVariable String thename) {

    	   LocalDateTime today = LocalDateTime.now(); 
    	   
    	    List<appointment> FirstEntityList       = AppointmentService.findBypatientAndLessThanreservationdate(  
    	    		thename ,    today );
         
            return FirstEntityList;
       }
       
       
       
}
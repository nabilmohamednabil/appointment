package com.example.appointment.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.OneToMany ;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class appointment {

	              @Id
	              @GeneratedValue(strategy=GenerationType.IDENTITY)
	              @Column(name="id")
	              private Integer id;

	              @Column(name="ReservationDate")
	              @JsonFormat(pattern="yyyy-MM-dd HH:MM:SS")
	              private LocalDateTime  reservationdate;

	              @Column(name="patient")
	              private String patient;
	              
	              @Column(name="cancelationReason")
	              private String cancelationReason;

	              public appointment() {}

	              public appointment(  LocalDateTime ReservationDate ,  String Patient  , String cancelationReason ) {
	                  this.reservationdate = ReservationDate ; 
	                  this.patient = Patient ; 
	                  this.cancelationReason = cancelationReason ; 
	                             }

				public LocalDateTime getReservation_Date() {
					return reservationdate;
				}

				public Integer getId() {
					return id;
				}

				public void setId(Integer id) {
					this.id = id;
				}

				public void setReservation_Date(LocalDateTime reservation_Date) {
					reservationdate = reservation_Date;
				}

				public String getPatient() {
					return patient;
				}

				public void setPatient(String patient) {
					patient = patient;
				}

				public String getCancelation_reason() {
					return cancelationReason;
				}

				public void setCancelation_reason(String cancelationReason) {
					this.cancelationReason = cancelationReason;
				}

	                      
}

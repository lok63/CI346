package com.lc475.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Data
@Entity
public class Employee {

     @Id
     @GeneratedValue
     private Long id;

    private Days days;
    private ShiftTime shiftTime;
    private String firstname;
    private String lastname;

    //we need a default construcctor to allow spring to create a new object by the input sent by a POST request
    public Employee(){}

    public Employee(String firstname, String lastname, Days days, ShiftTime shiftTime){
        this.firstname = firstname;
        this.lastname = lastname;
        this.days = days;
        this.shiftTime = shiftTime;
    }



    public Days getDays() {return days;}
    public void setDays(Days days) {this.days = days;}

    public ShiftTime getShiftTime() {return shiftTime;}
    public void setShiftTime(ShiftTime shiftTime) {this.shiftTime = shiftTime;}

    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}
    public void setLastname(String lastname) {this.lastname = lastname;}

    public Long getId() {return id;}








}

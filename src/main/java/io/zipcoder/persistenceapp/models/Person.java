package io.zipcoder.persistenceapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String mobile;
    private Date birthday;
    private int homeId;

    public Person() {
        firstName = "John";
        lastName = "Doe";
        mobile = "1234567890";
        birthday = new Date();
        homeId = 1;
    }

    public Person(String firstName, String lastName, String mobile, Date birthday, int homeId) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.mobile = mobile;
    	this.birthday = birthday;
    	this.homeId = homeId;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.lastName = surName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobile = mobileNumber;
    }

    public Date getBirthDate() {
        return birthday;
    }

    public void setBirthDate(Date birthDate) {
        this.birthday = birthDate;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }
}

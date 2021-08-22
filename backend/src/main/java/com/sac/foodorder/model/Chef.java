package com.sac.foodorder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chefId;

    private String firstName;
    private String lastName;
    private String gender;
    private int experience;
    private double rate;
    private String skill;
    private String status;
    private double price;

    public Chef() {
    }

    public Chef(String firstName, String lastName, String gender, int experience, double rate, String skill, String status, double price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.experience = experience;
        this.rate = rate;
        this.skill = skill;
        this.status = status;
        this.price = price;
    }

    public long getChefId() {
        return chefId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

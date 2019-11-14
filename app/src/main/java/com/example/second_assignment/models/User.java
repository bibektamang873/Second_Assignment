package com.example.second_assignment.models;

import java.io.Serializable;

public class User implements Serializable {
    private String fullName, gender,dob, country, email, contact;
    private int image;

    public User(String fullName, String gender, String dob, String country, String email, String contact, int image) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.country = country;
        this.email = email;
        this.contact = contact;
        this.image = image;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public int getImage() {
        return image;
    }
}

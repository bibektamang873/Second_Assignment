package com.example.second_assignment.models;

public class User {
    private String fullName, gender,dob, country, email, contact;

    public User(String fullName, String gender, String dob, String country, String email, String contact) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.country = country;
        this.email = email;
        this.contact = contact;
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
}

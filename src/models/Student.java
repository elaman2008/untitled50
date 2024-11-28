package models;

import enums.Gender;

import java.util.Collection;

public class Student {
    private Long id;
    private String Name;
    private String LastName;
    private String email;
    private int password;
    private Gender gender ;

    public Student() {
    }

    public Student(Long id, String name, String lastName, String email, int password, Gender gender) {
        this.id = id;
        Name = name;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email=" + email +
                ", password=" + password +
                ", gender=" + gender +
                '}';
    }



    }


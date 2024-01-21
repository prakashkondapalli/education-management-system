package com.ems.model;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegister {
    private String name;
    private String username;
    private String password;
    private String address;
    private String state;
    private String country;
    private String email;
    private String studentId;
    private String contactNo;
    private Date dateOfBirth;
    @Nullable
    private ArrayList<CourseRegister> courses;
}
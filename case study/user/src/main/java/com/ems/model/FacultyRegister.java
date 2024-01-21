package com.ems.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyRegister {
    private String name;
    private String username;
    private String password;
    private String email;
    private String employeeId;
    private String contactNo;
    @NotNull
    @Size(min = 1)
    private ArrayList<CourseRegister> courses;
}
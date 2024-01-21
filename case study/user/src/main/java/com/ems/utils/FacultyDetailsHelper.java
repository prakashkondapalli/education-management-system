package com.ems.utils;

import com.ems.model.FacultyRegister;
import com.ems.repositories.CourseRepository;
import com.ems.entity.Course;
import com.ems.entity.Faculty;
import com.ems.entity.Role;
import com.ems.model.CourseRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FacultyDetailsHelper {


    @Autowired
    private CourseRepository courseRepository;
    public Faculty mapToEntityModel(FacultyRegister facultyRegister) {
        Faculty faculty = new Faculty();

        if (Objects.nonNull(facultyRegister.getName())) {
            faculty.setName(facultyRegister.getName());
        }
        if (Objects.nonNull(facultyRegister.getUsername())) {
            faculty.setUsername(facultyRegister.getUsername());
        }
        if (Objects.nonNull(facultyRegister.getPassword())) {
            faculty.setPassword(facultyRegister.getPassword());
        }
        if (Objects.nonNull(facultyRegister.getEmail())) {
            faculty.setEmail(facultyRegister.getEmail());
        }
        if (Objects.nonNull(facultyRegister.getEmployeeId())) {
            faculty.setEmployeeId(facultyRegister.getEmployeeId());
        }
        if (Objects.nonNull(facultyRegister.getContactNo())) {
            faculty.setContactNo(facultyRegister.getContactNo());
        }
        if (Objects.nonNull(facultyRegister.getCourses())) {
            ArrayList<Course> courses = new ArrayList<>();
            for(CourseRegister courseRegister: facultyRegister.getCourses()) {
                System.out.println(courseRegister);
                Course repoCourse = courseRepository.findByCourseUuid(courseRegister.getCourseUuid());
                courses.add(repoCourse);
            }
            faculty.setCourses(new HashSet<>(courses.stream().collect(Collectors.toList())));
        }
        Role role = new Role(RoleEnum.USER);
        faculty.setRole(role);
        return faculty;
    }
}
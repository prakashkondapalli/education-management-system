package com.casestudy.course.controller;


import com.casestudy.course.entity.Course;
import com.casestudy.course.model.CourseDetails;
import com.casestudy.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody CourseDetails courseDetails) {
        Course course = courseService.coursePersist(courseDetails);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping("/getCourses")
    public ResponseEntity<ArrayList<Course>> allCourses() {
        ArrayList<Course> courses = courseService.allCourse();
        return new ResponseEntity<>(courses, HttpStatus.CREATED);
    }

}

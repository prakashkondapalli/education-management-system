package com.ems.service;

import com.ems.entity.Course;
import com.ems.repositories.CourseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CourseRepository courseRepository;

    @KafkaListener(topics = "course_topic", groupId = "code_group")
    public void listenToTopics(String course) throws JsonProcessingException {
        Course courseMsg = courseRepository.save(objectMapper.readValue(course,Course.class));
        System.out.println(courseMsg);
    }

    public ArrayList<Course> allCourse() {
        return new ArrayList<Course>(courseRepository.findAll());
    }
}
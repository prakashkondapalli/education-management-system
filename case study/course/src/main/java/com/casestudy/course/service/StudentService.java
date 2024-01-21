package com.casestudy.course.service;

import com.casestudy.course.entity.Course;
import com.casestudy.course.repositories.CourseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CourseRepository courseRepository;

    @KafkaListener(topics = "student_topic", groupId = "student_group")
    public void listenToTopics(String course) throws JsonProcessingException {
        Course courseMsg = courseRepository.findByCourseUuid(objectMapper.readValue(course,Course.class).getCourseUuid());
        System.out.println(courseMsg);
    }

}


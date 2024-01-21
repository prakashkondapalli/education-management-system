package com.casestudy.course.service;

import com.casestudy.course.entity.Course;
import com.casestudy.course.model.CourseDetails;
import com.casestudy.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    @Autowired
    private KafkaTemplate<String, Course> kafkaTemplate;

    private static final String topic = "course_topic";
    @Autowired
    private CourseRepository courseRepository;
    public Course coursePersist(CourseDetails courseDetails) {
        Course course = new Course();
        course.setCourseName(courseDetails.getCourseName());
        course.setDescription(courseDetails.getDescription());
        course.setSchedule(courseDetails.getSchedule());

        Course repoCourse =  courseRepository.save(course);
        Message<Course> message = MessageBuilder
                .withPayload(repoCourse)
                .setHeader(KafkaHeaders.TOPIC,topic).build();
        kafkaTemplate.send(message);
        return repoCourse;
    }

    public ArrayList<Course> allCourse() {
        return new ArrayList<Course>(courseRepository.findAll());
    }
}

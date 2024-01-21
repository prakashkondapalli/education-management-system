package com.ems.service;

import com.ems.entity.Course;
import com.ems.repositories.CourseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ContextConfiguration(classes = {CourseService.class})
@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private ObjectMapper objectMapper;

    /**
     * Method under test: {@link CourseService#listenToTopics(String)}
     */
    @Test
    void testListenToTopics() throws JsonProcessingException {
        when(courseRepository.save(getCourse())).thenReturn(getCourse());
        when(objectMapper.readValue((String) any(), (Class<Course>) any())).thenReturn(getCourse());
        courseService.listenToTopics("Course");
        assertNotNull(courseRepository);
        verify(objectMapper).readValue((String) any(), (Class<Course>) any());
    }

    /**
     * Method under test: {@link CourseService#allCourse()}
     */
    @Test
    void testAllCourse() {
        when(courseRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(courseService.allCourse().isEmpty());
        verify(courseRepository).findAll();
    }
    public Course getCourse(){
        Course course =  new Course();
        course.setCourseUuid(UUID.fromString("17098e63-abb7-4e74-b9a3-cb536aeff4aa"));
        course.setCourseName("CSE");
        course.setDescription("ComputerScienceEngineering");
        course.setSchedule("string");
        return course;
    }
 }


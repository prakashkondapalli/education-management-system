package com.ems.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CourseDetailsTest {


    @Test
    public void testGettersAndSetters() {
        // Create a mock instance of CourseDetails
        CourseDetails courseDetails = mock(CourseDetails.class);
        courseDetails.setCourseName("Mathematics");
        courseDetails.setSchedule("Monday, 10:00 AM");
        courseDetails.setDescription("Advanced Calculus");
        assertEquals("Mathematics", courseDetails.getCourseName());
        assertEquals("Monday, 10:00 AM", courseDetails.getSchedule());
        assertEquals("Advanced Calculus", courseDetails.getDescription());
    }
}


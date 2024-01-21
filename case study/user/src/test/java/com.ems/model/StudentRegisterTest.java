package com.ems.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StudentRegisterTest {

    @Test
    public void testGettersAndSetters() {
        // Create a mock instance of StudentRegister
        StudentRegister studentRegister = mock(StudentRegister.class);

        // Set values using setters
        studentRegister.setName("Jane Doe");
        studentRegister.setUsername("jane_doe");
        studentRegister.setPassword("password456");
        studentRegister.setAddress("123 Main St");
        studentRegister.setState("California");
        studentRegister.setCountry("USA");
        studentRegister.setEmail("jane.doe@example.com");
        studentRegister.setStudentId("STU789");
        studentRegister.setContactNo("987-654-3210");

        // Set date of birth
        Date dateOfBirth = new Date();
        studentRegister.setDateOfBirth(dateOfBirth);

        // Create a CourseRegister object for testing
        CourseRegister courseRegister = new CourseRegister();
        UUID courseUuid = UUID.randomUUID();
        courseRegister.setCourseUuid(courseUuid);

        // Create an ArrayList and add the CourseRegister object
        ArrayList<CourseRegister> courses = new ArrayList<>();
        courses.add(courseRegister);

        studentRegister.setCourses(courses);

        // Verify that the setters were called with the correct values
        verify(studentRegister).setName("Jane Doe");
        verify(studentRegister).setUsername("jane_doe");
        verify(studentRegister).setPassword("password456");
        verify(studentRegister).setAddress("123 Main St");
        verify(studentRegister).setState("California");
        verify(studentRegister).setCountry("USA");
        verify(studentRegister).setEmail("jane.doe@example.com");
        verify(studentRegister).setStudentId("STU789");
        verify(studentRegister).setContactNo("987-654-3210");
        verify(studentRegister).setDateOfBirth(dateOfBirth);
        verify(studentRegister).setCourses(courses);

        // Use getters to retrieve values and assert they match the set values
        assertEquals("Jane Doe", studentRegister.getName());
        assertEquals("jane_doe", studentRegister.getUsername());
        assertEquals("password456", studentRegister.getPassword());
        assertEquals("123 Main St", studentRegister.getAddress());
        assertEquals("California", studentRegister.getState());
        assertEquals("USA", studentRegister.getCountry());
        assertEquals("jane.doe@example.com", studentRegister.getEmail());
        assertEquals("STU789", studentRegister.getStudentId());
        assertEquals("987-654-3210", studentRegister.getContactNo());
        assertEquals(dateOfBirth, studentRegister.getDateOfBirth());
        assertEquals(courses, studentRegister.getCourses());
    }

    // Add additional test cases as needed
}

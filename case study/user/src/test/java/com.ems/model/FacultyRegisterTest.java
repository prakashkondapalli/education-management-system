package com.ems.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FacultyRegisterTest {

    @Test
    public void testGettersAndSetters() {
        // Create a mock instance of FacultyRegister
        FacultyRegister facultyRegister = mock(FacultyRegister.class);

        // Set values using setters
        facultyRegister.setName("John Doe");
        facultyRegister.setUsername("john_doe");
        facultyRegister.setPassword("password123");
        facultyRegister.setEmail("john.doe@example.com");
        facultyRegister.setEmployeeId("EMP123");
        facultyRegister.setContactNo("123-456-7890");

        // Create a CourseRegister object for testing
        CourseRegister courseRegister = new CourseRegister();
        UUID courseUuid = UUID.randomUUID();
        courseRegister.setCourseUuid(courseUuid);

        // Create an ArrayList and add the CourseRegister object
        ArrayList<CourseRegister> courses = new ArrayList<>();
        courses.add(courseRegister);

        facultyRegister.setCourses(courses);

        // Verify that the setters were called with the correct values
        verify(facultyRegister).setName("John Doe");
        verify(facultyRegister).setUsername("john_doe");
        verify(facultyRegister).setPassword("password123");
        verify(facultyRegister).setEmail("john.doe@example.com");
        verify(facultyRegister).setEmployeeId("EMP123");
        verify(facultyRegister).setContactNo("123-456-7890");
        verify(facultyRegister).setCourses(courses);

        // Use getters to retrieve values and assert they match the set values
        assertEquals("John Doe", facultyRegister.getName());
        assertEquals("john_doe", facultyRegister.getUsername());
        assertEquals("password123", facultyRegister.getPassword());
        assertEquals("john.doe@example.com", facultyRegister.getEmail());
        assertEquals("EMP123", facultyRegister.getEmployeeId());
        assertEquals("123-456-7890", facultyRegister.getContactNo());
        assertEquals(courses, facultyRegister.getCourses());
    }

}

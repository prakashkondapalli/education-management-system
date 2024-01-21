package com.ems.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CourseRegisterTest {

    @Test
    public void testGettersAndSetters() {
        // Create a mock instance of CourseRegister
        CourseRegister courseRegister = mock(CourseRegister.class);

        // Generate a UUID for testing
        UUID courseUuid = UUID.randomUUID();

        // Set the value using the setter
        courseRegister.setCourseUuid(courseUuid);

        // Verify that the setter was called with the correct value
        verify(courseRegister).setCourseUuid(courseUuid);

        // Use the getter to retrieve the value and assert it matches the set value
        assertEquals(courseUuid, courseRegister.getCourseUuid());
    }
}

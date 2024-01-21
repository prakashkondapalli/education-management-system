package com.ems.model;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CourseEnrollTest {

    @Test
    public void testGettersAndSetters() {
        CourseEnroll courseEnroll = mock(CourseEnroll.class);
        UUID courseUuid = UUID.randomUUID();
        UUID studentUuid = UUID.randomUUID();
        courseEnroll.setCourseUuid(courseUuid);
        courseEnroll.setStudentUuid(studentUuid);
        assertEquals(courseUuid, courseEnroll.getCourseUuid());
        assertEquals(studentUuid, courseEnroll.getStudentUuid());
    }
}


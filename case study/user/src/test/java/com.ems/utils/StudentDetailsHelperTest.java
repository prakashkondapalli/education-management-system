package com.ems.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ems.entity.Course;
import com.ems.entity.Student;
import com.ems.model.CourseRegister;
import com.ems.model.StudentRegister;
import com.ems.repositories.CourseRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentDetailsHelper.class})
@ExtendWith(MockitoExtension.class)
class StudentDetailsHelperTest {
    @InjectMocks
    private StudentDetailsHelper studentDetailsHelper;

    @Mock
    private CourseRepository courseRepository;



    /**
     * Method under test: {@link StudentDetailsHelper#mapToEntityModel(StudentRegister)}
     */
    @Test
    void testMapToEntityModel() {
        assertTrue(
                studentDetailsHelper.mapToEntityModel(new StudentRegister()).getRole().getRoleName() instanceof RoleEnum);
    }

    /**
     * Method under test: {@link StudentDetailsHelper#mapToEntityModel(StudentRegister)}
     */
    @Test
    void testMapToEntityModel2() {
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Student actualMapToEntityModelResult = studentDetailsHelper
                .mapToEntityModel(new StudentRegister("Name", "janedoe", "iloveyou", "42 Main St", "MD", "GB",
                        "jane.doe@example.org", "42", "Contact No", fromResult, new ArrayList<>()));
        assertEquals("42 Main St", actualMapToEntityModelResult.getAddress());
        assertEquals("janedoe", actualMapToEntityModelResult.getUsername());
        assertEquals("42", actualMapToEntityModelResult.getStudentId());
        assertEquals("MD", actualMapToEntityModelResult.getState());
        assertEquals("iloveyou", actualMapToEntityModelResult.getPassword());
        assertEquals("Contact No", actualMapToEntityModelResult.getContactNo());
        assertTrue(actualMapToEntityModelResult.getCourses().isEmpty());
        assertEquals("Name", actualMapToEntityModelResult.getName());
        assertEquals("jane.doe@example.org", actualMapToEntityModelResult.getEmail());
        assertSame(fromResult, actualMapToEntityModelResult.getDateOfBirth());
        assertEquals("GB", actualMapToEntityModelResult.getCountry());
        assertTrue(actualMapToEntityModelResult.getRole().getRoleName() instanceof RoleEnum);
    }


    /**
     * Method under test: {@link StudentDetailsHelper#mapToEntityModel(StudentRegister)}
     */
    @Test
    void testMapToEntityModel4() {
        StudentRegister studentRegister = mock(StudentRegister.class);
        when(studentRegister.getAddress()).thenReturn("42 Main St");
        when(studentRegister.getContactNo()).thenReturn("Contact No");
        when(studentRegister.getCountry()).thenReturn("GB");
        when(studentRegister.getEmail()).thenReturn("jane.doe@example.org");
        when(studentRegister.getName()).thenReturn("Name");
        when(studentRegister.getPassword()).thenReturn("iloveyou");
        when(studentRegister.getState()).thenReturn("MD");
        when(studentRegister.getStudentId()).thenReturn("42");
        when(studentRegister.getUsername()).thenReturn("janedoe");
        when(studentRegister.getCourses()).thenReturn(new ArrayList<>());
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        when(studentRegister.getDateOfBirth()).thenReturn(fromResult);
        Student actualMapToEntityModelResult = studentDetailsHelper.mapToEntityModel(studentRegister);
        assertEquals("42 Main St", actualMapToEntityModelResult.getAddress());
        assertEquals("janedoe", actualMapToEntityModelResult.getUsername());
        assertEquals("42", actualMapToEntityModelResult.getStudentId());
        assertEquals("MD", actualMapToEntityModelResult.getState());
        assertEquals("iloveyou", actualMapToEntityModelResult.getPassword());
        assertEquals("Contact No", actualMapToEntityModelResult.getContactNo());
        assertTrue(actualMapToEntityModelResult.getCourses().isEmpty());
        assertEquals("Name", actualMapToEntityModelResult.getName());
        assertEquals("jane.doe@example.org", actualMapToEntityModelResult.getEmail());
        assertSame(fromResult, actualMapToEntityModelResult.getDateOfBirth());
        assertEquals("GB", actualMapToEntityModelResult.getCountry());
        assertTrue(actualMapToEntityModelResult.getRole().getRoleName() instanceof RoleEnum);
        verify(studentRegister, atLeast(1)).getAddress();
        verify(studentRegister, atLeast(1)).getContactNo();
        verify(studentRegister, atLeast(1)).getCountry();
        verify(studentRegister, atLeast(1)).getEmail();
        verify(studentRegister, atLeast(1)).getName();
        verify(studentRegister, atLeast(1)).getPassword();
        verify(studentRegister, atLeast(1)).getState();
        verify(studentRegister, atLeast(1)).getStudentId();
        verify(studentRegister, atLeast(1)).getUsername();
        verify(studentRegister, atLeast(1)).getCourses();
        verify(studentRegister, atLeast(1)).getDateOfBirth();
    }

    /**
     * Method under test: {@link StudentDetailsHelper#mapToEntityModel(StudentRegister)}
     */
    @Test
    void testMapToEntityModel5() {
        when(courseRepository.findByCourseUuid((UUID) any())).thenReturn(new Course());

        ArrayList<CourseRegister> courseRegisterList = new ArrayList<>();
        courseRegisterList.add(new CourseRegister());
        StudentRegister studentRegister = mock(StudentRegister.class);
        when(studentRegister.getAddress()).thenReturn("42 Main St");
        when(studentRegister.getContactNo()).thenReturn("Contact No");
        when(studentRegister.getCountry()).thenReturn("GB");
        when(studentRegister.getEmail()).thenReturn("jane.doe@example.org");
        when(studentRegister.getName()).thenReturn("Name");
        when(studentRegister.getPassword()).thenReturn("iloveyou");
        when(studentRegister.getState()).thenReturn("MD");
        when(studentRegister.getStudentId()).thenReturn("42");
        when(studentRegister.getUsername()).thenReturn("janedoe");
        when(studentRegister.getCourses()).thenReturn(courseRegisterList);
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        when(studentRegister.getDateOfBirth()).thenReturn(fromResult);
        Student actualMapToEntityModelResult = studentDetailsHelper.mapToEntityModel(studentRegister);
        assertEquals("42 Main St", actualMapToEntityModelResult.getAddress());
        assertEquals("janedoe", actualMapToEntityModelResult.getUsername());
        assertEquals("42", actualMapToEntityModelResult.getStudentId());
        assertEquals("MD", actualMapToEntityModelResult.getState());
        assertEquals("iloveyou", actualMapToEntityModelResult.getPassword());
        assertEquals("Contact No", actualMapToEntityModelResult.getContactNo());
        assertEquals(1, actualMapToEntityModelResult.getCourses().size());
        assertEquals("Name", actualMapToEntityModelResult.getName());
        assertEquals("jane.doe@example.org", actualMapToEntityModelResult.getEmail());
        assertSame(fromResult, actualMapToEntityModelResult.getDateOfBirth());
        assertEquals("GB", actualMapToEntityModelResult.getCountry());
        assertTrue(actualMapToEntityModelResult.getRole().getRoleName() instanceof RoleEnum);
        verify(courseRepository).findByCourseUuid((UUID) any());
        verify(studentRegister, atLeast(1)).getAddress();
        verify(studentRegister, atLeast(1)).getContactNo();
        verify(studentRegister, atLeast(1)).getCountry();
        verify(studentRegister, atLeast(1)).getEmail();
        verify(studentRegister, atLeast(1)).getName();
        verify(studentRegister, atLeast(1)).getPassword();
        verify(studentRegister, atLeast(1)).getState();
        verify(studentRegister, atLeast(1)).getStudentId();
        verify(studentRegister, atLeast(1)).getUsername();
        verify(studentRegister, atLeast(1)).getCourses();
        verify(studentRegister, atLeast(1)).getDateOfBirth();
    }

}


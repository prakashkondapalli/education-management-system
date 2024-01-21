package com.ems.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ems.entity.Course;
import com.ems.entity.Faculty;
import com.ems.model.CourseRegister;
import com.ems.model.FacultyRegister;
import com.ems.repositories.CourseRepository;

import java.util.ArrayList;
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

@ContextConfiguration(classes = {FacultyDetailsHelper.class})
@ExtendWith(MockitoExtension.class)
class FacultyDetailsHelperTest {
    @InjectMocks
    private FacultyDetailsHelper facultyDetailsHelper;

    @Mock
    private CourseRepository courseRepository;

    /**
     * Method under test: {@link FacultyDetailsHelper#mapToEntityModel(FacultyRegister)}
     */
    @Test
    void testMapToEntityModel() {
        assertTrue(
                facultyDetailsHelper.mapToEntityModel(new FacultyRegister()).getRole().getRoleName() instanceof RoleEnum);
    }

    /**
     * Method under test: {@link FacultyDetailsHelper#mapToEntityModel(FacultyRegister)}
     */
    @Test
    void testMapToEntityModel2() {
        Faculty actualMapToEntityModelResult = facultyDetailsHelper.mapToEntityModel(new FacultyRegister("Name",
                "janedoe", "iloveyou", "jane.doe@example.org", "42", "Contact No", new ArrayList<>()));
        assertEquals("Contact No", actualMapToEntityModelResult.getContactNo());
        assertEquals("janedoe", actualMapToEntityModelResult.getUsername());
        assertEquals("iloveyou", actualMapToEntityModelResult.getPassword());
        assertTrue(actualMapToEntityModelResult.getCourses().isEmpty());
        assertEquals("42", actualMapToEntityModelResult.getEmployeeId());
        assertEquals("Name", actualMapToEntityModelResult.getName());
        assertEquals("jane.doe@example.org", actualMapToEntityModelResult.getEmail());
        assertTrue(actualMapToEntityModelResult.getRole().getRoleName() instanceof RoleEnum);
    }

    /**
     * Method under test: {@link FacultyDetailsHelper#mapToEntityModel(FacultyRegister)}
     */
    @Test
    void testMapToEntityModel4() {
        FacultyRegister facultyRegister = mock(FacultyRegister.class);
        when(facultyRegister.getContactNo()).thenReturn("Contact No");
        when(facultyRegister.getEmail()).thenReturn("jane.doe@example.org");
        when(facultyRegister.getEmployeeId()).thenReturn("42");
        when(facultyRegister.getName()).thenReturn("Name");
        when(facultyRegister.getPassword()).thenReturn("iloveyou");
        when(facultyRegister.getUsername()).thenReturn("janedoe");
        when(facultyRegister.getCourses()).thenReturn(new ArrayList<>());
        Faculty actualMapToEntityModelResult = facultyDetailsHelper.mapToEntityModel(facultyRegister);
        assertEquals("Contact No", actualMapToEntityModelResult.getContactNo());
        assertEquals("janedoe", actualMapToEntityModelResult.getUsername());
        assertEquals("iloveyou", actualMapToEntityModelResult.getPassword());
        assertTrue(actualMapToEntityModelResult.getCourses().isEmpty());
        assertEquals("42", actualMapToEntityModelResult.getEmployeeId());
        assertEquals("Name", actualMapToEntityModelResult.getName());
        assertEquals("jane.doe@example.org", actualMapToEntityModelResult.getEmail());
        assertTrue(actualMapToEntityModelResult.getRole().getRoleName() instanceof RoleEnum);
        verify(facultyRegister, atLeast(1)).getContactNo();
        verify(facultyRegister, atLeast(1)).getEmail();
        verify(facultyRegister, atLeast(1)).getEmployeeId();
        verify(facultyRegister, atLeast(1)).getName();
        verify(facultyRegister, atLeast(1)).getPassword();
        verify(facultyRegister, atLeast(1)).getUsername();
        verify(facultyRegister, atLeast(1)).getCourses();
    }

    /**
     * Method under test: {@link FacultyDetailsHelper#mapToEntityModel(FacultyRegister)}
     */
    @Test
    void testMapToEntityModel5() {
        when(courseRepository.findByCourseUuid((UUID) any())).thenReturn(new Course());

        ArrayList<CourseRegister> courseRegisterList = new ArrayList<>();
        courseRegisterList.add(new CourseRegister());
        FacultyRegister facultyRegister = mock(FacultyRegister.class);
        when(facultyRegister.getContactNo()).thenReturn("Contact No");
        when(facultyRegister.getEmail()).thenReturn("jane.doe@example.org");
        when(facultyRegister.getEmployeeId()).thenReturn("42");
        when(facultyRegister.getName()).thenReturn("Name");
        when(facultyRegister.getPassword()).thenReturn("iloveyou");
        when(facultyRegister.getUsername()).thenReturn("janedoe");
        when(facultyRegister.getCourses()).thenReturn(courseRegisterList);
        Faculty actualMapToEntityModelResult = facultyDetailsHelper.mapToEntityModel(facultyRegister);
        assertEquals("Contact No", actualMapToEntityModelResult.getContactNo());
        assertEquals("janedoe", actualMapToEntityModelResult.getUsername());
        assertEquals("iloveyou", actualMapToEntityModelResult.getPassword());
        assertEquals(1, actualMapToEntityModelResult.getCourses().size());
        assertEquals("42", actualMapToEntityModelResult.getEmployeeId());
        assertEquals("Name", actualMapToEntityModelResult.getName());
        assertEquals("jane.doe@example.org", actualMapToEntityModelResult.getEmail());
        assertTrue(actualMapToEntityModelResult.getRole().getRoleName() instanceof RoleEnum);
        verify(courseRepository).findByCourseUuid((UUID) any());
        verify(facultyRegister, atLeast(1)).getContactNo();
        verify(facultyRegister, atLeast(1)).getEmail();
        verify(facultyRegister, atLeast(1)).getEmployeeId();
        verify(facultyRegister, atLeast(1)).getName();
        verify(facultyRegister, atLeast(1)).getPassword();
        verify(facultyRegister, atLeast(1)).getUsername();
        verify(facultyRegister, atLeast(1)).getCourses();
    }

}


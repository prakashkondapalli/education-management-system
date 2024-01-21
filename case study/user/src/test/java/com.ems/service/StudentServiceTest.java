package com.ems.service;

import com.ems.entity.Course;
import com.ems.entity.Role;
import com.ems.entity.Student;
import com.ems.model.CourseEnroll;
import com.ems.repositories.CourseRepository;
import com.ems.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {StudentService.class})
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void testRegisterStudentWithNewStudent() {
        Student newStudent = new Student();
        newStudent.setUsername("newUser");
        newStudent.setPassword("newPassword");
        when(studentRepository.findByUsernameAndPassword("newUser", "newPassword"))
                .thenReturn(Optional.empty());
        when(studentRepository.save(newStudent)).thenReturn(newStudent);
        Student result = studentService.registerStudent(newStudent);
        verify(studentRepository, times(1)).findByUsernameAndPassword("newUser", "newPassword");
        verify(studentRepository, times(1)).save(newStudent);
        assertSame(newStudent, result);
    }

    @Test
    public void testRegisterStudentWithExistingStudent() {
        Student existingStudent = new Student();
        existingStudent.setUsername("existingUser");
        existingStudent.setPassword("existingPassword");
        when(studentRepository.findByUsernameAndPassword("existingUser", "existingPassword"))
                .thenReturn(Optional.of(existingStudent));
        Student result = studentService.registerStudent(existingStudent);
        verify(studentRepository, times(1)).findByUsernameAndPassword("existingUser", "existingPassword");
        verify(studentRepository, never()).save(any());
        assertNull(result);
    }
    @Test
    public void testLoginWithValidCredentials() {
        Student existingStudent = new Student();
        existingStudent.setUsername("validUser");
        existingStudent.setPassword("validPassword");
        when(studentRepository.findByUsernameAndPassword("validUser", "validPassword"))
                .thenReturn(Optional.of(existingStudent));
        Optional<Student> result = studentService.login("validUser", "validPassword");
        verify(studentRepository, times(1)).findByUsernameAndPassword("validUser", "validPassword");
        assertEquals(Optional.of(existingStudent), result);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        when(studentRepository.findByUsernameAndPassword("invalidUser", "invalidPassword"))
                .thenReturn(Optional.empty());
        Optional<Student> result = studentService.login("invalidUser", "invalidPassword");
        verify(studentRepository, times(1)).findByUsernameAndPassword("invalidUser", "invalidPassword");
        assertEquals(Optional.empty(), result);
    }
    
}


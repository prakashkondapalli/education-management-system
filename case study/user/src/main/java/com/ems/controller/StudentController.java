package com.ems.controller;

import com.ems.entity.Student;
import com.ems.exception.InvalidRegistrationException;
import com.ems.exception.UserNotFoundException;
import com.ems.model.CourseEnroll;
import com.ems.model.StudentRegister;
import com.ems.repositories.StudentRepository;
import com.ems.repositories.UserDetailsRepository;
import com.ems.service.StudentService;
import com.ems.utils.StudentDetailsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/education")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDetailsHelper studentHelper;
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody StudentRegister student) {
        try {
            Student studentDetails = studentHelper.mapToEntityModel(student);
            Student registeredStudent = studentService.registerStudent(studentDetails);
            if (registeredStudent == null)
                throw new InvalidRegistrationException();
            return new ResponseEntity<>(registeredStudent, HttpStatus.CREATED);
        }catch(Exception e){
            throw new InvalidRegistrationException();
        }
    }

    @GetMapping("/getStudent")
    public String getByUserName(@RequestParam String username, @RequestParam String password) {
        try {
            Optional<Student> studentDetails = studentRepository.findByUsernameAndPassword(username, password);
            if (studentDetails.isPresent())
                return studentDetails.get().toString();
            else {
                throw new UserNotFoundException();
            }
        }catch (Exception e){
            throw  new UserNotFoundException();
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Optional<Student> student = studentService.login(username, password);
        return student.isPresent()
                ? new ResponseEntity<>("Login successful", HttpStatus.OK)
                : new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/enrollCourse")
    public ResponseEntity<Object> enrollCourse(@RequestBody CourseEnroll courseEnroll) {
        Student student = studentService.enrollment(courseEnroll);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
package com.ems.controller;

import com.ems.entity.Faculty;
import com.ems.exception.InvalidRegistrationException;
import com.ems.exception.UserNotFoundException;
import com.ems.model.FacultyRegister;
import com.ems.repositories.FacultyRepository;
import com.ems.service.FacultyService;
import com.ems.utils.FacultyDetailsHelper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/faculty")
@Transactional
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private FacultyDetailsHelper facultyDetailsHelper;

    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody FacultyRegister facultyRegister) {
        try {
            Faculty faculty = facultyDetailsHelper.mapToEntityModel(facultyRegister);
            Faculty registeredFaculty = facultyService.registerFaculty(faculty);
            if (registeredFaculty == null)
                throw new InvalidRegistrationException();
            return new ResponseEntity<>(facultyRegister, HttpStatus.CREATED);
        }catch(Exception e){
            throw new InvalidRegistrationException();
        }
    }

    @GetMapping("/getFaculty")
    public String getByUserName(@RequestParam String username, @RequestParam String password) {
        try {
            Optional<Faculty> student = facultyRepository.findByUsernameAndPassword(username, password);
            if (student.isPresent())
                return student.get().toString();
            else {
                throw new UserNotFoundException();
            }
        }catch (Exception e){
            throw  new UserNotFoundException();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password) {
        Optional<Faculty> faculty = facultyService.login(username, password);
        return faculty.isPresent()
                ? new ResponseEntity<>(faculty, HttpStatus.OK)
                : new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateFaculty(@RequestBody FacultyRegister facultyRegister) {
        Faculty faculty = facultyService.updateFaculty(facultyDetailsHelper.mapToEntityModel(facultyRegister));
        return faculty!=null
                ? new ResponseEntity<>(faculty, HttpStatus.ACCEPTED)
                : new ResponseEntity<>("Faculty not found!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> removeFaculty(@RequestParam String username, @RequestParam String password) {
        Optional<Faculty> faculty = facultyRepository.findByUsernameAndPassword(username,password);
        if(faculty.isPresent()){
            facultyRepository.deleteByFacultyUuid(faculty.get().getFacultyUuid());
            return new ResponseEntity<>("Faculty Removed Successfully!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Faculty not found!", HttpStatus.BAD_REQUEST);
        }
    }

}
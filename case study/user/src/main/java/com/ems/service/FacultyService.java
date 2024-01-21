package com.ems.service;

import com.ems.repositories.CourseRepository;
import com.ems.repositories.FacultyRepository;
import com.ems.utils.RoleEnum;
import com.ems.entity.Course;
import com.ems.entity.Faculty;
import com.ems.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Faculty registerFaculty(Faculty faculty) {
        Optional<Faculty> facultyRepo = facultyRepository.findByUsernameAndPassword(faculty.getUsername(),faculty.getPassword());
        if(facultyRepo.isPresent()){
            return null;
        }
        else {
            return facultyRepository.save(faculty);
        }
    }

    public Optional<Faculty> login(String username, String password) {
        return facultyRepository.findByUsernameAndPassword(username,password);
    }

    public Faculty updateFaculty(Faculty faculty) {
        Optional<Faculty> facultyRepo = facultyRepository.findByUsernameAndPassword(faculty.getUsername(),faculty.getPassword());
        if(facultyRepo.isPresent()){
            facultyRepo.get().setName(faculty.getName());
            facultyRepo.get().setUsername(faculty.getUsername());
            facultyRepo.get().setPassword(faculty.getPassword());
            facultyRepo.get().setEmail(faculty.getEmail());
            facultyRepo.get().setEmployeeId(faculty.getEmployeeId());
            facultyRepo.get().setContactNo(faculty.getContactNo());
            if (Objects.nonNull(faculty.getCourses())) {
                ArrayList<Course> courses = new ArrayList<>();
                for(Course course: faculty.getCourses()) {
                    Course repoCourse = courseRepository.findByCourseUuid(course.getCourseUuid());
                    courses.add(repoCourse);
                }
                facultyRepo.get().setCourses(new HashSet<>(courses.stream().collect(Collectors.toList())));
            }
            Role role = new Role(RoleEnum.USER);
            facultyRepo.get().setRole(role);
            return facultyRepository.save(facultyRepo.get());
        }
        else {
            return null;
        }
    }
}
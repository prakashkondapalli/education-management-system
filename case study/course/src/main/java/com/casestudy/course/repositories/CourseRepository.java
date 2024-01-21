package com.casestudy.course.repositories;

import com.casestudy.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CourseRepository extends JpaRepository<Course, UUID> {

    Course findByCourseUuid(UUID courseUuid);
}

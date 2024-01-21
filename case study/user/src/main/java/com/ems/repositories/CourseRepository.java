package com.ems.repositories;

import com.ems.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CourseRepository extends JpaRepository<Course, UUID> {

    Course findByCourseUuid(UUID courseUuid);
}
package com.ems.repositories;

import com.ems.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUsernameAndPassword(String username, String password);

    Student findByStudentUuid(UUID studentUuid);

}
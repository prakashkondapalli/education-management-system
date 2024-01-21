package com.casestudy.course.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(generator = "UUID2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "course_uuid", columnDefinition = "uuid")
    private UUID courseUuid;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "description")
    private String description;
}

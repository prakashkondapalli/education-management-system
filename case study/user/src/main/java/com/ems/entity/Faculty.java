package com.ems.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(generator = "UUID2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "faculty_uuid", columnDefinition = "uuid")
    private UUID facultyUuid;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "faculty_uuid")
    @MapsId
    private Role role;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "contact_no")
    private String contactNo;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Course> courses;

}
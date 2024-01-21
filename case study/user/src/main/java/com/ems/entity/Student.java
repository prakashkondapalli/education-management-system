package com.ems.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(generator = "UUID2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "student_uuid", columnDefinition = "uuid")
    private UUID studentUuid;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "student_uuid")
    @MapsId
    private Role role;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Course> courses;

}
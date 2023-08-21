package com.example.hw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty(message = "name should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Column(columnDefinition = "int not null ")
    @NotNull(message = "age should be not empty")
    @Positive
    private Integer age;
    @Column(columnDefinition = "varchar(20) unique not null")
    @Email
    @NotEmpty(message = "email should be not empty")
    private  String email;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "salary should be not null")
    @Positive(message = "its has to be positive number")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courseSet;
}

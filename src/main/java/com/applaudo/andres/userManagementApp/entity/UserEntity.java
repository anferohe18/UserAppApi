package com.applaudo.andres.userManagementApp.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty
    @Size(min =1,max = 50, message = "Name must not be empty and should not be greater than 50 characters")
    @Column(name = "name", nullable = false)
    private String firstName;

    @NotEmpty
    @Size(min = 1, max = 50, message = "Last name must not be empty and should not be greater than 50 characters")
    @NotNull
    private String lastName;

    @Size(min = 12, max = 12, message = "Phone should have 12 characters and must start with +503")
    private String phone;

}

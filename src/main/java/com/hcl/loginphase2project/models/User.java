package com.hcl.loginphase2project.models;

import lombok.Data;

import javax.persistence.*;

@Table (name="users")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
}

package com.example.Register.Login.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;

   
    private String password;

    @Column(unique = true,nullable = false)
    private String phoneno;
}

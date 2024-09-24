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
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column(unique = true,nullable = false)

    private String phoneno;
}

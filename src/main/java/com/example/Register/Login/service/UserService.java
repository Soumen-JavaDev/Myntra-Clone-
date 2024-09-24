package com.example.Register.Login.service;

import com.example.Register.Login.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public  boolean registerUser(User user);
    public User loginUser(String email,String password);
}

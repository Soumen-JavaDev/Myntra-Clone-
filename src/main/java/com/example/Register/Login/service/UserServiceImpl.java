package com.example.Register.Login.service;

import com.example.Register.Login.Repository.UserRepository;
import com.example.Register.Login.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registerUser(User user){
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public User loginUser(String email,String password){
       User validUser= userRepository.findByEmail(email);
       if(validUser !=null && validUser.getPassword().equals(password)){
            return validUser;
       }
       return null;
    }
}

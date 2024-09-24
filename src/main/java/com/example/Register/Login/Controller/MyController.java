package com.example.Register.Login.Controller;


import com.example.Register.Login.entities.User;

import com.example.Register.Login.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
    @Autowired
   private UserService userService;
    @GetMapping("/RegPage")
    public String openRegPage(Model model){
        model.addAttribute("user",new User());
        return "RegisterPage";
    }

    @PostMapping("/regForm")
    public String submitRegForm(@ModelAttribute("user") User user,Model model){
     boolean status=  userService.registerUser(user);
       if(status){
           model.addAttribute("successMsg","user registered successfully");
       }
       else {
           model.addAttribute("errorMsg","user not registered due to some error");
       }
        return "RegisterPage";
    }

    @GetMapping("/loginPage")
    public String openLoginPage(Model model){
        model.addAttribute("user",new User());
        return "LoginPage";
    }
    @PostMapping("/loginForm")
    public  String submitLoginFrom(@ModelAttribute("user") User user,Model model){
        User validUesr =userService.loginUser(user.getEmail(),user.getPassword());
        if(validUesr !=null){
            model.addAttribute("modelName", validUesr.getName());
            return "profile";

        }else {
            model.addAttribute("errorMsg","Email id and password didnt matched");
            return "LoginPage";
        }
       
    }
}

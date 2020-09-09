package com.bookcode.controller;

import com.bookcode.entity.User;
import com.bookcode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author EdiMen
 * @Data 2020/9/8--0:08
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    @ResponseBody
    public String addUser(@RequestParam String firstName,@RequestParam String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        User u = userRepository.save(user);
        if (u!=null){
            return "success";
        }else {
            return "failure";
        }
    }
}

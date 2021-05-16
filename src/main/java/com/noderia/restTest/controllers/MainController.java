package com.noderia.restTest.controllers;

import com.noderia.restTest.models.User;
import com.noderia.restTest.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path ="/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String tel) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setTel(tel);
        userRepository.save(n);
        return "Saved...\n";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}

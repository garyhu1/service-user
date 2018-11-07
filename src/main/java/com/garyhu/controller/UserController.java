package com.garyhu.controller;

import com.garyhu.entity.User;
import com.garyhu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: garyhu
 * @since: 2018/11/7 0007
 * @decription:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    @ResponseBody
    public User findUserById(@PathVariable Integer id){
        User user = userRepository.findOne(id);

        return user;
    }
}

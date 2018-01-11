package com.mustafaergan.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mustafaergan.mongodb.entity.Group;
import com.mustafaergan.mongodb.entity.User;
import com.mustafaergan.mongodb.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	Gson gson = new Gson();
	
    @RequestMapping("/")
    public String get(@RequestParam(value="id") String id) {
    	User user = userRepository.findOne(id);
        return gson.toJson(user);
    }
	
	
    @RequestMapping("/hello")
    public void set(@RequestParam(value="name", defaultValue="World") String name) {
    	User user = new User();
    	user.setName("test");
    	Group group = new Group();
    	group.setName("group");
    	user.setGroup(group);
        userRepository.save(user);
    }
    
    
    @RequestMapping("/update")
    public String update(@RequestParam(value="id") String id) {
        User user = userRepository.findOne(id);
        user.setName("update");
        userRepository.save(user);
        return gson.toJson(user);
    }
	

}

package com.mustafaergan.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mustafaergan.mongodb.entity.Test;
import com.mustafaergan.mongodb.repository.TestRepository;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	TestRepository testRepository;
	
	
	Gson gson = new Gson();
	
    @RequestMapping("/")
    public String get(@RequestParam(value="id") String id) {
        Test test = testRepository.findOne(id);
        return gson.toJson(test);
    }
	
	
    @RequestMapping("/hello")
    public void set(@RequestParam(value="name", defaultValue="World") String name) {
        Test test = new Test();
        test.setValue(name);
        testRepository.save(test);
    }
    
    
    @RequestMapping("/update")
    public String update(@RequestParam(value="id") String id) {
        Test test = testRepository.findOne(id);
        test.setValue("update");
        testRepository.save(test);
        return gson.toJson(test);
    }
	
    


}

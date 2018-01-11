package com.mustafaergan.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mustafaergan.mongodb.entity.User;

public interface UserRepository  extends MongoRepository<User, String>{

}

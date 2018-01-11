package com.mustafaergan.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mustafaergan.mongodb.entity.Test;

public interface TestRepository extends MongoRepository<Test, String>{

}

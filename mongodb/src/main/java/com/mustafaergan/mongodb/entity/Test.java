package com.mustafaergan.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "test_data")
@Data
public class Test {
	
    @Id
    public String id;
    
    @Indexed(unique = true)
    private String value;

}

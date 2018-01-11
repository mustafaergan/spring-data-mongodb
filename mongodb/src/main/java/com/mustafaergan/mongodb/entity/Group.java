package com.mustafaergan.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "group")
@Data
public class Group {
	@Id
	String id;
	String name;
}

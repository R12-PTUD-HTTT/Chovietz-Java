package com.chovietz.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "user")
public class Customer extends User{
	private String name;
	private Date date_of_birth;
	private String email;
	private String phoneNumber;
//	private Object[] cart;
	
	
}

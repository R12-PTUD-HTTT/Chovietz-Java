package com.chovietz.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "user")
public class Shop extends User{
	private String name;
	private String phoneNumber;
	private String email;
	private Date date_of_birth;
	private Store storeInfo;
}

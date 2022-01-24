package com.chovietz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "store")
public class Store {
	@Id
	private String _id;
	private String store_name;
	private String phone_number;
	private String business_licences;
	private String avatar;
	private String cover_image;
	private String address;
}

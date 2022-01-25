package com.chovietz.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Shipping_Application_Form")
public class ShipperApply {
	private String _id;
	private String fullname;
	private String gender;
	private String email;
	private String tel;
	private String address;
	private String Work_area;
}

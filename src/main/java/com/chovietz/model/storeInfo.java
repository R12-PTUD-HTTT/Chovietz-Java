package com.chovietz.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class storeInfo {
	@Id
	private String _id;
	private String store_name;
	private String phone_number;
	
	public storeInfo(String id, String name, String phone) {
		this._id = id;
		this.store_name = name;
		this.phone_number = phone;
	}
}

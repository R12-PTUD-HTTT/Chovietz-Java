package com.chovietz.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "ShopApply")
public class ShopApply {
	private String _id;
	private String hoten;
	private String email;
	private String cmnd;
	private String sdt;
	private Date ngaysinh;
	private String diachi;
	private boolean hopdong;
}

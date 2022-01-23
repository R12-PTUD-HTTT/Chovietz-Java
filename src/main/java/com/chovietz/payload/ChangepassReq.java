package com.chovietz.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangepassReq {
	private String current;
	private String newpass;
	private String comfirm;
}

package com.MemberBoard1.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDTO {

	private String mid;
	private String mpassword;
	private String mname;
	private Date mbirth;
	private String maddress;
	private String memail;
	private String mphone;
	private String emailid;
	private String memaildomain;
	private String mpostcode;
	private String maddr;
	private String maddrefer;
	private String mdetailAddress;
}

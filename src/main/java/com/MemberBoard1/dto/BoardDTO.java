package com.MemberBoard1.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDTO {

	private int bno;
	private String bwriter;
	private String bpassword;
	private String btitle;
	private String bcontent;
	private Date bdate;
	private int bhit;
}

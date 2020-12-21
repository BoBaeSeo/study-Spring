package com.MemberBoard1.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MessageDTO {

	private String msg_sendid;
	private String msg_receiveid;
	private String msg_content;
	private Date msg_date;
	private int msg_check;
}

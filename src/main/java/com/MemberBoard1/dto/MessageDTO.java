package com.MemberBoard1.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MessageDTO {

	private int msg_code;
	private String msg_sendid;
	private String msg_receiveid;
	private String msg_content;
	private Date msg_date;
	private int msg_check;
}

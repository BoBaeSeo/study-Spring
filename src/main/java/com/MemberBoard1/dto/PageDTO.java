package com.MemberBoard1.dto;

import lombok.Data;

@Data
public class PageDTO {

	private int page;
	private int maxpage;
	private int startpage;
	private int endpage;
	private int startrow;
	private int endrow;
}

package com.MemberBoard1.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberDTO {

	private String mid;				// 아이디
	private String mpassword;		// 비밀번호
	private String mname;			// 이름
	private Date mbirth;			// 생년월일
	private String mphone;			// 연락처
	private String memail;			// 전체 이메일
	private String emailid;			// 이메일 아이디
	private String memaildomain;	// 이메일 도메인
	private String maddress;		// 전체주소
	private String mpostcode;		// 우편번호
	private String maddr;			// 주소
	private String maddrefer;		// 참고항목
	private String mdetailAddress;	// 상세주소

	private String mprofilename;
	private MultipartFile mprofile;
}


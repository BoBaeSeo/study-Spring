package com.TestProject1.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TestProject1.dto.TestDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/* @GetMapping("/") */ //Get 방식으로 넘어오는 것만 따로 어노테이션으로 표시 가능하다.
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/test01", method = RequestMethod.GET)
	public String test1() {
		System.out.println("/test01");
		return "result1";
	}
	
	/* 파라미터 넘기는 1번째 방법
	 * @RequestMapping(value = "/test02", method = RequestMethod.GET) public String
	 * test2(String name, int age) { System.out.println("/test02");
	 * System.out.println("name :" + name); System.out.println("age :" + age);
	 * return "result2"; }
	 */
	
	// 파라미터 넘기는 2번쨰 방법
	@RequestMapping(value = "/test02", method = RequestMethod.GET)
	public String test2(@RequestParam("name") String names, int age) {
		System.out.println("/test02");
		System.out.println("names :" + names);
		System.out.println("age :" + age);
		return "result2";
	}
	
	@RequestMapping(value = "/test03", method = RequestMethod.POST)
	public String test3(@RequestParam("name") String names, int age) {
		System.out.println("/test03");
		System.out.println("names :" + names);
		System.out.println("age :" + age);
		return "result3";
	}
	
	@GetMapping("/test04")
	public String test4(@ModelAttribute("name") String name, int age) {
		System.out.println("/test04_GET");
		System.out.println("name :" + name);
		System.out.println("age :" + age);
		return "result04";
	}
	
	@GetMapping("/test05")
	public String test5(TestDTO dto) {
		System.out.println("/test05_GET");
		System.out.println("name :" + dto.getName());
		System.out.println("age :" + dto.getAge());
		System.out.println("addr :" + dto.getAddr());
		return "result05";
	}
}

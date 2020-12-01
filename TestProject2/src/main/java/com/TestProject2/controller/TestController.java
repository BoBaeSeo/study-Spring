package com.TestProject2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TestProject2.dto.TestDto;

@Controller
public class TestController {

	@RequestMapping(value = "/testPage")
	public String testPage() {
		System.out.println("/testPage");
		
		return "test/testPage"; 
	}
	
	@RequestMapping(value = "test01", method=RequestMethod.GET)
	public String test01_GET(String name, int age, String addr) {
		System.out.println("test01_GET");
		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age);
		System.out.println("주소 :" + addr);
		return "home";
	}
	
	@RequestMapping(value = "test01", method=RequestMethod.POST)
	public String test01_POST(String name, int age, String addr) {
		System.out.println("test01_POST");
		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age);
		System.out.println("주소 :" + addr);
		return "home";
	}
	
	@RequestMapping(value = "test02", method=RequestMethod.POST)
	public String test02(@RequestParam("name") String data1, int age, String addr) {
		System.out.println("test02");
		System.out.println("이름 :" + data1);
		System.out.println("나이 :" + age);
		System.out.println("주소 :" + addr);
		return "home";
	}
	
	@RequestMapping(value = "test03", method=RequestMethod.POST)
	public String test03(TestDto testDto) {
		System.out.println("test03");
		System.out.println("이름 :" + testDto.getName());
		System.out.println("나이 :" + testDto.getAge());
		System.out.println("주소 :" + testDto.getAddr());
		return "home";
	}
	
	@RequestMapping("test04")
	public String test04(@ModelAttribute("name") String name, @ModelAttribute("age") int age, String addr, Model model ) {
		System.out.println("test04");
		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age);
		System.out.println("주소 :" + addr);
		model.addAttribute("birth", "1998-01-20");
		return "result/result04";
	}
	
	@RequestMapping("test05")
	public String test05(@ModelAttribute("dto") TestDto testDto, Model model) {
		System.out.println("test05");
		System.out.println("이름 :" + testDto.getName());
		System.out.println("나이 :" + testDto.getAge());
		System.out.println("주소 :" + testDto.getAddr());
		
		return "result/result05";
	}
	
}

package com.TestProject1.dto;

public class TestDTO {

	private String name;
	private int age;
	private String addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "TestDTO [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
}

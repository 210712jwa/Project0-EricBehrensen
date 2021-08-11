package com.revature.dto;

public class AddOrEditClientDTO {
	private String name;
	private int age;
	
	public AddOrEditClientDTO() {
		super();
	}

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
}

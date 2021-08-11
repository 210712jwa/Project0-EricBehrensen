package com.revature.dto;

public class AddOrEditAccountDTO {
	private int funds;
	private int age;
	
	public AddOrEditAccountDTO() {
		super();
	}

	public int getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

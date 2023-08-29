package com.coltroller.entiry;

public class User {
	
	private Long id;
	private String name;
	private double age;
	
	public User() {
		super();
	}

	public User(Long id, String name, double age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}
	

}

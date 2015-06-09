package com.changer.springbean;

public class Person {
	private String name;
	private int age;
	private String gender;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Person构造函数被调用");
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void sayHello(){
		System.out.println("Hello " + this.name);
	}
}

package com.changer.ej;

public enum ChairMan {
	INSTANCE;
	
	private String name;
	private int age;
	
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

	/*
	public ChairMan getInstance(){
		return INSTANCE;
	}
	*/
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name=" + name + "; age=" + age;
	}
}

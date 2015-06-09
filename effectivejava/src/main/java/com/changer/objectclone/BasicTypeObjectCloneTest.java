package com.changer.objectclone;

// Student的field都是基本数据类型，clone之后，会产生一个完全独立的s2。
// 对s2的更改不会影响s1。
public class BasicTypeObjectCloneTest {
	public static void main(String[] args) throws CloneNotSupportedException{
		Student s1 = new Student();
		s1.setName("fcjiang");
		s1.setAge(20);
		System.out.println("s1=" + s1);
		
		Student s2 = (Student)s1.clone();
		System.out.println("s2=" + s2);
		
		s2.setName("sszhu");
		
		System.out.println("s2 has been changed");
		System.out.println("s1: name=" + s1.getName() + "; age=" + s1.getAge());
		System.out.println("s2: name=" + s2.getName() + "; age=" + s2.getAge());
	}
}

//Cloneable接口是标记接口，没有要实现的方法
class Student implements Cloneable{
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
	
	// 重写clone的目的，是为了将clone方法的protected改为public
	@Override
	public Object clone() throws CloneNotSupportedException{
		Object obj = super.clone();
		return obj;
	}
}
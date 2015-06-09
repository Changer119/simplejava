package com.changer.objectclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 利用序列化进行深拷贝（推荐该方式）
public class ReferenceTypeObjectDeepCloneRecommendTest {
	public static void main(String[] args) throws Exception{
		Teacher3 teacher3 = new Teacher3();
		teacher3.setSubject("Chinese");
		
		Student3 src = new Student3();
		src.setName("fcjiang");
		src.setAge(20);
		src.setTeacher3(teacher3);
		System.out.println("src=" + src);
		
		Student3 dst = (Student3)src.deepClone();
		System.out.println("dst=" + dst);
		
		dst.setName("sszhu");
		dst.getTeacher3().setSubject("English");
		
		System.out.println("dst's teacher has been changed");
		System.out.println("src: name=" + src.getName() + "; age=" + src.getAge() + "; teacher's subject=" + src.getTeacher3().getSubject());
		System.out.println("dst: name=" + dst.getName() + "; age=" + dst.getAge() + "; teacher's subject=" + dst.getTeacher3().getSubject());
	}
}

// Serializable接口是标记接口，没有要实现的方法
class Student3 implements Serializable{
	private static final long serialVersionUID = -2041583694031578229L;
	
	private String name;
	private int age;
	private Teacher3 teacher3;
	
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
	public Teacher3 getTeacher3() {
		return teacher3;
	}
	public void setTeacher3(Teacher3 teacher3) {
		this.teacher3 = teacher3;
	}
	
	// 利用序列化实现deepClone
	public Object deepClone() throws Exception{
		// 序列化
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		// 反序列化
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
}

class Teacher3 implements Serializable{
	private static final long serialVersionUID = -925893186012855970L;
	
	private String subject;

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}

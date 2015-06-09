package com.changer.objectclone;


//Student的field中有引用类型时，clone方法产生的拷贝是浅拷贝，name/age会有独立的拷贝，但src和dst中的teacher2指向同一个Teacher2实例。
//对dst中teacher2的修改也会反应到src中。
public class ReferenceTypeObjectCloneTest {
	public static void main(String[] args) throws CloneNotSupportedException{
		Teacher2 teacher2 = new Teacher2();
		teacher2.setSubject("Chinese");
		
		Student2 src = new Student2();
		src.setName("fcjiang");
		src.setAge(20);
		src.setTeacher2(teacher2);
		System.out.println("src=" + src);
		
		Student2 dst = (Student2)src.clone();
		System.out.println("dst=" + dst);
		
		dst.setName("sszhu");
		dst.getTeacher2().setSubject("English");
		
		System.out.println("dst's teacher has been changed");
		System.out.println("src: name=" + src.getName() + "; age=" + src.getAge() + "; teacher's subject=" + src.getTeacher2().getSubject());
		System.out.println("dst: name=" + dst.getName() + "; age=" + dst.getAge() + "; teacher's subject=" + dst.getTeacher2().getSubject());
	}
}

//Cloneable接口是标记接口，没有要实现的方法
class Student2 implements Cloneable{
	private String name;
	private int age;
	private Teacher2 teacher2;
	
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
	public Teacher2 getTeacher2() {
		return teacher2;
	}
	public void setTeacher2(Teacher2 teacher2) {
		this.teacher2 = teacher2;
	}
	
	// 重写clone的目的，是为了将clone方法的protected改为public
	@Override
	public Object clone() throws CloneNotSupportedException{
		// 浅拷贝
//		Object obj = super.clone();
//		return obj;
		
		
		// 改为深复制：  
        Student2 student2 = (Student2) super.clone();  
        // 本来是浅复制，现在将Teacher对象复制一份并重新set进来  
        student2.setTeacher2((Teacher2) student2.getTeacher2().clone());  
        return student2; 
	}
}

class Teacher2 implements Cloneable{
	private String subject;

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
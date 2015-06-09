package com.changer.springbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class AppMain {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AppMain.class);
	
	public static void main(String[] args){
		// ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appcontext-springbean");
		/*
		// Bean的scope=singleton时，只要ApplicationContext被创建，bean就会直接被new出来。
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/changer/springbean/appcontext-springbean.xml");
		Person person = (Person) applicationContext.getBean("person");
		person.sayHello();
		*/ 
		
		// 利用BeanFactory产生bean实例
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/changer/springbean/appcontext-springbean.xml"));
		// 必须显示的getBean才能够new出来bean。
		beanFactory.getBean("person");
		
	}
	
	// 获取ApplicationContext的3种方式
	public void testXmlLoad(){
		// ClassPathXmlApplicationContext方式，从类路径获取
		
		// FileSystemXmlApplicationContext方式，从文件系统获取，需要给绝对路径
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("/Users/fcjiang/Code/gitHome/simplejava/springlearn/src/main/java/com/changer/springbean/appcontext-springbean.xml");
		
		
		// XmlWebApplicationContext方式，从web系统加载（tomcat启动时加载）
		
		Person person = (Person) applicationContext.getBean("person");
		person.sayHello();
	}
}

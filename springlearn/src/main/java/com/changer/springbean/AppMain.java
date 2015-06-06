package com.changer.springbean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AppMain.class);
	
	public static void main(String[] args){
		// ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appcontext-springbean");
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/changer/springbean/appcontext-springbean.xml");
		Person person = (Person) applicationContext.getBean("person");
		person.sayHello();
	}
}

package com.changer.quartztest.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
	public static void main(String args[]){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("file:/Users/fcjiang/Code/gitHome/simplejava/quartztest/src/main/resource/applicationContext.xml");
    }
}

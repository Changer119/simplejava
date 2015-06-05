package com.changer.quartztest.spring;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
	public void printMessage(){
		System.out.println(new Date() + "I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
	}
}

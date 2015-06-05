package com.changer.quartztest.spring;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("anotherBean")
public class AnotherBean {
	public void printAnotherMessage(){
        System.out.println(new Date() + "I am called by Quartz jobBean using CronTriggerFactoryBean");
    }
}

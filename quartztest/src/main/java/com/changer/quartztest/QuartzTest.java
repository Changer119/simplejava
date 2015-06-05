package com.changer.quartztest;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzTest {
	public static void main(String[] args) throws Exception{
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler sched = factory.getScheduler();
		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob")
				.build();
		Trigger trigger = TriggerBuilder.newTrigger()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(10)
						.repeatForever())
				.build();
		
		sched.start();
		sched.scheduleJob(job, trigger);
	}
}

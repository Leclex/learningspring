package com.leclex.ch1.main;

import com.leclex.ch1.service.GreetingMessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
//	private static ApplicationContext context;

	public static void main(String[] args) {
//		context = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		GreetingMessageService greetingMessageService = 
		context.getBean("greetingMessageServiceImpl", GreetingMessageService.class);
		System.out.println(greetingMessageService.greetUser());
		((ClassPathXmlApplicationContext) context).close();
	}

}

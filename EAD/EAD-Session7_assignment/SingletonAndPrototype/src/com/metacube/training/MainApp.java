package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		//Singleton Class
		Person person1 = (Person) context.getBean("person1");
		person1.setName("Rahul");
		System.out.println("Person1 - " + person1.getName());
		Person person2 = (Person) context.getBean("person1");
		System.out.println("Person1 - " + person2.getName());
		
		//Prototype Class
		Person person3 = (Person) context.getBean("person2");
		person3.setName("Rahul");
		System.out.println("Person2 - " + person3.getName());
		Person person4 = (Person) context.getBean("person2");
		System.out.println("Person2 - " + person4.getName());
	}
}

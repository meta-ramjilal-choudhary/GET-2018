package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.pointsList();
		triangle.pointsSet();
		triangle.pointsMap();
	}
	
}

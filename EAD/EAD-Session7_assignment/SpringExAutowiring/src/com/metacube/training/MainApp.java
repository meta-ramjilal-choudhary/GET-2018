package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String args[]){
		ApplicationContext contextForByName = new ClassPathXmlApplicationContext("BeansForByName.xml");
		ApplicationContext contextForByType = new ClassPathXmlApplicationContext("BeansForByType.xml");
		ApplicationContext contextForByConstructor = new ClassPathXmlApplicationContext("BeansForByConstructor.xml");
		TextEditor textEditor = (TextEditor) contextForByName.getBean("textEditor");
		textEditor.spellCheck();
		textEditor = (TextEditor) contextForByType.getBean("textEditor");
		textEditor.spellCheck();
		textEditor = (TextEditor) contextForByConstructor.getBean("textEditor");
		textEditor.spellCheck();
	}
	
}

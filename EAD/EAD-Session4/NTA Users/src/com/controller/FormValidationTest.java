package com.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class FormValidationTest {

	@Test
	public void test() {
		FormValidation form = new FormValidation();
		
		assertTrue(form.isFormValid("Ramjilal", "Choudhary", "8385000000", "ram@gmail.com", "Ram@12345"));
	
		assertTrue(form.isNameValid("Ramjilal"));
		assertFalse(form.isNameValid("Choudhary123"));
		
		assertTrue(form.isNumeric("8385028045"));
		assertFalse(form.isNumeric("12345"));
		assertFalse(form.isNumeric("ram1234"));
		
		assertTrue(form.isEmailValid("ram@gmail.com"));
		assertFalse(form.isEmailValid("ramjilal.gmaiil.com"));
		assertFalse(form.isEmailValid("@.com"));
		assertFalse(form.isEmailValid("@."));
		
		assertTrue(form.isPasswordValid("Rahul@1998"));
		assertFalse(form.isPasswordValid("ramjilal"));
	}

}

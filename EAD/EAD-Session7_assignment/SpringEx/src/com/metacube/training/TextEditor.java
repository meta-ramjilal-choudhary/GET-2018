package com.metacube.training;

public class TextEditor {
	
	private SpellChecker spellChecker;
	
	TextEditor(){
		System.out.println("Text Editor constructor calling ..");
	}
	
	/**
	 * 
	 * @param spellChecker - SpellChecker class object
	 */
	public void setSpellChecker(SpellChecker spellChecker){
		this.spellChecker = spellChecker;
	}
	
	/**
	 * 
	 * @return - SpellChecker class object
	 */
	public SpellChecker getSpellChecker(){
		return this.spellChecker;
	}
	
	/**
	 * Spell Checking method
	 */
	public void spellCheck(){
		this.spellChecker.check();
	}
}

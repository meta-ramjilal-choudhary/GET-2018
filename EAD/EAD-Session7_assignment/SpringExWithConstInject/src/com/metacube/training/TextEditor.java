package com.metacube.training;

public class TextEditor {

	private SpellChecker spellChecker;
	
	TextEditor(SpellChecker spellChecker){
		System.out.println("Constructor based injection");
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

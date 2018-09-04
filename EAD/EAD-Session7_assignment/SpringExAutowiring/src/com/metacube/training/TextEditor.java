package com.metacube.training;

public class TextEditor {
	
	private SpellChecker spellChecker;
	private String word;
	
	public TextEditor(){
		System.out.println("Text Editor constructor calling ..");
	}
	
	public TextEditor(SpellChecker spellChecker, String word){
		System.out.println("Text Editor parametrized constructor calling ..");
		this.spellChecker = spellChecker;
		this.word = word;
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
	 * @param word - word string
	 */
	public void setWord(String word){
		this.word = word;
	}
	
	/**
	 * 
	 * @return - SpellChecker class object
	 */
	public SpellChecker getSpellChecker(){
		return this.spellChecker;
	}
	
	/**
	 * 
	 * @return - word string
	 */
	public String getWord(){
		return this.word;
	}
	
	/**
	 * Spell Checking method
	 */
	public void spellCheck(){
		this.spellChecker.check(this.word);
	}
}

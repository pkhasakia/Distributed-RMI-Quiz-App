/**
 * Title: Quiz Application
 * Student: Preet Khasakia
 * Student ID: 100653168
 * Date: October 26, 2020
 */
import java.util.*;
/*
 * This class indicates the methods needed to be used by the server to access questions,
 * list of choices and answers for the client.
 */
public class Questions {
	
	private String questions;
	private String answers;
	private ArrayList<String> choices;
	
	public Questions(String q, String a, String[] c) {	//Constructor
		this.questions = q;
		this.choices = new ArrayList<String>();
		this.answers = a;
		

		for(int i = 0, n = c.length; i < n; i++) {
			this.choices.add(c[i]);
		}
		Collections.shuffle(this.choices);		
	}
	

	public ArrayList<String> promptChoices(){
		return choices;
	}

	public String promptAnswer() {
		return answers;
	}
	
	public String promptQuestions() {
		return questions;
	}
	
}

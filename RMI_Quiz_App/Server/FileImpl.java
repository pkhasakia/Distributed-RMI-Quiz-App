/**
 * Title: Quiz Application
 * Student: Preet Khasakia
 * Student ID: 100653168
 * Date: October 26, 2020
 */
import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.net.InetAddress;
import java.net.UnknownHostException; 

public class FileImpl implements FileInterface {

//Initialized instance variables
   private String name;
   private ArrayList<Questions> qList;
   private String question = null;
   private int correctAns;

//Constructor 
   public FileImpl(String s) throws RemoteException{
      super();
      name = s;
   }
   
   //Here each question is stored an an array list and answer in an array
   public void initQuestions() {
	   correctAns = 0;
	   
	   qList = new ArrayList<Questions>();
		
	   question = "Who was the Finals MVP of the 2019 NBA Championship?";
	   String[] answers = {"Kyle Lowry", "Kawhi Leonard", "Marc Gasol", "Pascal Siakam"};
	   qList.add(new Questions(question, "Kawhi Leonard", answers));
		
	   question = "What language is used in Android Studio?";
	   answers = new String[] {"Java", "C", "C++", "Perl"};
	   qList.add(new Questions(question, "Java", answers));
		    
	   question = "Which ice cream has a name after a day in the week?";
	   answers = new String[] {"Vanilla", "Sundae", "Chocolate", "Strawberry"};
	   qList.add(new Questions(question, "Sundae", answers));
	   
	   question = "Who is the GOAT of the Toronto Raptors?";
	   answers = new String[] {"Kyle Lowry", "DeMar DeRozan", "Kawhi Leonard", "Vince Carter"};
	   qList.add(new Questions(question, "Roger Fedrer", answers));
		    
	   question = "How many provinces are there in Canada?";
	   answers = new String[] {"5", "0", "10", "8"};
	   qList.add(new Questions(question, "10", answers));
	   Collections.shuffle(qList, new Random());			//Questions will be shuffled
	   
   }
   
   //Method is used to randmoized the questions/choices
   public void shuffleQuestions() {
	   Collections.shuffle(qList, new Random());
   }
   
   //Here, the method uses an external method from the Questions.java file to prompt every question
   public String showQuestions(int i){
		return qList.get(i).promptQuestions();
	}
   
   //Returns the size of the questions
   public int returnQuestionSize() {
	   int qListSize = qList.size();
	   return qListSize;
   }
   
   //Returns the size of the choices
   public int returnChoiceSize(int i) {
	   int choices = qList.get(i).promptChoices().size();
	   return choices;
   }
   
   //Prompts choices using an external method from the Questions.java file
   public ArrayList<String> showChoices(int i) {
	   return  qList.get(i).promptChoices();
   }
   
   //This method keeps track of the correct answer using an index and uses a print to identify the IP address of the client
   public void correctAnswer(int playerAnswer, int i) {
	   ArrayList<String> choiceList = qList.get(i).promptChoices();
			String correctAnswer = qList.get(i).promptAnswer();
			int index = choiceList.indexOf(correctAnswer);
			
			//Condition that increments the number of correct answers
			if(playerAnswer == index + 1) {
				correctAns++;
			}
			try {
				InetAddress ipAddress = InetAddress.getLocalHost();
				
				System.out.println("\n" + "Client (" + ipAddress + ") response: " + playerAnswer);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
   }
   
   //This method uses a switch case that displays the final score and a message when the quiz is finished
   public String message() {
	   try {
		InetAddress ipAddress = InetAddress.getLocalHost();
		System.out.println("\n" + "Quiz is over for Client: " + ipAddress + "\n");
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   switch (correctAns) {
		case 1:
			return ("Correct Answers: " + correctAns +"/5 Ohh...Good luck next time!");
			
		case 2:
			return ("Correct Answers: " + correctAns +"/5 Good try!");
			
		case 3:
			return ("Correct Answers: " + correctAns +"/5 I know you are better than this!");
			
		case 4:
			return ("Correct Answers: " + correctAns +"/5 Well Done!!");
			
		case 5:
			return ("Correct Answers: " + correctAns +"/5 Excellentoouu!!");
			
		default:
			return ("Correct Answers: " + correctAns +"/5 I'm sure you will do good!");
		}
	   
   }	
}
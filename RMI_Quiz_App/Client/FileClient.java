/**
 * Title: Quiz Application
 * Student: Preet Khasakia
 * Student ID: 100653168
 * Date: October 26, 2020
 */
import java.io.*; 
import java.rmi.*;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class FileClient{	
   public static void main(String argv[]) {
	 
	  //Condition to check if the user has entered their command to run the client
      if(argv.length != 1) {
        System.out.println("Usage: java FileClient machineName ");
        System.exit(0);
      }
      
      
	  try{
		  //This code is used to specify the server and uses a file interface object 
		  Scanner in = new Scanner(System.in);
		  String name = "//" + argv[0] + "/FileServer";
		  FileInterface fi = (FileInterface) Naming.lookup(name);
		  
		  //Quiz begins by initializing the questions
		  System.out.println("\n" + "WELCOME TO THE QUIZ!" + "\n");
		  fi.initQuestions();
		  
		  //This code returns the size of each questions used in the upcoming for loop
		  int s = fi.returnQuestionSize();
		  int answer = 0;							//variable for user input
		  String restartResponse = null;			//Variable for restart response
		  
		  while(true) {
			  //This loop displays each question
			  for(int i = 0; i < s; i++) {
				  System.out.println("Question " + (i+1) + ": " + fi.showQuestions(i)); 
		  		  int c = fi.returnChoiceSize(i);
		  		  
		  		  //This loop displays the choices
		  		  for(int j = 0; j < c; j++) {
		  			  System.out.println("("+ (j + 1) + ") "+fi.showChoices(i).get(j));
		  		  }
		  		//Here, the client asks for an answer
		  		System.out.print("\n" + "Enter response: ");
		  		answer = in.nextInt();
		  		
		  		//If the user enters an answer that is 0 or greater than 4 choices they will be prompted again 
		  		while(answer == 0 || answer > 4) {
		  			System.out.println("INVALID RESPONSE!");
		  			System.out.print("\n" + "Enter response: ");
			  		answer = in.nextInt();
		  		}
		  		
		  		System.out.println(" ");
		  		
		  		//This method will keep track of the correct answer
		  		fi.correctAnswer(answer, i);
		  		
			  }
			  
			  System.out.println(fi.message());		//Displays final result and message
			  
			  //This code will prompt the user to restart the quiz or quit
			  System.out.println("\n" + "To restart the quiz, enter 'r': ");
			  System.out.println("To exit the quiz, enter 'q' or [Ctrl + c]: ");
			  restartResponse = in.next();
			  if(restartResponse.contains("r")) {
				  fi.shuffleQuestions();
				  continue;
			  }
			  else {
				  System.exit(0);
			  }
		  }
	  }
	  catch(Exception e) {
		System.err.println("FileServer exception: "+ e.getMessage());
		e.printStackTrace();
		
	  }	  
   }
}
/**
 * Title: Quiz Application
 * Student: Preet Khasakia
 * Student ID: 100653168
 * Date: October 26, 2020
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FileInterface extends Remote {

	//Each method is remote which performs a specified task in the implementation file
	public String showQuestions(int i) throws RemoteException;						//Unique method
	public int returnQuestionSize() throws RemoteException;
	public void initQuestions() throws RemoteException;
	public int returnChoiceSize(int i) throws RemoteException;
	public ArrayList<String> showChoices(int i) throws RemoteException;				//Unique method
	public void correctAnswer(int playerAnswer, int i) throws RemoteException;		//Unique method
	public String message() throws RemoteException;									//Unique method
	public void shuffleQuestions() throws RemoteException;							//Unique method

}
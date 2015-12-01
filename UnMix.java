package project4;

import java.io.*;
import java.util.*;

public class UnMix implements iUnMix {
	
	/** Linked list of characters representing the initial message */
	public LinkedList<Character> iMessage;
	
	/** Used for saving text removed to a 'clipboard' */
	private String clipboard;
	
	/******************************************************************
	 * Constructor for the UnMix class. Creates a linked list to store
	 * the initial encrypted message and a clipboard for paste data.
	 *****************************************************************/
	public UnMix() {
		iMessage = new LinkedList<Character>();
		clipboard = null;
	}
	
	@Override
	/******************************************************************
	 * UnMixs the given message using the specified file containing
	 * information for decryption.
	 * @param fileName name of the file storing decryption information
	 * @param userMessage the encrypted message
	 * @return the decrypted String
	 *****************************************************************/
	public String UnMixUsingFile(String filename, String userMessage) {
		// Sets the initial encrypted message into a Linked List
		setMessage(userMessage);
		
		// Reads file and processes all commands
		return readFile(filename);
	}
	
	/******************************************************************
	 * Helper method used to process a given command.
	 * @param command the command issued to the Linked List
	 *****************************************************************/
	private void processCommand(String command) {
		try {
			// Deals with b command (insert)
			if (command.startsWith("b")) {
				String data[] = command.split(" ");
				iMessage.addBefore(Integer.parseInt(data[2]), data[1]);
			}
			
			// Deals with r command (delete)
			if (command.startsWith("r")) {
				String data[] = command.split(" ");
				int index = Integer.parseInt(data[1]);
				iMessage.delete(index);
			}

			// Deals with w command (swap)
			if (command.startsWith("w")) {
				String data[] = command.split(" ");
				int index1 = Integer.parseInt(data[1]);
				int index2 = Integer.parseInt(data[2]);
				iMessage.switchData(index1, index2);
			}

			// Deals with x command (cut)
			if (command.startsWith("x")) {
				String data[] = command.split(" ");
				int index1 = Integer.parseInt(data[1]);
				int index2 = Integer.parseInt(data[2]);
				iMessage.cutFromList(index1, index2);
			}

			// Deals with p command (paste)
			if (command.startsWith("p")) {
				String clipSplit[] = command.split("\\|");
				String clipboard = clipSplit[1];
				String data[] = clipSplit[0].split(" ");
				iMessage.pasteFromList(Integer.parseInt(data[1]), 
						clipboard);
			}
		}
		catch (Exception e) {
			// Gracefully exits program
			System.out.println("Error decrypting file!");
		}
	}

	/******************************************************************
	 * Sets the initial secret message entered by the user.
	 * @param message the initial message
	 *****************************************************************/
	public void setMessage(String message) {
		int index = 0;
		
		// Stores the initial encrypted message into a Linked List
		while (message.length() != index) {
			iMessage.addAtEnd(message.charAt(index));
			index += 1;
		}
	}
	
	/******************************************************************
	 * Reads the file entered by the user and processes each command to
	 * decrypt the Linked List. Returns the decrypted String.
	 * @param filename the decryption file provided by the user
	 * @return the decrypted String
	 *****************************************************************/
	private String readFile(String filename) {
		try {
			// Create object of FileReader
			FileReader inputFile = new FileReader(filename);

			// Instantiate the BufferedReader Class
			BufferedReader bufferReader = new BufferedReader(inputFile);

			// Variable to hold the one line data
			String line;

			// Read file line by line and print on the console
			while ((line = bufferReader.readLine()) != null)   {
				processCommand(line);
			}
			
			// Close the buffer reader
			bufferReader.close();
			
			return iMessage.displayMessage();
		}
		catch(Exception e) {
			// Gracefully exits the program
			System.out.println("Error while reading file line by line:"
					+ " " + e.getMessage());                      
		}
		
		return null;
	}

	/******************************************************************
	 * UnMix program that decrypts a secret message using a file and
	 * encrypted message.
	 *****************************************************************/
	public static void main(String[] args) {
		// Scans user input
		Scanner s = new Scanner(System.in);
		UnMix un = new UnMix();
		
		System.out.println("Welcome to the un-mixer!");
		System.out.println("Please enter your file name:");
		
		// Stores the file name into a temporary variable
		String filename = s.nextLine();
		
		System.out.println("");
		System.out.println("Please enter the secret message:");
		
		// Stores the message into a temporary variable
		String message = s.nextLine();
		
		System.out.println("");
		System.out.println("Decrypting...");
		System.out.println("The secret message was:");
		
		// Decrypted message
		System.out.println(un.UnMixUsingFile(filename, message));
		
	}

}

package project4;

import java.io.*;
import java.util.*;

public class UnMix implements iUnMix {
	
	/** Linked list of characters representing the initial message */
	public LinkedList<Character> iMessage;
	
	/** Used for saving text removed to a 'clipboard' */
	private String clipboard;
	
	public UnMix() {
		iMessage = new LinkedList<Character>();
		clipboard = null;
	}
	
	@Override
	public String UnMixUsingFile(String filename, String userMessage) {
		// TODO Auto-generated method stub
		setMessage(userMessage);
		return readFile(filename);
	}

	private void processCommand(String command) {
		try {
			if (command.startsWith("b")) {
				String data[] = command.split(" ");
				iMessage.addBefore(Integer.parseInt(data[2]), data[1]);
			}

			if (command.startsWith("r")) {
				String data[] = command.split(" ");
				int index = Integer.parseInt(data[1]);
				iMessage.delete(index);
			}

			if (command.startsWith("w")) {
				String data[] = command.split(" ");
				int index1 = Integer.parseInt(data[1]);
				int index2 = Integer.parseInt(data[2]);
				iMessage.switchData(index1, index2);
			}

			if (command.startsWith("x")) {
				String data[] = command.split(" ");
				int index1 = Integer.parseInt(data[1]);
				int index2 = Integer.parseInt(data[2]);
				iMessage.cutFromList(index1, index2);
			}

			if (command.startsWith("p")) {
				String clipSplit[] = command.split("\\|");
				String clipboard = clipSplit[1];
				String data[] = clipSplit[0].split(" ");
				iMessage.pasteFromList(Integer.parseInt(data[1]), 
						clipboard);
			}
		}
		catch (Exception e) {
			System.out.println("Error decrypting file!");
		}
	}

	/******************************************************************
	 * Sets the initial secret message entered by the user.
	 * @param message the initial message
	 *****************************************************************/
	public void setMessage(String message) {
		int index = 0;
		while (message.length() != index) {
			iMessage.addAtEnd(message.charAt(index));
			index += 1;
		}
	}
	
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
			System.out.println("Error while reading file line by line:"
					+ " " + e.getMessage());                      
		}
		
		return null;
	}

	public static void main(String[] args) {
		// Scans user input
		Scanner s = new Scanner(System.in);
		UnMix un = new UnMix();
		
		System.out.println("Welcome to the un-mixer!");
		System.out.println("Please enter your file name:");
		
		String filename = s.nextLine();
		
		System.out.println("");
		System.out.println("Please enter the secret message:");
		
		String message = s.nextLine();
		
		System.out.println("");
		System.out.println("Decrypting...");
		System.out.println("The secret message was:");
		System.out.println(un.UnMixUsingFile(filename, message));
		
	}

}

package project4;

import java.io.*;
import java.util.*;

public class Mix implements iMix {
	
	/** Linked list of characters representing a message */
	private LinkedList<Character> secretMessage;
	
	/** Listing of commands in reverse order */
	private Stack<String> commands;
	
	public Mix() {
		secretMessage = new LinkedList<Character>();
		commands = new Stack<String>();
	}

	@Override
	public String processCommand(String command) {
		Scanner s = new Scanner(new InputStreamReader(System.in));
		
		// User wants to quit the program.
		if (command.equals("Q")) {
			System.out.println("Closing program...");
			System.out.println("Final Message:");
			secretMessage.display();
			s.close();
			return null;
		}
		
		// User wants to insert a character before the specified position.
		if (command.startsWith("b")) {
			System.out.println(command);
			String data[] = command.split(" ");

			//System.out.println(temp[1]);
			//System.out.println(temp[2]);
			
			if (data.length == 1) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			// Checking if command was properly input
			if (data[1].equals(null)) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			if (data[1].equals("") || data[1].equals(" ")) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			if (!isNumeric(data[1])) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			int index = Integer.parseInt(data[2]);
			
			// Checking if index is valid
			if (index < 0 || index > secretMessage.count()) {
				System.out.println("Invalid position entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			// Format: b c #
			
			secretMessage.addBefore(Integer.parseInt(data[2]), data[1]);
			commands.push(command);
			secretMessage.display();
			System.out.println("");
			System.out.println("");
			printCommandListing();
			System.out.println("");
			System.out.println("Command: ");
			String c = s.nextLine();
			System.out.println("");
			processCommand(c);
			s.close();
			return null;
		}
		
		// User wants to remove a character at the specified position.
		if (command.startsWith("r")) {
			// Format: r #
			String[] data = command.split(" ");
			
			if (data.length == 1) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			// Checking if command was properly input
			if (data[1].equals(null)) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			if (data[1].equals("") || data[1].equals(" ")) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			if (!isNumeric(data[1])) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			int index = Integer.parseInt(data[1]);
			
			// Checking if index is valid
			if (index < 0 || index > secretMessage.count()) {
				System.out.println("Invalid position entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			secretMessage.delete(index);
			commands.push(command);
			secretMessage.display();
			System.out.println("");
			System.out.println("");
			printCommandListing();
			System.out.println("");
			System.out.println("Command: ");
			String c = s.nextLine();
			System.out.println("");
			processCommand(c);
			s.close();
			return null;
		}

		// User wants to switch characters at the two specified positions.
		if (command.startsWith("w")) {
			// Format: w & #
			String[] data = command.split(" ");

			if (data.length == 1 || data.length == 2) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}

			// Checking if command was properly input
			if (data[1].equals(null) || data[2].equals(null)) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}

			if (data[1].equals("") || data[1].equals(" ") || data[2].equals("") || data[2].equals(" ")) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}

			if (!isNumeric(data[1]) || !isNumeric(data[2])) {
				System.out.println("Invalid command entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}

			int index1 = Integer.parseInt(data[1]);
			int index2 = Integer.parseInt(data[2]);

			// Checking if index is valid
			if (index1 < 0 || index1 > secretMessage.count() || 
					index2 < 0 || index2 > secretMessage.count()) {
				System.out.println("Invalid position entered! Try again!");
				System.out.println("");
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				processCommand(c);
				s.close();
				return null;
			}
			
			// TODO: Switch characters here
			
			commands.push(command);
			s.close();
			return null;
		}
		
		// User wants to save the commands to a file.
		if (command.startsWith("s")) {
			// Format: s filename
			commands.push(command);
			s.close();
			return null;
		}
		
		// User wants to cut to the clipboard, starting at & to # (inclusive)
		if (command.startsWith("x")) {
			// Format: x & #
			commands.push(command);
			s.close();
			return null;
		}
		
		// User wants to paste from the clipboard starting at #
		if (command.startsWith("p")) {
			// Format: p #
			commands.push(command);
			s.close();
			return null;
		}
		
		// User wants to copy to the clipboard starting at & to #
		if (command.startsWith("c")) {
			// Format: c & #
			commands.push(command);
			s.close();
			return null;
		}
		
		// Invalid command entered. Prompt user again.
		System.out.println("Invalid command entered! Try again!");
		System.out.println("");
		printCommandListing();
		System.out.println("");
		System.out.println("Command: ");
		String c = s.nextLine();
		System.out.println("");
		processCommand(c);
		s.close();
		return null;
	}

	@Override
	public void setInitialMessage(String message) {
		int index = 0;
		while (message.length() != index) {
			secretMessage.addAtEnd(message.charAt(index));
			index += 1;
		}
	}
	
	private void printCommandListing() {
		System.out.println("The following commands are available to you: ");
		System.out.println("Q \t\t Quits the program. Prints the final mixed up message.");
		System.out.println("b c # \t\t Insert character (c) before position (#).");
		System.out.println("r # \t\t Remove the character at position (#).");
		System.out.println("w & # \t\t Switch character at position & with #.");
		System.out.println("x & # \t\t Cut to clipboard; starting at position & to #.");
		System.out.println("p # \t\t Paste from clipboard starting at position #.");
		System.out.println("c & # \t\t Copy to clipboard starting at position & to #.");
		System.out.println("s filename \t Save commands to a text file named 'filename'.");
	}
	
	private boolean isNumeric(String str) {
		try  
		{  
			int i = Integer.parseInt(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}
	
	public static void main(String[] args) throws IOException {
		Mix m = new Mix();
		Scanner s = new Scanner(new InputStreamReader(System.in));
		System.out.println("Welcome to the secret message mixer!");
		System.out.println("");
		System.out.println("Please enter your message: ");
		String initial = s.nextLine();
		m.setInitialMessage(initial);
		System.out.println("");
		m.secretMessage.display();
		// System.out.println("You typed: " + input);
		System.out.println("");
		System.out.println("");
		m.printCommandListing();
		System.out.println("");
		System.out.println("Command: ");
		String command = s.nextLine();
		System.out.println("");
		m.processCommand(command);
		s.close();
	}

}

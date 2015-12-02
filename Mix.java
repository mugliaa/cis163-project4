package project4;

import java.io.*;
import java.util.*;

/**********************************************************************
 * A secret message program that will encrypt a message that the user
 * entered using a given set of commands.
 * @author Adam Muglia & Tyler Miller
 * @version 2-Dec-2015
 *********************************************************************/
public class Mix implements iMix {

	/** Linked list of characters representing a message */
	public LinkedList<Character> secretMessage;

	/** Listing of commands in reverse order */
	private Stack<String> commands;

	/** Used for saving text removed to a 'clipboard' */
	private String clipboard;
	
	/** Used to ignore console for JUnit testing */
	public boolean testing = false;

	/******************************************************************
	 * Constructor for the Mix class. Creates a linked list that will 
	 * store the secret message, saves the commands entered by the user,
	 * and sets the clipboard to null.
	 *****************************************************************/
	public Mix() {
		secretMessage = new LinkedList<Character>();
		commands = new Stack<String>();
		clipboard = null;
	}

	@Override
	/******************************************************************
	 * Processes the user's command and changes the secret message.
	 * @param command the command entered by the user
	 * @return output of the command; null if invalid
	 *****************************************************************/
	public String processCommand(String command) {
		Scanner s = new Scanner(new InputStreamReader(System.in));

		// User wants to quit the program.
		if (command.equals("Q")) {
			// Checking if command is input properly
			if (command.length() != 1) {
				if (testing == true) 
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
			if (testing == true) 
				return null;
			System.out.println("Closing program...");
			System.out.println("Final Message:");
			System.out.println(secretMessage.displayMessage());
			s.close();
			return null;
		}

		// User wants to insert a character before the position.
		if (command.startsWith("b")) {
			// Format: b c #
			String data[] = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
				if (testing == true) 
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data.length == 1 || data.length == 2) {
				if (testing == true) 
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true) 
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true) 
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Checking if third element is numeric
			if (!isNumeric(data[2])) {
				if (testing == true) 
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
			if (index < 0 || index >= secretMessage.count()) {
				if (testing == true)
					return null;
				System.out.println("Invalid position entered! "
						+ "Try again!");
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

			secretMessage.addBefore(Integer.parseInt(data[2]), data[1]);
			// Converting command and putting into stack
			commands.push(convertCommand(command, null, null));
			if (testing == false) {
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				// Prompt user again
				processCommand(c);
				s.close();
			}
			return null;
		}

		// User wants to remove a character at the specified position.
		if (command.startsWith("r")) {
			// Format: r #
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data.length == 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Checking is second element is numeric
			if (!isNumeric(data[1])) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
			if (index < 0 || index >= secretMessage.count()) {
				if (testing == true)
					return null;
				System.out.println("Invalid position entered! "
						+ "Try again!");
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
			
			if (secretMessage.displayMessage().length() == 1) {
				if (testing == true) 
					return null;
				System.out.println("Cannot fully delete message! "
						+ "Try again!");
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

			// Delete at specified index and store character
			char deleted = secretMessage.delete(index);

			// Convert command and add to stack
			commands.push(convertCommand(command, deleted, null));
			if (testing == false) {
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				// Prompt user for input again
				processCommand(c);
				s.close();
			}
			return null;
		}

		// User wants to switch characters at the two positions.
		if (command.startsWith("w")) {
			// Format: w & #
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data.length == 1 || data.length == 2) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data[1].equals("") || data[1].equals(" ") || 
					data[2].equals("") || data[2].equals(" ")) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Checking if second and third elements are numeric
			if (!isNumeric(data[1]) || !isNumeric(data[2])) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Setting values into variables
			int index1 = Integer.parseInt(data[1]);
			int index2 = Integer.parseInt(data[2]);

			// Checking if index is valid
			if (index1 < 0 || index1 >= secretMessage.count() || 
					index2 < 0 || index2 >= secretMessage.count()) {
				if (testing == true)
					return null;
				System.out.println("Invalid position entered! "
						+ "Try again!");
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

			// Switches data at the two indexes
			secretMessage.switchData(index1, index2);
			
			// Command does not need to be converted
			commands.push(command);
			
			if (testing == false) {
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				// Prompt the user again
				processCommand(c);
				s.close();
			}
			return null;
		}

		// User wants to save the commands to a file.
		if (command.startsWith("s")) {
			// Format: s filename
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data.length == 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
			
			// Stores the information being written to the file
			String fileCommands = "";
			
			// Takes commands from Stack and appends to String
			// Separated by lines
			while (!commands.isEmpty()) {
				fileCommands += commands.pop() + "\n";
			}
			
			// Write to the text file
			try {
				PrintWriter out = new PrintWriter(data[1] + ".txt");
				out.println(fileCommands);
				out.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error writing to file! Try again!");
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

			if (testing == false) {
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				// Prompt the user again
				processCommand(c);
				s.close();
			}
			return null;
		}

		// User wants to cut to the clipboard, starting at & to #
		if (command.startsWith("x")) {
			// Format: x & #
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data.length == 1 || data.length == 2) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data[1].equals("") || data[1].equals(" ") || 
					data[2].equals("") || data[2].equals(" ")) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Checks if second and third elements are numeric
			if (!isNumeric(data[1]) || !isNumeric(data[2])) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Setting values into variables
			int index1 = Integer.parseInt(data[1]);
			int index2 = Integer.parseInt(data[2]);

			if (index1 > index2) {
				if (testing == true)
					return null;
				System.out.println("Invalid position entered! "
						+ "Try again!");
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
			
			// Checking if index is valid
			if (index1 < 0 || index1 >= secretMessage.count() || 
					index2 < 0 || index2 >= secretMessage.count()) {
				if (testing == true)
					return null;
				System.out.println("Invalid position entered! "
						+ "Try again!");
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
			
			if (index1 == 0 && index2 == secretMessage.count() - 1) {
				if (testing == true) 
					return null;
				System.out.println("Cannot cut the entire message! "
						+ "Try again!");
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

			// Cuts from the LinkedList and saves to clipboard
			clipboard = secretMessage.cutFromList(index1, index2);
			
			// Converts command and adds to Stack
			commands.push(convertCommand(command, null, clipboard));

			if (testing == false) {
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				// Prompt the user again
				processCommand(c);
				s.close();
			}
			return null;
		}

		// User wants to paste from the clipboard starting at #
		if (command.startsWith("p")) {
			// Format: p #
			String[] data = command.split(" ");

			if (data[0].length() != 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data.length == 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
			if (data[0].equals(null) || data[1].equals(null)) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data[0].equals("") || data[0].equals(" ") || 
					data[1].equals("") || data[1].equals(" ")) {
				if (testing == true) {
					return null;
				}
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Checks if second element is numeric
			if (!isNumeric(data[1])) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
			
			// Setting values into variables
			int index1 = Integer.parseInt(data[1]);

			// Checking if index is valid
			if (index1 < 0 || index1 >= secretMessage.count()) {
				if (testing == true)
					return null;
				System.out.println("Invalid position entered! "
						+ "Try again!");
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
			
			// Checks if clipboard is empty
			if (this.clipboard == null || this.clipboard.length() == 0){
				if (testing == true)
					return null;
				System.out.println("Clipboard is empty! "
						+ "Try again!");
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
			
			// Saves the clipboard to a temporary variable
			String clipboard = this.clipboard;
			
			// Pastes the clipboard to the LinkedList at specified pos
			secretMessage.pasteFromList(Integer.parseInt(data[1]), 
					clipboard);
			
			// Converts the command and adds to the Stack
			commands.push(convertCommand(command, null, clipboard));

			if (testing == false) {
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				// Prompts the user again
				processCommand(c);
				s.close();
			}
			return null;
		}

		// User wants to copy to the clipboard starting at & to #
		if (command.startsWith("c")) {
			// Format: c & #
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data.length == 1 || data.length == 2) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			if (data[1].equals("") || data[1].equals(" ") || 
					data[2].equals("") || data[2].equals(" ")) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Checks if the second and third element are numeric
			if (!isNumeric(data[1]) || !isNumeric(data[2])) {
				if (testing == true)
					return null;
				System.out.println("Invalid command entered! "
						+ "Try again!");
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

			// Setting values into variables
			int index1 = Integer.parseInt(data[1]);
			int index2 = Integer.parseInt(data[2]);

			// Checking if index is valid
			if (index1 < 0 || index1 >= secretMessage.count() || 
					index2 < 0 || index2 >= secretMessage.count()) {
				if (testing == true)
					return null;
				System.out.println("Invalid position entered! "
						+ "Try again!");
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

			// Copies the specified range to the clipboard
			clipboard = secretMessage.copyFromList(index1, index2);

			// Adds the command to the Stack
			commands.push(command);

			if (testing == false) {
				secretMessage.display();
				System.out.println("");
				System.out.println("");
				printCommandListing();
				System.out.println("");
				System.out.println("Command: ");
				String c = s.nextLine();
				System.out.println("");
				// Prompt the user for input again
				processCommand(c);
				s.close();
			}
			return null;
		}

		// Invalid command entered. Prompt user again.
		if (testing == false) {
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
		}
		return null;
	}

	/******************************************************************
	 * Helper method that converts an input command to be added to the
	 * Stack for later use in UnMix.
	 * @param command user inputed command being converted
	 * @param deleted character removed, if relevant
	 * @param clipboard data for pasting, if relevant
	 * @return the converted command
	 *****************************************************************/
	private String convertCommand(String command, Character deleted, 
			String clipboard) {
		
		// Split the command into sections by a space delimiter
		String[] split = command.split(" ");
		
		// Converts b to r
		if (split[0].equals("b")) {
			return "r " + split[2];
		}
		
		// Converts r to b
		if (split[0].equals("r")) {
			return "b " + deleted + " " + split[1];
		}
		
		// Converts x to p
		if (split[0].equals("x")) {
			return "p " + split[1] + "|" + clipboard;
		}

		// Converts p to x
		if (split[0].equals("p")) {
			return "x " + split[1] + " " + (Integer.parseInt(split[1]) + 
					clipboard.length() - 1);
		}

		// Invalid data
		return null;
	}
	
	@Override
	/******************************************************************
	 * Sets the initial secret message entered by the user.
	 * @param message the initial message
	 *****************************************************************/
	public void setInitialMessage(String message) {
		Scanner s = new Scanner(System.in);
		
		int index = 0;
		
		// Takes the initial message and adds it character-by-character
		while (message.length() != index) {
			secretMessage.addAtEnd(message.charAt(index));
			index += 1;
		}
	}

	/******************************************************************
	 * Helper method that prints the list of commands available.
	 *****************************************************************/
	private void printCommandListing() {
		System.out.println("The following commands are available to "
				+ "you: ");
		System.out.println("Q \t\t Quits the program. Prints the final "
				+ "mixed up message.");
		System.out.println("b c # \t\t Insert character (c) before "
				+ "position (#).");
		System.out.println("r # \t\t Remove the character at position "
				+ "(#).");
		System.out.println("w & # \t\t Switch character at position & "
				+ "with #.");
		System.out.println("x & # \t\t Cut to clipboard; starting at "
				+ "position & to #.");
		System.out.println("p # \t\t Paste from clipboard starting at "
				+ "position #.");
		System.out.println("c & # \t\t Copy to clipboard starting at "
				+ "position & to #.");
		System.out.println("s filename \t Save commands to a text file "
				+ "named 'filename'.");
	}

	/******************************************************************
	 * Helper method to determine if user input is numeric.
	 * @param str the user input
	 * @return true if numeric; false if not numeric
	 *****************************************************************/
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

	/******************************************************************
	 * Mix program that encrypts a secret message using user commands.
	 * @throws IOException error inputing a command
	 *****************************************************************/
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

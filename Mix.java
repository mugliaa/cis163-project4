package project4;

import java.io.*;
import java.util.*;

/**********************************************************************
 * A secret message program that will encrypt a message that the user
 * entered using a given set of commands.
 * @author Adam Muglia & Tyler Miller
 * @version 23-Nov-2015
 *********************************************************************/
public class Mix implements iMix {

	/** Linked list of characters representing a message */
	public LinkedList<Character> secretMessage;

	/** Listing of commands in reverse order */
	private Stack<String> commands;

	/** Used for saving text removed to a 'clipboard' */
	private String clipboard;

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
	 * @return output of the command
	 *****************************************************************/
	public String processCommand(String command) {
		Scanner s = new Scanner(new InputStreamReader(System.in));

		// User wants to quit the program.
		if (command.equals("Q")) {
			// Checking if command is input properly
			if (command.length() != 1) {
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
			System.out.println("Closing program...");
			System.out.println("Final Message:");
			System.out.println(secretMessage.displayMessage());
			s.close();
			return null;
		}

		// User wants to insert a character before the position.
		if (command.startsWith("b")) {
			// System.out.println(command);
			String data[] = command.split(" ");

			// System.out.println(temp[1]);
			// System.out.println(temp[2]);

			// Checking if command is input properly
			if (data[0].length() != 1) {
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

			if (!isNumeric(data[2])) {
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

			// Format: b c #

			secretMessage.addBefore(Integer.parseInt(data[2]), data[1]);
			commands.push(convertCommand(command, null, null));
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

			// Checking if command is input properly
			if (data[0].length() != 1) {
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

			if (!isNumeric(data[1])) {
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

			Character deleted = secretMessage.delete(index);
			commands.push(convertCommand(command, deleted, null));
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

		// User wants to switch characters at the two positions.
		if (command.startsWith("w")) {
			// Format: w & #
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
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

			if (!isNumeric(data[1]) || !isNumeric(data[2])) {
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
			if (index1 < 0 || index1 > secretMessage.count() || 
					index2 < 0 || index2 > secretMessage.count()) {
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

			secretMessage.switchData(index1, index2);
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

		// User wants to save the commands to a file.
		if (command.startsWith("s")) {
			// Format: s filename
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
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
			
			String fileCommands = "";
			while (!commands.isEmpty()) {
				fileCommands += commands.pop() + "\n";
			}
			
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

		// User wants to cut to the clipboard, starting at & to #
		if (command.startsWith("x")) {
			// Format: x & #
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
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

			if (!isNumeric(data[1]) || !isNumeric(data[2])) {
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

			clipboard = secretMessage.cutFromList(index1, index2);
			commands.push(convertCommand(command, null, clipboard));
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

			// User wants to paste from the clipboard starting at #
		if (command.startsWith("p")) {
			// Format: p #
			String[] data = command.split(" ");
			
			if (data[0].length() != 1) {
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

			if (!isNumeric(data[1])) {
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
			
			if (this.clipboard == null || this.clipboard.length() == 0){
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
			
			String clipboard = this.clipboard;
			secretMessage.pasteFromList(Integer.parseInt(data[1]), 
					clipboard);
			//System.out.println(clipboard);
			commands.push(convertCommand(command, null, clipboard));
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

		// User wants to copy to the clipboard starting at & to #
		if (command.startsWith("c")) {
			// Format: c & #
			String[] data = command.split(" ");

			// Checking if command is input properly
			if (data[0].length() != 1) {
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

			if (!isNumeric(data[1]) || !isNumeric(data[2])) {
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

			clipboard = secretMessage.copyFromList(index1, index2);
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

		// Invalid command entered. Prompt user again.
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

	private String convertCommand(String command, Character deleted, 
			String clipboard) {
		String[] split = command.split(" ");
		
		if (split[0].equals("b")) {
			return "r " + split[2];
		}
		
		if (split[0].equals("r")) {
			return "b " + deleted + " " + split[1];
		}
		
		if (split[0].equals("x")) {
			return "p " + split[1] + "|" + clipboard;
		}

		if (split[0].equals("p")) {
			return "x " + split[1] + " " + (Integer.parseInt(split[1]) + 
					clipboard.length() - 1);
		}

		return null;
	}
	
	@Override
	/******************************************************************
	 * Sets the initial secret message entered by the user.
	 * @param message the initial message
	 *****************************************************************/
	public void setInitialMessage(String message) {
		int index = 0;
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

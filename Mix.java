package project4;

import java.io.*;
import java.util.*;

public class Mix implements iMix {
	
	/** Linked list of characters representing a message */
	private LinkedList<Character> secretMessage;
	
	public Mix() {
		secretMessage = new LinkedList<Character>();
	}

	@Override
	public String processCommand(String command) {
		if (!command.startsWith("b") || !command.startsWith("r") || !command.startsWith("w") || !command.startsWith("s")) {
			System.out.println("Invalid Command Entered!");
		}
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
	
	public static void main(String[] args) throws IOException {
		Mix m = new Mix();
		Scanner s = new Scanner(new InputStreamReader(System.in));
		System.out.println("Welcome to the secret message mixer!");
		System.out.println("");
		System.out.println("Please enter your message: ");
		String input = s.nextLine();
		m.setInitialMessage(input);
		System.out.println("");
		m.secretMessage.display();
		// System.out.println("You typed: " + input);
		s.close();
	}

}

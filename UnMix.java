package project4;

import java.io.*;
import java.util.*;

public class UnMix implements iUnMix {
	
	private Mix m = new Mix();
	
	@Override
	public String UnMixUsingFile(String filename, String userMessage) {
		// TODO Auto-generated method stub
		m.setInitialMessage(userMessage);
		return readFile(filename);
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
				m.processCommand(line);
			}
			
			// Close the buffer reader
			bufferReader.close();
			
			return m.display();
		}
		catch(Exception e) {
			System.out.println("Error while reading file line by line: " + e.getMessage());                      
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

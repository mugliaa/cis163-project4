package project4;

/**********************************************************************
 * Used to hold a message for encryption and decryption
 * @author Adam Muglia & Tyler Miller
 * @version 2-Dec-2015
 *********************************************************************/
public class LinkedList<E> {
	
	/** The top of the Linked List */
	private Node<E> top;
	
	/** The end of the Linked List */
	private Node<E> tail;

	/******************************************************************
	 * Constructor for Linked List. Instantiates the top and tail 
	 * pointers for future use.
	 *****************************************************************/
	public LinkedList() {
		top = null;
		tail = null;
	}

	/******************************************************************
	 * Adds a Node at the beginning of the Linked List.
	 * @param data the information being stored
	 *****************************************************************/
	public void addfirst (E data) {
		if (top == null) 
			// List is empty
			tail = top = new Node<E>(data, top);
		else
			// List is not empty
			top = new Node<E>(data, top);
	}

	/******************************************************************
	 * Adds a Node at the specified index, moving all other Nodes over
	 * to add to the List.
	 * @param index the position where the Node is being added
	 * @param charB4 data held within the Node
	 * @return true if added; false if not added
	 *****************************************************************/
	public boolean addBefore(int index, String charB4) {
		Node<E> temp = top;
		Node<E> temp1;
		Node<E> temp2;

		// check for empty list
		if (top == null) 
			return false;

		// check if top element is the target
		if (index == 0) {
			temp = top = new Node<E>((E) charB4, temp);

			if (top.getNext() == null)
				tail = null;
			return true;
		}
		// Top element is not the target
		else {
			int i = 0;
			for(i=1;i< index;i++)
			{
				temp = temp.getNext();
			}
			temp2 = temp.getNext();
			temp1 = new Node<E> ((E)charB4, temp2);
			temp.setNext(temp1); 
		}
		return false;
	}
	
	/******************************************************************
	 * Switches two Node positions at the specified indices.
	 * @param index1 the first index
	 * @param index2 the second index
	 * @return true if added; false if not added
	 *****************************************************************/
	public boolean switchData(int index1, int index2) {
		// check for empty list
		if (top == null) 
			return false;
		
		// Gathers data of the Nodes at specified positions
		E data1 = search(index1);
		E data2 = search(index2);
		
		// Swapping data in Nodes at specified positions
		int count = 0;
		Node<E> temp = top;
		while (count != index1) {
			temp = temp.getNext();
			count++;
		}
		temp.setData(data2);
		
		
		count = 0;
		temp = top;
		while (count != index2) {
			temp = temp.getNext();
			count++;
		}
		temp.setData(data1);
		return true;
	}
	
	/******************************************************************
	 * Helper method that returns the data held within a Node at the 
	 * specified index.
	 * @param index the position being searched
	 * @return data within Node at specified position
	 *****************************************************************/
	private E search(int index) {
		int c = 0;
		Node<E> temp = top;
		while (c != index) {
			temp = temp.getNext();
			c++;
		}
		return temp.getData();
	}
	
	/******************************************************************
	 * Provides functionality for the cut command. Returns the String
	 * representation of the data removed from the Linked List.
	 * @param index1 the first index
	 * @param index2 the second index
	 * @return String representation of data removed between indices.
	 *****************************************************************/
	public String cutFromList(int index1, int index2) {
		// check for empty list
		if (top == null) 
			return null;

		if (index2 < index1) {
			return null;
		}
		
		// Copies the data between the given indices
		String str = copyFromList(index1, index2);
		
		// Removes the Nodes between the given indices
		Node<E> temp = top;
		Node<E> next = top;
		int count = 0;
		while (count != index2 + 1) {
			next = next.getNext();
			count++;
		}

		if (index1 != 0) {
			count = 0;
			while (count != index1 - 1) {
				temp = temp.getNext(); // Problem
				count++;
			}
			temp.setNext(next);
		}
		else {
			top = next;
		}
		
		// String representation of data removed
		return str;
	}
	
	/******************************************************************
	 * Copies the data within the Nodes between the given indices 
	 * without removing them from the Linked List
	 * @param index1 the first index
	 * @param index2 the second index
	 * @return the data being copied
	 *****************************************************************/
	public String copyFromList(int index1, int index2) {
		// Holds data for the clipboard in Mix
		String copy = "";
		int temp = index1;
		while (temp != index2 + 1) {
			// Gathers data from each Node between the indices
			copy += search(temp);
			temp++;
		}
		return copy;
	}
	
	/******************************************************************
	 * Pastes the specified data starting at the given indices into the
	 * Linked List.
	 * @param index1 the starting index
	 * @param clipboard the data being pasted
	 * @return true if pasted; false if not pasted
	 *****************************************************************/
	public boolean pasteFromList(int index1, String clipboard) {
		Node<E> temp = top;
		Node<E> temp1;
		// Puts the clipboard data into a temporary variable
		String paste = clipboard;
		// String testString = "This Is Test";
		char[] CharArray = paste.toCharArray();
 
		if (temp == null)
			return false;
		
		// Creates as many Nodes as required for the clipboard and adds
		int count = 0;
		int i = 0;
		if (index1 == 0) {
			temp = new Node(CharArray[0], null);
			temp.next = top;
			top = temp;

			for (i = 1; i < CharArray.length; i++) {
				temp1 = new Node(( CharArray[i]), temp.getNext());
				temp.next = temp1;
				temp = temp1;
			}
		} else {
			count = 0;
			while (count != index1 - 1) {
				temp = temp.getNext();
				count++;
			}

			temp1 = temp;

			for (i = 0; i < CharArray.length; i++) {
				temp1 = new Node( CharArray[i], temp.getNext());
				temp.next = temp1;
				temp = temp1;
			}
		}
		return true;

	}

	/******************************************************************
	 * Displays the Linked List with characters being matched to 
	 * indices.
	 *****************************************************************/
	public void display() {
		Node<E> temp = top;
		
		// Prints the indices
		int counter = 0;
		while (counter != count()) {
			System.out.print(counter + " ");
			counter ++;
		}
		System.out.println("");
		
		// Prints the data in each Node on a new line
		int count = 0;
		while (temp != null) {
			// System.out.print(counter + " ");
			
			// For spacing purposes...
			if (count >= 9) {
				if (count >= 99) {
					System.out.print (temp.getData() + "   ");
					temp = temp.getNext();
				}
				else {
					System.out.print (temp.getData() + "  ");
					temp = temp.getNext();
				}
			}
			else {
				System.out.print (temp.getData() + " ");
				temp = temp.getNext();
			}
			count ++;
			
		}
	}
	
	/******************************************************************
	 * Displays the String representation of the Linked List.
	 * @return the Linked List in standard String format
	 *****************************************************************/
	public String displayMessage() {
		Node<E> temp = top;
		
		// Gets the data from each node and saves into a String
		String display = "";
		while (temp != null) {
			// System.out.print(counter + " ");
					display += temp.getData();
					temp = temp.getNext();
		}
		
		// The final message
		return display;
	}

	/******************************************************************
	 * Returns the number of Nodes in the Linked List
	 * @return number of Nodes (data)
	 *****************************************************************/
	public int count() {
		int count = 0;

		// Counts how many Nodes
		Node<E> temp = top;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		
		return count;
	}

	/******************************************************************
	 * Adds a Node to the end of the Linked List.
	 * @param data the information to be held by the new Node
	 *****************************************************************/
	public void addAtEnd (E data) {
		// Checks if there is a list
		if (top == null) 
			tail = top = new Node<E> (data, top);

		// Adds to the end
		else {
			tail.setNext(new Node<E>(data, null));
			tail = tail.getNext();
		}
	} 

	/******************************************************************
	 * Deletes a Node from the Linked List via searching by data.
	 * @param data the data being queried for
	 * @return true if deleted; false if not deleted/found
	 *****************************************************************/
	public boolean delete (E data) {
		// Check for empty list
		if (top == null) 
			return false;

		// Check if top element is the target
		if (top.getData().equals(data)) {
			top = top.getNext();
			if (top.getNext() == null)
				tail = null;
			return true;
		}

		// Deletes the relevant Node
		Node<E> temp = top;
		while (temp.getNext() != null) {
			if (temp.getNext().getData().equals(data)) {
				temp.setNext(temp.getNext().getNext());
				if (temp.getNext() == null)
					tail = temp;
				return true;
			}
			temp = temp.getNext();		
		}

		return false;
	}

	/******************************************************************
	 * Deletes a Node from the Linked List via searching by index.
	 * @param index the index of the Node being deleted
	 * @return the data deleted
	 *****************************************************************/
	public E delete (int index) {
		// Check for empty list
		if (top == null) 
			return null;

		// Check if top element is the target
		if (index == 0) {
			E data = top.getData();
			top = top.getNext();
			if (top.getNext() == null)
				tail = null;
			return data;
		}

		// Deletes the relevant Node
		Node<E> temp = top;
		int i = 0;
		while (temp.getNext() != null) {
			if ((i + 1) == index) {
				E data = temp.getNext().getData();
				temp.setNext(temp.getNext().getNext());
				if (temp.getNext() == null)
					tail = temp;		
				return data;
			}
			temp = temp.getNext();	
			i ++;
		}

		return null;
	}
}

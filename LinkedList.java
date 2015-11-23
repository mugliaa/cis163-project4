package project4;


public class LinkedList<E> {
	private Node<E> top;
	private Node<E> tail;

	public LinkedList() {
		top = null;
		tail = null;
	}

	public void addfirst (E data) {
		if (top == null) 
			tail = top = new Node<E>(data, top);
		else
			top = new Node<E>(data, top);
	}


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
	
	public boolean switchData(int index1, int index2) {
		// check for empty list
		if (top == null) 
			return false;
		
		E data1 = search(index1);
		E data2 = search(index2);
		
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
	
	private E search(int index) {
		int c = 0;
		Node<E> temp = top;
		while (c != index) {
			temp = temp.getNext();
			c++;
		}
		return temp.getData();
	}
	
	public String cutFromList(int index1, int index2) {
		// check for empty list
		if (top == null) 
			return null;

		if (index2 < index1) {
			return null;
		}
		
		String str = copyFromList(index1, index2);
		
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
		return str;
	}
	
	public String copyFromList(int index1, int index2) {
		String copy = "";
		int temp = index1;
		while (temp != index2 + 1) {
			copy += search(temp);
			temp++;
		}
		return copy;
	}

	public void display() {
		Node<E> temp = top;
		int counter = 0;
		while (counter != count()) {
			System.out.print(counter + " ");
			counter ++;
		}
		System.out.println("");
		int count = 0;
		while (temp != null) {
			// System.out.print(counter + " ");
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

	public int count() {
		int count = 0;

		Node<E> temp = top;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public void addAtEnd (E data) {
		if (top == null) 
			tail = top = new Node<E> (data, top);

		else {
			tail.setNext(new Node<E>(data, null));
			tail = tail.getNext();
		}
	} 

	public boolean delete (E data) {
		// check for empty list
		if (top == null) 
			return false;

		// check if top element is the target
		if (top.getData().equals(data)) {
			top = top.getNext();
			if (top.getNext() == null)
				tail = null;
			return true;
		}

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

	public boolean delete (int index) {
		// check for empty list
		if (top == null) 
			return false;

		// check if top element is the target
		if (index == 0) {
			top = top.getNext();
			if (top.getNext() == null)
				tail = null;
			return true;
		}

		Node<E> temp = top;
		int i = 0;
		while (temp.getNext() != null) {
			if ((i + 1) == index) {
				temp.setNext(temp.getNext().getNext());
				if (temp.getNext() == null)
					tail = temp;
				return true;
			}
			temp = temp.getNext();	
			i ++;
		}

		return false;
	}

	public void deleteHalfWay() {


	}


	public static void main (String[] args){
		//		LinkedList<Character> list = new 
		//				LinkedList<String>();
		//
		//		list.addAtEnd("pizza1");
		//		list.addfirst("pizza2");
		//		list.addfirst("pizza3");
		//		list.addfirst("pizza4");
		//		list.addAtEnd("pizza5");
		//
		//		list.display();
		//
		//		list.delete("pizza1");
		//		list.display();
		//
		//		list.delete("pizza2");
		//		list.display();
		//
		//
		//				list.addAtEnd("pizza11");
		//
		//				list.addfirst("pizza3");
		//				list.addfirst("pizza4");
		//				list.addfirst("pizza5");
		//				list.addfirst("pizza6");
		//				list.addfirst("pizza7");
		//				list.addfirst("pizza8");
		//				list.addAtEnd("pizza9");
		//
		//		list.display();

	}

}

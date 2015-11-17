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

	public void display() {
		Node<E> temp = top;
		System.out.println ("-----------------");
		int counter = 0;
		while (counter != count()) {
			System.out.print(counter + " ");
			counter ++;
		}
		System.out.println("");
		while (temp != null) {
			// System.out.print(counter + " ");
			System.out.print (temp.getData() + " ");
			temp = temp.getNext();
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

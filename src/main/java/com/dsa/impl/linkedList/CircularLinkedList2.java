package com.dsa.impl.linkedList;


public class CircularLinkedList2<T> {
	public Node<T> head;

	public CircularLinkedList2() {
		head = null;
	}

	// Method to check if the list is empty
	public boolean isEmpty() {
		return head == null;
	}

	// Method to insert a node at the beginning of the list
	public void insertAtBeginning(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			head = newNode;
			head.next = head; // Point to itself in a circular manner
		} else {
			Node<T> temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	// Method to insert a node at the end of the list
	public void insertAtEnd(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			head = newNode;
			head.next = head; // Point to itself in a circular manner
		} else {
			Node<T> temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = head;
		}
	}

	// Method to display the contents of the list
	public String toString() {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head.data + "-->NULL";
		}

		String res = head.data + "-->";

		Node<T> temp = head.next;
		while (temp != null && !temp.equals(head)) {
			res = res + temp.data + "-->";
			temp = temp.next;
		}

		return res;
	}



	public static void main(String[] args) {

		CircularLinkedList2<Integer> cll = new CircularLinkedList2<>();
		cll.insertAtBeginning(10);
		System.out.println("=========main head=========");
		System.out.println(cll.toString());
		System.out.println("==================");

		cll.insertAtBeginning(60);
		System.out.println("=========main head=========");
		System.out.println(cll.toString());
		System.out.println("==================");

		cll.insertAtBeginning(70);
		System.out.println("=========main head=========");
		System.out.println(cll.toString());
		System.out.println("==================");

		cll.insertAtEnd(20);
		System.out.println("=========main tail=========");
		System.out.println(cll.toString());
		System.out.println("==================");

		cll.insertAtBeginning(30);
		System.out.println("=========main head=========");
		System.out.println(cll.toString());
		System.out.println("==================");

		cll.insertAtEnd(40);
		System.out.println("=========main tail=========");
		System.out.println(cll.toString());
		System.out.println("==================");

	}
}

package com.dsa.impl.linkedList;

public class DoublyLinkedList<T> {

	public static void main(String[] args) {

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.insertAtFront(10);
		System.out.println(dll.toString());
		dll.insert(20, 1);
		System.out.println(dll.toString());
		dll.insertTail(50);
		System.out.println(dll.toString());
		
		dll.remove(2);
		System.out.println(dll.toString());
		
		dll.insertTail(40);
		System.out.println(dll.toString());
		
		dll.removeMatched(dll.head.getNext());
		System.out.println(dll.toString());
		
	}
	
	private DLLNode<T> head;
	private DLLNode<T> tail;
	private int length;
	public DoublyLinkedList() {
		this.head = new DLLNode<T>(null,null,null);
		this.tail = new DLLNode<T>(null, this.tail, null);
		this.head.setNext(this.tail);
		this.length = 0;
	}
	
	public int getPosition(T data) {
		DLLNode<T> temp = head;
		int pos = 0;
		while(temp != null) {
			if(temp.getData().equals(data)) {
				return pos;
			}
			pos++;
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}
	
	public int getLength() {
		return length;
	}
	
	
	public void insertAtFront(T data) {
		if(head == null) {
			DLLNode<T> newNode = new DLLNode<T>(data, null, null);
			head = newNode;
			tail = newNode;
		}
		DLLNode<T> newNode = new DLLNode<T>(data, null, head.getPre());
		head.setPre(newNode);
		head = newNode;
		length++;
	}

	
	public void insert(T data, int pos) {
		DLLNode<T> newNode = new DLLNode<T>(data, null, null);
		if(pos < 0)
			pos = 0;
		
		if(pos > length)
			pos = length;
		
		
		
		if(pos == length) {
			DLLNode<T> temp = head;
			temp.setNext(newNode);
			newNode.setPre(head);
			
			if(length == 1 ) {
				tail = newNode;
				tail.setPre(head);
				return;
			}
			return;
		}
			
		if(head == null) {
			head = newNode;
			tail = head;
		}
		
		else if(pos == 0) {
			head.setPre(newNode);
			head = newNode;
			return;
		}
		
		else {
			DLLNode<T> temp = head;
			for(int i = 0 ; i < pos;i++) {
				temp = temp.getNext();
			}
			temp.setPre(newNode);
			newNode.setNext(temp);
		}
		length++;
	}
	
	public void insertTail(T data) {
		if(head == null)
			return;
		
		DLLNode<T> newNode = new DLLNode<T>(data, null, tail);
		tail.setNext(newNode);
		tail = newNode;
		length++;
		
	}
	
	public synchronized void remove(int pos) {
		
		if(head == null)
			return;
		
		if(pos > length) {
			pos = length;
		}
		
		if(pos == 0) {
			head = head.getNext();
		}
		else {
			DLLNode<T> tempNode = head;
			for(int i=0 ;i!=length;i++ ) {
				tempNode = tempNode.getNext();
			}
			DLLNode<T> preNode = tempNode.getPre();
			DLLNode<T> nextNode = tempNode.getNext();

			preNode.setNext(nextNode);
			if(nextNode != null)
				nextNode.setPre(preNode);
		}
		length--;
	}
	
	public synchronized void removeMatched(DLLNode<T> node) {
		
		if(head == null)
			return;
		if(head.equals(node)) {
			head = head.getNext();
			if(head == null)
				tail =null;
			length--;
			return;
		}
		DLLNode<T> p = head;
		while(p!=null) {
			if(node.equals(p)) {
				if(p.getNext() != null)
					p.getNext().setPre(p.getPre());
				p.getPre().setNext(p.getNext());
				return;
			}
			p = p.getNext();
		}
		length--;
		
	}
	
	public synchronized void removeHead() {
		if(head == null)
			return;
		
		head = head.getNext();
		if(head == null)
			tail = null;
		length--;
		
		
		
	}
	
	public String toString() {
		String dll = "";
		DLLNode<T> temp = head;
		dll = dll + "-->" + temp.getData();
		temp = temp.getNext();
		while( temp != null) {
			dll = dll + "-->" + temp.getData();
			temp = temp.getNext();
		}
		return dll;
	}
}

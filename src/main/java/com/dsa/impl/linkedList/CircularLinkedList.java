package com.dsa.impl.linkedList;

public class CircularLinkedList<T> {

	protected CLLNode<T> tail;
	protected int length;
	
	public CircularLinkedList() {
		tail = null;
		length = 0;
	}
	
	public void addToHead(T data) {
		CLLNode<T> newNode = new CLLNode<T>(data);
		
		if(tail == null) {
			tail = newNode;
			tail.setNext(tail);
		}
		else if(tail.equals(tail.getNext())) {
			tail.setNext(newNode);
			newNode.setNext(tail);
		}
		else {
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
			System.out.println("=========start=========");
			if(tail == null) {
				return;
			}
			if(tail.getNext() == null) {
				System.out.println(tail.getData() + "-->NULL") ;
			}
			
			String result = tail.getData()+"-->";
			
			CLLNode<T> temp = tail.getNext();
			while(!temp.equals(tail)) {
				result = result + temp.getData() + "-->";
				temp = temp.getNext();
			}
			
			System.out.println(result);
			System.out.println("=========End=========");
		}
		length++;
		
	}
	
	public void addToTail(T data) {
		addToHead(data);
		tail = tail.getNext();
	}
	
	public T peek() {
		return tail.getNext().getData();
	}
	
	public T tailPeek() {
		return tail.getData();
	}
	
	public T removeFromHead() {
		CLLNode<T> temp = tail.getNext();
		if(tail == tail.getNext())
			tail = null;
		else {
			tail.setNext(temp.getNext());
			temp.setNext(null); //helps clean things up; temp is free
		}
		length--;
		return temp.getData();
	}
	
	public void removeTail() {
		if(tail == null)
			return;
		
		CLLNode<T> temp = tail;
		
		while(!tail.equals(temp.getNext())) {
			temp = temp.getNext();
		}
		
		temp.setNext(tail.getNext());
		tail.setNext(null);
		tail = temp.getNext();
		return;
	}
	
	public String toString() {
		if(tail == null) {
			return null;
		}
		if(tail.getNext() == null) {
			return tail.getData() + "-->NULL" ;
		}
		
		String result = tail.getData()+"-->";
		
		CLLNode<T> temp = tail.getNext();
		while(!temp.equals(tail)) {
			result = result + temp.getData() + "-->";
			temp = temp.getNext();
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {

		CircularLinkedList<Integer> cll = new CircularLinkedList<>();
		cll.addToHead(10);
		System.out.println("=========main head=========");
		System.out.println(cll.toString());
		System.out.println("==================");
		
		cll.addToHead(60);
		System.out.println("=========main head=========");
		System.out.println(cll.toString());
		System.out.println("==================");
		
		cll.addToHead(70);
		System.out.println("=========main head=========");
		System.out.println(cll.toString());
		System.out.println("==================");
		
		cll.addToTail(20);
		System.out.println("=========main tail=========");
		System.out.println(cll.toString());
		System.out.println("==================");
		
		cll.addToHead(30);
		System.out.println("=========main head=========");
		System.out.println(cll.toString());
		System.out.println("==================");
		
		cll.addToTail(40);
		System.out.println("=========main tail=========");
		System.out.println(cll.toString());
		System.out.println("==================");
		
	}
	
	

}

package com.dsa.problems.Narasimha.LinkedList;

import com.dsa.impl.linkedList.LinkedList;
import com.dsa.impl.linkedList.SinglyListNode;

public class NK_P7_IsNULLTerminatedLL<T> {

	//Cannot be solved
	public  void IsNULLTerminatedLL(LinkedList<T> ll){
		
		if(ll.getHead() == null) {
			System.out.println("Linked List is Empty");
			return;
		}
		
		
		SinglyListNode<T> stillNode = ll.getHead(), movingNode = ll.getHead().getNext();
		
		if(movingNode == null) {
			System.out.println("Is Null terminated");
			return;
		}
		
		while(!movingNode.equals(stillNode)) {
			
			movingNode = movingNode.getNext();
			if(movingNode == null) {
				System.out.println("Is Null terminated");
				return;
			}
			
		}
		if(!movingNode.equals(stillNode))
			System.out.println("Is Cyclic");
			return;
		
	}
	

	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<>();
		
		ll.insertAtBegin(10);
		ll.insertAtBegin(20);
		ll.insertAtBegin(50);
		ll.insertAtBegin(30);
		ll.insertAtBegin(40);
		ll.insertAtBegin(60);
		
		ll.getHead().getNext().getNext().getNext().setNext(ll.getHead().getNext());
		
		NK_P7_IsNULLTerminatedLL<Integer> checkClass = new NK_P7_IsNULLTerminatedLL<>();
		
		checkClass.IsNULLTerminatedLL(ll);
		
		
	}

}

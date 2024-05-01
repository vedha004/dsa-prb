package com.dsa.problems.Narasimha.LinkedList;

import java.util.HashMap;
import java.util.Map;

import com.dsa.impl.linkedList.LinkedList;
import com.dsa.impl.linkedList.SinglyListNode;

public class NK_P10_FloydAlgorithm<T> {

	//Cannot be solved
	public  void IsCyclic(LinkedList<T> ll){
		
		SinglyListNode<T> slowPtr = ll.getHead(),fastPtr = ll.getHead().getNext();
		if(slowPtr == fastPtr) {
			System.out.println("Is cyclic");
			return;
		}
		slowPtr = slowPtr.getNext();
		fastPtr = fastPtr.getNext();
		while(!slowPtr.equals(fastPtr)) {
			if(fastPtr == null) {
				System.out.println("Is Not cyclic");
				return;
			}
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if(slowPtr == fastPtr) {
				System.out.println("Is cyclic");
				return;
			}
				
		}
		
		
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
		
		NK_P10_FloydAlgorithm<Integer> checkClass = new NK_P10_FloydAlgorithm<>();
		
		checkClass.IsCyclic(ll);
		
		
	}

}

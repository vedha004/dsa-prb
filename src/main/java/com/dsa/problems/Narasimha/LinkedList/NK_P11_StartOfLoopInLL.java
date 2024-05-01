package com.dsa.problems.Narasimha.LinkedList;


import com.dsa.impl.linkedList.LinkedList;
import com.dsa.impl.linkedList.SinglyListNode;

/*After finding the loop in the linked list
 * 1. we initialize the slowPtr to the head of the linked list.
 * 2. From that point onwards both slowPtr and fastPtr move only one node at a time. 
 * 3. The point at which they meet is the start of the loop.
 * 
 *  Generally we use this method for removing the loops.
 *   Let x and y be travelers such that y is walking twice as fast as x (i.e. y = 2x). 
 *   Further, let s be the place where x and y first started walking at the same time. 
 *   Then when x and y meet again, the distance from s to the start of the
 *   loop is the exact same distance from the present meeting place of x and y to the start of the loop
*/

public class NK_P11_StartOfLoopInLL<T> {

	public  SinglyListNode<T> findLoopStart(LinkedList<T> ll){
		
		Boolean loopExists = false;
		
		SinglyListNode<T> slowPtr = ll.getHead(),fastPtr = ll.getHead().getNext();
		if(slowPtr == fastPtr) {
			System.out.println("Is cyclic");
			loopExists = true;
		}
		slowPtr = slowPtr.getNext();
		fastPtr = fastPtr.getNext();
		while(!slowPtr.equals(fastPtr)) {
			if(fastPtr == null) {
				System.out.println("Is Not cyclic");
				loopExists = false;
			}
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if(slowPtr == fastPtr) {
				System.out.println("Is cyclic");
				loopExists = true;
			}
				
		}
		
		if(loopExists) {
			slowPtr = ll.getHead();
			while(slowPtr != fastPtr) {
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext();
			}
			return fastPtr;
		}
		else {
			return null;
		}
		
	}
	
public  SinglyListNode<T> mysolution_findLoopStart(LinkedList<T> ll){
		
		Boolean loopExists = false;
		
		SinglyListNode<T> slowPtr = ll.getHead(),fastPtr = ll.getHead().getNext();
		if(slowPtr == fastPtr) {
			System.out.println("Is cyclic");
			loopExists = true;
		}
		slowPtr = slowPtr.getNext();
		fastPtr = fastPtr.getNext();
		while(!slowPtr.equals(fastPtr)) {
			if(fastPtr == null) {
				System.out.println("Is Not cyclic");
				loopExists = false;
			}
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if(slowPtr == fastPtr) {
				System.out.println("Is cyclic");
				loopExists = true;
			}
				
		}
		
		if(loopExists) {
			slowPtr = ll.getHead();
			while(slowPtr != fastPtr) {
				slowPtr = slowPtr.getNext();
			}
			return fastPtr;
		}
		else {
			return null;
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
		System.out.println(ll.toString());
		ll.getHead().getNext().getNext().getNext().setNext(ll.getHead().getNext());
		
		NK_P11_StartOfLoopInLL<Integer> checkClass = new NK_P11_StartOfLoopInLL<>();
		
		System.out.println(checkClass.findLoopStart(ll).getData());

		System.out.println(checkClass.mysolution_findLoopStart(ll).getData());
		
		
		
	}

}

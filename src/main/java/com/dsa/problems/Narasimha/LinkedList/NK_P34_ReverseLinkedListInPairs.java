package com.dsa.problems.Narasimha.LinkedList;

import com.dsa.impl.linkedList.LinkedList;
import com.dsa.impl.linkedList.SinglyListNode;

public class NK_P34_ReverseLinkedListInPairs<T> {

	public void reverseListInPairs(LinkedList<T> ll) {

		SinglyListNode<T> pairNode1 = ll.getHead();
		SinglyListNode<T> pairNode2 = ll.getHead().getNext();
		SinglyListNode<T> tempNext = pairNode2.getNext();
		SinglyListNode<T> tempprev = null;
		ll.head = pairNode2;
		while (pairNode1 != null && pairNode2 != null) {
			pairNode2.setNext(pairNode1);
			pairNode1.setNext(tempNext);
			
			if(tempprev == null)
				ll.head = pairNode2;
			else
				tempprev.setNext(pairNode2);
			
			tempprev = pairNode1;
			pairNode1 = tempNext;
			if(tempNext != null)
				pairNode2 = tempNext.getNext();
			tempNext = pairNode2.getNext();
			
		}

		System.out.println( ll.toString());
	}
	
	public SinglyListNode<T> reverseListInPairs_recursive(SinglyListNode<T> head) {

		if(head == null || head.getNext() == null)
			return head;
		else {
				System.out.println(head.getData());
				SinglyListNode<T> temp = head.getNext();
				head.setNext(temp.getNext());
				temp.setNext(head);
				head = temp;
				head.getNext().setNext(reverseListInPairs_recursive(head.getNext().getNext())); 
				return head;
		}
		
	}
	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<>();

		ll.insertAtBegin(10);
		ll.insertAtBegin(20);
		ll.insertAtBegin(30);
		ll.insertAtBegin(40);
		ll.insertAtBegin(50);
		ll.insertAtBegin(60);
		System.out.println(ll.toString());
		NK_P34_ReverseLinkedListInPairs<Integer> prb32 = new NK_P34_ReverseLinkedListInPairs<>();
		//prb32.reverseListInPairs(ll);
		ll.head =   prb32.reverseListInPairs_recursive(ll.head);
		System.out.println(ll.toString());

	}

}

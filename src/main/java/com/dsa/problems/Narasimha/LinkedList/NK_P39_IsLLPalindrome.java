package com.dsa.problems.Narasimha.LinkedList;

import com.dsa.impl.linkedList.LinkedList;
import com.dsa.impl.linkedList.SinglyListNode;

public class NK_P39_IsLLPalindrome {

	
	SinglyListNode<Character> isLLPalindrome(SinglyListNode<Character> head,SinglyListNode<Character> next) {
		
			
			if(head.next == null) {
				return null;
			}
			
			head =  isLLPalindrome(head,head.next);
			 if(head.next == null) {
					return null;
				}
			 return null;
		
		
	}
	

	public static void main(String[] args) {

		LinkedList<Character> ll = new LinkedList<>();
		
		ll.insertAtBegin('M');
		ll.insertAtBegin('E');
		ll.insertAtBegin('M');
		ll.insertAtBegin('E');
		
		ll.getHead().getNext().getNext().getNext().setNext(ll.getHead().getNext());
		
		NK_P39_IsLLPalindrome checkClass = new NK_P39_IsLLPalindrome();
		
//		checkClass.IsNULLTerminatedLL(ll);
		
		
	}

}

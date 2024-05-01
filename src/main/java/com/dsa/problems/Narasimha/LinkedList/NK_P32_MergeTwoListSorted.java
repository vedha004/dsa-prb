package com.dsa.problems.Narasimha.LinkedList;

import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.Comparator;

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

public class NK_P32_MergeTwoListSorted {

	public SinglyListNode<Integer> mergeTwoList(SinglyListNode<Integer> headNode1, SinglyListNode<Integer> headNode2) {
		if (headNode1 == null) {
			return headNode2;
		}
		if (headNode2 == null) {
			return headNode1;
		}
		
		System.out.println("================================================" );
		System.out.println("headNode1 -->" + headNode1.getData());
		System.out.println("headNode2 -->" + headNode2.getData());
		
		
		SinglyListNode<Integer> headNode = new SinglyListNode<Integer>(0);
		if (headNode1.getData() <= headNode2.getData()) {
			headNode = headNode1;
			System.out.println("headList -->" + dispalyList(headNode));
			System.out.println("headList1 -->" + dispalyList(headNode1));
			System.out.println("headList2 -->" + dispalyList(headNode2));
			headNode.setNext(mergeTwoList(headNode1.getNext(), headNode2));
			
			System.out.println("================================================" );
			
		} else {
			headNode = headNode2;
			System.out.println("headList -->" + dispalyList(headNode));
			System.out.println("headList1 -->" + dispalyList(headNode1));
			System.out.println("headList2 -->" + dispalyList(headNode2));
			headNode.setNext(mergeTwoList(headNode2.getNext(), headNode1));
			
			System.out.println("================================================" );
		}
		return headNode;
	}

	public SinglyListNode<Integer> mergeTwoListIterative(SinglyListNode<Integer> headNode1,
			SinglyListNode<Integer> headNode2) {

		if (headNode1 == null) {
			return headNode2;
		}
		if (headNode2 == null) {
			return headNode1;
		}

		SinglyListNode<Integer> headNode = new SinglyListNode<Integer>(0);
		while (headNode1 != null && headNode2 != null) {
			if (headNode1.data < headNode2.data) {
				headNode = headNode1;
			}
		}

		return headNode;
	}
	
	public String dispalyList(SinglyListNode<Integer> head) {
		SinglyListNode<Integer> p = head;
		String list = "";
//		 list = list + head.getData();

		while (p != null) {
			list = list + "-->" + p.getData();
			p = p.getNext();
		}
		return list;
	}

	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<>();

		ll.insertAtBegin(10);
		ll.insertAtBegin(20);
		ll.insertAtBegin(50);
		ll.insertAtBegin(30);
		ll.insertAtBegin(40);
		ll.insertAtBegin(60);

		LinkedList<Integer> ll2 = new LinkedList<>();

		ll2.insertAtBegin(9);
		ll2.insertAtBegin(12);
		ll2.insertAtBegin(45);
		ll2.insertAtBegin(35);
		ll2.insertAtBegin(25);
		System.out.println("ll1 : "+ll.toString());
		System.out.println("ll1 : "+ll2.toString());

		NK_P32_MergeTwoListSorted checkClass = new NK_P32_MergeTwoListSorted();

		SinglyListNode<Integer> headNode = checkClass.mergeTwoList(ll2.getHead(), ll.getHead());

		LinkedList<Integer> ll3 = new LinkedList<>();

		ll3.head = headNode;
		System.out.println(ll3.toString());
	}

}

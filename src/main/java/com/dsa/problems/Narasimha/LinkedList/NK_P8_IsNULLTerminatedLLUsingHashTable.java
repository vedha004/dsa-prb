package com.dsa.problems.Narasimha.LinkedList;

import java.util.HashMap;
import java.util.Map;

import com.dsa.impl.linkedList.LinkedList;
import com.dsa.impl.linkedList.SinglyListNode;

public class NK_P8_IsNULLTerminatedLLUsingHashTable<T> {

	//Cannot be solved
	public  void IsNULLTerminatedLL(LinkedList<T> ll){
		
		if(ll.getHead() == null) {
			System.out.println("List is empty");
			return;
		}
		Map<Integer,T> hashMap = new HashMap<>();
		SinglyListNode<T> node = ll.getHead();
		while(node != null) {
			if(hashMap.containsKey(node.hashCode())) {
				System.out.println("Is cyclic");
				return;
			}
			hashMap.put(node.hashCode(), node.getData());
			node = node.getNext();
		}
		System.out.println("Is NULL teminated");
		
	}
	

	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<>();
		
		ll.insertAtBegin(10);
		ll.insertAtBegin(20);
		ll.insertAtBegin(50);
		ll.insertAtBegin(30);
		ll.insertAtBegin(40);
		ll.insertAtBegin(60);
		
//		ll.getHead().getNext().getNext().getNext().setNext(ll.getHead().getNext());
		
		NK_P8_IsNULLTerminatedLLUsingHashTable<Integer> checkClass = new NK_P8_IsNULLTerminatedLLUsingHashTable<>();
		
		checkClass.IsNULLTerminatedLL(ll);
		
		
	}

}

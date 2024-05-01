package com.dsa.impl.linkedList;


public class LinkedList<T> {
	int length = 0;
	public SinglyListNode<T> head;

	public LinkedList() {
		length = 0;
	}

	public synchronized SinglyListNode<T> getHead() {
		return head;
	}

	public synchronized void insertAtBegin(T data) {
		SinglyListNode<T> temp = new SinglyListNode<T>(data);
		temp.setNext(head);
		head = temp;
		length++;
	}

	public synchronized void insertAtEnd(T data) {
		SinglyListNode<T> temp = new SinglyListNode<T>(data);
		if (head == null)
			head = temp;
		else {
			SinglyListNode<T> p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(temp);
		}
		length++;
	}

	public synchronized void insert(T data, int position) {
		// correct the position
		if (position < 0) {
			position = 0;
		}
		if (position > length)
			position = length;
		// if
		if (head == null) {
			head = new SinglyListNode<T>(data);
		} else if (position == 0) {
			SinglyListNode<T> temp = new SinglyListNode<T>(data);
			temp.setNext(head);
			head = temp;
		} else {
			SinglyListNode<T> temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.getNext();
			}
			SinglyListNode<T> newNode = new SinglyListNode<T>(data);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		length++;
	}

	public synchronized SinglyListNode<T> removeFromBegin() {
		SinglyListNode<T> node = head;
		if (node != null) {
			head = node.getNext();
			length--;
		}
		return node;
	}

	public synchronized SinglyListNode<T> removeFromEnd() {
		if (head == null)
			return null;
		SinglyListNode<T> p = head, q = head.getNext();
		while (q.getNext() != null) {
			q = q.getNext();
			p = p.getNext();
		}
		p.setNext(null);
		length--;
		return p;
	}

	public synchronized SinglyListNode<T> removeMatched(SinglyListNode<T> node) {
		if (head == null)
			return null;
		if (head.equals(node)) {
			SinglyListNode<T> nodeFound = head;
			head = head.getNext();
			length--;
			return nodeFound;
		}
		SinglyListNode<T> p = head, q = head.getNext();
		while (q.getNext() != null) {
			if (q.equals(node)) {
				p.setNext(q.getNext());
				length--;
				return q;
			}
			q = q.getNext();
			p = p.getNext();
		}
		return null;
	}

	public synchronized void removeFromPos(int pos) {
		if (pos == 0) {
			head.setNext(head.getNext());
			length--;
		}

		if (pos > length)
			pos = length;

		SinglyListNode<T> p = head, q = head.getNext();

		for (int i = 0; i < length; i++) {
			if (pos-1 == i) {
				p.setNext(q.getNext());
				length--;
			}
			p = p.getNext();
			q = q.getNext();
		}

	}
	
	
	public void reverseLL(SinglyListNode<T> sllNode,SinglyListNode<T> nextNode,	LinkedList<T> ll) {
		if(ll.head == null) {
			return;
		}
		
		
		if(sllNode != null) {
			if(sllNode.getNext() == null) {
				ll.head = sllNode;
			}
			reverseLL(sllNode.getNext(),sllNode,ll);
			sllNode.setNext(nextNode);
			
		}
		
		
	}
	
	public void tousif_reverseLL(SinglyListNode<T> curNode,SinglyListNode<T> prevNode) {
		
		if(curNode.getNext() == null) {
			head = curNode;
			curNode.setNext(prevNode); 
			return;
		}
		SinglyListNode<T> tempNode = curNode.getNext();
		curNode.setNext(prevNode);
		tousif_reverseLL(tempNode,curNode);
		
		
	}

	public void reverseInterativeLL(LinkedList<T> ll) {
		if(ll.head == null) {
			return;
		}
		
		SinglyListNode<T> curNode = ll.head,nextNode = ll.head.getNext() ;
		SinglyListNode<T> preNode=null,tempNode = null;
		for(int i=0 ; i< length  ; i++) {
			if(curNode == null||nextNode == null )
				return;
			
			curNode.setNext(preNode);
			tempNode = nextNode.getNext();
			nextNode.setNext(curNode);
			
			preNode = curNode;
			curNode = nextNode;
			nextNode = tempNode;
			ll.head = curNode;
			
		}
		
	}
	
	@Override
	public String toString() {
		SinglyListNode<T> p = head;
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
		ll.insert(5, 0);
		System.out.println(ll.toString());
		ll.insertAtBegin(10);
		System.out.println(ll.toString());

		ll.insertAtEnd(40);
		System.out.println(ll.toString());
		ll.insertAtEnd(45);
		System.out.println(ll.toString());

//		ll.removeFromEnd();
//		System.out.println(ll.toString());
//		
//		ll.removeFromBegin();
//		System.out.println(ll.toString());

//		ll.removeMatched(ll.head.getNext().getNext());
//		System.out.println(ll.toString());
		
		ll.removeFromPos(2);
		System.out.println(ll.toString());
		
//		ll.reverseLL(ll.getHead(),null,ll);
//		System.out.println(ll.toString());
//		
//		ll.reverseInterativeLL(ll);
//		System.out.println(ll.toString());
//		
		ll.tousif_reverseLL(ll.head,null);
		System.out.println(ll.toString());
	}

}

package com.dsa.impl.linkedList;

public class SinglyListNode<T> {

	public T data;
	public SinglyListNode<T> next;

	public SinglyListNode(T data) {
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public void setNext(SinglyListNode<T> next) {
		this.next = next;
	}

	public SinglyListNode<T> getNext() {
		return this.next;
	}
}

package com.dsa.impl.linkedList;

public class DLLNode<T> {
	
	private T data;
	private DLLNode<T> next;
	private DLLNode<T> pre;
	public DLLNode(T data, DLLNode<T> next, DLLNode<T> prev) {
		this.data = data;
		this.next = next;
		this.pre = prev;
	}
	
	public void setData( T data) {
		this.data = data;
		
	}

	public T  getData() {
		return this.data;
	}
	
	public void setNext(DLLNode<T> next) {
		this.next = next;
	}
	
	public DLLNode<T> getNext() {
		return this.next;
	}
	
	public void setPre(DLLNode<T> pre) {
		this.pre = pre;
	}
	
	public DLLNode<T> getPre() {
		return this.pre;
	}
}

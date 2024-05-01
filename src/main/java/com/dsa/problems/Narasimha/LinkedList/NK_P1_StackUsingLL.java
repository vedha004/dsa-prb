package com.dsa.problems.Narasimha.LinkedList;

import com.dsa.impl.linkedList.Node;

public class NK_P1_StackUsingLL<T> {

	Node<T> top;

	public Boolean isEmpty() {
		return top == null;
	}

	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		} else {
			T popData = top.data;
			top = top.next;
			return popData;
		}
	}

	public T peek() {
		if (isEmpty()) {
			return null;
		} else
			return top.data;
	}

	public NK_P1_StackUsingLL() {
		top = null;

	}
	
	public String toString() {

		if (top == null) {
			return null;
		}
		if (top.next == null) {
			return top.data + "-->NULL";
		}

		String res = top.data + "-->";
		
		Node<T> temp = top.next;
		while (temp != null) {
			res = res + temp.data + "-->";
			temp = temp.next;
		}

		return res;
	
	}

	public static void main(String[] args) {
		NK_P1_StackUsingLL<Integer> stack = new NK_P1_StackUsingLL<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println("Stack:");
		System.out.println(stack.toString());

		System.out.println("Peek: " + stack.peek());

		System.out.println("Pop: " + stack.pop());
		System.out.println("Stack after pop:");
		System.out.println(stack.toString());

		System.out.println("Peek after pop: " + stack.peek());

	}

}

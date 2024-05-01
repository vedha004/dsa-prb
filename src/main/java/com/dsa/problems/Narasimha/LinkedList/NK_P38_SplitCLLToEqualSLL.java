package com.dsa.problems.Narasimha.LinkedList;

import com.dsa.impl.linkedList.CircularLinkedList2;
import com.dsa.impl.linkedList.Node;

public class NK_P38_SplitCLLToEqualSLL {

	CircularLinkedList2<Integer> cll1 = new CircularLinkedList2<>();
	CircularLinkedList2<Integer> cll2 = new CircularLinkedList2<>();

	public void splitCLLToEqualSLL(CircularLinkedList2<Integer> cll) {

		if (cll.head == null)
			return;

		Node<Integer> slowPtr = cll.head;
		Node<Integer> fastNode = cll.head;
		Node<Integer> prevFastNode = cll.head;
		Node<Integer> prevSlowNode = cll.head;
		int count = 0;
		while (fastNode != null) {

			if ((fastNode.next.equals(cll.head)) && count != 0) {

				fastNode.next = null;
				cll2.head = slowPtr.next;

				slowPtr.next = null;
				cll1.head = cll.head;

				System.out.println(cll1.toString());
				System.out.println(cll2.toString());

				return;
			}
			else if(fastNode.equals(cll.head)&& count != 0) {
				prevFastNode.next.next = null;
				cll2.head = prevSlowNode.next;
				
				prevSlowNode.next = null;
				cll1.head = cll.head;
				System.out.println(cll1.toString());
				System.out.println(cll2.toString());

				return;
				
			}

			count++;
			prevFastNode = fastNode;
			prevSlowNode = slowPtr;
			slowPtr = slowPtr.next;
			fastNode = fastNode.next.next;
			System.out.println("count:"+ count);
			System.out.println("sp:"+slowPtr.data);
			System.out.println("fp:"+fastNode.data);

		}

	}

	public static void main(String[] args) {

		CircularLinkedList2<Integer> cll = new CircularLinkedList2<>();

		cll.insertAtEnd(10);
		cll.insertAtEnd(20);
		cll.insertAtEnd(30);
		cll.insertAtEnd(40);
		cll.insertAtEnd(50);
		cll.insertAtEnd(60);
		cll.insertAtEnd(70);
		NK_P38_SplitCLLToEqualSLL prb38 = new NK_P38_SplitCLLToEqualSLL();

		prb38.splitCLLToEqualSLL(cll);
	}

}

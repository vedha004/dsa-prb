package com.dsa.impl.linkedList;

public class CLLNode<T> {
    private T data;
    private CLLNode<T> next;

    public CLLNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CLLNode<T> getNext() {
        return next;
    }

    public void setNext(CLLNode<T> next) {
        this.next = next;
    }
}

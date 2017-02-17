package com.ly.myList;

public class DLinkNode<T> {

	public T data;
	public DLinkNode<T> prev,next;
	public DLinkNode(T data, DLinkNode<T> prev, DLinkNode<T> next) {
		super();
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	public DLinkNode() {
		this(null,null,null);
	}
	
	
}

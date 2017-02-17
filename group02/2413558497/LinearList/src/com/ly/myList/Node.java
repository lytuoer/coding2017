package com.ly.myList;

/**
 * 单链表节点
 * @author Administrator
 * data:表示节点的数据域
 * next:表示节点的数据域
 * @param <T>
 */
public class Node<T> {

	public T data;
	public Node<T> next;
	
	public Node(T data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public Node() {
		this(null,null);
	}
	
	
	
}

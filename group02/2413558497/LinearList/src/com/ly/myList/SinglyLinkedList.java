package com.ly.myList;

public class SinglyLinkedList<T> implements LList<T> {

	public Node<T> head;

	public SinglyLinkedList() {

		this.head = new Node<T>();
	}

	//深度拷贝
	public SinglyLinkedList(SinglyLinkedList<T> singlyLinkedList){
		this();
		Node<T> p =singlyLinkedList.head.next;
		Node<T> rear = this.head;
		while(p!=null){
			rear.next = new Node<T>(p.data,null);
			rear = rear.next;
			p = p.next;
		}
	}
	// 由指定数组中的多个对象构造单链表，采用尾部插入的方法。
	public SinglyLinkedList(T[] element) {

		this();
		Node<T> rear = this.head;

		for (int i = 0; i < element.length; i++) {
			rear.next = new Node<T>(element[i], null);
			rear = rear.next;
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head.next == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		int i = 0;
		Node<T> p = this.head.next;
		while (p != null) {
			i++;
			p = p.next;
		}
		return i;
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		if (i >= 0) {
			Node<T> p = this.head.next;
			for (int j = 0; j < i && p != null; j++) {
				p = p.next;
			}
			if (p != null)
				return p.data;

		}
		return null;
	}

	@Override
	public void set(int i, T x) {
		// TODO Auto-generated method stub
		if (x == null) {
			return;
		}
		if (i >= 0) {
			Node<T> p = this.head.next;
			for (int j = 0; j < i && p != null; j++) {
				p = p.next;
			}
			if (p != null)
				p.data = x;
		} else
			throw new IndexOutOfBoundsException(i + "");
	}

	@Override
	public void insert(int i, T x) {
		// TODO Auto-generated method stub
		if (x == null) {
			return;
		}

		Node<T> p = this.head;
		for (int j = 0; j < i && p != null; j++) {
			p = p.next;
		}

		p.next = new Node<T>(x, p.next);
	}

	@Override
	public void append(T x) {
		// TODO Auto-generated method stub

		insert(Integer.MAX_VALUE, x);
	}

	@Override
	public T remove(int i) {
		// TODO Auto-generated method stub
		if (i >= 0) {
			Node<T> p = this.head.next;
			for (int j = 0; j < i && p.next != null; j++) {
				p = p.next;
			}
			if (p.next != null){
				T old = p.next.data;
				p.next = p.next.next;
				return old;
			}
		}
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

		this.head.next = null;
	}

	public String toString(){
		String str="(";
		Node<T> p = this.head.next;
		
		while (p!=null) {

			str+=p.data.toString();
			if(p.next!=null){
				str+=",";
			}
			p = p.next;
		}
		
		return str+")";
	}
	public boolean equals(Object obj){
		if(obj==this){
			return true;
		}else if(obj instanceof SinglyLinkedList){
			SinglyLinkedList list = (SinglyLinkedList) obj;
			Node<T> p = this.head;
			Node<T> q = list.head;
			
			while(p!=null&&q!=null&&p.data.equals(q.data)){
				p = p.next;
				q = q.next;
			}
			return p==null&&q==null;
		}else{
			return false;
		}
		
	}
	@Override
	public T search(T key) {
		// TODO Auto-generated method stub
		return null;
	}

}

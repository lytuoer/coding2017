package com.ly.myList;

public class SortedSinglyLinkedList<T extends Comparable<T>> extends SinglyLinkedList<T> {

	public SortedSinglyLinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SortedSinglyLinkedList(SortedSinglyLinkedList<T> singlyLinkedList) {
		super(singlyLinkedList);
		// TODO Auto-generated constructor stub
	}

	public SortedSinglyLinkedList(T[] element) {
		super();
		if(element!=null){
			for (int i = 0; i < element.length; i++) {
				this.insert(element[i]);
			}
		}
	}

	public void insert(T x) {
		// TODO Auto-generated method stub
		if(x==null)
			return;
		Node<T> front = this.head , p = this.head.next;
		while(p!=null&&p.data.compareTo(x)<0){
			front = p;
			p = p.next;
		}
		front.next = new Node<T>(x,p);
	}

	//不支持父类的insert(int i,T x) 和append(T x) 方法，将其覆盖并抛出异常
	public void insert(int i ,T x){
		throw new UnsupportedOperationException("insert(int i ,T x)");
	}
	
	public void append(T x){
		
		throw new UnsupportedOperationException("append(T x)");
		
	}
	//重载父类的remove(T x)方法
	public void remove(T x){
		if(x==null)
			return;
		Node<T> front = this.head , p = this.head.next;
		while(p!=null&&p.data.compareTo(x)<0){
			front = p;
			p = p.next;
		}
		if(p!=null&&p.data.compareTo(x)==0)
			front.next =p.next;
	}
}

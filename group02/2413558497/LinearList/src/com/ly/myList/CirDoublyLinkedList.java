package com.ly.myList;

public class CirDoublyLinkedList<T> implements LList<T> {

	public DLinkNode<T> head;
	
	
	public CirDoublyLinkedList() {
		this.head = new DLinkNode<T>();
		this.head.prev = this.head.next;
		this.head.next = this.head.prev;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head.next == this.head.prev;
	}

	@Override
	public int length() {
		int i =0;
		DLinkNode<T> p = this.head.next;
		while(p!=null){
			p = p.next;
			i++;
		}
		return i;
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		if(i>=0){
			DLinkNode<T> p = this.head.next;
			
			for (int j = 0; j <i&& p!=null; j++) {
				p = p.next;
			}
			if(p!=null){
				return p.data;
			}
		}
		return null;
	}

	@Override
	public void set(int i, T x) {
		// TODO Auto-generated method stub
		if(x==null)
			return;
		if(i>=0){
			DLinkNode<T> p = this.head.next;
			for (int j = 0; p!=null&&j<i; j++) {
				p = p.next;
			}
			if(p!=null){
				p.data = x;
			}
		}else{
			throw new IndexOutOfBoundsException(i+"");
			
		}
	}

	@Override
	public void insert(int i, T x) {
		// TODO Auto-generated method stub
		if(x==null)
			return;
		
			DLinkNode<T> p = this.head;
			for (int j = 0; j < i&&p.next!=this.head; j++) {
				p = p.next;
			}
				DLinkNode<T> q = new DLinkNode<T>(x, p, p.next);
				p.next.prev = q;
				p.next = q;
		
	}

	@Override
	public void append(T x) {
		// TODO Auto-generated method stub
		if(x==null)
			return;
		DLinkNode<T> q = new DLinkNode<T>(x, head.prev, head);
		head.prev.next = q;
		head.prev =q;
	}

	@Override
	public T remove(int i) {
		// TODO Auto-generated method stub
		if(i>=0){
			DLinkNode<T> p = this.head;
			for (int j = 0; j < i&&p.next!=head; j++) {
				p = p.next;
			}
			if(p!=head){
				T old = p.data;
				p.prev.next = p.next;
				p.next.prev = p.prev;
				return old;
			}
		}
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		this.head.prev = head;
		this.head.next = head;
	}

	@Override
	public T search(T key) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.ly.myList;

public class DoubleLinkedList<T> implements LList<T> {

	public DLinkNode<T> head;
	
	public DoubleLinkedList() {

		head = new DLinkNode<T>();
	}

	public DoubleLinkedList(T[] element){
		this();
		DLinkNode<T> rear = this.head;
		for (int i = 0; i < element.length; i++) {
			rear.next = new DLinkNode<T>(element[i], rear, null);
			rear = rear.next;
		}
		
		
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head.prev==null && this.head.next == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
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
		if(i<0)
			return null;
		DLinkNode<T> p = this.head.next;
		int j = 0;
		while(p!=null&&j==i){
			p = p.next;
		}
		if(p!=null)
			return p.data;
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
		if(x==null){
			return;
		}
		
			DLinkNode<T> p = this.head.next;
			for (int j = 0;p!=null&&j<i; j++) {
				p = p.next;
			}
			//在p节点的前面添加			
//				DLinkNode<T> q = new DLinkNode<T>(x, p.prev, p);
//				p.prev.next = q;
//				p.prev = q;
			//在p节点后面添加
			DLinkNode<T> q = new DLinkNode<T>(x, p, p.next);
			if(p.next!=null){
				p.next.prev = q;
			}
			p.next = q;
		
	}

	@Override
	public void append(T x) {
		// TODO Auto-generated method stub
		insert(Integer.MAX_VALUE, x);
	}

	@Override
	public T remove(int i) {
		// TODO Auto-generated method stub
		if(i>=0){
			DLinkNode<T> p = this.head.next;
			for (int j = 0; j <i&&p!=null; j++) {
				p = p.next;
			}
			if(p!=null){
				T old = p.data;
				p.prev.next = p.next;
				if(p.next!=null)
					p.next.prev = p.prev;
			
				return old;
			}
		}
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		this.head.prev=null;
		this.head.next=null;
	}

	@Override
	public T search(T key) {
		// TODO Auto-generated method stub
		return null;
	}

}

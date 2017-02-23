package com.ly.list;



public class MyLinkedList<E> implements LList {
	
	transient Node<E> first;
	transient Node<E> last;
	private int size;
	
	public MyLinkedList() {
		
	}
	
	private void linkFirst(E e) {
		final Node<E> f =  first;
		final Node<E> newNode = new Node<E>(null, e, first);
		
		first = newNode;
		
		if ( f == null)
			last = newNode;
		else
			f.prev = newNode;
		size ++;
		
		 
	}
	void linkLast(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<E>(l, e, null);
		
		last = newNode;
		if( l == null ) 
			first = newNode;
		else
			l.next = newNode;
		size ++;
		
	}
	
	void linkBefore(E e, Node<E> succ) {
		
		final Node<E> pred = succ.prev;
		final Node<E> newNode = new Node<E>(pred,e,succ);
		
		succ.prev = newNode;
		if ( pred == null )
			first = newNode;
		else
			pred.next = newNode;
		
		size++;
	}
	
	E unlink(Node<E> x) {
		
		final E element = x.item;
		final Node<E> prev = x.prev;
		final Node<E> next = x.next;
		
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}
		
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}
		
		x.item = null;
		size--;
		return element;
			
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(int index, Object e) {
		checkAddBound(index);
		
		if (index == size)
			linkLast( (E) e);
		else
			linkBefore((E) e, node(index));
	}

	private Node<E> node(int index) {
		
		if (index < (size >>1 )) {
			Node<E> x = first; 
			for(int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = last;
			for(int i = size-1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	private void checkAddBound(int index) {
		if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		// TODO Auto-generated method stub
		return "Index: "+index+", Size: "+size;
	}

	private boolean isPositionIndex(int index) {
		// TODO Auto-generated method stub
		return index >=0 && index<=index;
	}

	public void add(Object e) {
		linkLast((E)e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object e) {
		if (e == null) {
			for(Node<E> x = first; x!=null; x = x.next) {
				if (x.item == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for(Node<E> x = first; x != null; x = x.next) {
				if(((E) e).equals(x.item)){
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Object remove(int index) {
		checkElementIndex(index);
		return unlink(node(index));
	}

	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		
	}

	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	@Override
	public void removeAll() {
		
	}

	@Override
	public Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class Node<E> {
		E item ;
		Node next;
		Node prev;
		
		public Node(Node prev,E e,Node next) {
			this.item = item;
			this.next = next;
			this.prev = this.prev;
		}
		
	}


}

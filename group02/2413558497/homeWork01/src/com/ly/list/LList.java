package com.ly.list;

public interface LList<E> {
	
	boolean isEmpty();
	int size();
	void add(int i,E e);
	void add(E e);
	boolean remove(E e);
	E remove(int index);
	void removeAll();
	E get(int i);

}

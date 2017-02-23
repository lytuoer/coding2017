package com.ly.list;

import java.util.Arrays;

public class MyArrayList<E> implements LList<E> {

	private Object[] elementData;
	
	private int size;
	
	public MyArrayList() {
		this(10);
	}
	
    public MyArrayList(int length) {
    	if (length < 0)
    		throw new IllegalArgumentException("Illegal Capacity: "+
                    length); 
    	this.elementData = new Object[length];
	}
	
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void add(int index, E e) {
		
		checkAddBound(index);
		
		this.size ++;
		if(size > elementData.length) {
			grow();
		}
		System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
		elementData[index] = e;
	}

	private void grow() {
		this.elementData = Arrays.copyOf(elementData, elementData.length + elementData.length>>1);
	}

	private void checkAddBound(int index) {
		if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Index: "+index+", Size: "+size;
	}

	@Override
	public void add(E e) {
		this.size ++;
		if(size > elementData.length) {
			grow();
		}
		elementData[size-1] = e;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++) {
				if (elementData [index] == null)
					fastRemove(index);
				return true;
			}
		}
		return false;
	}

	private void fastRemove(int index) {
		int numMoved = size -index-1;
		if(numMoved > 0)
		    System.arraycopy(elementData, index+1, elementData, index, numMoved);
		elementData[--size] = null;
	}

	@Override
	public void removeAll() {
		this.size = 0;
	}

	@Override
	public E get(int i) {
		return null;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E e = (E) elementData[index];
		
		int numMoved = size - index -1;
		if (numMoved > 0)
		   System.arraycopy(elementData, index, elementData, index+1, numMoved);
		elementData[--size] = null;
		return e;
	}

	private void rangeCheck(int index) {
		if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

}

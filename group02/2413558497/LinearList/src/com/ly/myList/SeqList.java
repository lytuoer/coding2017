package com.ly.myList;


/**
 * ˳���
 * 
 * @author ly
 *
 *         SeqList������˽�г�Ա����element��len.
 *         element��һ��������Ա�Ԫ�ص�һά���飻Ԫ������ΪT��len��ʾ˳��?�ȡ�
 */
public class SeqList<T> implements LList<T> {

	private Object[] element;
	private int len;

	public SeqList(int size) {

		element = new Object[size];
		len = 0;
	}
	public SeqList(SeqList<T> seqList){
		this.len = seqList.len;
		this.element = new Object[seqList.length()];
		for (int i = 0; i < element.length; i++) {
			this.element[i] = seqList.element[i];
		}
	}

	public SeqList() {
		this(64);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return len == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return len;
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		if (i >= 0 && i < this.len) {
			return (T) this.element[i];
		} else
			return null;
	}

	// ���õ�i��Ԫ��ֵΪx,iΪ�������Ѿ����ڵġ����滻������
	@Override
	public void set(int i, T x) {
		// TODO Auto-generated method stub
		if (x == null) {
			return;
		}
		if (i >= 0 && i < this.len) {
			element[i] = x;
		} else
			throw new IndexOutOfBoundsException(i + "");
	}

	@Override
	public void insert(int i, T x) {
		// TODO Auto-generated method stub
		if (x == null) {
			return;
		}
		if (this.len == this.element.length) {
			Object[] temp = this.element;
			this.element = new Object[element.length * 2];
			for (int j = 0; j < temp.length; j++) {
				this.element[j] = temp[j];
			}
		}
		if (i < 0) {
			i = 0;
		}
		if (i > len) {
			i = len;
		}
		for (int j = len - 1; j >= i; j--) {
			element[j + 1] = element[j];
		}
		this.element[i] = x;
		this.len++;
	}

	@Override
	public void append(T x) {

		insert(this.len, x);
		// TODO Auto-generated method stub

	}

	@Override
	public T remove(int i) {
		// TODO Auto-generated method stub
		if (len == 0 || i < 0 || i >= len)
			return null;

		T x = (T) element[i];
		for (int j = i; j < len - 1; j++)
			element[i] = element[i + 1];

		this.element[len - 1] = null;
		this.len--;
		return x;

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

		this.len=0;
	}

	@Override
	public T search(T key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj instanceof SeqList){
			SeqList<T> list = (SeqList<T>)obj;
			for (int i = 0; i < element.length; i++) {
				if(!(this.get(i).equals(list.get(i)))){
					return false;
				}
				return true;
			}
			
		}
		return false;
	}

	
}

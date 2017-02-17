package com.ly.myList;

public interface LList<T> {

	boolean isEmpty();     //�ж����Ա��Ƿ�Ϊ��
	int length();          //�������Ա�ĳ���
	T get(int i);          //���ص�i(i>=0)��Ԫ��.
	void set(int i, T x);  //���õ�i��Ԫ��ֵΪx
	void insert(int i,T x);//����x��Ϊ��i��Ԫ��
	void append(T x);      //�����Ա�������Ԫ��x
	T remove(int i);       //ɾ����iԪ��,�����ر�ɾ���Ķ���
	void removeAll();      //ɾ�����Ա����е�Ԫ��
	T search(T key);       //���Ҳ������״γ��ֹؼ���ΪkeyԪ��
	
}

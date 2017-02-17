package com.ly.myList;

public interface LList<T> {

	boolean isEmpty();     //判断线性表是否为空
	int length();          //返回线性表的长度
	T get(int i);          //返回第i(i>=0)个元素.
	void set(int i, T x);  //设置第i个元素值为x
	void insert(int i,T x);//插入x作为第i个元素
	void append(T x);      //在线性表最后插入元素x
	T remove(int i);       //删除第i元素,并返回被删除的对象
	void removeAll();      //删除线性表所有的元素
	T search(T key);       //查找并返回首次出现关键字为key元素
	
}

package com.ly.myListTest;

import com.ly.myList.Node;
import com.ly.myList.SinglyLinkedList;

/**
 * 单链表反转
 * @author Administrator
 *
 */
public class SinglyLinkedList_reverse {

	public static <T> void reverse(SinglyLinkedList<T> list){
		Node<T> p = list.head.next, succ=null, front =null;
		
		while(p!=null){
			succ = p.next;
			p.next = front;
			front = p;
			p= succ;
		}
		list.head.next =front;
	}
	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<>(
				new String[]{"A","B","C","D","E"} );
		System.out.println(list.toString());
		new SinglyLinkedList_reverse().reverse(list);
		System.out.println(list.toString());
	}
}

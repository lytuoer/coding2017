package com.ly.myListTest;

import com.ly.myList.SortedSinglyLinkedList;

public class SortedSinglyLinkedList_ex {

	public static Integer[] random(int n) {
		Integer[] element = new Integer[n];
		for (int i = 0; i < n; i++) {
			element[i] = (int)(Math.random()*100);
		}
		return element;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] element = random(10);
		for (Integer integer : element) {
			System.out.print (integer + "  ");
		}
		System.out.println(element);
		SortedSinglyLinkedList<Integer> list1 =
				new SortedSinglyLinkedList<Integer>(element);
		System.out.println(list1);
		list1.insert(60);
		System.out.println(list1);
	}

}

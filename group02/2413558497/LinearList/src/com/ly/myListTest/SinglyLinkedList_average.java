package com.ly.myListTest;

import com.ly.myList.Node;
/**
 * �������������ƽ��ֵ
 */
import com.ly.myList.SinglyLinkedList;

public class SinglyLinkedList_average {

	public static Integer[] random(int n){
		
		Integer[] element =new Integer [n];
		for (int i = 0; i < n; i++) {
			element[i] = new Integer((int)(Math.random()*100));
		}
	
		return element;
	}
	//ȥ����߷ֺ���ͷ֣���ƽ��ֵ��O(n)
	public static double averageExceptMaxMin(SinglyLinkedList<Integer> list){
		if(list.isEmpty())
			throw new IllegalArgumentException("���ܶԿ��������");
		int sum=0,i=0,max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
		Node<Integer> p = list.head.next;
		
		while(p!=null){
			int value = p.data.intValue();
			sum+=value;
			if(value>max){
				max = value;
			}
			if(value<min){
				min = value;
			}
			p = p.next;
			i++;
		}
		if(i==1 ||i==2){
			return sum/i;
		}
		return (sum-max-min)/i;
		
	}
	public static void main(String[] args) {
		SinglyLinkedList_average sla = new SinglyLinkedList_average();
		Integer[] element = sla.random(10);
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(element);
		System.out.println(list.toString());
		System.out.println(sla.averageExceptMaxMin(list));;
	}
}

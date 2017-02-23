package com.ly.list;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		
		list.add(1);
		list.add(5);
		list.add("a");
		list.add("a");
		
		list.remove(new Integer(5));
		System.out.println(list.size());

	}

}

package com.sample.bootstrap.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Iterators {
	
	public static String[] testCases = new String[] {
		"A", "B", "C", "D", "F"	
	};
	
	public static List<String> buildFailFast() {
		ArrayList<String> list = new ArrayList<>();
		
		for(String value: testCases)
			list.add(value);
		
		return list;
	}
	
	public static List<String> buildFailSafe() {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		
		for(String value: testCases)
			list.add(value);
		
		return list;	
	}
	
}

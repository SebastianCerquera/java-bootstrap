package com.sample.bootstrap.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {

	public void arraysContravariance() {
		Integer[] myInts = {1,2,3,4};
		Number[] myNumber = myInts;
		myNumber[0] = 3.14; //attempt of heap pollution
	}
	
	public Integer genericsInvarianceExtend() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		List<? extends Integer> target = list;
		list.add(3);
		
		Integer value = target.get(0);
		return value;
	}
	
	public Object genericsInvarianceSuper() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		List<? super Integer> target = list;
		target.add(3);
		
		Object value = target.get(0);
		return value;
	}
	
	public Integer genericsInvarianceContravariance() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		
		List<? extends Integer> target = list;
		
		/* 
		 * Java is expecting something that inherets from integer yet you cannot store any and integer object
		 * 
		 * target.add(3);
		 */
		
		Integer value = target.get(0);
		return value;
	}
	
	public void genericsCovarianceAndContravariance() {
		List<? extends Number> source = Arrays.asList(new Integer[] {
			1, 2, 3	
		});
		
		List<Number> target = new ArrayList<>();
		for(Number entry : source)
			target.add(entry);
		
		target.add(Double.valueOf(1.0));
	}
	
}

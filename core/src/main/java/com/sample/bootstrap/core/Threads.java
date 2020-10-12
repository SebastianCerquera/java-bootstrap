package com.sample.bootstrap.core;

import java.util.concurrent.atomic.AtomicInteger;

public class Threads {
	
	public static class ThreadId {
	    // Next thread ID to be assigned
	    private final AtomicInteger nextId = new AtomicInteger(0);

	    // Thread local variable containing each thread's ID
	    private final ThreadLocal<Integer> threadId =
	        new ThreadLocal<Integer>() {
	            @Override protected Integer initialValue() {
	                return nextId.getAndIncrement();
	        }
	    };

	    // Returns the current thread's unique ID, assigning it if necessary
	    public int get() {
	        return threadId.get();
	    }
	}
	
	

}

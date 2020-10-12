package com.sample.bootstrap.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadsTest {
	
	private Runnable buildTestSample(final Threads.ThreadId local) {
		return new Runnable(){
			
			@Override
			public void run(){
				 Integer initialValue = local.get();
				 
					try {
						Thread.sleep(15000);
					} catch (InterruptedException e) {
						throw new IllegalStateException();
					}
						
					assertEquals(local.get(), initialValue);
			}
		};
		
	}

	@Test
	public void shouldKeepTheIdentifierSingle() {
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(buildTestSample(new Threads.ThreadId()));

	}
	
	@Test
	public void shouldKeepTheIdentifierFixed() {
		final Threads.ThreadId local = new Threads.ThreadId();
		Executor executor = Executors.newFixedThreadPool(100);
		for(int i = 0; i <= 200; i++)
			executor.execute(buildTestSample(local));		
	}
	
	@Test
	public void shouldKeepTheIdentifier() {
		final Threads.ThreadId local = new Threads.ThreadId();
		Executor executor = Executors.newCachedThreadPool();
		for(int i = 0; i <= 200; i++)
			executor.execute(buildTestSample(local));		
	}

}

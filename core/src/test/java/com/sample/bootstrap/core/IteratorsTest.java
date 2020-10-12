package com.sample.bootstrap.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

class IteratorsTest {

	@Test
	void shouldFailFast() {
		List<String> list = Iterators.buildFailFast();
		Iterator<String> it = list.iterator();
		
		assertTrue(it.hasNext());
		assertNotNull(it.next());
		
		assertTrue(it.hasNext());
		assertNotNull(it.next());
		
		list.add("TEST");
		
		assertTrue(it.hasNext());
		assertThrows(ConcurrentModificationException.class, () -> it.next());
	}
	
	@Test
	void shouldFailSafe() {
		List<String> list = Iterators.buildFailSafe();
		Iterator<String> it = list.iterator();
		
		assertTrue(it.hasNext());
		assertNotNull(it.next());
		
		assertTrue(it.hasNext());
		assertNotNull(it.next());
		
		list.add("TEST");
		
		assertTrue(it.hasNext());
		assertNotNull(it.next());
	}

}

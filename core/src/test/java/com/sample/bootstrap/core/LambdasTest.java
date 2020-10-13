package com.sample.bootstrap.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LambdasTest {
	
	@Test
	public void numericPredicate() {
		Lambdas lambdas = new Lambdas();
		
		assertDoesNotThrow(() -> lambdas.checkPredicate(5, (Integer e) -> e < 10 && e > 0));
		assertThrows(Exception.class, () -> lambdas.checkPredicate(-1, (Integer e) -> e < 10 && e > 0));
	}
	
	@Test
	public void indetityMapper() {
		Lambdas lambdas = new Lambdas();
		
		assertDoesNotThrow(() -> lambdas.checkIdentityMapper(5, 6, (Integer e) -> e + 1));
		assertThrows(Exception.class, () -> lambdas.checkIdentityMapper(5, 7, (Integer e) -> e + 1));
	}
	
	@Test
	public void numericConsumer() {		
		Lambdas lambdas = new Lambdas();

		Integer value = 1;
		Consumer<Integer> mock = Mockito.mock(Consumer.class);
		lambdas.checkConsumer(value, mock);
		
		Mockito.verify(mock, Mockito.times(1)).accept(value);
	}
}

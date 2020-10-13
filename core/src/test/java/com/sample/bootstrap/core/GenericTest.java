package com.sample.bootstrap.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenericTest {
	
	@Test
	public void arraysContravariance() {
		Generics generic = new Generics();
		assertThrows(ArrayStoreException.class, () -> generic.arraysContravariance());
	}

	@Test
	public void generiVarianceContravariance() {
		Generics generic = new Generics();
		generic.genericsCovarianceAndContravariance();	
	}
	
	@Test
	public void genericsInvarianceSuper() {
		Generics generic = new Generics();
		assertEquals(generic.genericsInvarianceSuper().getClass(), Integer.class);
	}
	
	@Test
	public void genericsInvarianceExtend() {
		Generics generic = new Generics();
		assertEquals(generic.genericsInvarianceExtend().getClass(), Integer.class);
	}
	
}

package com.sample.bootstrap.core;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import com.sample.bootstrap.core.Lang.FinallyPath;

public class LangTest {
	
	@Test
	public void finallyHappyPath(){
		Lang lang = new Lang();
		
		FinallyPath finallyPath = Mockito.mock(FinallyPath.class);
		lang.finallyHappyPath(finallyPath);
		
		InOrder orderedMock = Mockito.inOrder(finallyPath);
		orderedMock.verify(finallyPath, Mockito.times(1)).tryBlock();
		orderedMock.verify(finallyPath, Mockito.times(1)).finallyBlock();
		orderedMock.verify(finallyPath, Mockito.times(1)).lastBlock();
	}
	
	@Test
	public void finallyExceptionPath(){
		Lang lang = new Lang();
		
		FinallyPath finallyPath = Mockito.mock(FinallyPath.class);
		lang.finallyHappyPath(finallyPath);
		
		InOrder orderedMock = Mockito.inOrder(finallyPath);
		orderedMock.verify(finallyPath, Mockito.times(1)).finallyBlock();
	}

	
}

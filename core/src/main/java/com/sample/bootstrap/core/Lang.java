package com.sample.bootstrap.core;

public class Lang {
	
	public static interface FinallyPath {
		public void tryBlock();
		public void finallyBlock();
		public void lastBlock();
	}
	
	public void finallyHappyPath(FinallyPath path) {
		try {
			path.tryBlock();
		} finally {
			path.finallyBlock();	
		}
		
		path.lastBlock();
	}
	
	public void finallyExceptionPath(FinallyPath path) throws Exception {
		try {
			throw new Exception();
		} finally {
			path.finallyBlock();
		}
		
	}

}

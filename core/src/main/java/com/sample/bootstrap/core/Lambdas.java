package com.sample.bootstrap.core;

import java.util.function.*;

public class Lambdas {

	public <T> void checkPredicate(T value, Predicate<T> predicate) throws Exception {
		if (!predicate.test(value))
			throw new Exception();

	}

	public <T> void checkIdentityMapper(T input, T output, Function<T, T> mapper) throws Exception {
		if (mapper.apply(input) != output)
			throw new Exception();
	}
	
	public <T> void checkConsumer(T value, Consumer<T> consumer) {
		consumer.accept(value);
	}

}

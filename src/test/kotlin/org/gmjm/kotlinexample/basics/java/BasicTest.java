package org.gmjm.kotlinexample.basics.java;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

public class BasicTest {

	@Test
	public void test_basicFunction() {

		Function<String,String> basicFunction = new BasicFunction();

		Optional.of("jello")
			.map(basicFunction)
			.ifPresent(System.out::println);

	}

	@Test
	public void test_biConsumer() {
		BiConsumer<String,Consumer<String>> biConsumer = BasicUtil::sayHello;

		biConsumer.accept("jello",System.out::println);
	}

	@Test
	public void test_TriFunction() {

		System.out.println(BasicUtil.condense.apply("ONE","TWO","THREE"));

	}

}

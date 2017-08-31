package org.gmjm.kotlinexample.basics.java;

import java.util.function.Consumer;

public class BasicUtil {

	public static TriFunction<String, String, String, String> condense = (a, b, c) -> a + "_" + "_" + b + "_" + c;


	public static void sayHello(String subject, Consumer<String> obj) {
		obj.accept("Hello " + subject);
	}

	public static void greet(String subject) {
		BasicUtil.sayHello(subject, System.out::println);
	}

}

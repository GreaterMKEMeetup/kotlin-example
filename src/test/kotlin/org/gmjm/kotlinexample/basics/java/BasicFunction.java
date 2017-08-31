package org.gmjm.kotlinexample.basics.java;

import java.util.function.Function;

public class BasicFunction implements Function<String, String> {

	@Override
	public String apply(String s) {
		return String.join("-",s.split(""));
	}
}

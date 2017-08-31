package org.gmjm.kotlinexample.basics.java;

import java.math.BigInteger;

import org.junit.Test;

public class StackOverflow {

	static void toZeroRecursive(BigInteger bigInteger) {
		if(bigInteger.mod(new BigInteger("1000")).equals(BigInteger.ZERO)) {
			System.out.println(bigInteger);
		}

		if(bigInteger.compareTo(BigInteger.ZERO) > 0) {
			StackOverflow.toZeroRecursive(bigInteger.subtract(BigInteger.ONE));
		}
	}


	@Test
	public void test() {
		toZeroRecursive(new BigInteger("7000"));
	}

}

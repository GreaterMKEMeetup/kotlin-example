package org.gmjm.kotlinexample.strings;

import java.util.Calendar;

import org.junit.Test;

import static java.lang.String.*;

public class JavaExamples {


	public class Greeting {
		final String subject;
		final String author;
		final String language;
		final Integer integerNumber;
		final Float decimalNumber;
		final Calendar currentTime;

		public Greeting(
			String subject,
			String author,
			String language,
			Integer integerNumber,
			Float decimalNumber,
			Calendar currentTime
		) {
			this.subject = subject;
			this.author = author;
			this.language = language;
			this.integerNumber = integerNumber;
			this.decimalNumber = decimalNumber;
			this.currentTime = currentTime;
		}
	}

	@Test
	public void test() {

		Greeting greeting = new Greeting(
			"Meetup Attendees",
			"Andy Glassman",
			"Java",
			523,
			3.45f,
			Calendar.getInstance());

		String synopsis = format(
			"Hello %1$s,\n"+
			"	How are you today?  My name is %2$s, and today I'll be teaching you\n"+
			"how to write templated strings in %3$s.  It's easy they say! \n" +
			"You can format:\n" +
			"\tintegers: %4$d\n" +
			"\tintegers(hex): %4$x\n" +
			"\tdecimals: %5$5.5f\n" +
			"\tdates: %6$tc\n" +
			"You can also reference earlier arguments: %3$s!",
			greeting.subject,
			greeting.author,
			greeting.language,
			greeting.integerNumber,
			greeting.decimalNumber,
			greeting.currentTime);

		System.out.println(synopsis);

	}

}

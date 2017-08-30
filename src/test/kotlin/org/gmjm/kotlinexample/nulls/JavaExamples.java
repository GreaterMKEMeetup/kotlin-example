package org.gmjm.kotlinexample.nulls;

import org.junit.Test;

public class JavaExamples {

	class Person {
		String name;
		String email;
		Address address;
	}

	class Address {
		String streetAddress;
		String city;
		State state;
		String country;
	}

	class State {
		String fullName;
		String abbreviation;
	}

	@Test
	public void test_fullContact() {

		//Create a fully filled out object
		Person contact = new Person();
		contact.name = "Buster Bluth";
		contact.email = "buster@bluth.com";
		contact.address = new Address();
		contact.address.streetAddress = "302 Sudden Valley Ct.";
		contact.address.city = "The OC";
		contact.address.state = new State();
		contact.address.state.fullName = "California";
		contact.address.state.abbreviation = "CA";
		contact.address.country = "USA";

		unsafePrint(contact);
	}

	@Test
	public void test_partialContact() {

		//Create a fully filled out object
		Person contact = new Person();
		contact.name = "Buster Bluth";
		contact.email = null;
		contact.address = new Address();
		contact.address.streetAddress = "302 Sudden Valley Ct.";
		contact.address.city = "The OC";
		contact.address.state = new State();
		contact.address.state.fullName = null;
		contact.address.state.abbreviation = "CA";

		unsafePrint(contact);
	}

	@Test
	public void test_partialContact_NPE() {

		//Create a fully filled out object
		Person contact = new Person();
		contact.name = "Buster Bluth";
		contact.email = null;
		contact.address = new Address();
		contact.address.streetAddress = "302 Sudden Valley Ct.";
		contact.address.city = "The OC";
		contact.address.state = null;

		unsafePrint(contact);
	}

	@Test
	public void test_partialContact_safe() {

		//Create a fully filled out object
		Person contact = new Person();
		contact.name = "Buster Bluth";
		contact.email = null;
		contact.address = new Address();
		contact.address.streetAddress = "302 Sudden Valley Ct.";
		contact.address.city = "The OC";
		contact.address.state = null;

		String result1 = safeToString(contact);
		String result2 = safeToString_2(contact);

		System.out.println(result1);
		System.out.println(result2);
	}

	public void unsafePrint(Person contact) {
		System.out.println(
			String.format(
				"name: %s, email: %s, city: %s state: %s",
				contact.name,
				contact.email,
				contact.address.city,
				contact.address.state.fullName));

	}

	public String safeToString(Person contact) {
		return
			String.format(
				"name: %s, email: %s, city: %s state: %s",
				contact != null ? contact.name : null,
				contact != null ? contact.email : null,
				contact != null && contact.address != null ? contact.address.city : null,
				contact != null && contact.address != null && contact.address.state != null ? contact.address.state.fullName : null);

	}

	public String safeToString_2(Person contact) {

		StringBuilder sb = new StringBuilder();

		if(contact != null) {
			sb.append("name: ").append(contact.name).append(", ");
			sb.append("email: ").append(contact.email).append(", ");
			if(contact.address != null) {
				sb.append("city: ").append(contact.address.city).append(", ");
				if(contact.address.state != null) {
					sb.append("state: ").append(contact.address.state.fullName).append(", ");
				}
			}
		}

		return sb.toString();
	}

}

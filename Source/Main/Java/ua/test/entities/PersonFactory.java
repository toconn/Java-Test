package ua.test.entities;

import java.util.ArrayList;
import java.util.List;

public class PersonFactory {
	
	public static List<Person> newPersons() {
		
		List<Person> persons;
		
		persons = new ArrayList<>();
		
		persons.add (new Person("John",		"Murphy",		"M", 30));
		persons.add (new Person("Sarah",	"Lancaster",	"F", 17));
		persons.add (new Person("Frank",	"Bomer",		"M", 54));
		persons.add (new Person("Martha",	"Casey",		"F", 34));
		persons.add (new Person("Jeff",		"Shaw",			"M", 25));
		persons.add (new Person("Yvonna",	"Cohan",		"F", 28));
		persons.add (new Person("Tony",		"McArthur",		"M", 71));
		persons.add (new Person("Jane",		"Decker",		"F", 12));
		persons.add (new Person("Hugh",		"Decker",		"M", 22));
		persons.add (new Person("Anna",		"Wu", "F", 45));

		return persons;
	}
}

package ua.test.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonFactory {
	
	public static Map<String,Person> newPersonMap() {
		
		Map<String,Person> personMap;
		
		personMap = new HashMap<>();
		
		personMap.put ("John",		new Person("John",		"Murphy",		"M", 30));
		personMap.put ("Sarah",		new Person("Sarah",		"Lancaster",		"F", 17));
		personMap.put ("Frank",		new Person("Frank",		"Bomer",			"M", 54));
		personMap.put ("Martha",		new Person("Martha",		"Casey",			"F", 34));
		personMap.put ("Jeff",		new Person("Jeff",		"Shaw",			"M", 25));
		personMap.put ("Yvonna",		new Person("Yvonna",		"Cohan",			"F", 28));
		personMap.put ("Tony",		new Person("Tony",		"McArthur",		"M", 71));
		personMap.put ("Jane",		new Person("Jane",		"Decker",		"F", 12));
		personMap.put ("Hugh",		new Person("Hugh",		"Decker",		"M", 22));
		personMap.put ("Anna",		new Person("Anna",		"Wu", 			"F", 45));
		
		return personMap;
	}
	
	public static List<Person> newPersons() {
		
		List<Person> persons;
		
		persons = new ArrayList<>();
		
		persons.add (new Person("John",		"Murphy",		"M", 30));
		persons.add (new Person("Sarah",		"Lancaster",		"F", 17));
		persons.add (new Person("Frank",		"Bomer",			"M", 54));
		persons.add (new Person("Martha",	"Casey",			"F", 34));
		persons.add (new Person("Jeff",		"Shaw",			"M", 25));
		persons.add (new Person("Yvonna",	"Cohan",			"F", 28));
		persons.add (new Person("Tony",		"McArthur",		"M", 71));
		persons.add (new Person("Jane",		"Decker",		"F", 12));
		persons.add (new Person("Hugh",		"Decker",		"M", 22));
		persons.add (new Person("Anna",		"Wu", 			"F", 45));

		return persons;
	}

	public static List<Person> newPersonsHalf_1() {
		
		List<Person> persons;
		
		persons = new ArrayList<>();
		
		persons.add (new Person("John",		"Murphy",		"M", 30));
		persons.add (new Person("Sarah",		"Lancaster",		"F", 17));
		persons.add (new Person("Frank",		"Bomer",			"M", 54));
		persons.add (new Person("Martha",	"Casey",			"F", 34));
		persons.add (new Person("Jeff",		"Shaw",			"M", 25));

		return persons;
	}

	public static List<Person> newPersonsHalf_2() {
		
		List<Person> persons;
		
		persons = new ArrayList<>();
		
		persons.add (new Person("Yvonna",	"Cohan",			"F", 28));
		persons.add (new Person("Tony",		"McArthur",		"M", 71));
		persons.add (new Person("Jane",		"Decker",		"F", 12));
		persons.add (new Person("Hugh",		"Decker",		"M", 22));
		persons.add (new Person("Anna",		"Wu", 			"F", 45));

		return persons;
	}
	
	public static Set<Person> newPersonSet() {
		
		Set<Person> persons;
		
		persons = new HashSet<>();
		
		persons.add (new Person("John",		"Murphy",		"M", 30));
		persons.add (new Person("Sarah",		"Lancaster",		"F", 17));
		persons.add (new Person("Frank",		"Bomer",			"M", 54));
		persons.add (new Person("Martha",	"Casey",			"F", 34));
		persons.add (new Person("Jeff",		"Shaw",			"M", 25));
		persons.add (new Person("Yvonna",	"Cohan",			"F", 28));
		persons.add (new Person("Tony",		"McArthur",		"M", 71));
		persons.add (new Person("Jane",		"Decker",		"F", 12));
		persons.add (new Person("Hugh",		"Decker",		"M", 22));
		persons.add (new Person("Anna",		"Wu", 			"F", 45));

		return persons;
	}


}

package ua.test.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AComplexClassFactory {
	
	public static AComplexClass newAComplexClass1() {
		
		AComplexClass item;
		Map<String,List<Person>> personsMap;
		
		personsMap = new HashMap<>();
		personsMap.put ("Half-1", PersonFactory.newPersonsHalf_1());
		personsMap.put ("Half-2", PersonFactory.newPersonsHalf_2());
		
		item = AComplexClass.Builder()
				.name("A Complex Class 1")
				.aClass1(AClassTestDataFactory.newAClass1())
				.aClass2(AClassTestDataFactory.newAClass1_NullDates())
				.personMap(PersonFactory.newPersonMap())
				.persons(PersonFactory.newPersons())
				.personsMap(personsMap)
				.personSet(PersonFactory.newPersonSet())
				.build();
		
		return item;
	}

}

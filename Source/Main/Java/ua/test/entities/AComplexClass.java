package ua.test.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/* Definition:

AComplexClass
Options:
	Builder
	Immutable
Fields:
	name		String
	date		LocalDateTime
	aClass1		AClass					@ ToString
	aClass2		AClass					@ ToString
	persons		List:Person				@ ToString
	personMap	Map:String,Person		@ ToString
	personsMap	Map:String,List<Person>	@ ToString
	personSet	Set:Person				@ ToString

*/


/**
 * Created with CodeCrank.io
 */
public class AComplexClass {

    public static class Builder {

        private String name = "";
        private LocalDateTime date = LocalDateTime.now();
        private AClass aClass1 = new AClass();
        private AClass aClass2 = new AClass();
        private List<Person> persons = new ArrayList<>();
        private Map<String,Person> personMap = new HashMap<>();
        private Map<String,List<Person>> personsMap = new HashMap<>();
        private Set<Person> personSet = new HashSet<>();

        public Builder name(String name) {
            this.name = name; return this;
        }

        public Builder date(LocalDateTime date) {
            this.date = date; return this;
        }

        public Builder aClass1(AClass aClass1) {
            this.aClass1 = aClass1; return this;
        }

        public Builder aClass2(AClass aClass2) {
            this.aClass2 = aClass2; return this;
        }

        public Builder persons(List<Person> persons) {
            this.persons = persons; return this;
        }

        public Builder personMap(Map<String,Person> personMap) {
            this.personMap = personMap; return this;
        }

        public Builder personsMap(Map<String,List<Person>> personsMap) {
            this.personsMap = personsMap; return this;
        }

        public Builder personSet(Set<Person> personSet) {
            this.personSet = personSet; return this;
        }

        public AComplexClass build() {
            return new AComplexClass(this);
        }
    }

    public static Builder Builder() {
        return new Builder();
    }

    private final String name;
    private final LocalDateTime date;
    private final AClass aClass1;
    private final AClass aClass2;
    private final List<Person> persons;
    private final Map<String,Person> personMap;
    private final Map<String,List<Person>> personsMap;
    private final Set<Person> personSet;
    
    @SuppressWarnings("unused")
	private AComplexClass() {
    	
    	// Added this to allow Kryo to deserialize from a file.
    	
    	name = null;
    	date = null;
    	aClass1 = null;
    	aClass2 = null;
    	persons = null;
    	personMap = null;
    	personsMap = null;
    	personSet = null;
    }

    public AComplexClass(String name, LocalDateTime date, AClass aClass1, AClass aClass2, List<Person> persons, Map<String,Person> personMap, Map<String,List<Person>> personsMap, Set<Person> personSet) {

        this.name = name;
        this.date = date;
        this.aClass1 = aClass1;
        this.aClass2 = aClass2;
        this.persons = persons;
        this.personMap = personMap;
        this.personsMap = personsMap;
        this.personSet = personSet;
    }

    private AComplexClass(Builder builder) {

        this.name = builder.name;
        this.date = builder.date;
        this.aClass1 = builder.aClass1;
        this.aClass2 = builder.aClass2;
        this.persons = builder.persons;
        this.personMap = builder.personMap;
        this.personsMap = builder.personsMap;
        this.personSet = builder.personSet;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public AClass getAClass1() {
        return aClass1;
    }

    public AClass getAClass2() {
        return aClass2;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Map<String,Person> getPersonMap() {
        return personMap;
    }

    public Map<String,List<Person>> getPersonsMap() {
        return personsMap;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    @Override
    public String toString() {
        return "AComplexClass [" +
            "name=" + ((name != null) ? "\"" + name + "\"" : "null") +
            ", date=" + ((date != null) ? date.toString() : "null") +
            ", aClass1=" + ((aClass1 != null) ? aClass1.toString() : "null") +
            ", aClass2=" + ((aClass2 != null) ? aClass2.toString() : "null") +
            ", persons=" + ((persons != null) ? persons.toString() : "null") +
            ", personMap=" + ((personMap != null) ? personMap.toString() : "null") +
            ", personsMap=" + ((personsMap != null) ? personsMap.toString() : "null") +
            ", personSet=" + ((personSet != null) ? personSet.toString() : "null") +
            "]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aClass1 == null) ? 0 : aClass1.hashCode());
		result = prime * result + ((aClass2 == null) ? 0 : aClass2.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((personMap == null) ? 0 : personMap.hashCode());
		result = prime * result + ((personSet == null) ? 0 : personSet.hashCode());
		result = prime * result + ((persons == null) ? 0 : persons.hashCode());
		result = prime * result + ((personsMap == null) ? 0 : personsMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AComplexClass other = (AComplexClass) obj;
		if (aClass1 == null) {
			if (other.aClass1 != null)
				return false;
		} else if (!aClass1.equals(other.aClass1))
			return false;
		if (aClass2 == null) {
			if (other.aClass2 != null)
				return false;
		} else if (!aClass2.equals(other.aClass2))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personMap == null) {
			if (other.personMap != null)
				return false;
		} else if (!personMap.equals(other.personMap))
			return false;
		if (personSet == null) {
			if (other.personSet != null)
				return false;
		} else if (!personSet.equals(other.personSet))
			return false;
		if (persons == null) {
			if (other.persons != null)
				return false;
		} else if (!persons.equals(other.persons))
			return false;
		if (personsMap == null) {
			if (other.personsMap != null)
				return false;
		} else if (!personsMap.equals(other.personsMap))
			return false;
		return true;
	}

}

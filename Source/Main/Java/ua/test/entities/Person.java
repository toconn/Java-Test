package ua.test.entities;
/**
 * Created with CodeCrank.net
 *
 * Template: Java Object
 * Version:  3.0
*/
public class Person {

	private String firstName = "";
	private String lastName = "";
	private String gender = "";
	private int age = 0;

	public Person() {}
	
	public Person (String firstName, String lastName, String gender, int age) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getGender() { return gender; }
	public int getAge() { return age; }

	public void setFirstName (String firstName) { this.firstName = firstName; }
	public void setLastName (String lastName) { this.lastName = lastName; }
	public void setGender (String gender) { this.gender = gender; }
	public void setAge (int age) { this.age = age; }

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age + "]";
	}
	
	public String fullName() {
		
		return firstName + " " + lastName;
	}
	
	public void printFullName() {
		
		System.out.println (fullName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
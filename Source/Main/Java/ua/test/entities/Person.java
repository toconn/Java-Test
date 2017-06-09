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
}
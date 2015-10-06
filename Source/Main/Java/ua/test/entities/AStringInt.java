package ua.test.entities;
public class AStringInt {

	private String aString;
	private int anInt;

	public AStringInt () {}

	public AStringInt (String aString, int anInt) {

		this.aString = aString;
		this.anInt = anInt;
	}

	public AStringInt copy() {
		
		AStringInt aStringInt = new AStringInt();

		aStringInt.aString = this.aString;
		aStringInt.anInt = this.anInt;

		return aStringInt;
	}

	public String getAString() { return aString; }
	public int getAnInt() { return anInt; }

	public void setAString (String aString) { this.aString = aString; }
	public void setAnInt (int anInt) { this.anInt = anInt; }

	@Override
	public String toString() {
		return "AStringInt [aString=" + aString + ", anInt=" + anInt + "]";
	}
}

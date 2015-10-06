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

	@Override
	public int hashCode () {

		final int prime = 31;
		int result = 1;
		result = prime * result + ( (aString == null) ? 0 : aString.hashCode ());
		result = prime * result + anInt;
		return result;
	}

	@Override
	public boolean equals (Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass () != obj.getClass ())
			return false;
		AStringInt other = (AStringInt) obj;
		if (aString == null) {
			if (other.aString != null)
				return false;
		}
		else if (!aString.equals (other.aString))
			return false;
		if (anInt != other.anInt)
			return false;
		return true;
	}
}

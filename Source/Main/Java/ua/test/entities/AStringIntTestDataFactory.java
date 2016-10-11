package ua.test.entities;
public class AStringIntTestDataFactory {

	// A_STRING_INT_1

	public static final String A_STRING_INT_1_A_STRING = "A String 1";
	public static final int A_STRING_INT_1_AN_INT = 1;

	// A_STRING_INT_2

	public static final String A_STRING_INT_2_A_STRING = "A String 2";
	public static final int A_STRING_INT_2_AN_INT = 2;


	public static AStringInt newAStringIntEmpty() {

		AStringInt item = new AStringInt();

		return item;
	}

	public static AStringInt newAStringIntEmptyDefaults() {

		AStringInt item = new AStringInt();

		item.setAString ("");
		item.setAnInt (0);

		return item;
	}

	public static AStringInt newAStringInt1() {

		AStringInt item = new AStringInt();

		item.setAString (A_STRING_INT_1_A_STRING);
		item.setAnInt (A_STRING_INT_1_AN_INT);

		return item;
	}

	public static AStringInt newAStringInt2() {


		AStringInt item = new AStringInt();

		item.setAString (A_STRING_INT_2_A_STRING);
		item.setAnInt (A_STRING_INT_2_AN_INT);

		return item;
	}
}

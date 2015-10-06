package ua.test.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class AClassTestDataFactory {

	// A_CLASS_1

	public static final boolean A_CLASS_1_A_BOOLEAN = true;
	public static final Date A_CLASS_1_A_DATE = new Date (1444144454790l);
	public static final BigDecimal A_CLASS_1_A_BIG_DECIMAL = new BigDecimal ("12.34");
	public static final double A_CLASS_1_A_DOUBLE = 23.45d;
	public static final float A_CLASS_1_A_FLOAT = 34.56f;
	public static final int A_CLASS_1_AN_INT = 4567;
	public static final LocalDate A_CLASS_1_A_LOCAL_DATE = LocalDate.of (2015, 10, 06);
	public static final LocalDateTime A_CLASS_1_A_LOCAL_DATE_TIME = LocalDateTime.of (2015, 10, 07, 8, 9, 10);
	public static final LocalTime A_CLASS_1_A_LOCAL_TIME = LocalTime.of (11, 12, 13);
	public static final long A_CLASS_1_A_LONG = 5678;
	public static final String A_CLASS_1_A_STRING = "String 6789";

	// A_CLASS_2

	public static final boolean A_CLASS_2_A_BOOLEAN = true;
	public static final Date A_CLASS_2_A_DATE = new Date (1444144454790l);
	public static final BigDecimal A_CLASS_2_A_BIG_DECIMAL = new BigDecimal ("212.34");
	public static final double A_CLASS_2_A_DOUBLE = 223.45d;
	public static final float A_CLASS_2_A_FLOAT = 234.56f;
	public static final int A_CLASS_2_AN_INT = 24567;
	public static final LocalDate A_CLASS_2_A_LOCAL_DATE = LocalDate.of (2015, 11, 7);
	public static final LocalDateTime A_CLASS_2_A_LOCAL_DATE_TIME = LocalDateTime.of (2015, 11, 9, 9, 10, 11);
	public static final LocalTime A_CLASS_2_A_LOCAL_TIME = LocalTime.of (12, 13, 14);
	public static final long A_CLASS_2_A_LONG = 0;
	public static final String A_CLASS_2_A_STRING = "String 7890";

	public static AClass newAClassEmpty() {

		AClass item = new AClass();

		return item;
	}

	public static AClass newAClass_Empty() {

		AClass item = new AClass.Builder()
			.aBoolean (true)
			.aDate (new Date())
			.aBigDecimal (new BigDecimal("0.0"))
			.aDouble (0.0d)
			.aFloat (0.0f)
			.anInt (0)
			.aLocalDate (LocalDate.now())
			.aLocalDateTime (LocalDateTime.now())
			.aLocalTime (LocalTime.now())
			.aLong (0)
			.aString ("")
			.build();

		return item;
	}

	public static AClass newAClass_Null() {

		AClass item = new AClass.Builder()
			.aBoolean (true)
			.aDate (null)
			.aBigDecimal (null)
			.aDouble (0.0d)
			.aFloat (0.0f)
			.anInt (0)
			.aLocalDate (null)
			.aLocalDateTime (null)
			.aLocalTime (null)
			.aLong (0)
			.aString (null)
			.build();

		return item;
	}

	public static AClass newAClass1() {

		AClass item = new AClass.Builder()
			.aBoolean (A_CLASS_1_A_BOOLEAN)
			.aDate (A_CLASS_1_A_DATE)
			.aBigDecimal (A_CLASS_1_A_BIG_DECIMAL)
			.aDouble (A_CLASS_1_A_DOUBLE)
			.aFloat (A_CLASS_1_A_FLOAT)
			.anInt (A_CLASS_1_AN_INT)
			.aLocalDate (A_CLASS_1_A_LOCAL_DATE)
			.aLocalDateTime (A_CLASS_1_A_LOCAL_DATE_TIME)
			.aLocalTime (A_CLASS_1_A_LOCAL_TIME)
			.aLong (A_CLASS_1_A_LONG)
			.aString (A_CLASS_1_A_STRING)
			.build();

		return item;
	}

	public static AClass newAClass1_NullDates() {

		AClass item = new AClass.Builder()
			.aBoolean (A_CLASS_1_A_BOOLEAN)
			.aDate (null)
			.aBigDecimal (A_CLASS_1_A_BIG_DECIMAL)
			.aDouble (A_CLASS_1_A_DOUBLE)
			.aFloat (A_CLASS_1_A_FLOAT)
			.anInt (A_CLASS_1_AN_INT)
			.aLocalDate (null)
			.aLocalDateTime (null)
			.aLocalTime (null)
			.aLong (A_CLASS_1_A_LONG)
			.aString (A_CLASS_1_A_STRING)
			.build();

		return item;
	}

	public static AClass newAClass2() {


		AClass item = new AClass.Builder()
			.aBoolean (A_CLASS_2_A_BOOLEAN)
			.aDate (A_CLASS_2_A_DATE)
			.aBigDecimal (A_CLASS_2_A_BIG_DECIMAL)
			.aDouble (A_CLASS_2_A_DOUBLE)
			.aFloat (A_CLASS_2_A_FLOAT)
			.anInt (A_CLASS_2_AN_INT)
			.aLocalDate (A_CLASS_2_A_LOCAL_DATE)
			.aLocalDateTime (A_CLASS_2_A_LOCAL_DATE_TIME)
			.aLocalTime (A_CLASS_2_A_LOCAL_TIME)
			.aLong (A_CLASS_2_A_LONG)
			.aString (A_CLASS_2_A_STRING)
			.build();

		return item;
	}
}

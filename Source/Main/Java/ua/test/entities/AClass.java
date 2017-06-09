package ua.test.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class AClass {

	public static class Builder {

		private boolean aBoolean;
		private Date aDate;
		private BigDecimal aBigDecimal;
		private double aDouble;
		private float aFloat;
		private int anInt;
		private LocalDate aLocalDate;
		private LocalDateTime aLocalDateTime;
		private LocalTime aLocalTime;
		private long aLong;
		private String aString;

		public Builder aBoolean (boolean aBoolean) { this.aBoolean = aBoolean; return this; }
		public Builder aDate (Date aDate) { this.aDate = aDate; return this; }
		public Builder aBigDecimal (BigDecimal aBigDecimal) { this.aBigDecimal = aBigDecimal; return this; }
		public Builder aDouble (double aDouble) { this.aDouble = aDouble; return this; }
		public Builder aFloat (float aFloat) { this.aFloat = aFloat; return this; }
		public Builder anInt (int anInt) { this.anInt = anInt; return this; }
		public Builder aLocalDate (LocalDate aLocalDate) { this.aLocalDate = aLocalDate; return this; }
		public Builder aLocalDateTime (LocalDateTime aLocalDateTime) { this.aLocalDateTime = aLocalDateTime; return this; }
		public Builder aLocalTime (LocalTime aLocalTime) { this.aLocalTime = aLocalTime; return this; }
		public Builder aLong (long aLong) { this.aLong = aLong; return this; }
		public Builder aString (String aString) { this.aString = aString; return this; }

		public AClass build() { return new AClass (this); }
	}

	private boolean aBoolean;
	private Date aDate;
	private BigDecimal aBigDecimal;
	private double aDouble;
	private float aFloat;
	private int anInt;
	private LocalDate aLocalDate;
	private LocalDateTime aLocalDateTime;
	private LocalTime aLocalTime;
	private long aLong;
	private String aString;

	public AClass () {}

	public AClass (boolean aBoolean, Date aDate, BigDecimal aBigDecimal, double aDouble, float aFloat, int anInt, LocalDate aLocalDate, LocalDateTime aLocalDateTime, LocalTime aLocalTime, long aLong, String aString) {

		this.aBoolean = aBoolean;
		this.aDate = aDate;
		this.aBigDecimal = aBigDecimal;
		this.aDouble = aDouble;
		this.aFloat = aFloat;
		this.anInt = anInt;
		this.aLocalDate = aLocalDate;
		this.aLocalDateTime = aLocalDateTime;
		this.aLocalTime = aLocalTime;
		this.aLong = aLong;
		this.aString = aString;
	}

	private AClass (Builder builder) {

		this.aBoolean = builder.aBoolean;
		this.aDate = builder.aDate;
		this.aBigDecimal = builder.aBigDecimal;
		this.aDouble = builder.aDouble;
		this.aFloat = builder.aFloat;
		this.anInt = builder.anInt;
		this.aLocalDate = builder.aLocalDate;
		this.aLocalDateTime = builder.aLocalDateTime;
		this.aLocalTime = builder.aLocalTime;
		this.aLong = builder.aLong;
		this.aString = builder.aString;
	}

	public AClass copy() {
		
		AClass aClass = new AClass();

		aClass.aBoolean = this.aBoolean;
		aClass.aDate = this.aDate;
		aClass.aBigDecimal = this.aBigDecimal;
		aClass.aDouble = this.aDouble;
		aClass.aFloat = this.aFloat;
		aClass.anInt = this.anInt;
		aClass.aLocalDate = this.aLocalDate;
		aClass.aLocalDateTime = this.aLocalDateTime;
		aClass.aLocalTime = this.aLocalTime;
		aClass.aLong = this.aLong;
		aClass.aString = this.aString;

		return aClass;
	}

	public boolean isABoolean() { return aBoolean; }
	public Date getADate() { return aDate; }
	public BigDecimal getABigDecimal() { return aBigDecimal; }
	public double getADouble() { return aDouble; }
	public float getAFloat() { return aFloat; }
	public int getAnInt() { return anInt; }
	public LocalDate getALocalDate() { return aLocalDate; }
	public LocalDateTime getALocalDateTime() { return aLocalDateTime; }
	public LocalTime getALocalTime() { return aLocalTime; }
	public long getALong() { return aLong; }
	public String getAString() { return aString; }

	public void setABoolean (boolean aBoolean) { this.aBoolean = aBoolean; }
	public void setADate (Date aDate) { this.aDate = aDate; }
	public void setABigDecimal (BigDecimal aBigDecimal) { this.aBigDecimal = aBigDecimal; }
	public void setADouble (double aDouble) { this.aDouble = aDouble; }
	public void setAFloat (float aFloat) { this.aFloat = aFloat; }
	public void setAnInt (int anInt) { this.anInt = anInt; }
	public void setALocalDate (LocalDate aLocalDate) { this.aLocalDate = aLocalDate; }
	public void setALocalDateTime (LocalDateTime aLocalDateTime) { this.aLocalDateTime = aLocalDateTime; }
	public void setALocalTime (LocalTime aLocalTime) { this.aLocalTime = aLocalTime; }
	public void setALong (long aLong) { this.aLong = aLong; }
	public void setAString (String aString) { this.aString = aString; }

	// @Override
	public String toString1() {
		return "AClass [aBoolean=" + aBoolean + ", aDate=" + aDate.toString() + ", aBigDecimal=" + aBigDecimal.toString() + ", aDouble=" + aDouble + ", aFloat=" + aFloat + ", anInt=" + anInt + ", aLocalDate=" + aLocalDate.toString() + ", aLocalDateTime=" + aLocalDateTime.toString() + ", aLocalTime=" + aLocalTime.toString() + ", aLong=" + aLong + ", aString=" + aString + "]";
	}
	
	

	@Override
	public String toString () {

		return "AClass [aBoolean=" + aBoolean + ", aDate=" + aDate + ", aBigDecimal=" + aBigDecimal + ", aDouble=" + aDouble + ", aFloat=" + aFloat + ", anInt="
				+ anInt + ", aLocalDate=" + aLocalDate + ", aLocalDateTime=" + aLocalDateTime + ", aLocalTime=" + aLocalTime + ", aLong=" + aLong + ", aString="
				+ aString + "]";
	}

	@Override
	public int hashCode () {

		final int prime = 31;
		int result = 1;
		result = prime * result + ( (aBigDecimal == null) ? 0 : aBigDecimal.hashCode ());
		result = prime * result + (aBoolean ? 1231 : 1237);
		result = prime * result + ( (aDate == null) ? 0 : aDate.hashCode ());
		long temp;
		temp = Double.doubleToLongBits (aDouble);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits (aFloat);
		result = prime * result + ( (aLocalDate == null) ? 0 : aLocalDate.hashCode ());
		result = prime * result + ( (aLocalDateTime == null) ? 0 : aLocalDateTime.hashCode ());
		result = prime * result + ( (aLocalTime == null) ? 0 : aLocalTime.hashCode ());
		result = prime * result + (int) (aLong ^ (aLong >>> 32));
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
		AClass other = (AClass) obj;
		if (aBigDecimal == null) {
			if (other.aBigDecimal != null)
				return false;
		}
		else if (!aBigDecimal.equals (other.aBigDecimal))
			return false;
		if (aBoolean != other.aBoolean)
			return false;
		if (aDate == null) {
			if (other.aDate != null)
				return false;
		}
		else if (!aDate.equals (other.aDate))
			return false;
		if (Double.doubleToLongBits (aDouble) != Double.doubleToLongBits (other.aDouble))
			return false;
		if (Float.floatToIntBits (aFloat) != Float.floatToIntBits (other.aFloat))
			return false;
		if (aLocalDate == null) {
			if (other.aLocalDate != null)
				return false;
		}
		else if (!aLocalDate.equals (other.aLocalDate))
			return false;
		if (aLocalDateTime == null) {
			if (other.aLocalDateTime != null)
				return false;
		}
		else if (!aLocalDateTime.equals (other.aLocalDateTime))
			return false;
		if (aLocalTime == null) {
			if (other.aLocalTime != null)
				return false;
		}
		else if (!aLocalTime.equals (other.aLocalTime))
			return false;
		if (aLong != other.aLong)
			return false;
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

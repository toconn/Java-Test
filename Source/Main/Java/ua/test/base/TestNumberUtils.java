package ua.test.base;

import java.util.Random;

public class TestNumberUtils extends TestBase {

	public static int newRandomInt (int maxValue) {
		
		return new Random ().nextInt (maxValue + 1);
	}
	

	public static long newRandomLong (long maxValue) {

		return (long) (new Random().nextDouble() * (maxValue + 1));
	}
}

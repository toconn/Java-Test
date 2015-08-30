package ua.test.base;

import java.io.InputStream;
import java.util.Scanner;

public class TestIOUtils {

	public static String asString (InputStream inputStream) {
		
		Scanner inputScanner2;
		String	inputString = null;

		try (Scanner inputScanner = new Scanner (inputStream, "UTF-8")) {
		
			inputScanner2	= inputScanner.useDelimiter("\\A");
			
			if (inputScanner2.hasNext()) {
				inputString = inputScanner2.next();
			}
		}

		return inputString;
	}
}

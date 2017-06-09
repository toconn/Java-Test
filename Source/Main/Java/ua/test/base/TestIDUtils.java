package ua.test.base;

import java.text.DecimalFormat;

public class TestIDUtils {

	public static String newID () {
		
		// DECLARATIONS:

		long			id;
		String			idString;
		
		DecimalFormat	formatter;
		
		
		// CODE:

		formatter	= new DecimalFormat ("0000000000");
		
		id			= Math.round ((Math.random() * 9999999999l));
		idString	= formatter.format (id);
		
		return idString;
	}
	
}

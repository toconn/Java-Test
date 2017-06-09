package ua.test.base;

import java.util.List;


public class TestSystemUtils extends TestBase {
	
	public static void printSystemProps () {
		
		// DECLARATIONS:
		
		List <String>	sortedKeyList;


		// CODE:

		// Get sorted keys...
		
		sortedKeyList = TestCollectionUtils.asSortedList (System.getProperties ().stringPropertyNames ());
		
		// Print...
		
		for (String key: sortedKeyList) {
			
			print (key, System.getProperty (key));
		}
	}
	
	public static void sleep (long milliseconds) {
		
		try {
			
			Thread.sleep (milliseconds);
		}
		catch (InterruptedException e) {

		}
	}
}

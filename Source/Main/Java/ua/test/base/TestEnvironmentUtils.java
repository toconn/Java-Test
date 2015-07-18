package ua.test.base;

import java.util.ArrayList;
import java.util.List;

public class TestEnvironmentUtils {

	/**
	 * Returns a list of strings with the string environment variables expanded.
	 * 
	 * Null safe (returns empty list).
	 * 
	 * @param textList
	 * @return
	 */
	public static List <String> evaluateVariables (List <String> textList) {
		
		// DECLARATIONS:
		
		List <String>	list;
		
		
		// MAIN:
		
		list = new ArrayList <String> ();
		
		if (TestCollectionUtils.isNotEmpty (textList)) {
			
			for (String text : textList) {
				list.add (evaluateVariables (text));
			}
		}
		
		return list;
	}
	
	/**
	 * Returns a string with the environment variables expanded.
	 * 
	 * Null safe (returns empty list).
	 * 
	 * @param textList
	 * @return
	 */
	public static String evaluateVariables (String text) {
		
		// ///////////////////////////////////////////////////////////////
		//   Declarations
		// ///////////////////////////////////////////////////////////////

    	String			envName					= null;
    	String			envValue				= null;
    	
		StringBuilder	expandedStringBuilder	= null;
		
		int				previousIndex			= 0;
		int				nextIndex				= 0;
		
		boolean			startingPercentFound	= false;


		// ///////////////////////////////////////////////////////////////
		//   Code
		// ///////////////////////////////////////////////////////////////

		if (TestStringUtils.isNotEmpty (text)) {
			
			expandedStringBuilder = new StringBuilder ();
			
			while (nextIndex > -1 && previousIndex < text.length ()) {
				
		    	// find next %
				
				nextIndex = text.indexOf ('%', previousIndex);
				
				if (nextIndex > -1) {
		    	
					if (! startingPercentFound) {
						
						// if opening %...
		    	
						// append previous text to return string
						
						expandedStringBuilder.append (text.substring (previousIndex, nextIndex));
						
						
		    			// update previous index...
					
						previousIndex = nextIndex + 1;
						startingPercentFound = true;
						
					}
					else {
		    		
						// if closing %...
						
						// lookup environment variable...
						
						if (previousIndex < nextIndex - 1) {
						
							envName  = text.substring (previousIndex, nextIndex);
							envValue = System.getenv (envName);
						}
						else {
							
							envValue = null;
						}
		    	
		    			if (TestStringUtils.isNotEmpty (envValue)) {
		    				
		    				// Append environment value...
		    				
		    				expandedStringBuilder.append (envValue);
		    			}
		    			else {
		    				
		    				// Has no value. Append as it was in original string...
		    				
		    				expandedStringBuilder.append (text.substring (previousIndex -1, nextIndex + 1));
		    			}

		    			
		    			// update previous index...
						
						previousIndex = nextIndex + 1;
						startingPercentFound = false;
					}
				}

			}
			
			if (previousIndex < text.length ()) {
				
				// Append remaining text
				expandedStringBuilder.append (text.substring (previousIndex));
			}
	    	
	    	// return string
				
			return expandedStringBuilder.toString ();
			
		}
	    else {
	    	
	    	return null;
	    }
	}
}

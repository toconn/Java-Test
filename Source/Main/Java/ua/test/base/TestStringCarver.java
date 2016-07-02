package ua.test.base;
/**
 * StringCarver is a string manipulation class that allows you to locate, slice and return portions
 * of a string.
 * 
 * @author toconnell
 *
 */
public class TestStringCarver {
	

	/**
	 * EMPTY_STRING is always returned when nothing is found.
	 */
	public static String	EMPTY_STRING	= "";
	
	
	/**
	 * Returns the portion of text after the last instance of matchText in another string.
	 * EMPTY_STRING is returned if there is no match.
	 * 
	 * Ex:	text		ua.util.StringCarver
	 * 		matchText	.
	 * 
	 * 		returned	StringCarver
	 * 
	 * @param text
	 * @param lastString
	 * @return
	 */
	public static String getAfterLastMatch (String text, String matchText) {
		
		////////////////////////////////////////////////////////
		// Declarations
		////////////////////////////////////////////////////////

		int		pointer		= 0;	
		String	textSlice	= null;
	
		
		////////////////////////////////////////////////////////
		// Code
		////////////////////////////////////////////////////////

		textSlice = EMPTY_STRING;
		
		if (text != null && matchText != null) {
			
			// Check to see if matchText exists and there is text after it.
			
			pointer = text.lastIndexOf (matchText);
			
			if (pointer != -1 && pointer < text.length() -1) {	// text length -1... ensures there is text after the pointer position.
				
				// Return text after the pointer position.
				
				textSlice = text.substring (pointer + 1);
			}
		}

		return textSlice;
	}
	
	
	
	/**
	 * Returns the portion of text before the last instance of matchText.
	 * EMPTY_STRING is returned if there is no match.
	 * 
	 * Ex:	text		ua.util.StringCarver
	 * 		matchText	.
	 * 
	 * 		returned	ua.util

	 * @param text
	 * @param matchText
	 * @return
	 */
	public static String getBeforeLastMatch (String text, String matchText) {
		
		////////////////////////////////////////////////////////
		// Declarations
		////////////////////////////////////////////////////////

		int		pointer		= 0;	
		String	textSlice	= null;
	
		
		////////////////////////////////////////////////////////
		// Code
		////////////////////////////////////////////////////////

		textSlice = EMPTY_STRING;
		
		if (text != null && matchText != null) {
			
			// Check to see if matchText exists and it isn't in the first position...
			
			pointer = text.lastIndexOf (matchText);
			
			if (pointer > 0 ) {
				
				// Return text before the pointer position.
				
				textSlice = text.substring (0, pointer -1);
			}
		}

		return textSlice;
	}
}

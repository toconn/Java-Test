package ua.test.base;

import java.text.MessageFormat;
import java.util.*;

/**
 * @author: Tadhg Ua Conaill
 * @version: 1.00.00
 * 
 * A collection of static String manipulation methods.
 * 
 * Created - 2001.10.31 - 'Creation date: (31/10/2001)'
 * 
 * Updated - 2013.11.22 - Changed toString ([], Separator) to .join ([], Separator)
 * 
 */
public class TestStringUtils {
	
	public static int		INDENT_SPACE_COUNT	= 4;
	

	public static String asNonNullString (String text) {
	
		if (text == null)
			
			return "";

		else
	
			return text;

	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (2002/04/12 6:34:20 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param spText java.lang.String
	 */
	public static String characterValues (String text) {
	
		///////////////////////////////////////////
		// Declarations -
		///////////////////////////////////////////
	
		int				i;
		StringBuffer	characterValues	= null;
		
	
		///////////////////////////////////////////
		// Code -
		///////////////////////////////////////////
	
		characterValues = new StringBuffer (text.length() * 3 - 1);
		
		for (i = 0; i < text.length(); i++) {
	
			characterValues.append (i == 0 ? "" : " ");
			characterValues.append (Integer.toHexString ((int) text.charAt (i)));
		}
		
		return characterValues.toString();
	
	}
	
	
	public static int compare (String value1, String value2) {
	
		if (value1 == null) {
			
			if (value2 == null) {
				
				// Both null. They are equal.
				
				return 0;
			}
			else {
				
				// This object is null only. The other object is greater.
				
				return -1;
			}
			
		}
		else if (value2 == null) {
			
			// The compare object is null only. This object is greater.
			
			return 1;
		}
		else {
			
			// Do a string compare.
			
			return (toLowerCase (value1)).compareTo (toLowerCase (value2));
		}
		
	}
	
	
	
	
	public static boolean contains (String mainString, String matchString) {
		
		///////////////////////////////////////////
		// Code:
		///////////////////////////////////////////
	
		if (mainString != null && matchString != null) {
			
			return mainString.toLowerCase ().contains (matchString.toLowerCase ());
		}
		else if (mainString == null && matchString == null) {
			
			return true;
		}
		else {
		
			return false;
		}
		
	}


	/**
	 * Checks to see if a string contains any of the strings in the match string array.
	 * 
	 * This method is null safe. If both are null, returns true.
	 * 
	 * @param mainString
	 * @param matchString
	 * @return
	 */
	public static boolean contains (String mainString, String[] matchStringArray) {
		
		///////////////////////////////////////////
		// Code:
		///////////////////////////////////////////
	
		if (mainString != null && matchStringArray != null) {
			
			for (String matchString : matchStringArray) {
				if (mainString.contains (matchString.toLowerCase ())) {
					return true;
				}
			}
			
			return false;
		}
		else {
			return false;
		}
	}
	
	public static boolean contains (String[] stringArray, String matchString) {
		
		///////////////////////////////////////////
		// Code:
		///////////////////////////////////////////
	
		if (stringArray != null && matchString != null) {
			
			for (String string: stringArray) {
				
				if (contains (matchString,string)) {
				
					return true;
				}
			}
		}
		
		return false;
	}


	public static boolean containsLine (String[] stringArray, String matchString) {
		
		///////////////////////////////////////////
		// Declarations:
		///////////////////////////////////////////
		
		int i;
	
		///////////////////////////////////////////
		// Code:
		///////////////////////////////////////////
	
		if (stringArray != null && matchString != null) {
			
			for (i = 0; i < stringArray.length; i ++) {
				
				if (isEqual (stringArray [i], matchString)) {
				
					return true;
				}
			
			}
		
			
		}
		
		return false;
		
	}
	
	
	/**
	 * Checks that every character in the string is in the character list.
	 * if one of the string characters doesn't match, the method will return
	 * false.
	 * 
	 * Creation date: (2003/02/10 6:46:01 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return boolean
	 * @param originalString java.lang.String
	 * @param charArray char[]
	 */
	public static boolean containsOnly (String originalString, char[] acceptibleCharsArray) {
	
		/////////////////////////////////
		// Declarations:
		/////////////////////////////////
	
		int		stringIndex;
		int		charIndex;
		char	charItem;
	
		boolean	isValid;
		boolean charFound;
	
	
		/////////////////////////////////
		// Code:
		/////////////////////////////////
	
		isValid =  true;
	
		if (originalString != null) {
	
			// Loop through all chars in the string.
			
			for (stringIndex = 0; isValid && stringIndex < originalString.length(); stringIndex ++) {
	
				charItem	= originalString.charAt (stringIndex);
				charFound	= false;
	
				// loop through acceptible character list.
				
				for (charIndex = 0; ! charFound && charIndex < acceptibleCharsArray.length; charIndex ++) {
	
					if (charItem == acceptibleCharsArray[charIndex]) {
	
						// found a match. character is ok.
	
						charFound = true;
	
					}
	
				}
	
				if (! charFound) {
	
					// No matching character found. Invalid character.
	
					isValid = false;
	
				}
	
			}
	
		}
		
		return isValid;
	}
	
	
	public static String expandArray (String[] textArray, String separatorText) {
		
		// Expands an array into a string separated by the separator text.
		
		//////////////////////////////////////////////////////////////////
		// Declarations:
		//////////////////////////////////////////////////////////////////
		
		int				i;
		
		StringBuffer	concatStringBuffer = null;
		
		
		//////////////////////////////////////////////////////////////////
		// Code:
		//////////////////////////////////////////////////////////////////
		
		if (textArray != null && textArray.length > 0) {

			concatStringBuffer = new StringBuffer ();
			
			for (i = 0; i < textArray.length; i++) {
				
				if (i != 0) {
					
					concatStringBuffer.append (separatorText);
				}
				
				concatStringBuffer.append (textArray [i]);
			}
			
			return concatStringBuffer.toString();
		}
		else {
			
			return "";
		}
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (2002/04/11 4:54:09 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param expandChar char
	 * @param expandCount int
	 */
	public static String expandString(char expandChar, int expandCount) {
	
		///////////////////////////////////////////
		// Declarations -
		///////////////////////////////////////////
	
		char[]	charArray = null;
		int		i;
	
	
		///////////////////////////////////////////
		// Code -
		///////////////////////////////////////////
	
		if (expandChar != 0 && expandCount > 0) {
	
			charArray = new char[expandCount];
	
	
			for (i = 0; i < expandCount; i++) {
	
				charArray[i] =  expandChar;
			}
	
			return new String (charArray);
	
		}
		else {
			
			return "";
		}
	}
	
	
	/**
	 * Expands a string by a given number of times.
	 * 
	 * Creation date: (2002/04/11 4:54:09 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param expandString String
	 * @param expandCount int
	 */
	public static String expandString(String expandString, int expandCount) {
	
		///////////////////////////////////////////
		// Declarations -
		///////////////////////////////////////////
	
		StringBuffer	expandedStringBuffer = null;
		int				i;
	
	
		///////////////////////////////////////////
		// Code -
		///////////////////////////////////////////
	
		if (expandString != null && expandString.length() > 0 && expandCount > 0) {
	
			// Create buffer to final string size.
	
			expandedStringBuffer = new StringBuffer (expandString.length() * expandCount);
	
	
			// Build string.
			
			for (i = 0; i < expandCount; i++) {
	
				expandedStringBuffer.append (expandString);
			}
	
			return expandedStringBuffer.toString();
	
		}
		else {
			
			return "";
		}
	}
	
	
	public static String expandStrings (String leadString, String endString, int length) {
	
		return (leadString + expandString (' ', length - leadString.length()) + endString);
	}
	
	
	public static String getFormattedMessage (String formatString, Object[] objects) {
		
		// ///////////////////////////////////////////////////////////////
		//   Declarations
		// ///////////////////////////////////////////////////////////////

		MessageFormat	messageFormat;

		String			message;


		// ///////////////////////////////////////////////////////////////
		//   Code
		// ///////////////////////////////////////////////////////////////

		messageFormat	= new MessageFormat (formatString);
		message			= messageFormat.format (objects);
		
		return message;
	}
	
	/**
	 * Creates a padding string large enough to fill the pad length.
	 * 
	 * @param text
	 * @param fillText
	 * @param padLength
	 * @return
	 */
	public static String getPaddingString (String text, String fillText, int padLength) {
	
		return expandString (fillText, padLength - text.length());
	}
	
	
	public static String indent (int indentCount) {
		
		return expandString (' ', indentCount * INDENT_SPACE_COUNT);
	}
	
	
	/**
	 * Returns true if a string is null or just empty white space.
	 * Otherwise false.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isBlank (String string) {
		
		if (string == null || string.trim ().length () == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static boolean isCharEqual (char char1, String string2) {
		
		if (string2 != null && string2.length() > 0) {
			
			if (Character.toLowerCase(char1) == Character.toLowerCase(string2.charAt(0))) {
			
				return true;
			}
		}
		
		return false;
		
	}
	

	public static boolean isContains (String text, String searchText) {
		
		if (isNotEmpty (text) && text.length() >= searchText.length()) {
				
			return text.toLowerCase().indexOf (searchText.toLowerCase ()) != -1;
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (31/10/2001)
	 * @author: Tim O'Connell
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return boolean
	 * @param newString java.lang.String
	 */
	public static boolean isEmpty(String text) {
	
		if (text == null) {
			
			return true;
			
		}
		else if (text.equals ("")) {
			
			return true;
			
		}
		else {
		
			return false;
	
		}
	}
	
	
	public static boolean isEndsWith (String text, char endingChar) {
		
		if (isNotEmpty (text) && text.length() >= 1) {
				
			return Character.toLowerCase (text.charAt (text.length () - 1)) ==  Character.toLowerCase (endingChar);
		}
		
		return false;
	}
	
	
	public static boolean isEndsWith (String text, String endString) {
		
		if (isNotEmpty (text) && isNotEmpty (endString) && text.length() >= endString.length ()) {
				
			return text.toLowerCase ().endsWith (endString.toLowerCase ());
		}
		
		return false;
	}

	
	public static boolean isEqual (char char1, char char2) {
		
		return (Character.toLowerCase(char1)  == Character.toLowerCase(char2));		
	}

	
	public static boolean isEqual (String string1, String string2) {
		
		if (isEmpty (string1)) {
			
			return isEmpty (string2);		
		}
		else {
			
			return string1.equalsIgnoreCase (string2);
		}
	}
	
	
	public static boolean isInt(String string) {
	
		final char digitArray[]			= {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		final char digitSymbolArray[]	= {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '+'};
		
		if (string == null) {
			
			return false;
		}
		else {
			return containsOnly (string.substring (0, 1), digitSymbolArray) && containsOnly (string.substring (1), digitArray);
		}
	}
	
	
	/**
	 * Returns true if a string length is not null or just white space, and has a length greater than 0.
	 * Returns false for 0 length or null strings.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNotBlank (String string) {
		
		return ! isBlank (string);
	}
	
	
	public static boolean isNotEmpty (String Text) {
		
		return ! isEmpty (Text);
	}

	
	/**
	 * Compares two strings and returns true if they are not equal.
	 * Null safe. If one is null but the other isn't, returns true.
	 * If both are null, returns false.
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static boolean isNotEqual (String string1, String string2) {
		
		return ! isEqual (string1, string2);
	}
	
	
	
	
	public static boolean isStartsWith (String text, char startingChar) {
		
		if (isNotEmpty (text) && text.length() >= 1) {
				
			return Character.toLowerCase (text.charAt (0)) ==  Character.toLowerCase (startingChar);
		}
		
		return false;
	}

	
	public static boolean isStartsWith (String text, String startingText) {
		
		if (isNotEmpty (text) && text.length() >= startingText.length()) {
				
			return isEqual (text.substring (0, startingText.length()).toLowerCase (), startingText.toLowerCase ());
		}
		
		return false;
	}
	
	public static String join (String string1, String string2, String separator) {
		
		if (string1 == null) {
			return string2;
		}
		else if (string2 == null) {
			return string1;
		}
		else {
			return string1 + separator + string2;
		}
	}
	
	public static String join (String[] strings, String separator) {
		
		//////////////////////////////////////////////////////////////////
		// Declarations
		//////////////////////////////////////////////////////////////////

		StringBuilder	stringBuilder	= null;
		
		boolean			isFirst;


		//////////////////////////////////////////////////////////////////
		// Code
		//////////////////////////////////////////////////////////////////

		stringBuilder	= new StringBuilder ();
		
		isFirst = true;
		
		for (String string : strings) {
			
			if (separator != null) {
				if (isFirst) {
					isFirst = false;
				}
				else {
					stringBuilder.append (separator);
				}
			}
			
			stringBuilder.append (string);
		}
		
		
		return stringBuilder.toString ();
	}
	
	public static String join (Collection <String> strings, String separator) {
		
		//////////////////////////////////////////////////////////////////
		// Declarations
		//////////////////////////////////////////////////////////////////

		StringBuilder	stringBuilder	= null;
		
		boolean			isFirst;


		//////////////////////////////////////////////////////////////////
		// Code
		//////////////////////////////////////////////////////////////////

		stringBuilder	= new StringBuilder ();
		
		isFirst = true;
		
		for (String string : strings) {
			
			if (separator != null) {
				if (isFirst) {
					isFirst = false;
				}
				else {
					stringBuilder.append (separator);
				}
			}
			
			stringBuilder.append (string);
		}
		
		
		return stringBuilder.toString ();
	}
	
	/**
	 * Null safe, length safe function to return the left side of a string.
	 * If less than length, returns full string.
	 * 
	 * @param text
	 * @param length
	 * @return
	 */
	public static String left (String text, int length, boolean includeEllipsis) {
		
		if (text != null && text.length () > length) {
			if (includeEllipsis) {
				return trim (text.substring (0, length)) + "...";
			}
			else {
				return text.substring (0, length);
			}
		}
		else {
			return text;
		}
	}
	
	public static String leftPad (String text, String fillText, int totalLength) {
		
		if (text != null) {
		
			return expandString (fillText, totalLength - text.length()) + text;
		}
		else {
			
			return expandString (fillText, totalLength);
		}
	}
	
	public static int length (String string) {
		
		if (string != null)
			
			return string.length ();
		
		else 
			
			return 0;
	}
	
	public static int maxLength (String[] strings) {
		
		int maxLength = 0;
		
		if (TestCollectionUtils.isNotEmpty (strings)) {
			for (String string : strings) {
				if (length (string) > maxLength) {
					maxLength = length (string);
				}
			}
		}
		
		return maxLength;
	}
	
	public static int maxLength (Collection <String> strings) {
		
		int maxLength = 0;
		
		if (TestCollectionUtils.isNotEmpty (strings)) {
			
			for (String itemString: strings) {
				if (length (itemString) > maxLength) {
					maxLength = itemString.length();
				}
			}
		}
		
		return maxLength;
	}
	
	/**
	 * Returns the word that would be next in alphabetical terms.
	 * 
	 * ABC would return ABD.
	 * 
	 * @param word
	 * @return
	 */
	public static String nextWord (String word) {
		
		char nextLetter;
		String nextWord = null;

		if (isNotEmpty (word)) {
	        nextLetter = word.charAt (word.length() - 1);	// Get last letter.
	        nextLetter++;									// Set to next letter in alphabet.
	        nextWord = word.substring (0, word.length() - 1) + nextLetter;
	    }
		
		return nextWord;
	}
	
	public static String pad (String text, int totalLength) {
		return pad (text, ' ', totalLength);
	}
	
	/**
	 * 
	 * 
	 * Creation date: (2002/10/31 10:37:10 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param text java.lang.String
	 * @param fillChar char
	 * @param totalLength int
	 */
	public static String pad (String text, char fillChar, int totalLength) {
		
		if (text != null) {
			
			return text + expandString (fillChar, totalLength - text.length());
		}
		else {
			
			return expandString (fillChar, totalLength);
		}
	}

	
	/**
	 * 
	 * 
	 * Creation date: (2002/10/31 10:36:30 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param text java.lang.String
	 * @param fillText java.lang.String
	 * @param totalLength int
	 */
	public static String pad (String text, String fillText, int totalLength) {
	
		if (text != null) {
		
			return text + expandString (fillText, totalLength - text.length());
		}
		else {
			
			return expandString (fillText, totalLength);
		}
	}
	
	
	public static String[] prependAll (String[] stringArray, String prependText) {
		
		//////////////////////////////////////////////////////////////////
		// Declarations:
		//////////////////////////////////////////////////////////////////
		
		int			i;
		
		String[]	newStringArray	= null;
		
		//////////////////////////////////////////////////////////////////
		// Code:
		//////////////////////////////////////////////////////////////////
		
		if (stringArray != null) {
			
			newStringArray = new String [stringArray.length];
			
			for (i = 0; i < stringArray.length; i++) {
				
				newStringArray [i] = prependText + stringArray [i];
			}
		}
		
		return newStringArray;    
	}
	
	public static String[] prependAllExceptBlanks (String[] stringArray, String prependText) {
		
		//////////////////////////////////////////////////////////////////
		// Declarations:
		//////////////////////////////////////////////////////////////////
		
		int			i;
		
		String[]	newStringArray	= null;
		
		//////////////////////////////////////////////////////////////////
		// Code:
		//////////////////////////////////////////////////////////////////
		
		if (stringArray != null) {
			
			newStringArray = new String [stringArray.length];
			
			for (i = 0; i < stringArray.length; i++) {
				
				if (TestStringUtils.isNotEmpty (stringArray [i])) {
				
					newStringArray [i] = prependText + stringArray [i];
				}
			}
		}
		
		return newStringArray;    
	}
	
	/**
	 * 
	 * 
	 * Creation date: (31/10/2001)
	 * @author: Tim O'Connell
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return boolean
	 */
	public static boolean stringToBoolean (String spText)
		throws java.text.ParseException {
	
		if (spText != null) {
	
			if 		(spText.equalsIgnoreCase ("True")	||
					 spText.equalsIgnoreCase ("T")		||
					 spText.equalsIgnoreCase ("Yes")	||
					 spText.equalsIgnoreCase ("Y")		||
					 spText.equalsIgnoreCase ("1")) {
					
				return true;
			}
			else if (spText.equalsIgnoreCase ("False")	||
					 spText.equalsIgnoreCase ("F")		||
					 spText.equalsIgnoreCase ("No")		||
					 spText.equalsIgnoreCase ("N")		||
					 spText.equalsIgnoreCase ("0")) {
						 
				return false;
			}
			else {
				
				throw new java.text.ParseException ("Error: StringUtils.StringToBoolean: Can't parse the string \"" + spText + "\".", 0);
			}
			
		}
		else {
			
			throw new java.text.ParseException ("Error: StrungUtils.StringToBoolean: Can't parse null string.", 0);
		}
	
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (31/10/2001)
	 * @author: Tim O'Connell
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return boolean
	 * @param newString java.lang.String
	 * @param defaultValue boolean
	 */
	public static boolean stringToBoolean (String text, boolean defaultBooleanValue) {
	
		try {
	
			return stringToBoolean (text);
			
		}
		catch (Exception e) {
	
			return defaultBooleanValue;
		}
	
	}
	
	
	public static String strip (String text, char stripChar) {
		
		// ///////////////////////////////////////////////////////////////
		//   Declarations
		// ///////////////////////////////////////////////////////////////

		int				last	= 0;
		int				next	= 0;
		
		StringBuilder	stringBuilder	= null;


		// ///////////////////////////////////////////////////////////////
		//   Code
		// ///////////////////////////////////////////////////////////////
		
		stringBuilder = new StringBuilder ();
		
		if (isNotEmpty (text)) {
			
			while (next < text.length() && next != -1) {
				
				next = text.indexOf (stripChar, last);
				
				if (next >= 0) {
					
					if (next > last + 1) {
						
						stringBuilder.append (text.subSequence (last, next));
					}
					
					last = next + 1;
				}
			}
			
			if (next == -1 && last < text.length()) {
				
				stringBuilder.append (text.substring (last, text.length()));
			}
		}
		
		
		return stringBuilder.toString ();
	}
	
	
	public static String stripQuotes (String text) {
		
		if (text != null & text.length() > 1) {
			
			if (text.charAt (0) == '"' && text.charAt (text.length() - 1) == '"') {
				
				// Has quotes. strip and return.
				
				return text.substring (1, text.length() - 1);
			}
		}
		
		return text;	// default. return the current text. it doesn't have quotes.
	}
	
	
	public static char toChar (String text) {
		
		if (text != null && text.length() > 0) {
			
			return text.charAt(0);
		}
		
		return ' ';
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (2002/10/25 4:03:21 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param spStringIn java.lang.String
	 */
	public static String toLowerCase(String spStringIn) {
	
		if (spStringIn == null) {
			
			return null;
	
		}
		else {
	
			return spStringIn.toLowerCase();
	
		}
	
	}
	
	
	/**
	 * Returns the string or "" if the string is null.
	 * 
	 * @param value
	 * @return
	 */
	public static String toNonNullString (String value) {
		
		if (value == null) {
			
			return "";
		}
		else {
			return value;
		}
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (31/10/2001)
	 * @author: Tim O'Connell
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param bValue boolean
	 */
	public static String toString (boolean bValue) {
	
		if (bValue) {
	
			return "True";
		}
		else {
			
			return "False";
		}
	
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (2002/04/04 4:22:59 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param enumerator java.util.Enumeration
	 */
	public static String toString (Enumeration <String> oEnumerator) {
	
		///////////////////////////////////////////
		// Declarations -
		///////////////////////////////////////////
		
		StringBuffer	sbContents		= null;
		
		String			sItemName		= null;
		boolean			bFinishedFirst	= false;
		
	
		///////////////////////////////////////////
		// Code -
		///////////////////////////////////////////
	
		sbContents	= new StringBuffer();
	
		// Loop through the hash table.
		for (; oEnumerator.hasMoreElements(); ) {
	
			// Retrieve an item
			sItemName		= (String) oEnumerator.nextElement();
	
			// Add separator.
			if (bFinishedFirst) {
				
				sbContents.append (", ");
			}
			else {
	
				bFinishedFirst = true;
			}
			
			// Store the contents.
			sbContents.append (sItemName);
	
		}
	
		return sbContents.toString();
			
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (01/11/2001 6:47:03 PM)
	 * @author: Tim O'Connell
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param newHashtable java.util.Hashtable
	 */
	public static String toString (Hashtable <String, ?> hpHashtable) {
		
		return toString (hpHashtable, false);
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (01/11/2001 5:00:49 PM)
	 * @author: Tim O'Connell
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 */
	public static String toString (Hashtable <String, ?> hpHashtable, boolean bpIncludeClassName) {
	
		///////////////////////////////////////////
		// Declarations -
		///////////////////////////////////////////
	
		StringBuilder			sbHashContents	= null;
		Enumeration	<String>	oHashEnumorator	= null;
		String					sItemKey		= null;
		Object					oItemObject		= null;
		
	
		///////////////////////////////////////////
		// Code -
		///////////////////////////////////////////
	
		if (hpHashtable == null) {
			
			return "null";
		}
		else {
	
			sbHashContents	= new StringBuilder();
			oHashEnumorator	= hpHashtable.keys();
	
			// Loop through the hash table.
			for (; oHashEnumorator.hasMoreElements(); ) {
	
				// Retrieve an item
				sItemKey		= oHashEnumorator.nextElement();
				oItemObject	= hpHashtable.get (sItemKey);
	
				// Store the contents.
				sbHashContents.append (sItemKey + "=");
				
				if (oItemObject instanceof String) {
					sbHashContents.append (oItemObject);
				}
				else {
	
					if (bpIncludeClassName) {
						try {
							sbHashContents.append ("[" + oItemObject.getClass().getName() + "] ");
						}
						catch (Exception e) {
							sbHashContents.append ("[** class name unavailable] ");
						}
					}
	
					try {
						sbHashContents.append (oItemObject);
					}
					catch (Exception e) {
					}
	
				}
	
				sbHashContents.append ("\n");
			}
	
			return sbHashContents.toString();
			
		}
			
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (2002/04/16 3:06:34 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param opBundle java.util.ResourceBundle
	 */
	public static String toString (ResourceBundle opBundle) {
	
		///////////////////////////////////////////
		// Declarations -
		///////////////////////////////////////////
	
		Enumeration <String>	obundleKeys = null;
	
		String					sKey		= null;
		String					sValue		= null;
	
		StringBuilder			sbResults	= null;
	
	
		///////////////////////////////////////////
		// Code -
		///////////////////////////////////////////
	
		obundleKeys	= opBundle.getKeys();
		sbResults	= new StringBuilder();
	
		while (obundleKeys.hasMoreElements()) {
	
			sKey	= obundleKeys.nextElement();
			sValue	= opBundle.getString (sKey);
			sbResults.append (sKey + ":   " + sValue + "\n");
	      }
		
		sbResults.append ("\n");
	
		return sbResults.toString();
	
	}
	
	/**
	 * Converts a single word to title case.
	 * 
	 * Will not work if contains multiple words.
	 * 
	 * @param word
	 * @return
	 */
	public static String toTitleCase (String word) {
		
		int length;
		
		length = length (word);
		
		if (length == 1) {
			word = word.toUpperCase();
		}
		else if (length > 1) {
			word =  word.substring (0, 1).toUpperCase() + word.substring (1).toLowerCase();
		}
		// Else
			// Zero length. Return as is.
		
		return word;
	}
	
	/**
	 * 
	 * 
	 * Creation date: (2002/10/25 4:02:08 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param spStringIn java.lang.String
	 */
	public static String toUpperCase(String spStringIn) {
	
		if (spStringIn == null) {
			
			return null;
	
		}
		else {
	
			return spStringIn.toUpperCase();
	
		}
	
	}
	
	/**
	 * 
	 * 
	 * Creation date: (2002/04/18 2:25:36 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param spStringIn java.lang.String
	 */
	public static String trim (String spStringIn) {
	
		if (spStringIn == null) {
			
			return null;
	
		}
		else {
	
			return spStringIn.trim();
	
		}
	
	}
	
	
	/**
	 * 
	 * 
	 * Creation date: (2002/04/18 2:25:36 PM)
	 * 
	 * @param: <|>
	 * @return:
	 * 
	 * @return java.lang.String
	 * @param spStringIn java.lang.String
	 */
	public static String trimNonNull (String spStringIn) {
	
		if (spStringIn == null) {
			
			return "";
	
		}
		else {
	
			return spStringIn.trim();
	
		}
	
	}
}

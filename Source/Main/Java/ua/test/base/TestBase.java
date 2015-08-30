package ua.test.base;


import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


/**
 * Created on Dec 30, 2004
 * 
 * Updates:
 * 
 * 2013.11.22 - Added print (..., date)
 * 2013.11.22 - Added printDouble (..., date)
 * 2013.11.22 - Ordered methods.
 * 2013.12.19 - Added printDouble for exceptions.
 * 2015.01.07 - Added printDone, printTitle
 * 
 */
public class TestBase {

	private static int		COLUMN_2_START_POSITION	= 24;
	private static String	BORDER_CHARACTER	= "*";

	
	public static int getTextPaddingSize () {

		return COLUMN_2_START_POSITION;
	}
	
	public static void print () {

		print ("");
	}
	
	public static void print (Exception e) {

		print (e, null);
	}
	
	public static void print (Exception e, String description) {

		print ("Exception",		e.getClass().getName());
		
		if (description != null) {
			print ("   Description", description);
		}
		
		print ("   Message",	e.getMessage () != null ? e.getMessage() : "[null]");		
		print ();
		
		print ("   Stack Trace");
		e.printStackTrace();
		
		print ();
	}

	public static void print (Exception e, String className, String methodName, String comment) {

		print ("Exception",		e.getClass ().getName ());
		print ("   Message",	e.getMessage ());
		print ("   Class",		className);
		print ("   Method",		methodName);

		if (comment != null) {
			
			print ("   comment", comment);
		}

		print ("");
	}

	public static void print (Object obj) {

		System.out.println (obj);
	}
	
	public static void print (Collection <String> texts) {
		
		print (TestStringUtils.join (texts, ", "));
	}

	public static void print (String text) {

		System.out.println (text);
	}

	public static void print (String text1, boolean boolValue) {

		print (text1, Boolean.toString (boolValue));
	}
	
	public static void print (String text1, Collection <String> texts) {
		
		print (text1, TestStringUtils.join (texts, ", "));
	}

	public static void print (String text1, Date date) {

		print (text1, TestDateUtils.toTimestampString (date));
	}

	public static void print (String text1, double number) {

		print (text1, Double.toString (number));
	}

	public static void print (String text1, Exception e) {
		
		print (e, text1);
	}

	public static void print (String text1, float number) {

		print (text1, Float.toString (number));
	}

	public static void print (String text1, int number) {

		print (text1, Integer.toString (number));
	}

	public static void print (String text1, LocalDate date) {

		print (text1, TestDate2Utils.toTimestampString (date));
	}

	public static void print (String text1, LocalDateTime dateTime) {

		print (text1, TestDate2Utils.toTimestampString (dateTime));
	}

	public static void print (String text1, LocalTime time) {

		print (text1, TestDate2Utils.toTimestampString (time));
	}

	public static void print (String text1, long number) {

		print (text1, Long.toString (number));
	}

	public static void print (String text1, String text2) {

		print (padString (text1, " ", getTextPaddingSize ()) + ": " + text2);
	}
	
	public static void print (String className, String methodName, String comment, Exception e) {
		
		print (e, className, methodName, comment);
	}
	
	public static void printDone() {
		
		print ();
		print ("Done.");
		print ();
	}

	public static void printDone (String title) {
		
		int length = title.length();
		int halfLength = (length - 5) / 2;

		print ();
		print (TestStringUtils.expandString (BORDER_CHARACTER, halfLength + 4) + "  Done.  " + TestStringUtils.expandString (BORDER_CHARACTER, halfLength + 5 - length % 2));
		print ();
	}

	public static void printDouble () {
		
		print ();
		print ();
	}

	public static void printDouble (Exception e) {

		printDouble (e);		
		print ();
	}
	
	public static void printDouble (Exception e, String description) {

		printDouble (e, description);	
		print ();
	}

	public static void printDouble (Exception e, String className, String methodName, String comment) {

		printDouble (e, className, methodName, comment);
		print ();
	}

	public static void printDouble (Collection <String> texts) {
		
		print (texts);
		print ();
	}

	public static void printDouble (String text) {
		
		print (text);
		print ();
	}

	public static void printDouble (String text1, boolean boolValue) {
		
		print (text1, boolValue);
		print ();
	}
	
	public static void printDouble (String text1, Collection <String> texts) {
		
		print (text1, texts);
		print ();
	}

	public static void printDouble (String text1, Date date) {
		
		print (text1, date);
		print ();
	}
	
	public static void printDouble (String text1, Double number) {
		
		print (text1, number);
		print ();
	}
	
	public static void printDouble (String text1, Exception e) {
		
		print (e, text1);
		print ();
	}

	public static void printDouble (String text1, float number) {
		
		print (text1, number);
		print ();
	}
	
	public static void printDouble (String text1, int number) {
		
		print (text1, number);
		print ();
	}
	
	public static void printDouble (String text1, LocalDate date) {
		
		print (text1, date);
		print ();
	}
	
	public static void printDouble (String text1, LocalDateTime dateTime) {
		
		print (text1, dateTime);
		print ();
	}
	
	public static void printDouble (String text1, LocalTime time) {
		
		print (text1, time);
		print ();
	}
	
	public static void printDouble (String text1, long number) {
		
		print (text1, number);
		print ();
	}
	
	public static void printDouble (String text1, String text2) {
		
		print (text1, text2);
		print ();
	}
	
	public static void printDouble (String className, String methodName, String comment, Exception e) {
		
		print (e, className, methodName, comment);
		print ();
	}

	public static void printDoubleSorted (String text1, Collection <String> texts) {
		
		printSorted (text1, texts);
		print ();
	}
	
	public static void printIndent (int indentCount, String text) {
		
		String indent;
		
		if (TestStringUtils.isNotEmpty (text)) {
			
			indent = TestStringUtils.indent (indentCount);
			
			text = text.replaceAll ("[\n]", "\n" + indent);
			text = indent + text;
		}
		
		print (text);
	}


	public static void printInline (String text) {
		
		System.out.print (text);
	}
	
	public static void printSectionHeader (String headerText) {
		
		print ();
		print ("************  " + headerText + "  ************");
		print ();
	}
	
	public static void printSorted (String text1, Collection <String> texts) {
		
		print (text1, TestStringUtils.join (TestCollectionUtils.asSortedList (texts), ", "));
	}
	
	public static void printTitle (String title) {
		
		int length = title.length();
		
		print (TestStringUtils.expandString (BORDER_CHARACTER, length + 12));
		print (BORDER_CHARACTER + BORDER_CHARACTER + "    " + title + "    " + BORDER_CHARACTER + BORDER_CHARACTER);
		print (TestStringUtils.expandString (BORDER_CHARACTER, length + 12));
		print ();
	}
	
	public static void printXml (String xmlString) {
		

		// ///////////////////////////////////////////////////////////////
		//   Declarations
		// ///////////////////////////////////////////////////////////////

        Source				xmlInput			= null;
        StringWriter		stringWriter		= null;
        StreamResult		xmlOutput			= null;
        
        TransformerFactory	transformerFactory	= null;
        Transformer			transformer			= null;

        
		// ///////////////////////////////////////////////////////////////
		//   Code
		// ///////////////////////////////////////////////////////////////

        try {
        	
	        xmlInput		= new StreamSource (new StringReader (xmlString));
	        stringWriter	= new StringWriter();
	        xmlOutput		= new StreamResult (stringWriter);
	        
	        transformerFactory = TransformerFactory.newInstance();
	        transformerFactory.setAttribute ("indent-number", 4);
	        
	        transformer = transformerFactory.newTransformer(); 
	        transformer.setOutputProperty (OutputKeys.INDENT, "yes");
	        transformer.transform (xmlInput, xmlOutput);
	        
	        print (xmlOutput.getWriter().toString());
	        
	    }
	    catch (Exception e) {

	    	print (e);
	    }
	}

	public static void setTextPaddingSize (int textPaddingSize) {
		
		COLUMN_2_START_POSITION = textPaddingSize;
	}
	
	public static void sleep (int seepTimeMs) {
		
		try {
			Thread.sleep (seepTimeMs);
		}
		catch (InterruptedException e) {
			// Ignore.
		}
	}
	
	public static void sleepSecs (int sleepTimeSecs) {
		
		sleep (sleepTimeSecs * 1000);
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
	private static String expandString (String expandString, int expandCount) {
	
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

	private static String padString (String text, String fillText, int totalLength) {
		
		if (text != null) {
		
			return text + expandString (fillText, totalLength - text.length());
		}
		else {
			
			return expandString (fillText, totalLength);
		}
	}
}

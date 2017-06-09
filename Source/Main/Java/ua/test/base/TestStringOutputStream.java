package ua.test.base;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;


public class TestStringOutputStream extends ByteArrayOutputStream {

	public static final String	CODE_PAGE_DEFAULT	= "UTF-8";
	
	private String				codePage;
	
	
	public TestStringOutputStream () {
		
		this.codePage = CODE_PAGE_DEFAULT;
	}
	
	
	public TestStringOutputStream (String codePage) {
		
		this.codePage = codePage;
	}
	

	public String toString () {

		String	string;
		
		try {
			
			string = this.toString (this.codePage);
		}
		catch (UnsupportedEncodingException e) {
			
			string = null;
		}
		
		return string;
	}
}

/*
 * Created on May 26, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package ua.test.entities;


/**
 * @author TOCONNEL
 *
 * Immutable.
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class TestNameValuePair {
	
	public String	name	= null;
	public String	value	= null;


	public TestNameValuePair() {
		
	}
	
	/**
	 * @param name
	 * @param value
	 */
	public TestNameValuePair (String name, String value) {

		super ();
		this.name = name;
		this.value = value;
	}

	
	public String getName () {

		return name;
	}

	public String getValue () {

		return value;
	}

	@Override
	public String toString () {

		return "NameValue [name=" + name + ", value=" + value + "]";
	}
}

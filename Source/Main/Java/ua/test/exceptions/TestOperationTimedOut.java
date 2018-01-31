package ua.test.exceptions;

public class TestOperationTimedOut extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TestOperationTimedOut (String message) {
		super (message);
	}

}

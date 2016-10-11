package ua.test.base;

import java.util.List;

public class TestItemNotFoundException extends TestException {

	private static final long serialVersionUID = -7648437428494422152L;

	public TestItemNotFoundException() {

		super();
	}

	public TestItemNotFoundException (String message) {

		super(message);
	}

	public TestItemNotFoundException (List <String> messageList) {

		super(messageList);
	}

}

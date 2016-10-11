package ua.test.base;

import java.util.ArrayList;
import java.util.List;


public class TestException extends Exception {

	private static final long	serialVersionUID	= 7979685591590075107L;

	private List <String>		messageList = new ArrayList <String> ();

	
	public TestException() {

		super();
	}

	public TestException (String message) {

		super();
		messageList.add (message);
	}

	public TestException (List <String> messageList) {

		super();
		this.messageList = messageList;
	}
	
	public void addFirstMessage (String message) {

		messageList.add (0, message);
	}

	public void addMessage (String message) {

		messageList.add (message);
	}

	public void addMessageList (List <String> messageList) {

		this.messageList.addAll (messageList);
	}

	public List <String> getMessageList() {

		return messageList;
	}
	
	public String getMessage () {
	
		return TestStringUtils.join (messageList, " ");
	}
}

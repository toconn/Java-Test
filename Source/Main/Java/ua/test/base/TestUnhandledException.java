package ua.test.base;

import java.util.ArrayList;
import java.util.List;

public class TestUnhandledException extends Exception {

	private static final long serialVersionUID = 1L;

	public static class Builder {

        private Exception exception = new Exception();
        private List<String> messages = new ArrayList<>();

        public Builder addMessage(String message) {
        	this.messages.add (message); return this;
        }

        public Builder exception(Exception exception) {
            this.exception = exception; return this;
        }
        
        public Builder addMessages(List<String> messages) {
            this.messages.addAll (messages); return this;
        }

        public TestUnhandledException build() {
            return new TestUnhandledException(this);
        }
    }

    public static Builder Builder() {
        return new Builder();
    }

    private final Exception exception;
    private final List<String> messages;

    public TestUnhandledException(List<String> messages, Exception exception) {
    	
    	super (asMessage (messages), exception);
    	
        this.exception = exception;
        this.messages = messages;
    }

    private TestUnhandledException(Builder builder) {
    	
    	super (asMessage (builder.messages), builder.exception);

        this.exception = builder.exception;
        this.messages = builder.messages;
    }

    public Exception getException() {
        return exception;
    }

    public List<String> getMessages() {
        return messages;
    }
	
	public String getMessage() {

		return asMessage (this.messages);
	}
	
	private static String asMessage (List<String> messages) {
		
		if (messages.size () > 0) {
			return TestStringUtils.join (messages, ". ");
		}
		else {
			return "";
		}
	}

    @Override
    public String toString() {
    	
    	return "TestUnhandledException [" +
        	"message=" + getMessage() +
            "]";
    }
}
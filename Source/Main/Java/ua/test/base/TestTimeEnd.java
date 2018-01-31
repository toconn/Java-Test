package ua.test.base;

/**
 * A simple class to say when it has passed a particular time.
 */
public class TestTimeEnd {
	
	private long systemEndTimeMS;

	public TestTimeEnd (long systemEndTimeMS) {
		this.systemEndTimeMS = systemEndTimeMS;
	}
	
	public boolean hasEnded() {
		return this.systemEndTimeMS <= System.currentTimeMillis();
	}
	
	public boolean hasNotEnded() {
		return ! hasEnded();
	}

}

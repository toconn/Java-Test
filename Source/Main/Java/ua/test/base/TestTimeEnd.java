package ua.test.base;

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

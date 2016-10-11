package ua.test.base;

public class TestCounter {

	private long lastValue = 0;
	
	
	public TestCounter() {
		
		lastValue = 0;
	}
	
	public TestCounter (boolean startOnOne) {
		
		if (startOnOne) {
			
			lastValue = 1;
		}
		else {
			
			lastValue = 0;
		}
	}
	
	public long getLast() {
		
		return  lastValue;
	}

	public long getNext() {
		
		return lastValue++;
	}
}

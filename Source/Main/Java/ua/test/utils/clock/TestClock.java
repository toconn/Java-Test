package ua.test.utils.clock;

import java.time.LocalDateTime;


public interface TestClock {
	
	// Clock Functions:
	
	public LocalDateTime getDateTime();
	public void runNext();
	public void runTest (long iterationCount);
	
	// Observer Functions:
	
	public void notifyObservers();
	public void registerObserver	(ClockObserver observer);
	public void unregisterObserver	(ClockObserver observer);
}

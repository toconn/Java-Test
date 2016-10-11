package ua.test.utils.clock;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import ua.test.base.TestBase;

public class TestClockDefault extends TestBase implements TestClock {

	private LocalDateTime		currentDateTime;
	private Duration			timeIntervalDuration;
	private Set <ClockObserver>	observerSet = new HashSet <>();
	private boolean				printNotifyTime;
	
	public TestClockDefault (LocalDateTime startCurrentTimeDate, Duration timeIntervalDuration, boolean printNotifyTime) {
		
		this.currentDateTime = startCurrentTimeDate;
		this.timeIntervalDuration = timeIntervalDuration;
		this.printNotifyTime = printNotifyTime;
	}

	@Override
	public LocalDateTime getDateTime() {
	
		return this.currentDateTime;
	}
	
	
	@Override
	public void notifyObservers() {

		LocalDateTime currentDateTime;
		
		currentDateTime = getDateTime();
		
		printNotifyTime (currentDateTime);
		
		for (ClockObserver observer : this.observerSet) {
			observer.tick (currentDateTime);
		}
	}
	
	@Override
	public void registerObserver (ClockObserver observer) {

		this.observerSet.add (observer);
	}
	
	@Override
	public void runNext() {
	
		notifyObservers();
		updateToNextDateTime();
	}
	
	@Override
	public void runTest (long iterationCount) {
		
		for (long i = 0; i < iterationCount; i++) {
			notifyObservers();
			updateToNextDateTime();
		}
	}

	@Override
	public void unregisterObserver (ClockObserver observer) {

		this.observerSet.remove (observer);
	}
	
	
	private void printNotifyTime (LocalDateTime dateTime) {
		
		if (printNotifyTime) {
			print ("Notifying @ time", currentDateTime);
		}
	}
	
	private void updateToNextDateTime() {

		this.currentDateTime = this.currentDateTime.plus (this.timeIntervalDuration);
	}
}

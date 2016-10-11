package ua.test.utils.clock;

import java.time.LocalDateTime;

public interface ClockObserver {
	
	public void tick (LocalDateTime timeDate);

}

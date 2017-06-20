package ua.test.base;

public class TestTimeUtils {
	
	public static long getSystemTimeAfterMS (long delayMS) {
		
		return System.currentTimeMillis() + delayMS;
	}

}

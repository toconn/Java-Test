package ua.test.runner;

public abstract class TestRunnerUtils implements Runnable {
	
	public static void startThread (TestRunner testRunner) {
		new Thread (testRunner, testRunner.getName()).start();
	}
	
	public static void print (TestRunner testRunner, String text) {
		
		if (testRunner.isDebug()) {
			System.out.println (testRunner.getName() + ": " + text);
		}
	}
}

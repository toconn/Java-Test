package ua.test.runner;

public interface TestRunner extends Runnable {

	public boolean isDebug();
	public String getName();
	public void startThread();
}

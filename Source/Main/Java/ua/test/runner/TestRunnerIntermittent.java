package ua.test.runner;

import ua.test.base.TestNumberUtils;
import ua.test.base.TestSystemUtils;
import ua.test.base.TestTimeEnd;

/*

TestRunnerIntermittent

	command				TestCommand
	commandMaxDelayMS	long
	commandMinDelayMS	long
	endTimeMS			long
	name				String
	debug				boolean	

Options:

	FullConstructor
	Builder

*/


public class TestRunnerIntermittent implements TestRunner {

    public static class Builder {

        private TestCommand command = null;
        private long commandMaxDelayMS = 0L;
        private long commandMinDelayMS = 0L;
        private long endTimeMS = 0L;
        private String name = "";
        private boolean debug = false;

        public Builder command(TestCommand command) {
            this.command = command; return this;
        }

        public Builder commandMaxDelayMS(long commandMaxDelayMS) {
            this.commandMaxDelayMS = commandMaxDelayMS; return this;
        }

        public Builder commandMinDelayMS(long commandMinDelayMS) {
            this.commandMinDelayMS = commandMinDelayMS; return this;
        }

        public Builder endTimeMS(long endTimeMS) {
            this.endTimeMS = endTimeMS; return this;
        }

        public Builder name(String name) {
            this.name = name; return this;
        }

        public Builder debug(boolean debug) {
            this.debug = debug; return this;
        }

        public TestRunnerIntermittent build() {
            return new TestRunnerIntermittent(this);
        }
    }

    public static Builder Builder() {
        return new Builder();
    }

    private TestCommand command;
    private long commandMaxDelayMS;
    private long commandMinDelayMS;
    private TestTimeEnd endTime;
    private String name;
    private boolean debug;

    public TestRunnerIntermittent (TestCommand command, long commandMaxDelayMS, long commandMinDelayMS, long endTimeMS, String name, boolean debug) {
    	
    	this.command = command;
        this.commandMaxDelayMS = commandMaxDelayMS;
        this.commandMinDelayMS = commandMinDelayMS;
        this.endTime = new TestTimeEnd (endTimeMS);
        this.name = name;
        this.debug = debug;
        
        print ("Created.");
    }
    
    private TestRunnerIntermittent (Builder builder) {
    	
        this.command = builder.command;
        this.commandMaxDelayMS = builder.commandMaxDelayMS;
        this.commandMinDelayMS = builder.commandMinDelayMS;
        this.endTime = new TestTimeEnd (builder.endTimeMS);
        this.name = builder.name;
        this.debug = builder.debug;
        
        print ("Created.");
    }

    @Override
    public boolean isDebug() {
        return debug;
    }
    
    @Override
    public String getName() {
    	
    	return this.name;
    }

	@Override
	public void run() {
		
		print ("Starting...");
		
		while (endTime.hasNotEnded()) {
			
			command.execute();
			sleep();
		}
		
		print ("Stopping...");
		
		command.stop();
		
		print ("Stopped.");
		
	}
	
	@Override
	public void startThread() {
		
		TestRunnerUtils.startThread (this);
	}
	
	private void print (String text) {
		
		if (debug) {
			System.out.println (name + ": " + text);
		}
	}
	
	private void sleep() {
		
		long sleepTimeMS = commandMinDelayMS + TestNumberUtils.newRandomLong (this.commandMaxDelayMS - this.commandMinDelayMS);
		
		print ("Sleeping (" + sleepTimeMS + "ms).");
	
		TestSystemUtils.sleep (sleepTimeMS);
	}

}

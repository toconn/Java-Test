package ua.test.runner;

import ua.test.base.TestSystemUtils;
import ua.test.base.TestTimeEnd;


/*

TestRunnerContinuous

	command			TestCommand
	commandDelayMS	long
	endTimeMS		long
	name			String
	debug			boolean	

Options:

	FullConstructor
	Builder

*/

/**
 * 
 * Run a test continuously for a period of time.
 *
 */
public class TestRunnerContinuous implements TestRunner {
	
    public static class Builder {

        private TestCommand command = null;
        private long commandDelayMS = 0L;
        private long endTimeMS = 0L;
        private String name = null;
        private boolean debug = false;

        public Builder command(TestCommand command) {
            this.command = command; return this;
        }

        public Builder commandDelayMS(long commandDelayMS) {
            this.commandDelayMS = commandDelayMS; return this;
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

        public TestRunnerContinuous build() {
            return new TestRunnerContinuous(this);
        }
    }

    public static Builder Builder() {
        return new Builder();
    }

    private TestCommand command;
    private long commandDelayMS;
    private TestTimeEnd endTime;
    private String name;
    private boolean debug;


    public TestRunnerContinuous(TestCommand command, long commandDelayMS, long endTimeMS, String name, boolean debug) {

        this.command = command;
        this.commandDelayMS = commandDelayMS;
        this.endTime = new TestTimeEnd (endTimeMS);
        this.name = name;
        this.debug = debug;
        
        print ("Created.");
    }

    private TestRunnerContinuous(Builder builder) {

        this.command = builder.command;
        this.commandDelayMS = builder.commandDelayMS;
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
        return name;
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
		
		TestRunnerUtils.print (this, text);
	}
	
	private void sleep() {
		
		if (this.commandDelayMS > 0) {
			
			TestSystemUtils.sleep (this.commandDelayMS);
		}

	}

}

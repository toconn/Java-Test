package ua.test.base;

/**
 * Created with CodeCrank.io
 * 
 */
public class TestIncDecCounter {

    private boolean limitFloorToZero = true;
    private int count = 0;

    public TestIncDecCounter() {
    }

    public TestIncDecCounter(boolean limitFloorToZero, int count) {

        this.limitFloorToZero = limitFloorToZero;
        this.count = count;
    }
    
    public int decrement() {
    	
    		if (! this.limitFloorToZero || count > 0) {
	    		count -= 1;
    		}
    		
    		return count;
    }
    
    public int getCount() {
        return count;
    }
    
    /**
     * Returns the current value and then increments it.
     * 
     * @return
     */
    public int increment() {
    		count += 1;
    		return count -1;
    }

    @Override
    public String toString() {
        return "TestIncDecCounter [" +
            "limitFloorToZero=" + limitFloorToZero +
            ", count=" + count +
            "]";
    }
}
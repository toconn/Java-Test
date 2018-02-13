package ua.test.entities;


public class Test2Sub1 extends Test2Base {
	
	private String value;
	
	public Test2Sub1(String value) {
		this.value = value;
	}
	
	@Override
	public String getClassName() {
		return super.getClassName() + "->" + "TestSub1";
	}

	@Override
	public String getValue () {

		return value;
	}

}

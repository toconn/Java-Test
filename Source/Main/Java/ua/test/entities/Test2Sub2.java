package ua.test.entities;


public class Test2Sub2 extends Test2Base {
	
	private String value;
	
	public Test2Sub2(String value) {
		this.value = value;
	}
	
	@Override
	public String getClassName() {
		return super.getClassName() + "->" + "TestSub2";
	}

	@Override
	public String getValue () {

		return value;
	}

}

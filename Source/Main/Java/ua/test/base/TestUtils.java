package ua.test.base;

public class TestUtils {
	
	public static final String DEV_POC_DIR_ENVIRONMENT_VARIABLE = "User_Dev_POC_Dir";
	
	public static final String getPocPath (String subpath) {

		return TestFileUtils.join (System.getenv (DEV_POC_DIR_ENVIRONMENT_VARIABLE), subpath);
	}

}

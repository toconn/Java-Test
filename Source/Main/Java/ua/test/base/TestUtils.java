package ua.test.base;

public class TestUtils {
	
	public static final String DEV_APP_DIR_ENVIRONMENT_VARIABLE = "User_Dev_Dir";
	public static final String DEV_POC_DIR_ENVIRONMENT_VARIABLE = "User_Dev_POC_Dir";
	public static final String DEV_JAVA_SOURCE_SUBDIR = "Source/Java/Current";
	
	public static final String getAppPath (String subpath) {
		return TestFileUtils.join (System.getenv (DEV_APP_DIR_ENVIRONMENT_VARIABLE), subpath);
	}
	
	public static final String getAppPath (String rootAppDir, String sourceAppName) {
		return TestFileUtils.join (System.getenv (DEV_APP_DIR_ENVIRONMENT_VARIABLE), rootAppDir, DEV_JAVA_SOURCE_SUBDIR, sourceAppName);
	}

	public static final String getAppPath (String rootAppDir, String sourceAppName, String subdir, String fileName) {
		return TestFileUtils.join (System.getenv (DEV_APP_DIR_ENVIRONMENT_VARIABLE), rootAppDir, DEV_JAVA_SOURCE_SUBDIR, sourceAppName, subdir, fileName);
	}

	public static final String getPocPath (String subpath) {
		return TestFileUtils.join (System.getenv (DEV_POC_DIR_ENVIRONMENT_VARIABLE), subpath);
	}
	
	public static final String getPocPath (String rootAppDir, String sourceAppName) {
		return TestFileUtils.join (System.getenv (DEV_POC_DIR_ENVIRONMENT_VARIABLE), rootAppDir, DEV_JAVA_SOURCE_SUBDIR, sourceAppName);
	}

	public static final String getPocPath (String rootAppDir, String sourceAppName, String subdir, String fileName) {
		return TestFileUtils.join (System.getenv (DEV_POC_DIR_ENVIRONMENT_VARIABLE), rootAppDir, DEV_JAVA_SOURCE_SUBDIR, sourceAppName, subdir, fileName);
	}

}

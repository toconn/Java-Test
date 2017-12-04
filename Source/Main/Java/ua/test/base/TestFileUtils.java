package ua.test.base;


import java.io.*;
import java.nio.channels.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestFileUtils {

	public static final String	FILE_ENCODING_UTF8			= "UTF-8";
	public static final char	FILE_EXTENSION_SEPARATOR	= '.';
	
	public static final String	JAVA_PROPERTIES_APP_DIR		= "user.dir";
	public static final String	JAVA_PROPERTIES_NEWLINE		= "line.separator";
	public static final String	JAVA_PROPERTIES_OS_NAME		= "os.name";

	public static final String	OSX_OS_NAME					= "Mac OS X";
	public static final String	OSX_FILE_SEPARATOR			= "/";
	public static final String	OSX_NEW_LINE				= "\n";
	public static final String	OSX_PATH_SEPARATOR			= ":";	
	
	public static final String	UNIX_OS_NAME				= "????";
	public static final String	UNIX_FILE_SEPARATOR			= "/";
	public static final String	UNIX_NEW_LINE				= "\n";
	public static final String	UNIX_PATH_SEPARATOR			= ":";
	
	public static final String	WINDOWS_OS_NAME				= "Windows";
	public static final String	WINDOWS_FILE_SEPARATOR		= "\\";
	public static final String	WINDOWS_NEW_LINE			= "\r\n";
	public static final String	WINDOWS_PATH_SEPARATOR		= ";";
	
	public static final void copyFile (File sourceFile, File destinationFile) throws IOException {
		
		// Note:
		
		// File Path = full file name and directory
		// File Name = name of the file without the directory information.
		// File Dir is the directory part of the path with no name.
		

		// //////////////////////////////////////////////////////////////////////////
		// Declarations:
		// //////////////////////////////////////////////////////////////////////////

		FileInputStream 	sourceInputStream		= null;
		FileChannel			sourceFileChannel		= null;
		FileOutputStream	destinationOutputStream	= null;
		FileChannel			destinationFileChannel	= null;

		
		// //////////////////////////////////////////////////////////////////////////
		// Code:
		// //////////////////////////////////////////////////////////////////////////

		if (! destinationFile.exists ()) {

			destinationFile.createNewFile ();
		}

		try {

			sourceInputStream = new FileInputStream (sourceFile);
			sourceFileChannel = sourceInputStream.getChannel();

			destinationOutputStream = new FileOutputStream (destinationFile);
			destinationFileChannel = destinationOutputStream.getChannel();
			destinationFileChannel.transferFrom (sourceFileChannel, 0, sourceFileChannel.size());

			destinationFile.setLastModified (sourceFile.lastModified ());
		}
		finally {

			if (sourceFileChannel != null) {
				sourceFileChannel.close();
			}
			
			if (sourceInputStream != null) {
				sourceInputStream.close();
			}

			if (destinationFileChannel != null) {
				destinationFileChannel.close();
			}
			
			if (destinationOutputStream != null) {
				destinationOutputStream.close();
			}
		}
	}
	
	
	/**
	 * Deletes a file. It checks first to see that the file actually exists.
	 * 
	 * @param filePath
	 */
	public static void delete (String filePath) {
		
		File file = new File (filePath);
		
		if (file.exists()) {
			
			file.delete();
		}
	}


    /** 
     * Finds the path to a file from a list of possible paths.
     * Will return either the path or null if nothing is found.
     * 
     * @param dirList
     * @param fileName
     * @return
     */
    public static String findFileDirectory (List<String> dirList, String fileName) {
    	
		// ///////////////////////////////////////////////////////////////
		//   Declarations
		// ///////////////////////////////////////////////////////////////

		String	fileDirectory	= null;


		// ///////////////////////////////////////////////////////////////
		//   Code
		// ///////////////////////////////////////////////////////////////

		
    	for (String directory: dirList) {
    		
    		if (isFileExists (getPath (directory, fileName))) {
    		
    			fileDirectory = directory;
    			break;
    		}
    	}
    	
    	return fileDirectory;
    }
    
    
    /** 
     * Finds one or more paths containing a file from a list of possible paths.
     * Will return either the path list or null if nothing is found.
     * 
     * @param dirList
     * @param fileName
     * @return
     */
    public static List<String> findFileDirectoryList (List<String> dirList, String fileName) {
    	
		// ///////////////////////////////////////////////////////////////
		//   Declarations
		// ///////////////////////////////////////////////////////////////

		List<String>	fileDirList	= null;


		// ///////////////////////////////////////////////////////////////
		//   Code
		// ///////////////////////////////////////////////////////////////

		
    	for (String pathName: dirList) {
    		
    		if (isFileExists (getPath (pathName, fileName))) {
    			
    			if (fileDirList == null)
    				
    				fileDirList = new ArrayList <String> ();
    		
    			fileDirList.add (pathName);
    			break;
    		}
    	}
    	
    	return fileDirList;
    }
	
	
    public static String findFileInClassPath (String fileName) throws IOException  {

		// ////////////////////////////////////////////////////////////////////////////////////
		// Declarations:
		// ////////////////////////////////////////////////////////////////////////////////////

		TestFileUtils dummyClass = null; // Used to get class loader.

		URL fileURL = null;
		String filePath = null;

		// ////////////////////////////////////////////////////////////////////////////////////
		// Code:
		// ////////////////////////////////////////////////////////////////////////////////////

		if (fileName != null) {

			dummyClass = new TestFileUtils();
			fileURL = dummyClass.getClass().getClassLoader().getResource (fileName);

			if (fileURL != null) {
				filePath = URLDecoder.decode (fileURL.getPath(), FILE_ENCODING_UTF8);
			}

			if (filePath != null) {
				filePath = getParentPath (filePath);
			}
		}

		return filePath;
	}


    /**
     * Returns the java canonical form of the path.
     * 
     * @param path
     * @return
     * @throws IOException
     */
	public static String getCanonicalPath (String path) throws IOException {

		// ///////////////////////////////
		// Declarations:
		// ///////////////////////////////

		File file = null;
		String newPath = null;

		// ///////////////////////////////
		// Code:
		// ///////////////////////////////

		file = new File (path);
		newPath = file.getCanonicalPath();

		return newPath;
	}
	
	
	public static String getExtension (String fileName) {
		
		//////////////////////////////////////////////////////////////////
		// Declarations
		//////////////////////////////////////////////////////////////////

		int		extensionSepIndex	= 0;
		String	fileExtension		= null;


		//////////////////////////////////////////////////////////////////
		// Code
		//////////////////////////////////////////////////////////////////

		if (fileName != null) {
			
			extensionSepIndex = fileName.lastIndexOf (FILE_EXTENSION_SEPARATOR);
			
			if (extensionSepIndex != -1 && extensionSepIndex < fileName.length() - 1) {
				
				fileExtension = fileName.substring (extensionSepIndex + 1);
			}
		}

		return fileExtension;
	}

	
	/**
	 * Returns the parent of the path.
	 * 
	 * It must return a directory.
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String getParentPath (String path) throws IOException {

		// ///////////////////////////////
		// Declarations:
		// ///////////////////////////////

		File currentFile = null;
		String currentPath = null;

		File parentFile = null;

		// ///////////////////////////////
		// Code:
		// ///////////////////////////////

		currentFile = new File (path);
		currentPath = currentFile.getCanonicalPath ();

		currentFile = new File (currentPath);
		parentFile = currentFile.getParentFile ();

		if (parentFile != null) {

			return parentFile.getCanonicalPath ();
		}
		else {

			return null;
		}
	}
	

	/**
	 * Returns the path (file directory + sparator + file name).
	 * 
	 * Returns the correct format for the os.
	 * 
	 * @param directoryName
	 * @param fileName
	 * @return
	 */
	public static String getPath (String directoryName, String fileName) {
		
		return directoryName + File.separator + fileName;
	}
	
	
	/**
	 * Returns the file directory without the file name.
	 * 
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String getPathDirectory (String filePath) throws IOException {

		// ///////////////////////////////
		// Declarations:
		// ///////////////////////////////

		File	file		= null;


		// ///////////////////////////////
		// Code:
		// ///////////////////////////////

		file	= new File (filePath);
		
		return file.getParent ();
	}	


	/**
	 * Returns the file name only (not full path, no directory).
	 * 
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String getPathName (String filePath) throws IOException {

		// ///////////////////////////////
		// Declarations:
		// ///////////////////////////////

		File	file		= null;


		// ///////////////////////////////
		// Code:
		// ///////////////////////////////

		file	= new File (filePath);
		
		return file.getName ();
	}
	
	
	/**
	 * Returns the name subpart of a file name.
	 * File name = subname.ext. Returns subname.
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSubname (String fileName) {
		
		//////////////////////////////////////////////////////////////////
		// Declarations
		//////////////////////////////////////////////////////////////////

		int		extensionSepIndex	= 0;
		String	subname				= null;


		//////////////////////////////////////////////////////////////////
		// Code
		//////////////////////////////////////////////////////////////////

		if (fileName != null) {
			
			extensionSepIndex = fileName.lastIndexOf (FILE_EXTENSION_SEPARATOR);
			
			if (extensionSepIndex > 0) {
				
				subname = fileName.substring (0, extensionSepIndex);
			}
		}

		return subname;
	}


	/**
	 * Checks to see if the path is an absolute path.
	 * 
	 * Will return false for a relative path.
	 * 
	 * @param path
	 * @return
	 */
	public static final boolean isAbsolutePath (String path) {

		if (TestStringUtils.isNotEmpty (path)) {

			if (! isOSWindows ()) {

				// Check unix file name...

				if (TestStringUtils.isEqual (path.charAt (0), File.pathSeparatorChar)) {

					return true;
				}
			}
			else {

				// Check dos file name...

				if (TestStringUtils.isEqual (path.charAt (0), File.pathSeparatorChar)) {

					return true;
				}
				else if (path.length () > 2 && ":".equals (path.substring (1, 2))) {

					return true;
				}

			}

		}

		return false;
	}


	/**
	 * Checks to see if a file exists.
	 * 
	 * Does not check to see what kind of file (file, link, directory).
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isFileExists (String fileName) {

		return (new File (fileName)).exists ();
	}

	
	public static boolean isOSWindows () {

		return TestStringUtils.isEqual (System.getProperty (JAVA_PROPERTIES_OS_NAME), WINDOWS_OS_NAME);
	}
	
	
	public static String readToString (String filePath) throws FileNotFoundException {
		
		String text;
		
		try (Scanner scanner = new Scanner (new File (filePath))) {
			text = scanner.useDelimiter ("\\Z").next();
		}
		
		return text;
	}

}

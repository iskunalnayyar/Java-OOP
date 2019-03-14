
/*
 * FindPattern.java
 * 
 * Versions
 * 		10/21/2017
 * 
 * Revisions
 * 		7.4
 */

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * FindPattern class will run the specific find commands to find the files or
 * folders for the particular directory.
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class FindPattern {

	public static void main(String[] args) {
		String directoryPath = null;
		try {

			// Get the find command from the user
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the find command");
			String command = scanner.nextLine();
			String find[] = command.split(" ");


			// if improper find command given exit the program.
			if (!find[0].trim().equals("find")) {
				System.err.println("Please give proper find command");
				System.exit(0);
			}
			
			if(!Pattern.matches("-name|-type", find[2])) {
				System.err.println("Please give proper find type command");
				System.exit(0);
			}
			
			if(find[2].trim().equals("-type")) {
				if(!Pattern.matches("f|d", find[3])) {
					System.err.println("Please give proper find command");
					System.exit(0);
				}
			}
			
			if(find.length == 5 && find[2].trim().equals("-type")) {
				if(!Pattern.matches("-date|-length", find[4])) {
					System.err.println("Please give proper find command");
					System.exit(0);
				}
			}

			// If user gives . get the current directory path
			if (find[1].equals(".")) {
				directoryPath = System.getProperty("user.dir");
			} else {
				directoryPath = find[1].trim();
			}
			System.out.println(directoryPath);

			// Create a new file with those directory
			File file = new File(directoryPath);
			File[] files = file.listFiles();

			for (File getFile : files) {

				// Get the file for the particular name
				if (find.length == 4 && find[2].equals("-name")) {
					getFileName(getFile, find[3]);

				} else if (find.length == 4 && find[2].equals("-type")) { // Get the files or dir starting from the
																			// current dir
					if (find[3].equals("f")) {
						getAllFile(getFile);
					} else if (find[3].equals("d")) {
						getAllDirectory(getFile);
					}

				} else if (find.length == 5 && find[2].equals("-type")) { // Get the file or dir starting from the
																			// current dir append with the modified date
																			// or by the length
					if (find[4].equals("-date")) {
						getDateFile(getFile, find[3]);
					} else if (find[4].equals("-length")) {
						getFileLength(getFile, find[3]);
					}
				}
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Exception Occurs");
			e.printStackTrace();
		}
	}

	/**
	 * This method will check the every dir starting from the current dir to get the
	 * file
	 * 
	 * @param get
	 *            File or folder path
	 * @param name
	 *            Name of the file to be search
	 */
	public static void getFileName(File get, String name) {
		if (get.isFile()) {
			if (Pattern.matches(".*"+name+".*", get+""))
				System.out.println("File is present::" + get);
		}

		if (get.isDirectory()) {
			File file = new File(get + "");
			File[] files = file.listFiles();
			for (File file2 : files) {
				getFileName(file2, name);
			}
		}
	}

	/**
	 * 
	 * This method will print the all the files for the path starting from the
	 * current dir
	 * 
	 * @param get
	 *            File or folder path
	 */
	public static void getAllFile(File get) {
		if (get.isFile()) {
			System.out.println("File::" + get);
		}

		if (get.isDirectory()) {
			File file = new File(get + "");
			File[] files = file.listFiles();
			for (File file2 : files) {
				getAllFile(file2);
			}
		}
	}

	/**
	 * 
	 * This method will print the all the folders for the path starting from the
	 * current dir
	 * 
	 * @param get
	 *            File or folder path
	 */
	public static void getAllDirectory(File get) {
		if (get.isDirectory()) {
			System.out.println("Directory::" + get);
			File file = new File(get + "");
			File[] files = file.listFiles();
			for (File file2 : files) {
				getAllDirectory(file2);
			}
		}
	}

	/**
	 * 
	 * This method will print the all the files or the folder of the path starting
	 * from the current dir with the last modified date
	 * 
	 * @param get
	 *            File or folder path
	 * @param dir::
	 *            file or dir
	 */
	public static void getDateFile(File get, String dir) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		if (get.isFile()) {
			if (dir.equals("f"))
				System.out.println("File::" + get + " Date Modified::" + dateFormat.format(get.lastModified()));
		}

		if (get.isDirectory()) {
			if (dir.equals("d"))
				System.out.println("Directory::" + get + " Date Modified::" + dateFormat.format(get.lastModified()));
			File file = new File(get + "");
			File[] files = file.listFiles();
			for (File file2 : files) {
				getDateFile(file2, dir);
			}
		}
	}

	/**
	 * 
	 * This method will print the all the files starting from the current dir with
	 * the length of the file
	 * 
	 * @param get
	 *            File or folder path
	 * @param dir::
	 *            file or dir
	 */
	public static void getFileLength(File get, String dir) {
		if (get.isFile()) {
			if (dir.equals("f"))
				System.out.println("File::" + get + " Length::" + get.length() + " bytes");
		}

		if (get.isDirectory()) {
			if (dir.equals("d"))
				System.out.println("Directory::" + get + " Length::" + get.length() + " bytes");
			File file = new File(get + "");
			File[] files = file.listFiles();
			for (File file2 : files) {
				getFileLength(file2, dir);
			}
		}
	}

}

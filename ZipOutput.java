
/*
 * ZipOutput.java
 * 
 * Versions
 * 		10/21/2017
 * 
 * Revisions
 * 		7.3.b
 */

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * 
 * This program will read the user text file and copy the contents into the own
 * created text file and also it will generate the contents in the text file and
 * append it into the end of the file.
 * 
 * Contenttrue.txt file is needed to start the ZipOutput program to execute
 * 
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class ZipOutput {
	/**
	 * This is the main method
	 * 
	 * @param args
	 */
	String textFile;
	String outputHashCode;

	public ZipOutput(String textFile) {
		this.textFile = textFile;
	}

	public File output() {
		File file = new File("zip.txt");
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			// Importing the file
			Scanner scanner = new Scanner(new File(textFile));
			String text = "";
			while (scanner.hasNextLine()) {
				text = text + scanner.nextLine() + "\n";
			}

			// Generate the hashcode value
			messageDigest(text);

			// Creating the new file.
			file.createNewFile();
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);

			// Writing into the file
			bufferedWriter.write(text);
			bufferedWriter.write("Hashcode::" + outputHashCode);
			bufferedWriter.flush();
			bufferedWriter.close();
			scanner.close();
		} catch (IOException e) {
			System.out.println("IO Exception Occurs");
			e.printStackTrace();

		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException Occurs");
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * This method will generate the hashcode using MD5 algorithm
	 * 
	 * @param text::
	 *            Text contents to be stored in the file
	 * @throws NoSuchAlgorithmException::
	 *             If this doesnot found as the algorithm it will throw exception
	 */
	public void messageDigest(String text) throws NoSuchAlgorithmException {
		MessageDigest m = java.security.MessageDigest.getInstance("MD5");
		m.update(text.getBytes());

		byte[] bytedigest = m.digest();
		StringBuffer sbwritten = new StringBuffer(bytedigest.length * 2);
		for (byte b : bytedigest)
			sbwritten.append(String.format("%02x", b));

		outputHashCode = sbwritten.toString();
	}
}

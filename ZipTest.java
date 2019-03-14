
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
import java.security.NoSuchAlgorithmException;

/**
 * 
 * This program contains two test cases
 * 
 * 1) Both hashcodes should be same
 * 
 * 2) hashcode should be different
 * 
 * Contenttrue.txt file is needed to start the ZipOutput program to execute
 * 
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class ZipTest {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		// For equal Hashcode
		System.out.println("For Equal Hashcode");
		String contentTrue = "contenttrue.txt";
		ZipOutput output = new ZipOutput(contentTrue);
		File file = output.output();
		ZipInput input = new ZipInput(file);
		input.input();
		System.out.println("Output HashCode::" + output.outputHashCode);
		System.out.println("Input HashCode::" + input.inputHashCode);

		System.out.println();

		String text = "Replacing Contents to prove the hashcode becomes false";
		System.out.println("For UnEqual Hashcode");
		output.messageDigest(text);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		bufferedWriter.write(text);
		bufferedWriter.write("\n");
		bufferedWriter.write("Hashcode::" + output.outputHashCode);
		bufferedWriter.flush();
		bufferedWriter.close();
		ZipInput input2 = new ZipInput(file);
		input2.input();
		System.out.println("Output HashCode::" + output.outputHashCode);
		System.out.println("Input HashCode::" + input.inputHashCode);
	}

}

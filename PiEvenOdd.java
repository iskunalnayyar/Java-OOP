
/*
 * PiEvenOdd.java
 * 
 * Versions
 * 		10/17.2017
 * 
 * Revisions
 * 		7.1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * This program will read the file containing 1024000 digits of pi and count the
 * even and odd number in that file and figure out the time taken by the program
 * to execute.
 * 
 * cat /home/fac/hpb/data.txt | java PiEvenOdd
 * 
 * Cat command is the viewer command where the user can view the file. Using
 * pipeline will send the contents of the text file and to that java program for
 * the further processing
 * 
 * 
 * java PiEvenOdd /home/fac/hpb/data.txt 
 * 
 * Above command line will pass the text
 * as the argument to the java program for the further execution.
 * 
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class PiEvenOdd {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// Reading the file
		Scanner scanner = new Scanner(new File("data.txt"));
		String pi = null;
		double odd = 1, even = 0;

		// Store the contents of the file into the string
		while (scanner.hasNext()) {
			pi = scanner.next();
		}

		char[] piArray = pi.toCharArray();

		// Count the even and odd numbers in the piArray
		for (int i = 2; i < piArray.length; i++) {
			if (piArray[i] % 2 == 0) {
				even++;
			} else if (piArray[i] % 2 != 0) {
				odd++;
			}
		}

		System.out.println("even = " + (int) even);
		System.out.println("odd = " + (int) odd);

		double result = odd / even;

		System.out.println("odd / even = " + result);
		scanner.close();
	}

}

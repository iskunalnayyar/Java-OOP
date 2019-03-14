import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * PiEvenOdd2.java
 * 
 * Versions
 * 		10/17.2017
 * 
 * Revisions
 * 		7.2
 */

/**
 * 
 * This program will increase the performance of the program by reading the file
 * containing 1024000 digits of pi using buffered reader and count the even and
 * odd number in that file and figure out the time taken by the program to
 * execute.
 * 
 * 
 * Buffered Reader used two parameters for the constructor. One to read the
 * file using file Reader and other one is buffer size. Increase in the buffer
 * size will lead into the better performance. Once at the certain point, even
 * if you increase the buffer size the performance or the execution speed of the
 * program remains same.
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class PiEvenOdd2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Importing the file from user
		File file = new File("data.txt");

		// Read the text file using BUffered Reader
		BufferedReader reader = new BufferedReader(new FileReader(file), 512);
		String pi = null;
		double odd = 1, even = 0;

		// WHile the contents are present in the file
		while ((pi = reader.readLine()) != null) {
			char piArray[] = pi.toCharArray();

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
		}
		reader.close();
	}

}

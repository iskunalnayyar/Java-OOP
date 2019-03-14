
/*
 * PiMultiThreaded.java
 * 
 * Versions
 * 		10/28/2017
 * 
 * Revisions
 * 		8.1
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * PiMultiThreaded class will read the files and determine the even and odds
 * based on the multi threads
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */

public class PiMultiThreaded extends Thread {

	private static BufferedReader bufferedReader;
	private static String nextLine = null;
	private int startIndex;
	private int endIndex;
	private static char[] piArray;
	private double even = 0, odd = 1;

	/**
	 * Constructor class will set the start and end values of the different thread
	 * objects
	 * 
	 * @param startIndex
	 * @param endIndex
	 */
	public PiMultiThreaded(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	/**
	 * Override run method will be called based on the thread scheduler to determine
	 * even or odds in the file
	 */
	public void run() {
		for (int index = startIndex; index <= endIndex; index++) {
			if (piArray[index] % 2 == 0) {
				even++;
			} else if (piArray[index] % 2 != 0) {
				odd++;
			}
		}
	}

	/**
	 * return current thread class even counts
	 * 
	 * @return even counts
	 */
	private double getEven() {
		return this.even;
	}

	/**
	 * return current thread class odd counts
	 * 
	 * @return odd counts
	 */
	private double getOdd() {
		return this.odd;
	}

	/**
	 * This is the main method class
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		int cores = Runtime.getRuntime().availableProcessors();

		long startTime = System.currentTimeMillis();
		try {
			bufferedReader = new BufferedReader(new FileReader(new File("data.txt")), 512);
			while ((nextLine = bufferedReader.readLine()) != null) {
				piArray = nextLine.toCharArray();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int length = piArray.length;

		System.out.println("The number of cores available is ::" + cores);

		if (cores >= 8) {
			// Creating different thread objects
			PiMultiThreaded t0 = new PiMultiThreaded(2, (length / 6) - 1); // for length = 30 , [2, 4]
			PiMultiThreaded t1 = new PiMultiThreaded(length / 6, (length / 3) - 1); // [5,9]
			PiMultiThreaded t2 = new PiMultiThreaded(length / 3, ((length / 3) * 2) - (length / 6) - 1); // [10,14]
			PiMultiThreaded t3 = new PiMultiThreaded(((length / 3) * 2) - (length / 6), (((length / 3) * 2 - 1))); // [15,19]
			PiMultiThreaded t4 = new PiMultiThreaded(((length / 3) * 2), (length - (length / 6)) - 1);
			PiMultiThreaded t5 = new PiMultiThreaded((length - (length / 6)), (length) - 1);

			// start all the threads at the same time to run as multi threads
			t0.start();
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();

			// Waiting for all the threads to finish the job
			t0.join();
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();

			// Getting even and odd counts for all the thread objects
			double totalEvenCount = t0.getEven() + t1.getEven() + t2.getEven() + t3.getEven() + t4.getEven()
					+ t5.getEven();
			double totalOddCount = t0.getOdd() + t1.getOdd() + t3.getOdd() + t2.getOdd() + t4.getEven() + t5.getEven();
			System.out.println("even = " + (int) totalEvenCount);
			System.out.println("odd = " + (int) totalOddCount);

			double result = totalOddCount / totalEvenCount;

			System.out.println("odd / even = " + result);

			long endTime = System.currentTimeMillis();
			System.out.println("Total time::" + (endTime - startTime) + " ms");
		} else {
			// Creating different thread objects
			PiMultiThreaded t0 = new PiMultiThreaded(2, (length / 4) - 1);
			PiMultiThreaded t1 = new PiMultiThreaded(length / 4, (length / 2) - 1);
			PiMultiThreaded t2 = new PiMultiThreaded(length / 2, ((length / 4) * 3) - 1);
			PiMultiThreaded t3 = new PiMultiThreaded((length / 4) * 3, length - 1);

			// start all the threads at the same time to run as multi threads
			t0.start();
			t1.start();
			t2.start();
			t3.start();

			// Waiting for all the threads to finish the job
			t0.join();
			t1.join();
			t2.join();
			t3.join();

			// Getting even and odd counts for all the thread objects
			double totalEvenCount = t0.getEven() + t1.getEven() + t2.getEven() + t3.getEven();
			double totalOddCount = t0.getOdd() + t1.getOdd() + t3.getOdd() + t2.getOdd();
			System.out.println("even = " + (int) totalEvenCount);
			System.out.println("odd = " + (int) totalOddCount);

			double result = totalOddCount / totalEvenCount;

			System.out.println("odd / even = " + result);

			long endTime = System.currentTimeMillis();
			System.out.println("Total time::" + (endTime - startTime) + " ms");
		}

	}
}

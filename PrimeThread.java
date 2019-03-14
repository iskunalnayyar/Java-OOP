/*
 * PrimeThread.java
 * 
 * Versions
 * 		10/28/2017
 * 
 * Revisions
 * 		8.4
 */

/**
 * PrimeThread class will run the to get the prime from 0 to 8 * MAX using
 * multiple threads and store it in the byte array and extract those byte array
 * to get the only primes and perform calculations
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class PrimeThread extends Thread {
	private final static int MAX = 800000;
	private static int total = 8 * MAX;
	private int startIndex, endIndex;
	private static byte[] allThePrimeNumbers = new byte[MAX];
	private static boolean[] isPrimeBoolean = new boolean[total];
	private static final int cores = Runtime.getRuntime().availableProcessors();

	// Paramaterized Constrcutor to run for certain indexes for multiple threads
	public PrimeThread(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	/**
	 * Overrides run method from the thread class and get the prime numbers using
	 * multiple threads
	 */
	public void run() {
		for (int index = startIndex; index <= endIndex; index++) {
			isPrimeBoolean[index] = isPrime(index);
		}
	}

	/**
	 * 
	 * This method will determine whether the value is prime or not
	 * 
	 * @param index
	 *            ranges between 0 to total
	 * @return boolean result
	 */
	public boolean isPrime(int index) {
		int count = 0;
		if (index <= 1) {
			return false;
		} else {
			double endLimit = Math.sqrt(index);
			int limit = (int) Math.round(endLimit);
			for (int i = 1; i <= limit; i++) {
				if (index % i == 0)
					count++;
			}
			if (count == 1)
				return true;
			else
				return false;
		}
	}

	/**
	 * Compress the boolean array into the byte array and extract it to get only
	 * prime numbers and perform some calculations
	 */
	public static void getByteArray() {
		int count = -1, index = 0;
		int[] onlyPrime = new int[total];
		// storing the boolean array into the byte array
		for (int i = 0; i < allThePrimeNumbers.length; i++) {
			for (int bit = 0; bit < 8; bit++) {
				if (isPrimeBoolean[i * 8 + bit]) {
					allThePrimeNumbers[i] |= 128 >>> bit;
				}
			}
		}

		// extracting the byte array and store only prime numbers in a seperate array
		for (byte b : allThePrimeNumbers) {
			String bits = Integer.toBinaryString(b & 255 | 256).substring(1);
			for (int i = 0; i < bits.length(); i++) {
				count++;
				if (bits.charAt(i) == '1') {
					onlyPrime[index++] = count;
				}
			}
		}
		int primeCalculate = onlyPrime[0];

		// calculate the vaules using the found primes
		for (int i = 1; i < onlyPrime.length; i++) {
			if (i % 2 != 0) {
				primeCalculate = (primeCalculate - onlyPrime[i]) % MAX;
			} else if (i % 2 == 0) {
				primeCalculate = (primeCalculate + onlyPrime[i]) % MAX;
			}
		}
		System.out.println("Total calculation made from the prime::" + primeCalculate);
	}

	/**
	 * This is the main method class
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		if (cores >= 8) {
			long startTime = System.currentTimeMillis();
			PrimeThread t0 = new PrimeThread(0, (total / 6 - 1));
			PrimeThread t1 = new PrimeThread(total / 6, (total / 3 - 1));
			PrimeThread t2 = new PrimeThread(total / 3, (total / 2) - 1);
			PrimeThread t3 = new PrimeThread((total / 2), (total / 3) * 2 - 1);
			PrimeThread t4 = new PrimeThread((total / 3) * 2, (total / 6) * 5 - 1);
			PrimeThread t5 = new PrimeThread((total / 6) * 5, (total) - 1);
			t0.start();
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();

			t0.join();
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();

			getByteArray();
			long endTime = System.currentTimeMillis();
			System.out.println("Total time::" + (endTime - startTime) + " ms");
		} else {
			long startTime = System.currentTimeMillis();
			PrimeThread t0 = new PrimeThread(0, (total / 4 - 1));
			PrimeThread t1 = new PrimeThread(total / 4, (total / 2 - 1));
			PrimeThread t2 = new PrimeThread(total / 2, (total / 4) * 3 - 1);
			PrimeThread t3 = new PrimeThread((total / 4) * 3, total - 1);

			t0.start();
			t1.start();
			t2.start();
			t3.start();
			t0.join();
			t1.join();
			t2.join();
			t3.join();

			getByteArray();
			long endTime = System.currentTimeMillis();
			System.out.println("Total time::" + (endTime - startTime) + " ms");
		}
	}
}

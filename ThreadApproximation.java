
/*
 * ThreadApproximation.java
 * 
 * Versions
 * 		10/28/2017
 * 
 * Revisions
 * 		8.3
 */

/**
 * ThreadApproximation will determine the volume of both the left Approximation
 * and right approximation and modulus difference between those two should be
 * less than 0.0001
 * 
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */

public class ThreadApproximation extends Thread {

	public static double divisions = 0.5; // basecase
	public static double deltaX = 2; // TO determine the length between two coordinates of X
	public static double deltaY = 2; // TO determine the length between two coordinates of Y
	public int startLengthOfX = -4, endLengthOfX = 4, startlengthOfY = -4, endLengthOfY = 4;
	public double leftAreaApprox = 0.0, rightAreaApprox = 0.0;

	/**
	 * run method overrides method from the thread class and it will calculates the
	 * riemann left and right sum approximation
	 */
	public void run() {

		if (currentThread().getName().equals("11")) {
			leftApprox();
			// System.out.println("::" + leftAreaApprox);
		}

		if (currentThread().getName().equals("12")) {
			rightApprox();
			// System.out.println(";;" + rightAreaApprox);
		}
	}

	/**
	 * leftApprox() will calculate the volume of the left side of the shape
	 */
	public void leftApprox() {
		double leftX = startLengthOfX, leftY = startlengthOfY, leftZ = 0.0;
		leftAreaApprox = 0.0;

		for (double i = leftX; i < 0; i = i + deltaX) {
			for (double j = leftY; j < endLengthOfY; j = j + deltaY) {
				leftZ += (i * i) + (j * j);
			}
			break;
		}
		
		leftAreaApprox = deltaX * deltaY * leftZ;
	}

	/**
	 * rightApprox() will calculate the volume of the right side of the shape
	 */
	public void rightApprox() {
		double rightX = startLengthOfX + deltaX, rightY = startlengthOfY + deltaY, rightZ = 0.0;
		rightAreaApprox = 0.0;

		for (double i = rightX; i <= 0; i = i + deltaX) {
			for (double j = rightY; j <= endLengthOfY + deltaY; j = j + deltaY) {
				rightZ += (i * i) + (j * j);
			}
			break;
		}
		rightAreaApprox = deltaX * deltaY * rightZ;
	}

	public double getLeftApprox() {
		return this.leftAreaApprox;
	}

	public double getRightApprox() {
		return this.rightAreaApprox;
	}

	/**
	 * This is the main method
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// loop runs till the diff between left volume and right volume should be less
		// than 0.0001
		while (true) {

			// Creates two threads for every iteration
			ThreadApproximation t0 = new ThreadApproximation();
			ThreadApproximation t1 = new ThreadApproximation();

			divisions = divisions + 1;
			deltaX = deltaX / divisions;
			deltaY = deltaY / divisions;

			// setting the constants names for every threads
			t0.setName("11");
			t1.setName("12");
			t0.start();
			t1.start();
			t0.join();
			t1.join();
			// finding the difference between two volumes
			double result = Math.abs(t0.leftAreaApprox - t1.rightAreaApprox);
			System.out.println("Diff between green and yellow volume::"+result);
			if (result <= 0.0001) {
				System.out.println();
				System.out.println(result+" is less than 0.0001  ");
				break;
			} else
				continue;
		}
	}

}

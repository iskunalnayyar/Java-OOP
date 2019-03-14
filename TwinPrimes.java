/*
 * TwinPrimes.java
 * 
 * Version:
 *      2.3
 *      09/09/2017
 */

import java.*;

/**
 * This program prints all sets of Twin Primes taking n from 1 to 1000,
 * then calling the function findTwinPrimes within the current range of [n,n+100]
 *
 * @author Kunal Nayyar
 * @author Maha Krishnan
 */

public class TwinPrimes
{

	public static void main(String[] args)
	{
		/**
		 * Main method of class TwinPrimes 
		 */
		int delta = 100;
		System.out.println("Twin Primes between 1 and 1000 are:");
		for (int index = 00; index < 1000; index += 100)
		{
			new TwinPrimes().findTwinPrimes(index, index + delta);
		}

	}

	private void findTwinPrimes(int start, int end)
	{
		/**
		 * Within the range [n,n+delta],
		 * this function checks for prime numbers 
		 * by calling helper function IsPrime
		 * for every two twin numbers [j,j+2] .
		 *
		 * @param start        start of range
		 * @param end        end of range
		 */

		int k;
		for (int j = start; j < end; j++)
		{
			if (isPrime(j) && isPrime(k = j + 2))
			{
				System.out.println("(" + j + "," + k + ")");
			}
		}
	}

	private static boolean isPrime(int n)
	{
		/**
		 * Checks if number is prime or not,
		 * using divisors from 1 till "square-root" of that number,
		 * as that covers all distinct divisors possible for any number.
		 *
		 * @param n integer number to be checked
		 */

		int count = 0;
		double endI = Math.sqrt(n);                    //square-root of n
		int newEndI = (int) Math.round(endI);        //check divisors from 2 to sqrt(n)
		for (int i = 1; i <= newEndI; i++)
		{
			if (n % i == 0)
			{
				count++;
			}
		}
		return count == 1;                            // returns if the condition is true
	}

}
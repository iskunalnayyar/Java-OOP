
/*
 * P.java
 *
 * Version:
 *    09/03/2017
 *
 * Revisions:
 * 		1.2
 */

import java.util.Scanner;

/**
 * This program which calculates f(n) for a given expression, where 2 ≤ n ≤ 100.
 *
 *
 *
 * @author      Kunal Nayyar
 * @author      Maha Krishnan Krishnan
 *
 */

public class P
{
	/**
	 * This is the main method class
	 *
	 * @param            n                     Input the value for P(n) := 2 * P(n-1) + P(n-2); where n ≥ 2
	 * @param            anArray               calculates the value each element in array until the maximum value.
	 *
	 *
	 */

	public static void main(String args[])
		{
			System.out.println("Enter value of n: ");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();


			Double[] anArray = new Double[101];	   // creates a new array of double type since int won't work for size of the data in the program
			anArray[0]= new Double("0") ;      //creates a new obj for anArray[0]
			anArray[1]= new Double("1");       // creates a new obj for anArray[1]
			System.out.println("anArray[0]  : " +anArray[0]);
			System.out.println("anArray[1]  : " +anArray[1]);


			for(int i=2; i<=100; i++)
			{
				anArray[i]= ((anArray[i-1] * 2 + (anArray[i-2])));  //calculates anArray[i] for ith value

				System.out.println("anArray["+i+"] : " +anArray[i]);
			}
		}
}

/*
 * E.java
 *
 * Version:
 *    09/03/2017
 *
 * Revisions:
 * 		1.3
 *
 */


import java.util.Scanner;

/**
 * This program prints the absolute value of the difference between fn(0.5) & fi(0.5) where it is less than delta.
 * Delta is hardcoded to be 1.
 *
 *
 * @author      Kunal Nayyar
 * @author      Maha Krishnan Krishnan
 *
 *
 */

class E
{
	/**
	 * This is the main method class
	 *
	 * @param            n                  Input the range
	 * @param            sum1               calculates the value of the finite exponent series.
	 * @param            sum2               calculates the value of the infinite exponent series.
	 * @param            sumCheck           stores the value of the last added term 'n'
	 * @param            result             stores the difference of sum1 and sum2
	 * @param            value              stores the absolute value of the answer in result.
	 * @param            delta              delta set to 1
	 *
	 */

    static private void f (double x)
    {
        System.out.println("Enter value of n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum1 = 0.0;
        double sum2 = 0.0;
        double sumCheck;

        for (int i = 0; i <= n; i++)
        {
            sum1 = sum1 + expo(-x, i);
        }
        sumCheck = expo(-x, n-1); // stores the last term added. nth term.

        for (int j = 0; j <= 30; j++)
        {
            sum2 = sum2 + expo(-x, j);
        }
        double delta = 1;
        System.out.println("value of function is :" + sum1);
        System.out.println("value of last added term is:" + sumCheck);
        double result = sum1 - sum2; // stores the difference of sum1 and sum2.
        if (result < 0)
        {
            result = result * -1; // reverses the polarity of the result if it is negative.
        }
        if (result < delta)
        {
            System.out.println("value of n is: " + n); // checks if the result is less than delta.
        }
    }

    private static double expo (double x, int y) // a function that calculates the exponential value.
    {
        double value = 1.0;
        for (int j = 1; j<=y; j++)
        {
            value *= x;
        }
        return value;
    }

    public static void main(String args[])
    {
        E newVar = new E(); // Defining a new object to call the below function.
        newVar.f(0.5);
    }
}
/*
 * X.java
 *
 * Version:
 * 			09/17/2017
 *
 * Revisions:
 * 			3.1
 *
 */

/**
 * X.java will get to know how increment and decrement works and ternary
 * operators
 *
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 */

public class X
{
	public static void main(String[] args)
	{
		int n = 0;
		here:
		while (true)
		{
			// 1st loop :: n = 0 satisfies the while condition
			// 2nd loop :: n = 2 satisfies the while condition
			// 3rd loop :: n = 5 condition is not satisfied
			while (((n != 3) || (n != 5)) && (n < 4))
			{

				// 1st loop :: ++n --> first n is incremented to 1 and then it checks with the
				// value 0,
				// so the condition is not satisfied

				// 2nd loop :: ++n --> first n is incremented to 3 and then it checks with the
				// value 0,
				// so the condition is not satisfied
				if (++n == 0) System.out.println("a/  n is " + n);

					// 1st loop :: Now n = 1 n++ --> first n checks with 1 and then it incremented
					// to 2
					// condition satisfied. So it will print as b/ n is 2.. It will skip out the
					// remaining condition and goes to print the sysout statement

					// 2nd loop :: n++ --> first n is incremented to 4 and then it checks with the
					// value 1,
					// so the condition is not satisfied
				else if (n++ == 1)
				{
					System.out.println("b/  n is " + n);
				}

				// 2nd loop :: n++ --> first n is incremented to 5 and then it checks with the
				// value 1,
				// so the condition is not satisfied
				else if (n++ == 2) System.out.println("c/  n is " + n);

					// 2nd loop :: Now n = 5 : So it will print the else statement and the output is
					// d/ n is 5
				else System.out.println("d/  n is " + n);

				// 1st loop: Print the sysout statement
				// 2nd loop: Print the sysout statement
				System.out.println("    executing break here");
			}

			// Usually ternary operator starts with the rightmost operation
			// 1st it will execute n % 3 != 0 ? "3" : "!3" and returns 3
			// 2nd it will execute n == 4 ? "=" : "!" and returns !
			// atlast the ternary operator will be like this n % 2 == 0 ? "!" : "3" and it
			// returns 3
			// and then it breaks the while loop
			System.out.println(n % 2 == 0 ? (n == 4 ? "=" : "!") : (n % 3 != 0 ? "3" : "!3"));
			break here;
		}
	}
}

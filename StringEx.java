/*
 * StringEx.java
 *
 * Version:
 *        09/10/2017
 *
 * Revisions:
 *        2.5
 */

import java.lang.String;
import java.lang.*;


/**
 * This code checks if the given string is a palindrome,
 * and also finds all possible substrings of palindrome.
 *
 * @author Kunal Nayyar
 * @author Maha Krishnan
 */

class StringEx
{
	private static String[] aText = {"ab", "baB", "ba", "niT", "in"};


	public static void main(String args[])
	{
		/**
		 * This is the main method for the StringEx program
		 *
		 */

		String palindrome = "";            // empty string
		int wordLength;

		for (int i = 0; i < aText.length; i++)
		{
			palindrome = palindrome + aText[i]; // printing the concatenated aText
		}
		wordLength = palindrome.length();
		System.out.println("The given input in is: " + palindrome);
		for (int i = 0; i <= wordLength; i++)
		{
			for (int j = i + 1; j < wordLength; j++)
			{    //checks for each possible substring from i to j+1, while eliminating any single letters.
				if (palCheck(palindrome.substring(i, j + 1)))
				{
					System.out.println("A possible substring palindrome is " + palindrome.substring(i, j + 1));
				}
			}
		}
	}

	private static boolean palCheck(String palindrome)
	{
		/**
		 * This is a function meant to check if the character
		 * at the given position and its corresponding opposite
		 * position is the same character i.e. palindrome check
		 *
		 * @param palindrome    string that stores the given input
		 *
		 */

		for (int i = 0; i <= palindrome.length() / 2; i++)
			if (palindrome.toLowerCase().charAt(i) != palindrome.toLowerCase().charAt(palindrome.length() - 1 - i))
				return false;
		//the if statement treats the lowercase and uppercase letters equally
		return true;
	}

}
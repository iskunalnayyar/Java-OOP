/*
 * BackToTheFuture.java
 *
 * Version:
 * 			09/17/2017
 *
 * Revisions:
 * 			3.3
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * BackToTheFuture.java is the java implementation of the hangman game where we
 * import the file using Scanner class and choose a random word from the file
 * and user should have to guess that word. User will have 9 incorrect guesses.
 *
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 */

public class BackToTheFuture
{
	static private Scanner scanner = new Scanner(System.in);

	/**
	 * This is the main method where we import the file and pick one random word
	 * from that file
	 *
	 * @throws FileNotFoundException Handles the file not found exception
	 */
	
	public static void main(String[] args) throws FileNotFoundException
	{

		Scanner scan = new Scanner(new File("D:\\words.txt"));
		int index = 0;

		// To find index to create a String array
		while (scan.hasNext())
		{
			scan.next();
			index++;
		}

		System.out.println(index);
		String words[] = new String[index];

		scan = new Scanner(new File("D:\\words.txt"));
		index = 0;

		// To store the words in the array
		while (scan.hasNext())
		{
			words[index] = scan.next();
			index++;
		}

		// pick a random word using random class
		int randomIndex = new Random().nextInt(words.length);
		String word = words[randomIndex];
		String yn;
		do
		{
			guessWord(word);
			System.out.println("Do you want to continue (yes/no)?");
			yn = scanner.next();
		} while ("yes".equalsIgnoreCase(yn));
	}

	/**
	 * Guess word method will let the user to guess the word which was randomly pick
	 * by the system
	 * <p>
	 * Initially one full scene will appear and for every wrong guess some part of
	 * scene will get disappears. Once user done with the 9 guesses the game gets
	 * over
	 *
	 * @param word Stores the random word chosen from the file
	 */

	private static void guessWord(String word)
	{
		int wordLength = word.length();
		int wrongGuess = 0;
		int totalGuess = 9;
		int wordToFind = wordLength;

		String[] totalEmptyLength = new String[wordLength];

		// to show the number of characters for user
		for (int i = 0; i < wordLength; i++)
		{
			totalEmptyLength[i] = "_ ";
			System.out.print(totalEmptyLength[i]);
		}
		System.out.println();
		showScene(totalGuess - wrongGuess);

		// have to guess the word till it reaches the maximum guesses
		while (wrongGuess < totalGuess)
		{
			int count = 0;
			System.out.print("Enter a word:");
			String givenInput = scanner.next();

			// comparing the input from the user to the word from the file
			for (int i = 0; i < word.length(); i++)
			{
				if (givenInput.equalsIgnoreCase(word.charAt(i) + "") && totalEmptyLength[i].equalsIgnoreCase("_ "))
				{
					totalEmptyLength[i] = givenInput;
					count++;
					wordToFind--;
				}
			}

			// increment the wrong guess value if the letter is not in the word
			if (count == 0)
			{
				wrongGuess++;
			}

			for (int i = 0; i < totalEmptyLength.length; i++)
			{
				System.out.print(totalEmptyLength[i]);
			}
			System.out.println();

			// Once find all the letters the game terminates
			if (wordToFind == 0)
			{
				System.out.println("All Words guessed");
				break;
			}

			System.out.println("Total guesses remaining: " + (totalGuess - wrongGuess));

			// Show scene for the every guesses
			showScene(totalGuess - wrongGuess);
			System.out.println();
			System.out.println();
			if (wrongGuess == totalGuess)
			{
				System.out.println("Maximum number of guesses tried..");
			}

		}
	}

	/**
	 * showScene method will show the scene for every guess the user have
	 *
	 * @param guessRemaining Has the remaining number of guesses
	 */

	private static void showScene(int guessRemaining)
	{
		System.out.println();
		if (guessRemaining == 9)
		{
			System.out.println("                        ###  ");
			System.out.println("                        ###  ");
			System.out.println("                         #   ");
			System.out.println("                       ##### ");
			System.out.println("                     #  ##  #");
			System.out.println("                       ####  ");
			System.out.println("                      #    # ");
			System.out.println("                     ##    ##");
			System.out.println("##################################");
		} else if (guessRemaining == 8)
		{
			System.out.println("                        ###  ");
			System.out.println("                         #   ");
			System.out.println("                       ##### ");
			System.out.println("                     #  ##  #");
			System.out.println("                       ####  ");
			System.out.println("                      #    # ");
			System.out.println("                     ##    ##");
			System.out.println("##################################");
		} else if (guessRemaining == 7)
		{
			System.out.println("                         #   ");
			System.out.println("                       ##### ");
			System.out.println("                     #  ##  #");
			System.out.println("                       ####  ");
			System.out.println("                      #    # ");
			System.out.println("                     ##    ##");
			System.out.println("##################################");
		} else if (guessRemaining == 6)
		{
			System.out.println("                       ##### ");
			System.out.println("                     #  ##  #");
			System.out.println("                       ####  ");
			System.out.println("                      #    # ");
			System.out.println("                     ##    ##");
			System.out.println("##################################");
		} else if (guessRemaining == 5)
		{
			System.out.println("                     #  ##  #");
			System.out.println("                       ####  ");
			System.out.println("                      #    # ");
			System.out.println("                     ##    ##");
			System.out.println("##################################");
		} else if (guessRemaining == 4)
		{
			System.out.println("                       ####  ");
			System.out.println("                      #    # ");
			System.out.println("                     ##    ##");
			System.out.println("##################################");
		} else if (guessRemaining == 3)
		{
			System.out.println("                      #    # ");
			System.out.println("                     ##    ##");
			System.out.println("##################################");
		} else if (guessRemaining == 2)
		{
			System.out.println("                     ##    ##");
			System.out.println("##################################");
		} else if (guessRemaining == 1)
		{
			System.out.println("##################################");
		} else if (guessRemaining == 0)
		{
			System.out.println();
		}
	}

}

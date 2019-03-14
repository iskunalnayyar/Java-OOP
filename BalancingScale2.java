/*
 * BalancingScale2.java
 *
 * Version:
 *     09/10/2017
 *
 * Revisions:
 * 		2.2
 */

import java.util.Arrays;

/**
 * This program will balance the scale by adding appropriate weights on the both
 * side
 *
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 */

public class BalancingScale2
{

	static int[] weights = {1, 2, 3, 5, 30, 40, 45, 50};
	static int startIndex = 0;
	static int length = weights.length;

	static int count = 0;

	public static void main(String[] args)
	{
		/**
		 * This is the main method for BalancingScale2 program
		 */

		doWeightIt(0);
		doWeightIt(3);
		doWeightIt(5);
		doWeightIt(8);
		doWeightIt(37);
		doWeightIt(49);
		doWeightIt(87);
		doWeightIt(100);
		doWeightIt(14);
	}

	public static void doWeightIt(int weight)
	{
		/**
		 * doWeightIt method.. It will call the sumAllCombinations method to find sum of
		 * all possible combinations in an array and then it will compare the given
		 * weight with calculated weight
		 *
		 * @param weight    weight in grams
		 */

		Arrays.sort(weights);
		int digits = 1;
		int tempArray[] = new int[length];
		int sumAllArray[] = new int[(int) Math.pow(2, length)];
		String combiAllArray[] = new String[(int) Math.pow(2, length)];

		// Calls sumAllCombinations method by passing right parameters
		while (digits <= length)
		{
			int indexOfDigits = 0;
			sumAllCombinations(sumAllArray, combiAllArray, tempArray, digits, indexOfDigits, startIndex);
			digits++;
			indexOfDigits++;
		}

		// compares weight to provide the result
		if (weight > 0)
		{
			for (int i = 0; i < sumAllArray.length; i++)
			{
				if (weight == sumAllArray[i])
				{
					System.out.println(weight + "g: yes used weights = " + combiAllArray[i]);
					break;
				} else if (i == sumAllArray.length - 1 && weight != sumAllArray[i])
				{
					System.out.println(balanceScale(sumAllArray, combiAllArray, weight));
				}
			}
		} else if (weight == 0)
		{
			System.out.println(weight + "g: yes used weights = empty set");
		} else if (weight < 0)
		{
			System.out.println("Weight shouldn't be negative values");
		}

		count = 0;
	}

	private static void sumAllCombinations(int[] sumAllArray, String[] combiAllArray, int[] tempArray, int digits, int indexOfDigits, int startIndex)
	{
		/**
		 * sumAllCombinations will find all possible sum values using recursive
		 * functions
		 *
		 * @param tempArray            stores certain combinations from the given array of weights
		 * @param digits            number of indices used from given array
		 * @param indexOfDigits        used for temp array
		 * @param startIndex        starting index
		 * @param combiAllArray        stores all weights used to find the combination
		 * @param sumAllArray        stores sum of all possible combinations of an array
		 */

		int sum = 0;
		String combi = "";

		// Adding all combinations for certain digits
		if (indexOfDigits == digits)
		{
			for (int i = 0; i < indexOfDigits; i++)
			{
				sum = sum + tempArray[i];
				combi = combi + tempArray[i] + "g ";
			}
			sumAllArray[count] = sum;
			combiAllArray[count] = combi;
			count++;
		}

		// parsing the right values to find all combinations in an array
		for (int i = startIndex; i < length; i++)
		{
			tempArray[indexOfDigits] = weights[i];
			sumAllCombinations(sumAllArray, combiAllArray, tempArray, digits, indexOfDigits + 1, i + 1);
		}
	}

	private static String balanceScale(int[] sumArray, String[] combiArray, int thisWeight)
	{
		/**
		 * balanceScale method will balance the scale by adding appropriate weights
		 *
		 * @param thisWeight        weight given by user
		 * @param combiArray        stores all weights used to find the combination
		 * @param sumArray            stores sum of all possible combinations of an array
		 * @return result            returns result by adding and comparing weights.
		 */

		String result = "";
		for (int i = 0; i < weights.length; i++)
		{
			int leftWeight = thisWeight;
			leftWeight = leftWeight + weights[i];
			String combi = weights[i] + "g  ";
			for (int j = 0; j < sumArray.length; j++)
			{
				if (leftWeight == sumArray[j])
				{
					result = result + leftWeight + " Left side Weights Added = " + thisWeight + "g " + combi + "::::::";
					result = result + sumArray[j] + " Right side Weights Added = " + combiArray[j];
					return result;
				} else if (i == weights.length && j == sumArray.length && leftWeight != sumArray[j])
				{
					result = thisWeight + "g: no";
					return result;
				}
			}
		}
		return result;
	}
}

/*
* Test.java
*
* Versions
* 		10/08/2017
*
* Revisions
* 		6.2.b
*/


/**
 * Main Test class program
 *
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 */

import java.util.Random;

public class Test
{
	final static int MAX_SIZE = 10000;

	Random rand = new Random();
	int size = rand.nextInt(MAX_SIZE);
	//double size2 = rand.nextInt(MAX_SIZE) * 0.5;

	//MyStorage aStorage;

	int[] checkInt = new int[size];
	double[] checkDouble = new double[size];
	String[] checkString = new String[size];

	MyStorage<Integer> storesInt;
	MyStorage<Double> storesDouble;
	MyStorage<String> storesString;

	long milliSeconds = 0;

	public void startTime()
	{
		milliSeconds = System.currentTimeMillis();
	}


	public void endTime()
	{
		System.out.println("Time for all:    " + (System.currentTimeMillis() - milliSeconds));
	}

	public void addTest()
	{
		System.out.println("Add Tests STARTS HERE");
		addIntegers();
		addStrings();
		addDoubles();
		System.out.println("Add Tests ENDS HERE/");
	}


	public void addIntegers()
	{
		System.out.println("Total Integers to add: " + size);
		for (int i = 0; i < size; i++)
		{
			checkInt[i] = rand.nextInt(1000);
			storesInt.add(checkInt[i]);
		}
		System.out.println("Added Integer");
	}


	public void addDoubles()
	{
		System.out.println("Total Doubles to add: " + size);
		for (int j = 0; j < size; j++)
		{
			double digit = rand.nextDouble();
			checkDouble[j] = digit;
			storesDouble.add(digit);
		}
		System.out.println("Added Double");
	}


	public void addStrings()
	{
		System.out.println("Total Strings to add: " + size);
		for (int k = 0; k < size; k++)
		{
			checkString[k] = rand.nextInt(1000) + "";
			storesString.add(checkString[k]);
		}
		System.out.println("Added Strings");
	}


	public void removeTest()
	{
		System.out.println("Remove Tests STARTS HERE-");
		removeExistingElement();
		removeNonExistentElement();
		System.out.println("Remove Tests ENDS HERE/");
	}


	public void removeExistingElement()
	{
		removeInt();
		removeDouble();
		removeString();
	}


	public void removeInt()
	{
		boolean check = false;
		for (int i = 0; i < size; i++)
		{
			if (!(storesInt.remove(checkInt[i])))
			{
				check = true;
				break;
			}
			if (check)
			{
				System.out.println("Can't delete existing element");
			}
		}
	}

	public void removeDouble()
	{
		boolean check = false;
		for (int i = 0; i < size; i++)
		{
			if (!(storesDouble.remove(checkDouble[i])))
			{
				check = true;
				break;
			}
			if (check)
			{
				System.out.println("Can't delete existing element");
			}
		}
	}


	public void removeString()
	{
		boolean check = false;
		for (int i = 0; i < size; i++)
		{
			if (!(storesString.remove(checkString[i])))
			{
				check = true;
				break;
			}
			if (check)
			{
				System.out.println("Can't delete existing element");
			}
		}
	}


	public void removeNonExistentElement()
	{
		if (storesString.remove("-1"))
		{
			System.out.println("Removal of Non-Existent String Object FAILED");
		}
		if (storesInt.remove(-1))
		{
			System.out.println("Removal of Non-Existent Integer Object FAILED");
		}
		if (storesDouble.remove(-1.000d))
		{
			System.out.println("Removal of Non-Existent Double Object FAILED");
		}
	}


	public void clear()
	{
		storesInt.clear();
		storesDouble.clear();
		storesString.clear();
	}

	public void containsTest()
	{
		storesInt.add(1);
		if (storesInt.contains(1))
		{
			System.out.println("Contains test for integer PASSED");
		} else
		{
			System.out.println("Contains test for integer FAILED");
		}

		storesDouble.add(1.000d);
		if (storesDouble.contains(1.000d))
		{
			System.out.println("Contains test for double PASSED");
		} else
		{
			System.out.println("Contains test for double FAILED");
		}

		storesString.add("1");
		if (storesString.contains("1"))
		{
			System.out.println("Contains test for string PASSED");
		} else
		{
			System.out.println("Contains test for string FAILED");
		}
	}


	public void size()
	{
		System.out.println("Integer Storage Size is " + storesInt.size());
		System.out.println("Double Storage Size is " + storesDouble.size());
		System.out.println("String Storage Size is " + storesString.size());
	}


	public void isEmpty()
	{
		System.out.println("Integer Storage isEmpty " + storesInt.isEmpty());
		System.out.println("Double Storage isEmpty " + storesDouble.isEmpty());
		System.out.println("String Storage isEmpty " + storesString.isEmpty());
	}


	public String getClassName()
	{
		return storesDouble.getClassName();
	}


	public void testIt()
	{
		startTime();

		addTest();
		size();
		removeTest();
		isEmpty();
		containsTest();
		getClassName();

		endTime();
	}

	public void testSortedList()
	{
		this.storesInt = new MySortedList<>();
		this.storesString = new MySortedList<>();
		this.storesDouble = new MySortedList<>();
		testIt();
	}

	public void testHashSet()
	{
		System.out.println("HashSet Tests STARTS HERE-");
		this.storesInt = new MyHashSet<>();
		this.storesString = new MyHashSet<>();
		this.storesDouble = new MyHashSet<>();
		testIt();
		System.out.println("HashSet Tests ENDS HERE/\n");
	}

	public void testList()
	{
		System.out.println("List Tests STARTS HERE-");
		this.storesInt = new MyList<>();
		this.storesString = new MyList<>();
		this.storesDouble = new MyList<>();
		testIt();
		System.out.println("List Tests ENDS HERE/\n");
	}

	/**
	 * The main program
	 *
	 * @param args
	 */
	public static void main(String args[])
	{
		Test test = new Test();

		test.testHashSet();
		test.testList();
		test.testSortedList();
	}
}
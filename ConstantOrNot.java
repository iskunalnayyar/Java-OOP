/*
 * ConstantOrNot.java
 *
 * Version:
 * 			09/17/2017
 *
 * Revisions:
 * 			3.2
 *
 */

/**
 * Understanding the keyword final.
 *
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 */

class ConstantOrNot
{

	// All of these are global variables and can be used by all methods in this class
	// Once a variable has been assigned as final, it's value cannot be changed
	private final int aInt = 1;
	private final String aString = "abc";
	private String bString = "abc";
	private final String[] aArray = new String[10];

	public void doTheJob()
	{
		aInt = 3;                            // not possible to assign any value to a final string
		aString = aString + "abc";            // not possible to alter any value to a final string
		aString = aString;                    // pointless assignment when no operation can been performed to the final
		aString String
		aArray = new String[10];            // Cannot reinitialize the defined final array
		bString = aString;
		bString = aString + "def";
		aArray[0] = "abc";
	}

	public static void main(String args[])
	{
		new ConstantOrNot().doTheJob();
	}
}
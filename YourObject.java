package com.first.java;

/*
 * YourObject.java
 *
 * Version:
 * 		09/24/2017
 *
 * Revisions:
 * 		4.2
 */


class YourObject implements Cloneable
{
	/**
	 * This program is an example of inheritance
	 *
	 * @author Kunal Nayyar
	 * @author Maha Krishnan Krishnan
	 */

		public static void main(String[] args) throws CloneNotSupportedException
		{

			YourObject yourObject = new YourObject();
			YourObject yourObject2 = new YourObject();

			// clone()
			System.out.println("-----Your Object-------");
			yourObject.i = 5;
			System.out.println("yourObject.i::" + yourObject.i);

			yourObject2.i = 8;
			System.out.println("yourObject2.i::" + yourObject2.i);

			yourObject2 = yourObject.clone();
			System.out.println("After Cloning yourObject2.i::" + yourObject2.i);

			// equals
			YourObject yourObject3 = yourObject;
			System.out.println("yourObject equals yourObject2::" + (yourObject.equals(yourObject2)));
			System.out.println("yourObject equals yourObject3::" + (yourObject.equals(yourObject3)));

			// hashcode
			System.out.println("Hashcode fn::" + yourObject.hashCode());

			// toString
			System.out.println("yourObject.toString()::" + yourObject);

			// ClassName
			System.out.println("Get Class Name::" + yourObject.getClassName());

			System.out.println();
			System.out.println("-----Your String-------");
			System.out.println();

			YourString yourString = new YourString();
			YourString yourString2 = new YourString("Parameter");

			// YourString Constructors
			System.out.println("Calling Default Constructor::" + yourString);
			System.out.println("Calling Parameterized Constructor::" + yourString2);

			// Char At
			System.out.println("Char At::" + yourString.charAt(3));

			// Compare TO
			System.out.println("Comparing two String::" + yourString.compareTo(yourString2));

			// concat
			System.out.println("COncat two Strings::" + yourString.concat(yourString2));

			// toString
			System.out.println("String to String::" + yourString.toString());

			// Equals
			System.out.println("yourString equals yourString2::" + yourString.equals(yourString2));

			// isempty()
			System.out.println("String is EMpty::" + yourString.isEmpty());

			System.out.println();
			System.out.println("-----Your Integer-------");
			System.out.println();
			YourInteger yourInteger = new YourInteger();
			YourInteger yourInteger2 = new YourInteger(yourString);
			// Your Integer Constructors
			System.out.println("YourInteger default::" + yourInteger);
			System.out.println("YourInteger parameter::" + yourInteger2);

			// COmpare
			System.out.println("Compare two integers::" + yourInteger.compareTo(yourInteger2));

			// equals
			System.out.println("yourInteger equals yourInteger2::" + yourInteger.equals(yourInteger2));

			// toString
			System.out.println("String to String::" + yourInteger.toString());

		}

		int i;

		/**
		 * Creates and returns a copy of this object.
		 *
		 * @return cloned object
		 * @throws CloneNotSupportedException
		 */
		public YourObject clone() throws CloneNotSupportedException
		{
			return (YourObject) super.clone();
		}

		/**
		 * Indicates whether some objects is "equal to" this one.
		 *
		 * @param obj
		 * @return
		 */
		public boolean equals(Object obj)
		{
			return super.equals(obj);
		}

		/**
		 * Returns a hash code value for the object of super class.
		 *
		 * @return
		 */
		public int hashcode()
		{
			return super.hashCode();
		}

		/**
		 * Returns a string representation of the object.
		 */
		@Override
		public String toString()
		{
			return "YourObject [i=" + i + "]";
		}

		/**
		 * Returns the class name of the object
		 *
		 * @return
		 */
		public String getClassName()
		{

			return this.getClass().getName();
		}
	}

	class YourString extends YourObject
	{

		private String original;
		private String original1 = "";

		/**
		 * Default Constructor
		 */
		public YourString()
		{
			this.original = "Default";
			System.out.println("Default Constructor is created");
		}

		/**
		 * Parameterized Constructor
		 *
		 * @param original
		 */
		public YourString(String original)
		{
			this.original = original;
			System.out.println("Parameterized Constructor is created ::" + original);
		}

		/**
		 * Returns the char value at the specified index.
		 *
		 * @param index
		 * @return
		 */
		public char charAt(int index)
		{
			return original.charAt(index);
		}

		/**
		 * Compares two strings.
		 *
		 * @param anotherString
		 * @return 0 or integer depending on which string is greater
		 */

		public int compareTo(YourString anotherString)
		{
			return original.compareTo(anotherString.original);
		}

		/**
		 * Concatenates the specified string to the end of another value string.
		 *
		 * @param str
		 * @return
		 */
		public YourString concat(YourString str)
		{
			this.original = original.concat(str.original);
			return this;
		}

		/**
		 * Compares this string to the specified object. The result is true if and only
		 * if the argument is not null and is a String object, that represents the same
		 * sequence of characters as the object.
		 *
		 * @param anObject
		 * @return
		 */

		public boolean equals(Object anObject)
		{
			return super.equals(anObject);
		}

		/**
		 * Returns the string values or an object which is a reference address in a
		 * string
		 *
		 * @return
		 */
		@Override
		public String toString()
		{
			return "YourString [original=" + original + "]";
		}

		/**
		 * Returns true iff, length() is 0.
		 *
		 * @return
		 */
		public boolean isEmpty()
		{
			return original1.isEmpty();

		}
	}

	class YourInteger extends YourObject
	{
		static int MAX_VALUE;
		static int MIN_VALUE;
		static int SIZE;

		int yI;
		YourString yourStringInt;

		/**
		 * constructor of YourInteger
		 */
		public YourInteger()
		{
			yI = MAX_VALUE;
			System.out.println("Your Integer Default Constructor is created");
		}

		/**
		 * constructor of YourInteger
		 *
		 * @param original
		 */
		public YourInteger(YourString original)
		{
			this.yourStringInt = original;
			System.out.println("Your Integer Paramaterized Constructor is created:: " + yourStringInt);
		}

		/**
		 * Compares two Integer objects numerically.
		 *
		 * @param anotherInteger
		 * @return
		 */
		public int compareTo(YourInteger anotherInteger)
		{
			if (anotherInteger.yI > MIN_VALUE) return 1;
			else return -1;
		}

		/**
		 * Compares this object to the specified object.
		 *
		 * @param obj
		 * @return
		 */
		public boolean equals(Object obj)
		{
			System.out.println("This is in YourInteger Class");
			if (super.equals(obj))
			{
				return true;
			}
			return false;
		}

		/**
		 * Returns a String object representing this Integer's value.
		 *
		 * @return
		 */
		@Override
		public String toString()
		{
			return "YourInteger []";
		}

	}


//package com.first.java;
/*
 * JavaRunTimeVersion.java
 *
 * Version:
 *     09/03/2017
 *
 * Revisions:
 * 		1.1
 *
 */

import java.util.Enumeration;

/**
 * This program prints out the java run time version
 *
 * @author     Kunal Nayyar
 *
 */

public class JavaRunTimeVersion
{
		public static void main(String[] args)
		{
			double aDouble = 123456.78D;
			String format = "%,15.2f\n";
			System.out.println("The Old output is ----------");
			System.out.println("Hello World");
			System.out.printf("%-15.5s\n", "Hello World");
			System.out.printf("%15.5s\n", "Hell");
			System.out.printf("%,15.2f\n", aDouble);
			System.out.printf(format, aDouble);

			// The modification for just printing the JavaRunTimeVersion
			Enumeration allProp = System.getProperties().propertyNames();
			System.out.println("The main output is ---------");
			// Using the property java.runtime.version
			System.out.println("The java runtime version is: " + System.getProperty("java.runtime.version"));
		}
}


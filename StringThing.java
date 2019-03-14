/*
 * StringThing.java
 *
 * Version:
 *        2.4
 *        09/10/2017
 *
 * Revisions:
 *        1
 */

import java.*;


/**
 * This code contains answers as comments to the questions
 * specified in the assignment.
 * Also, the error in the code is corrected and runs successfully.
 *
 * @author Kunal Nayyar
 * @author Maha Krishnan
 */


public class StringThing
{
	private static void method(String id, String literal, String aNewString)
	{
		System.out.println("method!" + id + ". " + (literal == aNewString));
	}

	public static void main(String args[])
	{
		String aString = "123";
		String bString = "123";
		int number = 3;
		System.out.println("a.	" + "123" == aString);
		// Memory location/reference pointers for "123" and aString are checked, which are not the same,
		// hence it always returns False.
		// This prints a boolean false.

		System.out.println("b.	" + ("12" + number == aString));
		// Here the parenthesis will have higher precedence, therefore 12 will be concatenated with the number and
		// Since both do not refer to the same memory location i.e. false. This result is then concatenated with b.
		// Thus prints a new literal b. false

		System.out.println("c.	" + aString + 1 * 23);
		// This prints a new literal c. 12323. In this 1 is multiplied by 23 then is concatenated with
		// aString followed by literal c.

		System.out.println("d.	" + 123 + number + aString);
		// This prints a new literal d. 1233123. In this d is concatenated with 123 which converts to literal
		// and therefore performs concatenation with the number 3 and aString and returns a new literal.

		System.out.println("e.	" + (123 + number) + aString);
		// This prints a new literal e. 126123. Here parenthesis has higher priority and therefore performs arithmetic
		// addition and concatenates with aString.This is then concatenated with e and returns a new literal.

		System.out.println("f.	" + (123 - 2 + "" + number + aString));
		// This prints f. 1213123. In this ,parenthesis has higher priority. Therefore 123 is subtracted by 1 and then
		// concatenated with " " which is converted to a literal and performs concatenation with aString which is then
		// concatenated with f and returns a new literal

		System.out.println("g.	" + 123 * number + aString);
		// This prints g. 369123. Here the multiplication has higher precedence. Therefore it performs integer
		// multiplication and concatenates with g and aString thereby returning a new Literal.

		System.out.println("h.	" + 123 / number + aString);
		// This prints h. 41123.In this, Division has higher precedence.Therefore it performs integer division and
		// concatenates with h and aString thereby returning a new Literal.

		System.out.println("i.	" + (123 - number) + aString);
		// By order of operations, addition takes place first between ["i.   "+ 123 ],
		// and then the compiler tries to subtract [number] which is an INT from the concatenated String [i.	123].
		// Hence by adding parenthesis around [123 - number], where all both INTs,
		// the compiler concatenates it answer at the end with the string "i.  "
		// System.out.println("i.	" +   123 - number  + aString  );
		// Here it prints i. 120123. Because the parenthesis have a higher priority, integer subtraction is done first
		// and then it is concatenated with aString followed by i.


		method("1", "xyz", "x" + "yz");
		// prints method!1. True. Here, null string is concatenated with the literal xyz which is the same literal
		// as the literal xyz thereby referring to the same memory location. Hence returns boolean value true.
		// Therefore method! and id is concatenated with the equal to operator result.


		method("2", "xyz", new String("x") + "yz");
		// prints method!2. False. Here, null string is concatenated with the literal xyz which is not the same literal
		// as the literal xyz since we are creating a new string x. Hence returns boolean value false.
		// Then method! and id is concatenated with the equal to operator result.


		method("3", "xyz", "x" + "y" + "z");
		// prints method!3. True. Here, null string is concatenated with the literal xyz which is the same literal
		// as the literal xyz thereby referring to the same memory location. Hence returns boolean value true.
		// Therefore method! and id is concatenated with the equal to operator result.


		method("4", "1" + "2" + "3", "1" + 2 * 1 + 3);
		// prints method!4. True. Here, the multiplication takes precedence, then null string is concatenated
		// with the literal 123 which is the same literal as the literal 123 thereby referring to
		// the same memory location. Hence returns boolean value true.
		// Therefore method! and id is concatenated with the equal to operator result.


		method("5", "1" + "2" + "3", "1" + 2 + 3);
		// prints method!5. True. Here, null string is concatenated with the literal 123 which is the same literal
		// as the literal 123 thereby referring to the same memory location. Hence returns boolean value true.
		// Therefore method! and id is concatenated with the equal to operator result.


		method("6", "1" + "2" + "3", "1" + (3 - 1) + 3);
		// prints method!1. True. Here, the parenthesis take precedence and then null string is concatenated
		// with the literal 123 which is the same literal as the literal 123 thereby referring to
		// the same memory location. Hence returns boolean value true.
		// Therefore method! and id is concatenated with the equal to operator result.
	}
}

/* Collective Answer 2:
From a to i:
9 new literals are formed.

From 1 to 7:
1: 2 literals.
2: 1 string and 3 literals
3: 2 literals
4: 3 literals
5: 3 literals
6: 3 literals


/* Answer 3:

Garbage collection in java starts after the use of the variable and when the scope of the variable ends.

for a to i

The concatenation operations (+ operation) results in a literal which is
stored in the string pool. After the println statement ,the literal is marked for garbage collection
and once JVM realises that memory is full, it initiates the garbage collection by freeing the marked literals.


for 1 to 7

1,3,4,5,6-> The concatenation operations (+ operation) results in a literal which is stored in
the string pool. After the println statement, the literal is marked for garbage collection and once JVM
realises that memory is full, it initiates the garbage collection by freeing the marked literals.
Therefore garbage collection is initiated after execution of the method

2-> New operator creates a new string and is stored in the heap. It will be initialized for garbage
collection only when it is not referenced to something else.

*/
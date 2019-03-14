/*
 * MyFixedList2.java
 *
 * Versions
 * 		10/01/2017
 *
 * Revisions
 * 		5.2.b
 */
public class MyFixedList2 extends MyStorage2 {
	/**
	 * MyFixedList class extends the super class MyStorage which will pass the
	 * string and this class will store those objects into any arrays of fixed
	 * length
	 *
	 *
	 * @author Maha Krishnan Krishnan
	 * @author Kunal Nayyar
	 *
	 */

	int myFixedListIndex = 0, arrayLength = 100;

	String myFixedList[] = new String[arrayLength];

	/**
	 * This method will add the string values into the fixed length array which will
	 * pass from the test class
	 *
	 * @return boolean
	 */
	public boolean add(String e) {
		if (myFixedListIndex != arrayLength && e != null) {
			myFixedList[myFixedListIndex++] = e;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method will remove the objects from the particular index in the array
	 *
	 * @param o
	 * @return boolean
	 */
	public boolean remove(String o) {
		if (o != null) {
			for (int index = 0; index < myFixedListIndex; index++) {
				if (myFixedList[index] != null && myFixedList[index].equals(o)) {
					for (int j = index; j < myFixedListIndex; j++) {
						if (j + 1 != myFixedListIndex) {
							myFixedList[j] = myFixedList[j + 1];
						} else {
							myFixedList[j] = null;
						}
					}
					myFixedListIndex--;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method will clear the all the values in the array completely
	 */
	public void clear() {
		myFixedList = new String[arrayLength];
		myFixedListIndex = 0;
	}

	/**
	 * This method will the let user to know whether the array is empty or not
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (myFixedList.length > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method will check whether the particular value is present or not
	 * @param o
	 * @return boolean
	 */
	public boolean contains(String o) {
		for (int index = 0; index < myFixedListIndex; index++) {
			if (o != null && myFixedList[index] != null && myFixedList[index].equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The method will let the user to know the-exact length in the array
	 *
	 * @return int
	 */
	public int size() {
		return myFixedListIndex;
	}

	/**
	 * This method will return the name of the this class
	 *
	 * @return this.getClass()
	 */
	public String getClassName() {
		return this.getClass().getName();
	}
}

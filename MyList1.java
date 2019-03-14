/*
 * MyList1.java
 *
 * Versions
 * 		10/01/2017
 *
 * Revisions
 * 		5.1.c
 */
public class MyList1 extends MyStorage1 {
	/**
	 * My List class extends the super class MyStorage which will pass the string
	 * and this class will store those objects into any with dynamic arrays
	 *
	 *
	 * @author Maha Krishnan Krishnan
	 * @author Kunal Nayyar
	 *
	 */

	int myListIndex = 0, arrayLength = 100;

	String myList[] = new String[arrayLength];

	/**
	 * This method will add the string values into the dynamic array which will pass
	 * from the test class
	 *
	 * @return boolean
	 */
	public boolean add(String e) {

		// length of the array keeps on increasing if the index reaches the previous
		// size length
		if (myListIndex == arrayLength) {
			arrayLength = arrayLength * 2;
			String temp[] = myList;
			myList = new String[arrayLength];
			for (int i = 0; i < temp.length; i++) {
				myList[i] = temp[i];
			}
		}

		if (e != null) {
			myList[myListIndex++] = e;
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
			for (int index = 0; index < myListIndex; index++) {
				if (myList[index] != null && myList[index].equals(o)) {
					for (int j = index; j < myListIndex; j++) {
						if (j + 1 != myListIndex) {
							myList[j] = myList[j + 1];
						} else {
							myList[j] = null;
						}
					}
					myListIndex--;
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
		myList = new String[arrayLength];
		myListIndex = 0;
	}

	/**
	 * This method will the let user to know whether the array is empty or not
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (myList.length > 0) {
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
		for (int index = 0; index < myListIndex; index++) {
			if (o != null && myList[index] != null && myList[index].equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The method will let the user to know theexact length in the array
	 *
	 * @return int
	 */
	public int size() {
		return myListIndex;
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


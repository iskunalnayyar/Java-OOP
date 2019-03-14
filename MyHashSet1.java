/*
 * MyHashSet1.java
 *
 * Versions
 * 		10/01/2017
 *
 * Revisions
 * 		5.1.d
 */
public class MyHashSet1 extends MyStorage1 {
	/**
	 * MyHashSet class extends the super class MyStorage which will pass the string
	 * and this class will store those objects into any arrays and null values are
	 * permitted into arrays and also duplicate values are not allowed
	 *
	 *
	 * @author Maha Krishnan Krishnan
	 * @author Kunal Nayyar
	 *
	 */

	int map = 11, size = 10, nullCount = 0;
	String[][] myHashSet = new String[map][size];

	/**
	 * This method will return the default hash-code for the object
	 *
	 * @param e
	 * @return hashcode
	 */
	public int hashCode(String e) {
		int hashCode = 0;
		if (e != null) {
			for (int index = 0; index < e.length() - 1; index++) {
				hashCode += (int) Math.pow(31 * e.charAt(index), (e.length() - 1));
			}
		}
		return hashCode;
	}

	/**
	 * This method will store the values into the 2d array based on the hash-code %
	 * 10 which will be assigned into the first index of the array
	 *
	 * @param e
	 * @return boolean
	 */
	public boolean add(String e) {
		// Generating Hash code values for the object String
		int hashCode = Math.abs(hashCode(e));

		// To find map for the particular map Index and store it into the array
		if (e != null) {
			int hashMap = hashCode % 10;
			for (int index = 0; index < size; index++) {

				// If it reaches the size length it will increment the size length by 2
				if (index + 1 == size) {
					size = size * 2;
					String temp[][] = myHashSet;
					myHashSet = new String[map][size];
					for (int i = 0; i < map - 1; i++) {
						for (int j = 0; j < (size / 2); j++) {
							myHashSet[i][j] = temp[i][j];
						}
					}
				}

				if (nullCount != 0) {
					myHashSet[10][0] = null;
					nullCount++;
				}

				if (myHashSet[hashMap][index] == null && !contains(e)) {
					myHashSet[hashMap][index] = e;
					return true;
				}

			}
		} else if (e == null && nullCount == 0) {
			myHashSet[10][0] = null;
			nullCount++;
			return true;
		}
		return false;
	}

	/**
	 * This method will remove the objects from the particular index into the array
	 *
	 * @param o
	 * @return boolean
	 */
	public boolean remove(String o) {
		int hashCode = Math.abs(hashCode(o));
		int hashMap = hashCode % 10;

		if (o != null) {
			for (int index = 0; index < myHashSet[hashMap].length; index++) {
				if (myHashSet[hashMap][index] != null && myHashSet[hashMap][index].equals(o)) {
					for (int j = index; j < myHashSet[hashMap].length; j++) {
						if (j + 1 != myHashSet[hashMap].length) {
							myHashSet[hashMap][index] = myHashSet[hashMap][index + 1];
						} else {
							myHashSet[hashMap][index] = null;
						}
					}
					return true;
				}
			}
		} else if (o == null && nullCount != 0) {
			nullCount = 0;
			return true;
		}
		return false;
	}

	/**
	 * This method will check whether the particular value is present or not
	 *
	 * @param o
	 * @return boolean
	 */
	public boolean contains(String o) {
		int hashCode = Math.abs(hashCode(o));

		int hashMap = hashCode % 10;

		for (int index = 0; index < size; index++) {
			if (o != null && myHashSet[hashMap][index] != null && myHashSet[hashMap][index].equals(o)) {
				return true;
			} else if (o == null && nullCount != 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will clear the all the values in the array completely
	 */
	public void clear() {
		myHashSet = new String[map][size];
		nullCount = 0;
	}

	/**
	 * This method will the let user to know whether the array is empty or not
	 * @return boolean
	 */
	public boolean isEmpty() {
		for (int m = 0; m < map; m++) {
			for (int index = 0; index < size; index++) {
				if (myHashSet[m][index] != null) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * The method will let the user to know the-exact length in the array
	 *
	 * @return int
	 */
	public int size() {
		int count = 0;
		for (int m = 0; m < map; m++) {
			for (int index = 0; index < size; index++) {
				if (myHashSet[m][index] != null) {
					count++;
				}
			}
		}
		return count;
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

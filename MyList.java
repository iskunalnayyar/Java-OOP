import java.util.Vector;
/*
* MyList.java
*
* Versions
* 		10/08/2017
*
* Revisions
* 		6.2.b
*/

/**
 * My List class extends the super class MyStorage which will pass the string
 * and this class will store those objects into any with dynamic arrays
 *
 *
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class MyList<T> implements MyStorage<T> {

	Vector<T> myList = new Vector<T>();

	/**
	 * This method will add the string values into the dynamic vector which will pass
	 * from the test class
	 *
	 * @return boolean
	 */
	public boolean add(T e) {

		// length of the array keeps on increasing if the index reaches the previous
		// size length
		myList.add(e);
		return true;
	}

	/**
	 * This method will remove the objects from the particular index in the vector
	 *
	 * @param o
	 * @return boolean
	 */
	public boolean remove(T o) {
		return myList.remove(o);
	}

	/**
	 * This method will clear the all the values in the vector completely
	 */
	public void clear() {
		myList.clear();
	}

	/**
	 * This method will the let user to know whether the array is empty or not
	 *
	 * @return boolean
	 */
	public boolean isEmpty() {
		return myList.isEmpty();
	}

	/**
	 * This method will check whether the particular value is present or not
	 *
	 * @param o
	 * @return boolean
	 */
	public boolean contains(T o) {
		return myList.contains(o);
	}

	/**
	 * The method will let the user to know theexact length in the array
	 *
	 * @return int
	 */
	public int size() {
		return myList.size();
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

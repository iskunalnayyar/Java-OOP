/*
 * MyStorage.java
 *
 * Version:
 * 	10/01/2017
 *
 * Revisions 5.1.a
 *
 */
public class MyStorage1 {
	/**
	 * My Storage class contains list of methods that needs to override by the subclass
	 *
	 *
	 * @author Maha Krishnan Krishnan
	 * @author Kunal Nayyar
	 *
	 */

	/**
	 * This method will call the relative subclasses
	 *
	 * @param e
	 * @return boolean
	 */
	// true if e could have been added
	public boolean add(String e) {
		return true;
	}

	/**
	 * This method will call the relative subclasses
	 */
	// all elements will be removed
	public void clear() {
	}

	/**
	 * This method will call the relative subclasses
	 * @param o
	 * @return boolean
	 */
	// true if o is in storage
	public boolean contains(String o) {
		return true;
	}

	/**
	 * This method will call the relative subclasses
	 * @return boolean
	 */
	// true if storage is empty
	public boolean isEmpty() {
		return true;
	}

	/**
	 * This method will call the relative subclasses
	 *
	 * @param o
	 * @return boolean
	 */
	// true if o could be removied from storage
	public boolean remove(String o) {
		return true;
	}

	/**
	 * This method will call the relative subclasses
	 *
	 * @return int
	 */
	// # of elements in storage
	public int size() {
		return 0;
	}

	/**
	 * This method will call the relative subclasses
	 *
	 * @return this.className()
	 */
	// class name;
	public String getClassName() {
		return "MyStorage";
	}
}

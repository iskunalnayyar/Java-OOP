/*
 * MyStorage.java
 *
 * Version:
 * 	10/08/2017
 *
 * Revisions 6.2.a
 *
 */

/**
 * My Storage class contains list of abstract methods that needs to be implement
 * by the subclass
 *
 *
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */

public interface MyStorage<T> {


	/**
	 * This method will call the relative subclasses
	 *
	 * @param e
	 * @return boolean
	 */
	// true if e could have been added
	boolean add(T e);

	/**
	 * This method will call the relative subclasses
	 */
	// all elements will be removed
	void clear();

	/**
	 * This method will call the relative subclasses
	 *
	 * @param o
	 * @return boolean
	 */
	// true if o is in storage
	boolean contains(T o);

	/**
	 * This method will call the relative subclasses
	 *
	 * @return boolean
	 */
	// true if storage is empty
	boolean isEmpty();

	/**
	 * This method will call the relative subclasses
	 *
	 * @param o
	 * @return boolean
	 */
	// true if o could be removed from storage
	boolean remove(T o);

	/**
	 * This method will call the relative subclasses
	 *
	 * @return int
	 */
	// # of elements in storage
	int size();

	/**
	 * This method will call the relative subclasses
	 *
	 * @return this.className()
	 */
	// class name;
	String getClassName();
}

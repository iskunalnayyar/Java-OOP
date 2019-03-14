/*
 * MyStorage2.java
 *
 * Version:
 * 	10/01/2017
 *
 * Revisions 5.2.a
 *
 */
public abstract class MyStorage2 {
	/**
	 * My Storage class contains list of abstract methods that needs to be implement by the subclass
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
	public abstract boolean add(String e);

	/**
	 * This method will call the relative subclasses
	 */
	// all elements will be removed
	public abstract void clear();


	/**
	 * This method will call the relative subclasses
	 * @param o
	 * @return boolean
	 */
	// true if o is in storage
	public abstract boolean contains(String o);

	/**
	 * This method will call the relative subclasses
	 * @return boolean
	 */
	// true if storage is empty
	public abstract boolean isEmpty();

	/**
	 * This method will call the relative subclasses
	 *
	 * @param o
	 * @return boolean
	 */
	// true if o could be removed from storage
	public abstract boolean remove(String o);

	/**
	 * This method will call the relative subclasses
	 *
	 * @return int
	 */
	// # of elements in storage
	public abstract int size();

	/**
	 * This method will call the relative subclasses
	 *
	 * @return this.className()
	 */
	// class name;
	public abstract String getClassName();
}

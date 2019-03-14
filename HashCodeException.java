/*
 * HashCodeException.java
 * 
 * Versions
 * 		10/21/2017
 * 
 * Revisions
 * 		7.3.c
 */

/**
 * HashCodeException class is the user defined exception which extends the class
 * Exception and it will throw only when two hashcode values mismatches
 * 
 * 
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 *
 */
public class HashCodeException extends Exception {
	
	/**
	 * serialVersionUID is to define the particular class while serializing and deserializing
	 */
	private static final long serialVersionUID = 4136633144199100299L;

	@Override
	public String toString() {
		return "Hashcode verification failed :: "+serialVersionUID ;
	}
}

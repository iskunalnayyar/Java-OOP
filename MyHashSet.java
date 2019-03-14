/*
 * MyHashSet.java
 *
 * Versions
 * 		10/08/2017
 *
 * Revisions
 * 		6.2.d
 */


public class MyHashSet<T> implements MyStorage<T>
{
	int nullCount = 0, storeCount = 0, size = 100;
	T[] myHashSet = (T[]) new Comparable[size];

	/**
	 * This method will return the default hashcode for the object
	 *
	 * @param e
	 * @return hashcode
	 */
	public int hashCode(String e)
	{
		int hashCode = 0;
		if (e != null)
		{
			for (int index = 0; index < e.length() - 1; index++)
			{
				hashCode += (int) Math.pow(31 * e.charAt(index), (e.length() - 1));
			}
		}
		return hashCode;
	}

	/**
	 * This method will store the values into the array based on the hashcode %
	 * 10 which will be assigned
	 *
	 * @param e
	 * @return boolean
	 */
	public boolean add(T e)
	{
		// Generating Hash code values for the object String
		int hashCode = Math.abs(hashCode(String.valueOf(e)));
		int hashMap = hashCode % size;

		if (storeCount == size || contains(e))
		{
			return false;
		}
		if (e == null && nullCount == 0)
		{
			nullCount = 1;
			storeCount++;
			return true;
		}

		do
		{
			if (myHashSet[hashMap] != null)
			{
				hashMap = (hashMap + 1) % size;
			}
		} while (myHashSet[hashMap] != null);
		myHashSet[hashMap] = e;
		storeCount++;
		return true;
	}

	/**
	 * This method will remove the objects from the particular index in the generic array
	 *
	 * @param o
	 * @return boolean
	 */
	public boolean remove(T o)
	{
		int hashCode = Math.abs(hashCode(String.valueOf(o)));
		int hashMap = hashCode % size;
		int startMap = hashMap;

		if (o != null)
		{
			do
			{
				if (myHashSet[hashMap] != null && myHashSet[hashMap].equals(o))
				{
					myHashSet[hashMap] = null;
					int nextHashMap = (hashMap + 1) % size;
					while (myHashSet[nextHashMap] != null && nextHashMap != startMap)
					{
						if (((Math.abs(hashCode(String.valueOf(myHashSet[nextHashMap])))) % size) == startMap)
						{
							myHashSet[hashMap] = myHashSet[nextHashMap];
							myHashSet[nextHashMap] = null;
							hashMap = nextHashMap;
						}
						nextHashMap = (nextHashMap + 1) % size;
					}
					storeCount--;
					return true;
				} else
				{
					hashMap = (hashMap + 1) % size;
				}
			} while (myHashSet[hashMap] != null && startMap != hashMap);
		} else if (o == null && nullCount != 0)
		{
			nullCount = 0;
			storeCount--;
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
	public boolean contains(T o)
	{
		int hashCode = Math.abs(hashCode(String.valueOf(o)));
		int hashMap = hashCode % size;
		int startMap = hashMap;

		if (nullCount != 0)
		{
			return true;
		}

		do
		{
			if (myHashSet[hashMap] != null && myHashSet[hashMap].equals(o))
			{
				return true;
			} else
			{
				hashMap = (hashMap + 1) % size;
			}
		} while (myHashSet[hashMap] != null && startMap != hashMap);

		return false;
	}

	/**
	 * This method will clear the all the values in the generic array completely
	 */
	public void clear()
	{
		myHashSet = (T[]) new Comparable[size];
		nullCount = 0;
		storeCount = 0;
	}

	/**
	 * This method will the let user to know whether the generic array is empty or not
	 *
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		if (storeCount == 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * The method will let the user to know the exact length in the array
	 *
	 * @return int
	 */
	public int size()
	{
		return storeCount;
	}

	/**
	 * This method will return the name of the this class
	 *
	 * @return this.getClass()
	 */
	public String getClassName()
	{
		return this.getClass().getName();
	}

}

import java.util.Vector;
/*
* MySortedList.java
*
* Versions
* 		10/08/2017
*
* Revisions
* 		6.2.b
*/


/**
 * Main Test class program
 *
 * @author Maha Krishnan Krishnan
 * @author Kunal Nayyar
 */

public class MySortedList<T extends Comparable<T>> implements MyStorage<T>
{


	Vector<T> mySortedList = new Vector<T>();

	@Override
	public boolean add(T e)
	{
		if (isEmpty())
		{
			mySortedList.add(e);
		} else
		{
			mySortedList.add(e);

			for (int index = mySortedList.size() - 1; index > 0; index--)
			{
				T prevIndex = mySortedList.get(index - 1);
				int compareValue = prevIndex.compareTo(mySortedList.get(index));

				if (compareValue > 0)
				{
					T curValue = mySortedList.get(index);
					T prevValue = prevIndex;
					mySortedList.setElementAt(prevValue, index);
					mySortedList.setElementAt(curValue, index - 1);
				} else
				{
					break;
				}
			}
		}
		return true;
	}

	public boolean remove(T o)
	{
		return mySortedList.remove(o);
	}

	/**
	 * This method will clear the all the values in the vector completely
	 */
	public void clear()
	{
		mySortedList.clear();
	}

	/**
	 * This method will the let user to know whether the vector is empty or not
	 *
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return mySortedList.isEmpty();
	}

	/**
	 * This method will check whether the particular value is present or not
	 *
	 * @param o
	 * @return boolean
	 */
	public boolean contains(T o)
	{
		return mySortedList.contains(o);
	}

	/**
	 * The method will let the user to know the exact length in the vector
	 *
	 * @return int
	 */
	public int size()
	{
		return mySortedList.size();
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

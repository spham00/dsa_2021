package list;

/** 
 * An ADT for a Collection in which duplicates are permitted, 
 * and order is maintained.
 * 
 * @author (sdb)
 * @author	Sarah Pham
 * @version (September 2021)
 */
public interface List<E> {

	/** 
	 * @return the value at the given index in this List.
	 * @param 0 <= ndx < size
	 */
	public E get (int ndx);

	/** 
	 * Set the value at the given index to the given value.
	 * @return the old value.
	 * @param 0 <= ndx < size
	 */
	public E set (int ndx, E value);

	/** 
	 * Add the given value at the end of this List.
	 */
	public void add (E value);

	/** Insert the given value at the given index in this List
	 * @param 0 <= ndx <= size
	 */
	public void add (int ndx, E value);

	/**
	 * Remove the value at the given index from this List.
	 * @return the value which was removed.
	 * @param 0 <= ndx < size.
	 */
	public E remove (int ndx);

	/**
	 * @return the size of this List
	 */
	public int size();

	/**
	 * @return true iff this List is empty 
	 */
	public boolean isEmpty();

	/** Clear this List
	 */
	public void clear();

	/**
	 * Returns the index of the first occurrence of the specified Object.
	 * @param obj	The specified Object whose first occurrence index is to be found.
	 * @return		The position of the first occurrence of the given Object in this List,
	 * 				or -1 if it is not in this List.
	 */
	public int indexOf(Object obj);

	/**
	 * Returns true if the List contains the specified Object.
	 * @param obj	The specified Object that is meant to be found.
	 * @return		True only if the given Object is in this List.
	 */
	public boolean contains(Object obj);

	/**
	 * Removes the first occurrence of the specified Object from the List.
	 * @param obj	The specified Object to be removed.
	 * @return		Whether the removal was successful or not.
	 */
	public boolean remove(Object obj);

	/**
	 * Returns an Iterator for this List.
	 * @return	An Iterator for this List.
	 */
	Iterator<E> iterator();

	/** 
	 * Returns a ListIterator for this List.
	 * @return a ListIterator for this List 
	 */
	public ListIterator<E> listIterator();

	/** 
	 * Returns a ListIterator for this List starting from the given start position.
	 * @return a ListIterator for this List.
	 * @param start iterating at given start position.
	 * Initial call to previous() returns the value
	 * at position start-1
	 */
	public ListIterator<E> listIterator(int start);
	
	/** 
	 * @return true only if the parameter obj is a List and contains the same elements 
	  * (in the same sequence) as this List. 
	  */
	boolean equals (Object obj);
	
	// For quiz
	/** @return the position of the last occurrence of the given Object in this List,
	  *  or -1, if not found
	  */
	int indexOfLast (Object obj);
	
	/**
	 * Adds all the elements of the entered List to this List.
	 * @param List	The List that the user wants to add the elements of.
	 */
	boolean addAll(List<E> list);
	
	String toString();

}

package set;

import list.Iterator;

/** 
 * A collection with no duplicates. Ordering of the values need not be maintained
 * @author (sdb)
 * @author (Sarah Pham) 
 */
public interface Set<E>
{

	/** 
	 * @return true iff this Set contains the given object.
	 */
	boolean contains(Object obj);

	/** 
	 * Add the given value to this Set, if not aleady in this Set.
	 * @return true iff it was added.
	 */
	boolean add(E value);

	/** 
	 * Remove the given object from this Set, if possible.
	 * @return true iff it was removed.
	 */
	boolean remove(Object obj);

	/** 
	 * @return an Iterator for this Set 
	 */
	Iterator<E> iterator();
	
	/**
	 * Clear this set
	 */
	void clear();
	
	/**
	 * @return true iff this Set is empty
	 */
	boolean isEmpty();
	
	/**
	 * @return the number of valeus in this Set
	 */
	int size();
	
	/**
	 * @return true iff obj is a Set which contains the same values as this Set, and
	 * only those values which are in this Set
	 */
	boolean equals(Object obj);

	
}
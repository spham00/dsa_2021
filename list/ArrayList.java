package list;

import java.util.Arrays;

/** 
 * An implementation of the List interface, using an array to store the values.
 * Also added an if statement to fix if the cap was to be 0 in the constructor.
 * Some code was taken from Lectures 3 from Professor Bergmann.
 * 
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (September 2021)
 */
public class ArrayList <E> implements List <E>{
	int size = 0;
	E[] values;

	// Constructors
	/**
	 * Creates an array with the default size of 10.
	 */
	public ArrayList () {
		// default array size
		this (10);
	}

	/**
	 * Creates an array with the specified size.
	 * @param cap	The size of the to-be created array.
	 */
	public ArrayList (int cap) {
		if (cap == 0) {
			cap = 10;	// Sets to default since a size of 0 would break future functionality, like adding elements
		}
		values = (E[]) new Object[cap];
	}
	
	// Copy constructor
	public ArrayList(List<E> other) {
		this (other.size() + 10);
		for (int i=0; i<other.size(); i++)
		add(other.get(i));
	}

	// Methods
	/**
	 * Gets the value at the specified index.
	 * @param ndx	The index that the user wants to get the value of.
	 * @return		The value at the specified index.
	 */
	public E get (int ndx) {
		return values[ndx];
	}

	/**
	 * Sets the specified value to the specified index (overwrites any existing value).
	 * @param ndx	The index that the user wants to change the value of.
	 * @param value	The value that the user wants to use to overwrite an existing value, if any.
	 * @return 		The value that was overwritten.
	 */
	public E set (int ndx, E value) {
		E result = values[ndx];
		values[ndx] = value;
		return result;
	}

	/**
	 * Adds the specified value to the end of the list.
	 * @param value	The value the user wants to add.
	 */
	public void add(E value){ 
		add(size,value);
	}

	/**
	 * Adds the specified value at the specified index.
	 */
	public void add(int ndx, E value) { 
		// Is the array full?
		if (values.length == size)
			alloc(); // allocate a bigger array
		// Make room for the insertion
		for (int i=size; i>ndx; i--)
			values[i] = values[i-1];
		values[ndx] = value;
		size++;
	}

	/** 
	 * Allocate a new array, twice as big, and copy all values
	 */
	private void alloc() { 
		E[] tempArray =  (E[]) new Object[2*values.length];
		for (int i=0; i<size; i++) {
			tempArray[i] = values[i];
		}
		values = tempArray;
	}

	/**
	 * Removes the current value at the specified index and shuffles.
	 * @param ndx	The index of the value the user wants to remove.
	 * @return		The value removed.
	 */
	public E remove (int ndx) { 
		// Don’t clobber the result
		E result = values[ndx];
		for (int i=ndx; i<size-1; i++)
			values[i] = values[i+1];
		size--;
		return result;
	}

	/**
	 * Returns the size of the ArrayList.
	 * @return	Size of the ArrayList.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true iff the ArrayList is empty.
	 * @return	True or false depending on whether the ArrayList is empty or not.
	 */
	public boolean isEmpty() {
		return size > 0 ? false: true;
	}

	/**
	 * Clears the ArrayList.
	 */
	public void clear() {
		Arrays.fill(values, null);
		size = 0;
	}

	/**
	 * Finds the index of the first occurrence of the specified Object, if any.
	 * @param obj	The specified Object whose index is meant to be found.
	 * @return		The position of the first occurrence of the given Object in the ArrayList, or
	 * 				-1 if it is not in the ArrayList.
	 */
	public int indexOf(Object obj) {
		int i = 0;
		boolean found = false;

		if(obj != null) {
			while(!found && i < size) {
				found = values[i].equals(obj);
				if(!found) {
					i++;
				}
			}
		}
		return found ? i: -1;
	}

	/**
	 * Finds if the specified Object is in the ArrayList or not.
	 * @param obj	The specified Object meant to be found.
	 * @return		True only if the given Object is in the ArrayList.
	 */
	public boolean contains(Object obj) {
		return (indexOf(obj) != -1) ? true: false;
	}

	@Override
	/**
	 * Gives a String representation of the ArrayList.
	 * @return	A String representation of the ArrayList.
	 */
	public String toString() {
		String array = "[";
		if(this.isEmpty()) {
			return array + " ]";
		}
		else {
			for(int i = 0; i < size; i++) {
				array = array + values[i] + ",";
			}
			return array.substring(0, array.length() - 1) + "]";
		}
	}
	
	/**
	 * Removes the first occurrence of the specified Object from the ArrayList.
	 * @param obj	The Object to be removed.
	 * @return		Whether the removal was successful.
	 */
	public boolean remove(Object obj) {
		int i = indexOf(obj);
		if(i != -1) {
			remove(i);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns an Iterator for the ArrayList.
	 * @return	An Iterator for the ArrayList.
	 */
	public Iterator<E> iterator()
	{
		return new ArrayIterator<E>(this);
	}
	
	/**
	 * Returns a newly created ListIterator for the ArrayList.
	 * @return	A ListIterator of the ArrayList.
	 */
	public ListIterator<E> listIterator()
	{
		return new ArrayListIterator<E>(this);
	}
	
	/**
	 * Returns a newly created ListIterator starting at given index for the ArrayList.
	 * @param start	The index where the user wants the Iterator to start at.
	 * @return		A ListIterator of the ArrayList starting at the given index.
	 */
	public ListIterator<E> listIterator(int start)
	{
		return new ArrayListIterator<E>(this, start);
	}
	
	/** 
	 * @return true only if the parameter obj is a List and contains the same elements 
	  * (in the same sequence) as this List. 
	  */
	public boolean equals (Object obj) {	// HANDLE EMPTY LIST CASE??
		boolean match = false;
		if(obj instanceof List) {
			List<E> list = (List)obj;
			
			// First comparing the size of the two lists
			if(list.size() == size) {
				// Don't use Iterator for the ArrayList since we can access it w/o methods easier here
				int index = 0;
				Iterator<E> objList = list.iterator();
				
				// The two are a match currently; if a mismatch is found, will change to false
				boolean current = true;
				// Only checks one hasNext() since the two Lists are the same size
				while(current && objList.hasNext()) {
					if(!values[index].equals(objList.next())) {
						current = false;
					}
					index++;
				}
				if(current) {
					match = true;
				}
			}
		}
		return match;
	}

	@Override
	public int indexOfLast(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Adds all the elements of the entered List to this ArrayList.
	 * @param List	The List that the user wants to add the elements of.
	 */
	public boolean addAll(List<E> list) {
		int previous_size = size;	// For the boolean return value
		Iterator<E> it = list.iterator();
		if(it.hasNext()) {
			this.add(it.next());
		}
		return(size > previous_size);
	}
	
	/** @return a hashCode for this ArrayList */
	public int hashCode() {
		int code = 17;
		Iterator<E> itty = this.iterator();
		while(itty.hasNext()) {
			code = code * 31 + itty.next().hashCode();
		}
		return code;
	}

}

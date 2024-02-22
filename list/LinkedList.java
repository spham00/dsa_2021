package list;

/**
 * An implementation of the List interface, using references rather than an array.
 * This is a doubly Linked List.
 * 
 * @author (sdb)
 * @author Sarah Pham
 * @version (September 2021)
 */
public class LinkedList <E> implements List <E> {

	int size = 0;
	// Dummy head node
	Node<E> head = new Node<E>(null, null, null);
	// Dummy tail node
	Node<E> tail = new Node<E>(null, null, head);
	private Node<E> ref;

	// Constructor
	public LinkedList() {
		// Set head's "next" reference to tail, therefore connecting the head to the tail
		head.next = tail;
	}

	/**
	 * Changes the field "ref" to refer to the node at the given index, starting from the head.
	 * @param ndx	The index of the node that needs to be found.
	 */
	private void setRef(int ndx) {
		ref = head.next;
		for(int i = 0; i < ndx; i++) {
			ref = ref.next;
		}
	}

	/**
	 * Changes the field "ref" to refer to the node at the given index, starting from the tail.
	 * @param ndx	The index of the node that needs to be found.
	 */
	private void setTailRef(int ndx) {
		ref = tail.prev;						// Last node becomes the ref.
		for (int i = size - 1; i > ndx; i--) {
			ref = ref.prev;						// ref becomes the current node at ndx.
		}
	}

	/**
	 * Test the specified index to see if it's closer to the head or tail, then use that to
	 * set the field "ref" accordingly.
	 * @param ndx	The index to be tested.
	 */
	private void testIndex(int ndx) {
		if(ndx >= 0 && ndx < size) {
			// Find the "middle" number of the size, then test ndx against it
			if(ndx < size/2) {	// If ndx is less than middle number, i.e. closer to head.
				setRef(ndx);
			}
			else {					// If ndx is greater than or equal to middle number, i.e. closer to tail or
				setTailRef(ndx);	// directly in the middle.
			}
		}
		else {
			System.err.println("ERROR: Index is less than 0 or greater than/equal to " + size);
		}
	}

	/**
	 * Gets the value at the given index.
	 * @param ndx	The index that the user wants the value from.
	 * @return		The value that was at the given index.
	 */
	public E get(int ndx) {
		testIndex(ndx);
		return ref.value;
	}

	/**
	 * Sets the given value at the given index (overwrites any existing value).
	 * @param ndx	The index that the user wants to change the value of.
	 * @param value	The value that the user wants to use to overwrite an existing value, if any.
	 * @return		The value that was overwritten.
	 */
	public E set(int ndx, E value) {
		testIndex(ndx);
		E result = ref.value;
		ref.value = value;
		return result;
	}

	/**
	 * Adds the specified value to the end of the LinkedList.
	 * @param	The value to be added at the end of the LinkedList.
	 */
	public void add(E value) {
		Node<E> temp = new Node<E>(value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}

	/**
	 * Adds the specified value to the specified index in the LinkedList.
	 * @param ndx	The specified index the user wants to add the value at.
	 * @param value	The specified value the user wants to add.
	 */
	public void add(int ndx, E value) {
		// Inserting at the tail?
		if(ndx == size) {
			add(value);
		}
		else {
			testIndex(ndx);
			Node<E> temp = new Node<E>(value, ref, ref.prev);
			ref.prev.next = temp;
			ref.prev = temp;
			size++;
		}
	}

	/**
	 * Removes the value at the given index.
	 * @param ndx	The index of the value that the user wants to remove.
	 * @return		The value removed.
	 */
	public E remove(int ndx) {
		testIndex(ndx);
		ref.next.prev = ref.prev;
		ref.prev.next = ref.next;
		size--;
		return ref.value;
	}

	/**
	 * Returns the size of the LinkedList.
	 * @return	The size of the LinkedList.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true iff the LinkedList is empty.
	 * @return	True or false depending on whether the LinkedList is empty or not.
	 */
	public boolean isEmpty() {
		return size > 0 ? false: true;
	}

	/**
	 * Clears the LinkedList.
	 */
	public void clear() {
		// By setting the tail equal to the head, all references to the other elements are lost,
		// and so, by Java, they are essentially removed from memory when the head.next changes.
		head.next = tail;
		tail.prev = head;
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
			Node<E> current = head.next;
			while(!found && i < size) {
				if(current.value != null) {		// As long as current doesn't equal the tail
					found = current.value.equals(obj);
					if(!found) {
						i++;
						current = current.next;
					}
				}
			}
			ref = current;		// For remove(obj); besides, ref can be changed later in other methods
			// Since we already found current, should store it and use that
		}

		return found ? i: -1;
	}

	/**
	 * Returns true if the LinkedList contains the specified Object.
	 * @param obj	The specified Object that is meant to be found.
	 * @return		True only if the given Object is in this List.
	 */
	public boolean contains(Object obj) {
		return (indexOf(obj) != -1) ? true: false;
	}

	@Override
	/**
	 * Return this LinkedList as a String.
	 * @return	The LinkedList as a String.
	 */
	public String toString() {
		String linked = "[";
		if(this.isEmpty()) {
			return linked + " ]";
		}
		else {
			ref = head.next;
			linked = addToString(linked);
			for(int i = 0; i < size - 1; i++) {		// Condition is size - 1 since already got the first element added
				ref = ref.next;
				linked = addToString(linked);
			}
			return linked.substring(0, linked.length() - 1) + "]";
		}
	}

	/**
	 * Adds a ref value and a comma to the toString (or specified String).
	 * @param toString	The string that the ref value and a comma need to be added to.
	 * @return			The resulting string after adding the ref value and comma to the specified String.
	 */
	private String addToString(String toString) {
		// Keeps formatting of printing in one private helper method.
		return toString + ref.value + ",";
	}

	/**
	 * Removes the first occurrence of the specified Object from the LinkedList.
	 * @param obj	The specified Object to be removed.
	 * @return		Whether the removal was successful or not.
	 */
	public boolean remove(Object obj) {
		int i = indexOf(obj);
		if(i != -1) {		// Hidden loop was removed
			ref.prev.next = ref.next;
			ref.next.prev = ref.prev;
			size--;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns an Iterator for the LinkedList.
	 * @return	An Iterator for the LinkedList.
	 */
	public Iterator<E> iterator()
	{
		return new RefIterator<E>(this);
	}

	/**
	 * Returns a newly created ListIterator for the LinkedList.
	 * @return	A ListIterator of the LinkedList.
	 */
	public ListIterator<E> listIterator()
	{
		return new RefListIterator<E>(this);
	}

	/**
	 * Returns a newly created ListIterator starting at given index for the LinkedList.
	 * @param start	The index where the user wants the Iterator to start at.
	 * @return		A ListIterator of the LinkedList starting at the given index.
	 */
	public ListIterator<E> listIterator(int start)
	{
		return new RefListIterator<E>(this, start);
	}

	/** 
	 * @return true only if the parameter obj is a List and contains the same elements 
	 * (in the same sequence) as this List. 
	 */
	public boolean equals (Object obj) {
		boolean match = false;
		if(obj instanceof List) {
			List<E> list = (List)obj;

			// First comparing the size of the two lists
			if(list.size() == size) {
				// No easy way to access LinkedList elements in the class so use Iterator for both
				Iterator<E> thisList = this.iterator();
				Iterator<E> objList = ((List) obj).iterator();

				// The two are a match currently; if a mismatch is found, will change to false
				boolean current = true;
				// Only need to check one hasNext() since both are the same size
				while(current && thisList.hasNext()) {
					if(!thisList.next().equals(objList.next())) {
						current = false;
					}
				}
				if(current) {
					match = true;
				}
			}
		}
		return match;
	}

	/**
	 * For Quiz 1 
	 * @return the position of the last occurrence of the given Object in this List,
	 *  or -1, if not found
	 */
	public int indexOfLast(Object obj) {
		int i = size - 1;
		boolean found = false;

		if(obj != null) {
			Node<E> current = tail.prev;
			while(!found && i >= 0) {
				found = current.value.equals(obj);
				if(!found) {
					i--;
					current = current.prev;
				}
			}
		}
		return found ? i : -1;
	}

	/**
	 * Adds all the elements of the entered List to this LinkedList.
	 * @param List	The List that the user wants to add the elements of.
	 */
	public boolean addAll(List<E> list) {
		int previous_size = size;	// For the boolean return value
		Iterator<E> it = list.iterator();
		while(it.hasNext()) {
			this.add(it.next());
		}
		return(size > previous_size);
	}
}

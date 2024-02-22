package queue;

import list.*;

/** 
 * An implementation of the QueueADT interface,
 * using a LinkedList
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (September 2021)
 */
public class Queue<E> implements QueueADT<E>
{ 
	List<E> values = new LinkedList<E>();

	// front is at position 0 (head)
	// back is at position size-1 (tail)

	/**
	 * Adds the entered value to the back of the queue.
	 * @param value	The value the user wants to add to the back of the queue.
	 */
	public void add(E value)
	{ 
		values.add(value);
	}

	/**
	 * Removes the value at the front of the queue.
	 * @return	The value removed.
	 */
	public E remove()
	{ 
		return values.remove(0); 
	}

	/**
	 * Peek at the value at the front of the queue.
	 * @return	The value at the front of the queue.
	 */
	public E peek()
	{ 
		if (values.isEmpty())
			return null;
		return values.get(0);
	}
	
	/** @return the size of this QueueADT
	 */
	public int size() {
		return values.size();
	}
	
	/** Clears this QueueADT
	 */
	public void clear() {
		values.clear();
	}
	
	/** @return true iff this QueueADT is empty
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	/**
	 * Gives a String representation of the Queue.
	 * @return A String representation of the Queue.
	 */
	public String toString() {
		if(!values.isEmpty()) {
			String e = "[";
			Iterator<E> q = values.iterator();
			while(q.hasNext()) {
				e = e + q.next() + ", ";
			}
			return e.substring(0, e.length() - 2) + "]";
		}
		else {
			return "[]";
		}
	}
}

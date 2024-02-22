package queue;

import list.*;

/** 
 * An implementation of the QueueADT interface,
 * using an ArrayList
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (September 2021)
 */
public class ArrayQueue<E> implements QueueADT<E>
{ 
	List<E> values = new ArrayList<E>();
	int front=0;
	int back=0;
	int size=0;

	/**
	 * Adds the given value to the back of the ArrayQueue.
	 * @param value	The value the user wants to add to the ArrayQueue.
	 */
	public void add(E value)
	{ 
		if (size==values.size()) { // ArrayList is full?
			values.add(back,value); // Insert
			front = (front+1) % values.size(); // Wrap around
		}
		else {
			values.set (back,value); // Clobber
		}
		back = (back+1) % values.size(); // Wrap around
		size++;
	}

	/**
	 * Removes the front value from the ArrayQueue.
	 * @return The value that was removed.
	 */
	public E remove()
	{ 
		E result = values.get(front);
		front = (front+1) % values.size();
		size--;
		return result;
	}

	/**
	 * Returns the front value of the ArrayQueue.
	 * @return The front value.
	 */
	public E peek()
	{ 
		if (size>0)
			return values.get(front);
		return null;
	}
	
	/** @return the size of this ArrayQueue
	 */
	public int size() {
		return size;
	}
	
	/** Clears this ArrayQueue
	 */
	public void clear() {
		values.clear();
		front = 0;
		back = 0;
		size = 0;
	}
	
	/** @return true iff this ArrayQueue is empty
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	/**
	 * Gives a String representation of the ArrayQueue.
	 * @return A String representation of the ArrayQueue.
	 */
	public String toString() {
		String e = "";
		int i = front;		// Tracks the index
		
		// backEfront will be false initially in order to go through the loop, also in case
		// the front == back value in the beginning
		for(boolean backEfront = false; !backEfront; ) {
			e = e + values.get(i) + ", ";
			i = (i + 1) % values.size();
			
			// If 'i' == the back, the loop will stop
			backEfront = (i == back);
		}
		return e.substring(0, e.length() - 2);
	}
}

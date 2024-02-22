package stack;

import list.ArrayList;
import list.LinkedList;
import list.List;
import listDriver.*;

/**
 * An implementation of the StackADT interface using a List.
 * Client may opt for an ArrayList or a LinkedList.
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (September 2021) 
 */
public class Stack<E> implements StackADT<E>
{
	List<E> values = new ArrayList<E>();

	/** Default constructor.
	 * Use an ArrayList
	 */
	public Stack()
	{ }

	/** Constructor
	 * @param 	arrayBased => Use an ArrayList
	 * 			!arrayBased => Use a LinkedList.
	 */
	public Stack(boolean arrayBased)
	{ 
		if (!arrayBased)
			values = new LinkedList<E> ();
	}

	/**
	 * Adds the given value to the top of the Stack.
	 * @param value	The value that is to be added.
	 * @return		The value that was added.
	 */
	public E push(E value)
	{ 
		values.add(value); 
		return value;
	}

	/**
	 * Removes the top value of the stack.
	 * @return	The value removed.
	 */
	public E pop()
	{ 
		return values.remove(values.size() - 1);
	}

	/**
	 * Get the value at the top of the stack.
	 * @return	The value at the top of the stack currently.
	 */
	public E peek()
	{ 
		return values.get(values.size() - 1);
	}
	
	/** @return true iff this Stack is empty. */
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}
		return false;
	}
	
	/** clear this Stack
	 * Post: clear() now returns true
	 */
	public void clear() {
		values.clear();
	}
	
	/** @return the size of this Stack. */
	public int size() {
		return values.size();
	}
	
	@Override
	public String toString() {
		return values.toString();
	}

}

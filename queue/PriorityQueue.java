package queue;

import list.*;

/** A priorityQueue is a Queue, in which each item has a priority. When removing,
 * the value with the highest priority is removed (not FIFO).
 * @author (sdb)
 * @author (Sarah Pham)
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E> {

	List <E> values = new ArrayList<E> ();

	public E remove () { 
		E result = values.get (0); // highest priority
		int last = values.size() - 1;
		int avail = 0; // Position of an available slot.
		int bc = biggerChild (0); // Position of bigger child.

		while (2*avail+1 < last && greater (bc, last)) { 
			values.set (avail, values.get(bc));
			avail = bc; // avail moves down
			bc = biggerChild (avail);
		}

		values.set (avail, values.get (last));
		values.remove (last);
		return result;
	}

	public void add (E value) { 
		int added, parent;
		values.add (value);
		added = values.size() - 1;
		parent = (added - 1) / 2;

		while (added>0 && greater (added,parent)) { 
			swap (added,parent); // added moves up
			added = parent;
			parent = (added-1) / 2;
		}
	}

	/** 
	 * @return position of parent’s bigger child
	 */
	private int biggerChild (int parent) { 
		int left = 2*parent + 1, // left child
				right = left + 1;

		if (right >= values.size()) // has a right child?
			return left; // No.
		if (greater (left,right)) // left > right?
			return left;

		return right;
	}

	/** 
	 * @return true iff the value at position x is greater than the value at position y
	 */
	private boolean greater (int x, int y) { 
		return values.get(x).compareTo(values.get(y)) > 0;
	}

	private void swap(int x, int y) {
		E temp = values.get(x);
		values.set(x, values.get(y));
		values.set(y,temp);
	}

	@Override
	public E peek() {
		if (values.isEmpty())
			return null;
		return values.get(0);
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override
	public void clear() {
		values.clear();

	}

	@Override
	public boolean isEmpty() {
		return values.isEmpty();
	}

	@Override
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
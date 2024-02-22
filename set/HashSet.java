package set;

import hash.*;
import list.Iterator;

/** 
 * An implementation of Set, using a HashTable
 * @author (sdb)
 * @author (Sarah Pham) 
 */
public class HashSet<E> implements Set<E>
{ 
	HashTable<E> table = new HashTable<E>();

	public boolean add(E value) { 
		if (table.containsKey(value))
			return false; // no duplicates
		table.put(value);
		return true;
	}

	public boolean contains(Object obj) { 
		return table.containsKey(obj);
	}

	public boolean remove(Object obj) { 
		return table.remove(obj);
	}

	public Iterator<E> iterator() { 
		return table.iterator();
	}

	public void clear() {
		table.clear();
	}

	public boolean isEmpty() {
		return table.isEmpty();
	}

	public int size() {
		return table.size();
	}

	public boolean equals(Object obj) {
		// If obj is not a Set, return false
		if (!(obj instanceof Set))
			return false;

		// Can cast to Set now
		Set<E> o = (Set)obj;

		// If the size is not equal, return false b/c duplicates not allowed to be added
		if (this.size() != o.size())
			return false;

		// Make an Iterator to check over this HashSet's elements
		Iterator<E> this_itty = this.iterator();

		while (this_itty.hasNext()) {
			E a = this_itty.next();

			// If other Set doesn't contain an element, they're not equal
			if (!o.contains(a))
				return false;
		}

		// If break free of while loop, this means all items were found
		return true;
	}
	
	// return the elements that are in both this and the otherset
	public Set<E> intersection(Set<E> otherSet) {
		Iterator<E> itty1 = this.iterator();
		Iterator<E> itty2 = otherSet.iterator();
		Set<E> result = new HashSet<E>();
		E element1, element2;
		//boolean found = false;
		
		while(itty1.hasNext()) {
			element1 = itty1.next();
			if(otherSet.contains(element1))
				result.add(element1);
		}
		return result;
	}

	@Override
	public String toString() {
		// If no elements, nothing to print
		if (size() == 0) {
			return "No elements in this HashSet";
		}

		String s = "{";
		Iterator <E> itty = this.iterator();

		while (itty.hasNext()) {
			s = s + itty.next() + ", ";
		}

		return s.substring(0, s.length() - 2) + "}";
	}

}
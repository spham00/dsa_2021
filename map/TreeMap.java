package map;

import tree.*;
import list.Iterator;
import map.HashMap.Entry;
import set.*;

/**
 * An implementation of the Map interface using a Binary Search Tree of entries.
 * @author sdb
 * @author Sarah Pham
 */
public class TreeMap <K extends Comparable, V> implements Map <K, V> {

	// Inner class to define an Entry
	class Entry<K extends Comparable, V> implements Comparable<Entry<K,V>> {
		K key;
		V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * @return a positive int if this Entry is greater than other,
		 * return 0 if this Entry equals other,
		 * return a negative int if this Entry is less than other
		 */
		public int compareTo(Entry<K,V> other) {
			return key.compareTo(other.key);
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}
	}
	// End of inner class Entry

	BinaryTree<Entry<K, V>> tree = new EmptyBinarySearchTree();
	int size = 0;	// we need to keep track of size here because binarytrees don't maintain size

	public boolean containsKey(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		return tree.containsKey(entry);
	}

	public V get(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = tree.get(entry);
		if(entry == null)			// Not found in tree?
			return null;
		return entry.value;			// Yes, return the value
	}

	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key, value),
				oldEntry = tree.get(newEntry);

		if(oldEntry == null) {		// Key not found in tree?
			tree = tree.add(newEntry);
			size++;
			return null;
		}

		V oldValue = oldEntry.value;
		oldEntry.value = value;		// Change the entry's value
		return oldValue;
	}

	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = tree.get(entry);

		if(entry == null)
			return null;

		size--;	
		tree = tree.remove(entry);	// remove and store the new updated tree
		return entry.value;			// return value of the entry that was removed
	}

	public void clear() {
		tree = new EmptyBinarySearchTree();
		size = 0;
	}

	public boolean isEmpty() {
		return tree.isEmpty();
	}

	public int size() {
		return size;
	}

	public Set<K> keySet() {
		Iterator<Entry<K,V>> itty = tree.iterator();
		Set<K> set = new TreeSet();

		while(itty.hasNext())
			set.add(itty.next().key);

		return set;
	}

	public boolean equals(Object obj) {
		// If the object isn't a Map, it's not equal
		if(!(obj instanceof Map))
			return false;

		Map<K,V> other = (Map)obj;

		// if sizes don't match, it's not equal
		if(other.size() != this.size())
			return false;

		Iterator<Entry<K,V>> itty = tree.iterator();

		while(itty.hasNext()) {
			Entry<K,V> next = itty.next();

			// check if other map has the key; if not, not equal
			if(!other.containsKey(next.key))
				return false;

			// if other map has key, then check if the value is the same
			if(!next.value.equals(other.get(next.key)))
				return false;
		}

		// if all the keys and values have been checked, then it's good
		return true;
	}

	@Override
	public String toString() {
		String s = "[";
		Iterator<Entry<K,V>> itty = tree.iterator();

		while(itty.hasNext()) 
			s = s + itty.next() + ",";

		return s.substring(0, s.length() - 1) + "]";
	}

}

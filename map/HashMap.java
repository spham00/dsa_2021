package map;

import hash.*;
import list.Iterator;
import set.*;

/** An implementation of the Map interface using a HashTable of entries. 
 * @author (sdb)
 * @author (Sarah Pham)
 */
public class HashMap <K,V> implements Map <K,V> {

	// Inner class to define an Entry
	class Entry <K,V> {
		K key;
		V value;

		Entry (K key, V value) { 
			this.key = key;
			this.value = value;
		}

		/** @return true iff the given object is an Entry, and its 
		 * key is equal to the key of this Entry.
		 */
		public boolean equals (Object obj)
		{ 
			if (! (obj instanceof Entry))
				return false;
			Entry <K,V> entry = (Entry <K,V>) obj;
			return this.key.equals (entry.key);
		}

		public int hashCode() { 
			return key.hashCode();
		}
		
		@Override
		public String toString() {
			return key + "=" + value;
		}
	}
	// End of inner class Entry

	HashTable <Entry <K,V>> table;

	public HashMap () { 
		table = new HashTable <Entry<K,V>> ();
	}

	public HashMap (int size) { 
		table = new HashTable <Entry <K,V>> (size);
	}

	public boolean containsKey (K key) { 
		Entry <K,V> entry = new Entry <K,V> (key, null);
		return table.containsKey (entry);
	}

	public V get (K key) { 
		Entry<K,V> entry = new Entry<K,V> (key,null);
		entry = table.get (entry);
		if (entry == null) // Not found in the table?
			return null;
		return entry.value; // Yes, return the value
	}

	public V put (K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V> (key, value),
				oldEntry = table.get(newEntry);

		if (oldEntry == null) { 
			table.put (newEntry); // Key not found
			return null;
		}

		V oldValue = oldEntry.value;
		oldEntry.value = value; // Change the value
		return oldValue;
	}

	public V remove (K key) { 
		Entry<K,V> entry = new Entry<K,V> (key,null),
				result = table.get (entry);
		if (table.remove (entry) )
			return result.value;
		return null;
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
	
	public Set<K> keySet() {
		Iterator<Entry<K,V>> itty = table.iterator();
		Set<K> set = new HashSet();
		
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
		
		Iterator<Entry<K,V>> itty = table.iterator();
		
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
	
	// return the keys (in a set) that have V value as their value
	public Set<K> getKeys(V value) {
		Set<K> keys = this.keySet();
		Set<K> result = new HashSet<K>();
		Iterator<K> itty = keys.iterator();
		K key;
		
		while(itty.hasNext()) {
			key = itty.next();
			if(this.get(key).equals(value))
				result.add(key);
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		String s = "[";
		Iterator<Entry<K,V>> itty = table.iterator();
		
		while(itty.hasNext())
			s = s + itty.next() + ",";
		
		return s.substring(0, s.length() - 1) + "]";
	}
	
}

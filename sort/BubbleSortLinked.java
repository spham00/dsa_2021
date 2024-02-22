package sort;

import list.*;

/** 
 * Sort a LinkedList in time O(n2), using a ListIterator.
 * This will be slow for an ArrayList.
 * 
 * @author (sdb) 
 * @author (Sarah Pham)
 * @version (October 2021)
 */
public class BubbleSortLinked <E extends Comparable> implements Sorter<E>
{ 
	List <E> list;

	public void sort (List<E> list)
	{ 
		this.list = list;
		E left, right; // Neighboring values
		ListIterator<E> itty;
		for (int i=0; i<list.size()-1; i++) // same loop control
		{
			itty = list.listIterator();
			right = itty.next();
			for (int j=0; j<list.size()-i-1; j++)
			{ 
				left = right;
				right = itty.next(); // neighbors
				if (left.compareTo(right) > 0)
				{ 
					itty.remove(); // swap left and right
					itty.previous();
					itty.add (right);
					right = itty.next();
				}
			}
		}
	}
}

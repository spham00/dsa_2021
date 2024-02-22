package sort;

import list.*;

/** 
 * Implementation of the QuickSort algorithm 
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (October 2021)
 */
public class QuickSort <E extends Comparable> implements Sorter<E>
{ 
	List<E> list;

	public void sort (List<E> list)
	{ 
		this.list = list;
		qSort(0,list.size()-1); 
	}

	/**
	 * Recursive sort method using the QuickSort algorithm
	 * @param start		The start of what needs to be sorted
	 * @param end		The end of what needs to be sorted
	 */
	private void qSort(int start, int end)
	{ 
		if (start >= end) 		// Base case
			return;
		int p = partition (start,end);
		qSort(start,p - 1); 		// Left part
		qSort(p + 1,end);	 		// Right part
	}
	
	/** 
	 * Partition the values from start to end about a pivot value.
	 * @param start		The start of the partition.
	 * @param end		The end of the partition.
	 * @return 			The pivot position.
	 */
	private int partition(int start, int end) {
		int mid = (start + end) / 2;	// Pivot position
		E pivot = list.get(mid);		// Pivot value
		int p = start;					// Start from the beginning
		list.set(mid, list.get(p));		// Set pivot position to beginning
		
		for(int i = start + 1; i <= end; i++) {
			if(pivot.compareTo(list.get(i)) > 0) {	// If pivot greater than value at position i
				list.set(p, list.get(i));
				p++;
				list.set(i, list.get(p));
			}
		}
		list.set(p, pivot);		// Put the pivot back in the list
		return p;
	}

}


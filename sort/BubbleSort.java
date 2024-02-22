package sort;

import list.*;

/** 
 * Implementation of the Bubble Sort Algorithm 
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (Oct 2021)
 * */
public class BubbleSort<E extends Comparable> implements Sorter<E>
{ 
	List<E> list;

	/** @param list of values to be sorted.
	 * Post: Items in the list will be arranged in increasing order
	 */
	public void sort (List<E> list)
	{ 
		this.list = list;
		
		boolean swap = true;
		
		// It should terminate as soon as it knows that the list is sorted
		// Thus it should be a condition in the for-loop; be reminded of the cases where only one swap
		// needs to take place.
		for (int ndx=0; ndx<list.size()-1 && swap; ndx++) {
			swap = false;
			for (int i=0; i<list.size()-ndx-1; i++) {
				// Change to greater than later
				if (list.get(i).compareTo(list.get(i+1)) < 0) {
					swap(i,i+1);
					swap = true;
				}
			}
			
		}
	}
	
	/** 
	 * Exchange the items at the given positions in the list
	 */
	private void swap (int x, int y)
	{ 
		E temp = list.get(x);
		list.set(x,list.get(y));
		list.set(y,temp);
	}
	
	/**
	 * Sort in descending order, for Quiz 3.
	 * @param list
	 */
	public void sortDescending(List<E> list) {
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = 0; j < list.size() - 1; j++) {
				if(list.get(j).compareTo(list.get(j + 1)) < 0) {
					swap(j, j + 1);
				}
			}
		}
	}
}
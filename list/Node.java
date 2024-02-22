package list;

/**
 * A node stores one value in a LinkedList, a reference to the next Node in the List, 
 * and a reference to the previous Node in the List.
 * 
 * @author (sdb)
 * @version (Jul 2019)
 */
public class Node <E> {
	
	E value;
	Node <E> next;
	Node <E> prev;

	// Constructor
	/**
	 * Makes a node with the specified value.
	 * @param value	The value in an element in a LinkedList.
	 * @param next	A reference to the next node, whatever it may be.
	 */
	public Node(E value, Node<E> next, Node<E> prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	
}

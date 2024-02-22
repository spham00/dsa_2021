package list;
/**
 * An Iterator which can go to the previous value as well as the next value.
 * @author (sdb)
 * @version	(September 18, 2021)
 */
public interface ListIterator<E> extends Iterator<E> {

	/**
	 * Returns true iff there is a previous value.
	 * @return True iff there is a previous value.
	 */
	boolean hasPrevious();
	/**
	 * Returns the previous value, and moves the implicit cursor to the left.
	 * @return The previous value.
	 */
	public E previous();

	/** Insert the given value just prior to the implicit cursor position.  A subsequent call to previous()
    should return the inserted value, and a subsequent call to next() should be unaffected.
	 */
	public void add (E value);


	/**
	 * The remove operation, inherited from Iterator, will always remove the last value obtained by a
	 * call to next() or previous().
	 * Pre: remove may be called no more than once between successive calls to next() or previous().
	 */
}

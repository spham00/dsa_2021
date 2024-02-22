package tree;

/**
 * A BinaryTree which has no value and no children (empty)
 */
public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E>
{

	/**
	 * Creates a new BinaryTree with the given value as the root.
	 * @param value	The value the user wants to add as the root of the new Binary Tree.
	 * @return		The new Binary Tree, no longer empty.
	 */
	public BinaryTree<E> add(E value) { 
		return new BinarySearchTree<E> (value);
	}

	/**
	 * @return false always since an empty Binary Search Tree has no objects
	 */
	public boolean containsKey (Object obj) {
		return false;
	}

	/**
	 * @return null always since there are no objects to get
	 */
	public E get (E value) { 
		return null; 
	}

	/**
	 * @return true always since there are no objects stored, ever
	 */
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int size() {
		return 0;
	}
		
	/**
	 * Not possible to remove anything from an EmptyBinarySearchTree
	 */
	public BinaryTree<E> remove (Object obj)
	{
		return this;
	}
	
	@Override
	/**
	 * @return an empty string since an EmptyBinarySearchTree has no elements
	 */
	public String toString() {
		return "";
	}
	
	public int height() {
		return 0;
	}
	
	public boolean isBalanced() {
		return true;
	}

	// Auto-generated stubs with null returns since no use (tree is always empty)
	@Override
	public E getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinaryTree<E> getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinaryTree<E> getRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(E value) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setLeft(BinaryTree<E> left) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setRight(BinaryTree<E> right) {
		// TODO Auto-generated method stub
	}

	@Override
	public TreeIterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}


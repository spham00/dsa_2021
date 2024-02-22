package tree;

import list.*;

/** 
 * A BinaryTree which whose left child’s value is smaller, and whose right child’s value is greater than
 * the value of this BinarySearchTree. All non-empty children are also BinarySearchTrees. 
 */
public class BinarySearchTree<E extends Comparable> implements BinaryTree<E>
{ 
	BinaryTree<E> left = new EmptyBinarySearchTree<E>(),
			right  = new EmptyBinarySearchTree<E>();
	E value;

	/**
	 * Create and set the root of the Binary Search Tree to the given value.
	 * @param value	The root of the Binary Search Tree.
	 */
	public BinarySearchTree (E value)
	{ 
		this.value = value;
	}

	// Fill in accessor and mutator methods
	@Override
	/**
	 * Returns the value (root) of this tree.
	 * @return	The value of this tree.
	 */
	public E getValue() {
		return value;
	}

	@Override
	/**
	 * Gets the left child of this tree.
	 * @return	The left child of this tree.
	 */
	public BinaryTree<E> getLeft() {
		return left;
	}

	@Override
	/**
	 * Gets the right child of this tree.
	 * @return	The right child of this tree.
	 */
	public BinaryTree<E> getRight() {
		return right;
	}

	@Override
	/**
	 * Sets the user-entered value as the new root.
	 * @param value	The value the user wants to set this tree's root to.
	 */
	public void setValue(E value) {
		this.value = value;
	}

	@Override
	/**
	 * Sets the left child of this tree to the given Binary Tree.
	 * @param left	The tree the user wants to change the left child of this one to.
	 */
	public void setLeft(BinaryTree<E> left) {
		this.left = left;
	}

	@Override
	/**
	 * Sets the right child of this tree to the given Binary Tree.
	 * @param right	The tree the user wants to change the right child of this one to.
	 */
	public void setRight(BinaryTree<E> right) {
		this.right = right;
	}

	@Override
	/**
	 * @return whether the tree is empty or not (it never is empty)
	 */
	public boolean isEmpty() {
		return false;
	}

	@Override
	/**
	 * @return the number of values in the family of this BinaryTree
	 */
	public int size() {
		return 1 + left.size() + right.size();
	}

	@Override
	public TreeIterator<E> iterator() {
		return new TreeIterator<E>(this);
	}

	/**
	 * Search whether the tree contains the given object.
	 * 
	 * @param obj	The object the user wants to search for.
	 * @return		Whether the tree contains the given object.
	 */
	public boolean containsKey (Object obj)
	{ 
		int cmp = value.compareTo(obj);
		if (cmp == 0)
			return true; // found it
		if (cmp < 0)
			return right.containsKey(obj); // search right child
		return left.containsKey(obj); // search left child
	}

	/**
	 * Search the tree for the given value.
	 * Can return null reference because right and left could contain empty binary search trees.
	 * 
	 * @param value	The value the user wants to find.
	 * @return 		The value if found, null if not.
	 */
	public E get (E value)
	{ 
		int cmp = this.value.compareTo (value);
		if (cmp == 0)
			return this.value; // found it
		if (cmp < 0)
			return right.get(value); // search right child
		return left.get(value); // search left child
	}

	/**
	 * Adds the given value to this tree.
	 * 
	 * @param value	The value to be added to the tree.
	 * @return 		The updated tree after the value was added.
	 */
	public BinaryTree<E> add (E value)
	{ 
		int cmp = this.value.compareTo(value);
		if (cmp < 0) // add to family of right child
			right = right.add(value);
		if (cmp > 0) // add to family of left child
			left = left.add(value);
		return this;
	}

	/**
	 * Removes the specified object from the tree.
	 * @return The updated tree.
	 */
	public BinaryTree<E> remove(Object obj)
	{ 
		int cmp = value.compareTo(obj);

		if (cmp == 0) { // removing the root
			List<BinaryTree<E>> kids = children();
			if (kids.size() == 0) // no children
				return new EmptyBinarySearchTree<E>();
			if (kids.size() == 1) // one child
				return kids.get(0);

			// Two children
			BinaryTree<E> successor = getSuccessor();
			remove (successor.getValue());
			setValue (successor.getValue());
			return this;
		}

		if (cmp > 0) // Remove from family of
			left = left.remove(obj); // left child.
		if (cmp < 0) // Remove from family of
			right = right.remove(obj); // right child.
		return this;
	}

	/** @return a list of this BinarySearchTree’s children
	 */
	private List<BinaryTree<E>> children()
	{ 
		// Doesn't matter if Array or LinkedList - tree has at most 2 children
		List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
		if (! left.isEmpty())
			result.add (left);
		if (! right.isEmpty())
			result.add (right);
		return result;
	}

	/** @return the successor of this BinaryTree.
	 * successor is the smallest value in the family of the right child
	 */
	private BinaryTree<E> getSuccessor()
	{ 
		BinaryTree<E> temp = right;
		while (!temp.getLeft().isEmpty())
			temp = temp.getLeft();
		return temp;
	}
	
	/**
	 * @return a String listing all the elements of this BinarySearchTree in their natural order
	 */
	public String toString() {
		String elements = "[";
		Iterator<E> itty = this.iterator();
		
		while(itty.hasNext()) {
			elements = elements + itty.next() + ",";
		}
		
		return elements.substring(0, elements.length() - 1) + "]";
	}
	
	public int height() {
		int height = 1;
		return (right.height() > left.height() ? right.height() : left.height()) + height;
	}
	
	public boolean isBalanced() {
		boolean balanced = false;
		if(right.height() > left.height())
			balanced = (right.height() - left.height()) < 5;
		else
			balanced = (left.height() - right.height()) < 5;
		return (left.isBalanced() && right.isBalanced()) && balanced;
	}

}
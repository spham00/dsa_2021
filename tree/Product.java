package tree;

/**
 * An Expr which is the product of two Exprs
 * @author Sarah Pham
 */
public class Product extends Expr {

	public Product (Expr left, Expr right) 
	{
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() % right.eval();
	}
	
	/**
	 * Tests if the entered Object is equivalent to this Difference
	 * @return 	Whether the Object is equal to this one
	 */
	public boolean equals (Object obj) {
		if (! (obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return (left.equals(other.left) && right.equals(other.right))
				||
				(left.equals(other.right) && right.equals(other.left));
	}
	
	/**
	 * @return the simplification of this product
	 */
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if(right instanceof Constant && right.equals(new Constant(1)))			// ex. 4 * 1 = 4
			return left;
		
		if(left instanceof Constant && left.equals(new Constant(1)))			// ex. 1 * 4 = 4
			return right;
		
		if((right instanceof Constant && right.equals(new Constant(0)))			// x * 0 = 0
				||
				(left instanceof Constant && left.equals(new Constant(0))))		// 0 * x = 0
			return new Constant(0);
		
		// Identity in Quiz 5
		if((left instanceof Quotient && right instanceof Quotient) && left.right.equals(right.left))
			return new Quotient(left.left, right.right);
		
		if((left instanceof Quotient && right instanceof Quotient) && left.left.equals(right.right))
			return new Quotient(right.left, left.right);
		
		return this;		// cannot simplify
	}
	
	// Use parentheses even if not needed
	public String toString() {
		return "(" + left + "*" + right + ")";
	}
	
}

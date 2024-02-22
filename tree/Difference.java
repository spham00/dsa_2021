package tree;

/**
 * An Expr which is the difference of two Exprs
 * @author Sarah Pham
 */
public class Difference extends Expr {

	public Difference (Expr left, Expr right) 
	{
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() - right.eval();
	}
	
	/**
	 * Tests if the entered Object is equivalent to this Difference
	 * @return 	Whether the Object is equal to this one
	 */
	public boolean equals (Object obj) {
		if (! (obj instanceof Difference))
			return false;
		Difference other = (Difference) obj;
		return left.equals(other.left) && right.equals(other.right);
	}
	
	/**
	 * @return the simplification of this difference
	 */
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if(right instanceof Constant && right.equals(new Constant(0)))	// x - 0 = x
			return left;
		
		if(right.equals(left))			// x - x = 0
			return new Constant(0);	
		
		return this;		// cannot simplify
	}
	
	// Use parentheses even if not needed
	public String toString() {
		return "(" + left + "-" + right + ")";
	}
	
}

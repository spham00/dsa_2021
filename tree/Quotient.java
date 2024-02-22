package tree;

/**
 * An Expr which is the quotient of two Exprs
 * @author Sarah Pham
 */
public class Quotient extends Expr {

	public Quotient (Expr left, Expr right) 
	{
		super.left = left;
		super.right = right;
	}
	
	public int eval() {
		return left.eval() / right.eval();
	}
	
	/**
	 * Tests if the entered Object is equivalent to this Difference
	 * @return 	Whether the Object is equal to this one
	 */
	public boolean equals (Object obj) {
		if (! (obj instanceof Quotient))
			return false;
		Quotient other = (Quotient) obj;
		return left.equals(other.left) && right.equals(other.right);
	}
	
	/**
	 * @return the simplification of this quotient
	 */
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if(right instanceof Constant && right.equals(new Constant(1)))	// x / 1 = x
			return left;
		
		if(right.equals(left))				// x / x = 1
			return new Constant(1);	
		
		return this;		// cannot simplify
	}
	
	// Use parentheses even if not needed
	public String toString() {
		return "(" + left + "/" + right + ")";
	}
	
}

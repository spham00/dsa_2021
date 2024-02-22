package tree;

/**
 * An Expr which is the mod of two Exprs
 * @author Sarah Pham
 */
public class Mod extends Expr {

	public Mod (Expr left, Expr right) 
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
		if (! (obj instanceof Mod))
			return false;
		Mod other = (Mod) obj;
		return left.equals(other.left) && right.equals(other.right);
	}
	
	/**
	 * @return the simplification of this mod
	 */
	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if(left.equals(right))				// x % x = 0
			return new Constant(0); 
		
		return this;		// cannot simplify
	}
	
	// Use parentheses even if not needed
	public String toString() {
		return "(" + left + "%" + right + ")";
	}
	
}

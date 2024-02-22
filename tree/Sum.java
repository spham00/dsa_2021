package tree;

/** 
 * An Expr which is the sum of two Exprs 
 */
public class Sum extends Expr
{

	public Sum (Expr left, Expr right)
	{ 
		super.left = left;
		super.right = right;
	}
	public int eval()
	{ 
		return left.eval() + right.eval(); 
	}

	public boolean equals (Object obj)
	{ 
		if (! (obj instanceof Sum))
			return false;
		Sum other = (Sum) obj;
		return left.equals(other.left)
				&& right.equals(other.right) // a+b = a+b
				||
				left.equals(other.right) // a+b = b+a
				&& right.equals(other.left); 
	}

	public Expr simplify()
	{ 
		left = left.simplify();
		right = right.simplify();
		
		if (left instanceof Constant && left.equals(new Constant(0))) // 0 + x = x
			return right;
		if (right instanceof Constant && right.equals(new Constant(0))) // x + 0 = x
			return left;
		
		return this; // cannot simplify
	}
	
	// Use parentheses even if not needed
	public String toString() {
		return "(" + left + "+" + right + ")";
	}
	
}
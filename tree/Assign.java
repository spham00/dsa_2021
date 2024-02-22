package tree;

/**
 * The Assign class represents the assignment operator and assigns
 * values to variables.
 * 
 * @author Sarah Pham
 */
public class Assign extends Expr {

	/**
	 * Create an Assign object
	 * @param e1	Should be a variable
	 * @param e2	Any expression that the user wants to assign to the variable
	 */
	public Assign(Expr left, Expr right) {
		super.left = left;
		super.right = right;
	}

	public int eval() {
		((Variable) left).value = right.eval();
		((Variable) left).assigned = true;
		return ((Variable)left).value;
	}

	public boolean equals(Object obj) {
		return right.equals(obj);
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		return this;
	}

	public String toString() {
		return "(" + left + "=" + right + ")";
	}

}

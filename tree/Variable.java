package tree;

/**
 * An Expr that represents a variable.
 * @author Sarah
 */
public class Variable extends Expr {
	
	char name;
	int value;
	boolean assigned;		// whether the variable has a value assigned to it
	
	public Variable(char name) {
		this.name = name;
	}
	
	public int eval() {
		if(!assigned)
			throw new IllegalArgumentException();
		else
			return value;
	}

	public boolean equals(Object obj) {
		if(! (obj instanceof Variable))
			return false;
		
		Variable v = (Variable)obj;
		return name == v.name;
	}
	
	public Expr simplify() {
		return this;
	}
	
	public String toString() {
		return name + "";
	}
}

package tree;

/** 
 * A Constant is an Expr which has a value 
 */
public class Constant extends Expr
{ 
	int value;
	
	public Constant(int value)
	{ 
		this.value = value;
	}
	
	public int eval()
	{
		return value;
	}
	
	public boolean equals(Object obj)
	{ 
		if (! (obj instanceof Constant))
			return false;
		Constant c = (Constant) obj;
		return value == c.value;
	}

	public Expr simplify() {
		return this;
	}
	
	public String toString() {
		return value + "";
	}

}
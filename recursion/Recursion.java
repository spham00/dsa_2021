package recursion;

/**
 * The Recursion class tests and holds a recursive function.
 * 
 * @author 	(Sarah Pham)
 * @version	(October 2021)
 */
public class Recursion
{
	
	public static void main(String[] args)
	{
		System.out.println("Dividing 14, 5 = " + div(14, 5));	// Test
	}
	
	/**
	 * @return	The quotient when x is divided by y.
	 * 			If preconditions aren't met, return -1. REVERT FROM STATIC??
	 * Precondition: x >= 0, y > 0
	 */
	private static int div(int x, int y) 
	{
		if(!(x >= 0) || !(y > 0)) {	// Checking pre-conditions
			return -1;				// -1 representing that no answer is given since preconditions not met
		}
		if(x < y) {
			return 0;		// Remainder isn't included for this.
		}
		return 1 + div((x-y), y);
	}

}

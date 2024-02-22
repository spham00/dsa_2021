package stackDriver;
import java.util.Scanner;
import stack.*;

/**
 * Evaluate postfix expressions
 * Assume that numbers and operators are separated by one space.
 * Assume that the expressions are well-formed.
 * @author (sdb and Sarah Pham) 
 * @version (2021)
 */
public class LabPostfix
{
	public static void main(String[] args) {
		postfixEval();
	}

	// read postfix expressions from the keyboard, and evaluate
	public static void postfixEval()
	{   
		Stack <Integer> stack = new Stack <Integer> ();

		// read expression from the keyboard
		Scanner scanner = new Scanner (System.in);

		String input;       // store an entire expression
		String [] opInts;   // Each string is an operator or an int.
		int right;           // store right operand

		System.out.println ("Enter postfix expressions, or Enter to terminate");
		input = scanner.nextLine();
		while (input.length() > 0)               // Empty input line terminates the program
		{   opInts = input.split (" ");      // An array of Strings, delimiter is space
		char first;

		////////////////  fill in the body of this loop:
		for (String s : opInts)
		{   // Is the string s a number or operator?
			// If the first character in the string is a numeric digit,
			//    then it must be a number.

			first = s.charAt(0);
			if(Character.isDigit(first)) {
				stack.push(Integer.parseInt(s));
			}
			else {
				right = stack.pop();
				switch(s) {
				case("+"):
					stack.push(stack.pop() + right);
				break;
				case("-"):
					stack.push(stack.pop() - right);
				break;
				case("*"):
					stack.push(stack.pop() * right);
				break;
				case("/"):
					stack.push(stack.pop() / right);
				break;
				case("%"):
					stack.push(stack.pop() % right);
				break;
				default:
					System.out.println("Not a number or operation");
				}
			}

		}       // reached end of an expression
		if (!stack.isEmpty())
			System.out.println (stack.peek());
		stack.clear();

		input = scanner.nextLine();
		}
	}


}

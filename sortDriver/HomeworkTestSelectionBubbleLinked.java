package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the Selection Sort and Bubble Sort Linked algorithms.
 * 
 * @author (sdb) 
 * @author (Sarah Pham)
 * @version (2020)
 */
public class HomeworkTestSelectionBubbleLinked
{
	static List <Integer> grades = new ArrayList <Integer> ();
	static Random rand = new Random();

	public static void main (String[] args)
	{

		System.out.println ("Test Selection Sort:");
		Sorter <Integer> sorter = new SelectionSort <Integer> ( );
		testSort (sorter);

		System.out.println ("Test Bubble Sort Linked:");
		sorter = new BubbleSortLinked <Integer>  ( );
		grades = new LinkedList<Integer>();		// Use LinkedList instead
		testSort (sorter);
	}

	private static void testSort (Sorter<Integer> sorter)
	{   
		init();

		System.out.println ("Before sorting:");
		System.out.println (grades);
		System.out.println ("After sorting:");
		sorter.sort(grades);
		System.out.println (grades + "\n");
		System.out.println ( );

	}

	private static void init()
	{   
		grades.clear(); 
		for (int i=0; i<20; i++)
			grades.add (rand.nextInt(150));

	}
}

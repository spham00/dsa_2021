package misc;

public class Question8433a {

	public static void main(String[] args) { 
		final int MAX = 10000;
		int sum = 0;
		int [][] nums = new int[MAX][MAX];
		System.out.println ("start row-major order");
		for (int row=0; row<MAX; row++)
			for (int col=0; col<MAX; col++)
				nums[row][col] = row + col;
		System.out.println ("start col-major order");
		for (int col=0; col<MAX; col++)
			for (int row=0; row<MAX; row++)
				nums[row][col] = row + col;
		System.out.println ("done");
	}
}

// Difference Of Squares exercise
// http://exercism.io/exercises/java/difference-of-squares/readme

public class DifferenceOfSquares
{
	private double sumSquares = 0;
	private double squaredSum = 0;
	private double diffOfSquares = 0;
	
	public void printDifferenceOfSquares(double lastNum)
	{
		for (double i = lastNum; i > 0; i--)
		{
			sumSquares += Math.pow(i, 2);
			squaredSum += i;
		}
		
		squaredSum = Math.pow(squaredSum, 2);
		
		diffOfSquares = squaredSum - sumSquares;

		System.out.println("Difference of squares: " + diffOfSquares);
	}
}
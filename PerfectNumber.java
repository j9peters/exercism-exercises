// Perfect Numbers exercise
// http://exercism.io/exercises/java/perfect-numbers/readme

public class PerfectNumber
{
	private int aliquotSum = 0;
	private int number;
	
	public PerfectNumber(int number)
	{		
		this.number = number;
	}
	
	public void isPerfect()
	{
		for (int i = 1; i < number; i++)
		{
			if (number % i == 0)
			{
				aliquotSum += i;
			}
		}
		
		if (aliquotSum == number)
		{
			System.out.println("This is a perfect number!");
		}
		
		else
		{
			System.out.println("Nope. Not a perfect number.");
		}
	}
}
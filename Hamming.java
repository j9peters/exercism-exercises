// Hamming exercise
// http://exercism.io/exercises/java/hamming/readme

public class Hamming
{
	public static int compare(String dna1, String dna2)
	{
		int differences = 0;
		
		for (int i = 0; i < dna1.length(); i++)
		{
			if (dna1.charAt(i) != dna2.charAt(i))
				differences++;
		}
		
		return differences;
	}
}
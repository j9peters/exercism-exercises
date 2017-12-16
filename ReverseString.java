// Reverse String exercise
// http://exercism.io/exercises/java/reverse-string/readme

public class ReverseString
{
	private String input;
	private String output = "";
	
	public ReverseString(String input)
	{
		this.input = input;
	}
	
	public void printReverse()
	{
		for (int i = input.length() - 1; i >= 0; i--)
		{
			output += input.charAt(i);
		}
		
		System.out.println("Reversed: " + output);
	}
}
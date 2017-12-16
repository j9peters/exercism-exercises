// Raindrops exercise
// http://exercism.io/exercises/java/raindrops/readme

public class Raindrop
{
	private String message = "";
	private int inputNumber;
	
	public Raindrop(int number)
	{
		inputNumber = number;
	}
	
	public void printRaindropsMsg()
	{
		if (inputNumber % 3 == 0)
			message += "Pling";
		if (inputNumber % 5 == 0)
			message += "Plang";
		if (inputNumber % 7 == 0)
			message += "Plong";
		if (message == "")
			message += Integer.toString(inputNumber);
		
		System.out.println(message);
	}
}
// Two Fer exercise
// http://exercism.io/exercises/java/two-fer/readme

public class TwoFer
{
	private String name;
	
	public TwoFer()
	{
		name = "you";
	}
	
	public TwoFer(String name)
	{
		this.name = name;
	}
	
	public void twoFerMsg()
	{
		if (name.equals("you"))
			System.out.println("One for you, one for me.");
		else
			System.out.println("One for " + name + ", one for me.");
	}
}
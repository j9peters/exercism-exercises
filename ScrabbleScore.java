// Scrabble Score exercise
// http://exercism.io/exercises/java/scrabble-score/readme

public class ScrabbleScore
{
	private String word;
	private int score = 0;
	private String alphabet = "AEIOULNRSTDGBCMPFHVWYKJXQZ";
	private int index;
	
	public ScrabbleScore(String word)
	{
		this.word = word.toUpperCase();
	}
	
	public void displayScore()
	{	
		for (int i = 0; i < word.length(); i++)
		{
			index = alphabet.indexOf(word.charAt(i));

			if (index >= 0 && index <= 9)
				score += 1;
			else if (index > 9 && index <= 11)
				score += 2;
			else if (index > 11 && index <= 15)
				score += 3;
			else if (index > 15 && index <= 20)
				score += 4;
			else if (index == 21)
				score += 5;
			else if (index > 21 && index <= 23)
				score += 8;
			else
				score += 10;
		}			
	
		System.out.println("Your word scored " + score + " points!");
	}
}
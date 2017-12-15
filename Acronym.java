// Acronym exercise
// http://exercism.io/exercises/java/acronym/readme

import java.util.Scanner;

public class Acronym
{
	private String acronym = "";
	private String word;
	private String firstLetter;
	private Scanner scan;
		
	public void createAcronym(String input)
	{
		scan = new Scanner(input);
		scan.useDelimiter(" ");
		
		while (scan.hasNext())
		{
			word = scan.next();
			firstLetter = word.substring(0,1);
			acronym += firstLetter.toUpperCase();
		}
		
		System.out.println("\"" + input + "\" can be abbreviated using the following acronym: " + acronym);
	}
}
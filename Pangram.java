// Pangram exercise
// http://exercism.io/exercises/java/pangram/readme

import java.util.*;

public class Pangram
{
	private HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();
	private boolean allAlphabet = true;
	private char currentChar;
	private int currentValue;	
	private String input;
	
	public Pangram(String str)
	{
		input = str.toLowerCase();
	}
	
	public void isPangram()
	{			
		createHashMap();	

		// check hashmap for values of 0; any 0 disqualifies input string as pangram
		for (HashMap.Entry<Character, Integer> pairing : mapping.entrySet())
		{
			if (pairing.getValue() == 0)
			{
				allAlphabet = false;
			}
		}
		
		if (allAlphabet)
		{
			System.out.println("This is a pangram!");
		}
		else
		{
			System.out.println("Try again. :(");
		}		
	}
	
	private void createHashMap()
	{
		// set up hashmap with 26 keys, one key for each letter of the alphabet
		for (char c = 'a'; c <= 'z'; c++)
		{
			mapping.put(c, 0);
		}
	
		// fill hashmap; values are occurrences of each letter in input string
		for (int i = 0; i < input.length(); i++)
		{	
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
			{
				currentChar = input.charAt(i);
				
				currentValue = mapping.get(currentChar);
				
				mapping.put(currentChar, currentValue + 1);
			}
		}
	}
}
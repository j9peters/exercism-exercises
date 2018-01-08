// Isbn Verifier exercise
// http://exercism.io/exercises/java/isbn-verifier/readme

import java.util.Random;

public class IsbnVerifier
{	
	// contain no dashes
	private static String cleanIsbn10 = "";
	private static String cleanIsbn13 = "";
		
	public static void validateIsbn10(String isbn10)
	{
		boolean isValidIsbn;
		
		isValidIsbn = verifyIsbn10(isbn10);
		
		if (isValidIsbn)
		{
			System.out.println("ISBN-10: " + isbn10 + " is valid.");
		}
	}
	
	private static boolean verifyIsbn10(String isbn10)
	{
		boolean hasValidFormat;
		boolean hasValidCheckDigit;
		
		hasValidFormat = verifyIsbn10Format(isbn10);
		
		if (hasValidFormat)
		{
			hasValidCheckDigit = verifyIsbn10CheckDigit(isbn10);
		}
		else
		{
			return false;
		}
		
		if (hasValidCheckDigit)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static boolean verifyIsbn10Format(String isbn10)
	{
		if (isbn10.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d") || 
			isbn10.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\dX") ||
			isbn10.matches("\\d-\\d\\d\\d-\\d\\d\\d\\d\\d-\\d") ||
			isbn10.matches("\\d-\\d\\d\\d-\\d\\d\\d\\d\\d-X") )
		{	
			return true;
		}
		else
		{
			System.out.println("Invalid ISBN-10 format.\n\nValid formats are:\n\n"
					+ "1-234-56789-0\n1-234-56789-X\n1234567890\n"
					+ "123456789X\n\nTry again.");
			
			return false;
		}
	}
	
	private static boolean verifyIsbn10CheckDigit(String isbn10)
	{
		String checkDigit;
		int weightedSum;
		
		cleanIsbn10 = removeDashes(isbn10);

		weightedSum = processFirstNineDigitsOfIsbn10(cleanIsbn10);
		checkDigit = calculateIsbn10CheckDigit(weightedSum);
		
		if (Character.toString(cleanIsbn10.charAt(9)).equals(checkDigit))
		{
			return true;
		}
		else
		{
			System.out.println("ISBN-10: " + isbn10 + " is invalid.");
			
			return false;
		}
	}
	
	private static int processFirstNineDigitsOfIsbn10(String cleanIsbn10)
	{
		int weightedSum = 0;
		int position = 10;

		for (int i = 0; i < 9; i++)
		{
			weightedSum += position * Character.getNumericValue(cleanIsbn10.charAt(i));
			position--;
		}
		
		return weightedSum;
	}
	
	private static String calculateIsbn10CheckDigit(int weightedSum)
	{
		int checkDigit;
		
		checkDigit = (11 - (weightedSum % 11)) % 11;

		if (checkDigit == 10)
		{
			return "X";
		}
		else
		{
			return Integer.toString(checkDigit);
		}
	}
		
	public static void validateIsbn13(String isbn13)
	{
		boolean isValidIsbn;
		
		isValidIsbn = verifyIsbn13(isbn13);
		
		if (isValidIsbn)
		{
			System.out.println("ISBN-13: " + isbn13 + " is valid.");
		}
	}
	
	private static boolean verifyIsbn13(String isbn13)
	{
		boolean hasValidFormat;
		boolean hasValidCheckDigit;
		
		hasValidFormat = verifyIsbn13Format(isbn13);
		
		if (hasValidFormat)
		{
			hasValidCheckDigit = verifyIsbn13CheckDigit(isbn13);
		}
		else
		{
			return false;
		}
				
		if (hasValidCheckDigit)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static boolean verifyIsbn13Format(String isbn13)
	{
		if (isbn13.matches("978-\\d-\\d\\d\\d-\\d\\d\\d\\d\\d-\\d") || 
			isbn13.matches("978\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d"))
		{			
			return true;
		}
		else
		{
			System.out.println("Invalid ISBN-13 format.\n\nValid formats are:\n\n"
					+ "978-1-234-56789-0\n9781234567890\n\n"
					+ "Try again.");
			
			return false;
		}
	}
	
	private static boolean verifyIsbn13CheckDigit(String isbn13)
	{
		String checkDigit;
		int weightedSum;
		
		cleanIsbn13 = removeDashes(isbn13);
		
		weightedSum = processFirstTwelveDigitsOfIsbn13(cleanIsbn13);
		checkDigit = calculateIsbn13CheckDigit(weightedSum);
				
		if (Character.toString(cleanIsbn13.charAt(12)).equals(checkDigit))
		{
			return true;
		}
		else
		{
			System.out.println("ISBN-13: " + isbn13 + " is invalid.");
			
			return false;
		}
	}

	private static int processFirstTwelveDigitsOfIsbn13(String cleanIsbn13)
	{
		int weightedSum = 0;
		
		for (int i = 0; i < 12; i++)
		{
			if (i % 2 == 0)
			{
				weightedSum += Character.getNumericValue(cleanIsbn13.charAt(i));
			}
			else
			{
				weightedSum += Character.getNumericValue(cleanIsbn13.charAt(i))*3;
			}
		}
		
		return weightedSum;
	}

	private static String calculateIsbn13CheckDigit(int weightedSum)
	{
		int checkDigit;
		
		checkDigit = 10 - (weightedSum % 10);
		
		if (checkDigit == 10)
		{
			checkDigit = 0;
		}
		
		return Integer.toString(checkDigit);
	}
		
	public static void convertToIsbn13(String isbn10)
	{
		boolean isValidIsbn10;
		
		isValidIsbn10 = verifyIsbn10(isbn10);
		
		if (isValidIsbn10)
		{			
			performIsbn10ToIsbn13Conversion(cleanIsbn10);
		}
	}
	
	private static void performIsbn10ToIsbn13Conversion(String cleanIsbn10)
	{
		String isbn13WithDashes = "";
		String isbn13CheckDigit;		
		int isbn13WeightedSum;
				
		cleanIsbn13 = "978" + cleanIsbn10.substring(0,9);
		
		isbn13WeightedSum = processFirstTwelveDigitsOfIsbn13(cleanIsbn13);
		isbn13CheckDigit = calculateIsbn13CheckDigit(isbn13WeightedSum);
		cleanIsbn13 += isbn13CheckDigit;
		
		isbn13WithDashes = addDashesToIsbn13(cleanIsbn13);
		
		System.out.println("ISBN-13: " + isbn13WithDashes);	
	}
	
	public static void convertToIsbn10(String isbn13)
	{
		boolean isValidIsbn13;
		
		isValidIsbn13 = verifyIsbn13(isbn13);
		
		if (isValidIsbn13)
		{			
			performIsbn13ToIsbn10Conversion(cleanIsbn13);
		}
	}
	
	private static void performIsbn13ToIsbn10Conversion(String cleanIsbn13)
	{
		String isbn10WithDashes = "";
		String isbn10CheckDigit;
		int isbn10WeightedSum;

		cleanIsbn10 = cleanIsbn13.substring(3, 12);
		
		isbn10WeightedSum = processFirstNineDigitsOfIsbn10(cleanIsbn10);
		isbn10CheckDigit = calculateIsbn10CheckDigit(isbn10WeightedSum);
		cleanIsbn10 += isbn10CheckDigit;
		
		isbn10WithDashes = addDashesToIsbn10(cleanIsbn10);
		
		System.out.println("ISBN-10: " + isbn10WithDashes);
	}
	
	public static void generateIsbn10()
	{
		String isbn10WithDashes = "";
		String checkDigit;
		int weightedSum;
		
		cleanIsbn10 = generateRandomDigits(9);
		
		weightedSum = processFirstNineDigitsOfIsbn10(cleanIsbn10);
		checkDigit = calculateIsbn10CheckDigit(weightedSum);
		cleanIsbn10 += checkDigit;
		
		isbn10WithDashes = addDashesToIsbn10(cleanIsbn10);
		
		System.out.println("ISBN-10: " + isbn10WithDashes);		
	}
	
	private static String addDashesToIsbn10(String cleanIsbn10)
	{
		String isbn10WithDashes = "";
		
		for (int i = 0; i < cleanIsbn10.length(); i++)
		{
			isbn10WithDashes += cleanIsbn10.charAt(i);
			
			if (i == 0 || i == 3 || i == 8)
			{
				isbn10WithDashes += "-";
			}
		}
		
		return isbn10WithDashes;
	}
	
	public static void generateIsbn13()
	{
		String isbn13WithDashes = "";
		String checkDigit;
		int weightedSum;
		
		cleanIsbn13 = "978" + generateRandomDigits(9);
		
		weightedSum = processFirstTwelveDigitsOfIsbn13(cleanIsbn13);
		checkDigit = calculateIsbn13CheckDigit(weightedSum);
		cleanIsbn13 += checkDigit;
		
		isbn13WithDashes = addDashesToIsbn13(cleanIsbn13);
				
		System.out.println("ISBN-13: " + isbn13WithDashes);
	}
	
	private static String addDashesToIsbn13(String cleanIsbn13)
	{
		String isbn13WithDashes = "";
		
		for (int i = 0; i < cleanIsbn13.length(); i++)
		{
			isbn13WithDashes += cleanIsbn13.charAt(i);
			
			if (i == 2 || i == 3 || i == 6 || i == 11)
			{
				isbn13WithDashes += "-";
			}
		}
		
		return isbn13WithDashes;
	}
	
	private static String generateRandomDigits(int numDigits)
	{
		Random generator = new Random();
		String randomDigitSequence = "";
		int randomDigit;
		
		for (int i = 1; i <= numDigits; i++)
		{
			randomDigit = generator.nextInt(10);
			
			randomDigitSequence += Integer.toString(randomDigit);
		}
		
		return randomDigitSequence;
	}
	
	private static String removeDashes(String isbn10OrIsbn13)
	{
		String isbnNoDashes;
		
		isbnNoDashes = isbn10OrIsbn13.replaceAll("-", "");

		return isbnNoDashes;
	}
}
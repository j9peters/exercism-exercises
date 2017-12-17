// Space Age exercise
// http://exercism.io/exercises/java/space-age/readme

public class SpaceAge
{
	final private static double earthYrSeconds = 31557600;
	final private static double mercuryYrSeconds = 0.2408467*earthYrSeconds;
	final private static double venusYrSeconds = 0.61519726*earthYrSeconds;
	final private static double marsYrSeconds = 1.8808158*earthYrSeconds;
	final private static double jupiterYrSeconds = 11.862615*earthYrSeconds;
	final private static double saturnYrSeconds = 29.447498*earthYrSeconds;
	final private static double uranusYrSeconds = 84.016846*earthYrSeconds;
	final private static double neptuneYrSeconds = 164.79132*earthYrSeconds;
	
	public static double convertToEarthYrs(double seconds)
	{
		return seconds / earthYrSeconds;
	}
	
	public static double convertToMercuryYrs(double seconds)
	{
		return seconds / mercuryYrSeconds;
	}
	
	public static double convertToVenusYrs(double seconds)
	{
		return seconds / venusYrSeconds;
	}
	
	public static double convertToMarsYrs(double seconds)
	{
		return seconds / marsYrSeconds;
	}
	
	public static double convertToJupiterYrs(double seconds)
	{
		return seconds / jupiterYrSeconds;
	}
	
	public static double convertToSaturnYrs(double seconds)
	{
		return seconds / saturnYrSeconds;
	}
	
	public static double convertToUranusYrs(double seconds)
	{
		return seconds / uranusYrSeconds;
	}
	
	public static double convertToNeptuneYrs(double seconds)
	{
		return seconds / neptuneYrSeconds;
	}
}
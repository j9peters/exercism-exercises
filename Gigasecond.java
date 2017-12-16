// Gigasecond exercise
// http://exercism.io/exercises/java/gigasecond/readme

import java.time.*;

public class Gigasecond
{
	private LocalDateTime birth;
	
	public Gigasecond(LocalDateTime birth)
	{
		this.birth = birth;
	}
	
	public void addGigasecond()
	{
		System.out.println(birth.plusSeconds(1000000000));
	}
}
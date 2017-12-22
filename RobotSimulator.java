// Robot Simulator exercise
// http://exercism.io/exercises/java/robot-simulator/readme

import java.util.*;

public class RobotSimulator
{
	private List<String> allOrientations = Arrays.asList("North", "East", "South", "West");
	private String orientation;
	private int index;
	private int xCoordinate;
	private int yCoordinate;
	private char currentChar;
	
	public RobotSimulator(int xCoordinate, int yCoordinate, String orientation)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.orientation = orientation;
		
		index = allOrientations.indexOf(orientation);
	}
	
	public void interpretInstructions(String instructions)
	{
		for (int i = 0; i < instructions.length(); i++)
		{
			currentChar = instructions.charAt(i);

			if (currentChar == 'R')
			{
				rightTurn();
			}
			
			else if (currentChar == 'L')
			{
				leftTurn();
			}
			
			else if (currentChar == 'A')
			{
				advance();
			}
		}
		
		System.out.println("Orientation: " + orientation);
		System.out.println("Coordinates: {" + xCoordinate + ", " + yCoordinate + "}");
	}
	
	private void rightTurn()
	{		
		if (index == 3)
		{
			index = 0;
		}
		
		else
		{
			index++;
		}
		
		orientation = allOrientations.get(index);
	}
	
	private void leftTurn()
	{		
		if (index == 0)
		{
			index = 3;
		}
		
		else
		{
			index--;
		}
		
		orientation = allOrientations.get(index);
	}
	
	private void advance()
	{
		if (orientation.equals("North"))
		{
			yCoordinate++;
		}
		
		else if (orientation.equals("South"))
		{
			yCoordinate--;
		}
		
		else if (orientation.equals("East"))
		{
			xCoordinate++;
		}
	
		else if (orientation.equals("West"))
		{
			xCoordinate--;
		}
	}
}
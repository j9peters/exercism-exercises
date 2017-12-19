// Secret Handshake exercise
// http://exercism.io/exercises/java/secret-handshake/readme

public class SecretHandshake
{
	private String[] actions = {"wink", "double blink", "close your eyes", "jump"};
	private String[] tempArray = new String[4];
	private String[] handshake;
	private String binary;
	private char reverseFlag = '0';
	private int index = 0;
	private int count = 0;
	
	public SecretHandshake(int number)
	{
		binary = Integer.toBinaryString(number);
		
		// truncate long binary numbers, keep last 4 digits
		if (binary.length() >= 5)
		{
			reverseFlag = binary.charAt(binary.length()-5);
			
			binary = binary.substring(binary.length()-4, binary.length());
		}
	}
	
	public void displayHandshakeArray()
	{
		createHandshakeArray();
		
		System.out.print("[");
		
		for (int i = 0; i < handshake.length; i++)
		{
			System.out.print(handshake[i]);
			
			if (i != handshake.length - 1)
			{
				System.out.print(", ");
			}
		}
		
		System.out.print("]");
	}
	
	private void createHandshakeArray()
	{		
		// determine size and contents of handshake array
		for (int i = binary.length() - 1; i >= 0; i--)
		{
			if (binary.charAt(i) == '1')
			{
				tempArray[count] = actions[index];
				count++;
			}
			
			index++;
		}
		
		handshake = new String[count];
		
		index = 0;
		
		// fill handshake array
		if (reverseFlag == '1')
		{
			for (int i = (count-1); i >= 0; i--)
			{
				handshake[index] = tempArray[i];
				index++;
			}
		}
		else
		{
			for (int i = 0; i < count; i++)
			{
				handshake[i] = tempArray[i];
			}	
		}
	}
}
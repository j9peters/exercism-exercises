// Rna Transcription exercise
// http://exercism.io/exercises/java/rna-transcription/readme

public class RnaTranscription
{
	private String rna = "";
	private String dna;
	
	public RnaTranscription(String dna)
	{
		this.dna = dna;
	}
	
	public String convertToRNA()
	{
		for (int i = 0; i < dna.length(); i++)
		{
			if (dna.charAt(i) == 'G')
				rna += "C";
			else if (dna.charAt(i) == 'C')
				rna += "G";
			else if (dna.charAt(i) == 'T')
				rna += "A";
			else if (dna.charAt(i) == 'A')
				rna += "U";	
		}
		
		return rna;
	}
}
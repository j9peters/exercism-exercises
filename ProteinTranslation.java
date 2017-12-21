// Protein Translation exercise
// http://exercism.io/exercises/java/protein-translation/readme

public class ProteinTranslation
{
	private String rna;
	private String currentCodon;
	private String nextCodon;
	private String proteins = "";
	private int numCodons;
	private int index = 0;
	
	public ProteinTranslation(String rna)
	{
		this.rna = rna;
		numCodons = rna.length() / 3;
	}
	
	public void translateToProteins()
	{
		for (int i = 1; i <= numCodons; i++)
		{	
			currentCodon = rna.substring(index, index+3);
			
			if (currentCodon.equals("UAA") || currentCodon.equals("UAG") || currentCodon.equals("UGA"))
			{
				break;
			}
			
			else if (currentCodon.equals("AUG"))
			{
				proteins += "Methionine";
			}
			
			else if (currentCodon.equals("UUU") || currentCodon.equals("UUC"))
			{
				proteins += "Phenylalanine";
			}
			
			else if (currentCodon.equals("UUA") || currentCodon.equals("UUG"))
			{
				proteins += "Leucine";
			}
			
			else if (currentCodon.equals("UCU") || currentCodon.equals("UCC") || 
					 currentCodon.equals("UCA") || currentCodon.equals("UCG"))
			{
				proteins += "Serine";
			}
			
			else if (currentCodon.equals("UAU") || currentCodon.equals("UAC"))
			{
				proteins += "Tyrosine";
			}
			
			else if (currentCodon.equals("UGU") || currentCodon.equals("UGC"))
			{
				proteins += "Cysteine";
			}
			
			else if (currentCodon.equals("UGG"))
			{
				proteins += "Tryptophan";
			}
			
			
			// check next codon for STOP instruction (UAA, UAG, or UGA). if STOP, exit loop
			
			if (index != rna.length()-3)
			{
				nextCodon = rna.substring(index+3, index+6);

				if (nextCodon.equals("UAA") || nextCodon.equals("UAG") || nextCodon.equals("UGA"))
				{
					break;
				}
				
				else
				{
					proteins += ", ";
					index += 3;
				}
			}
		}
		
		System.out.println("Protein translation: " + proteins);
	}
}
package application;

public class Figur
{
	//private String figurFarbe;
	//private int figurID;
	private int figurPosition;
	
	public Figur()
	{
		//figurFarbe = "blau";
		//figurID = 1;
		figurPosition = 2;
	}
	
	public int Abfragen()
	{
		return figurPosition;
	}
	
	public void Setzen(int anzahlFelder)
	{
		figurPosition = figurPosition + anzahlFelder;
	}
}
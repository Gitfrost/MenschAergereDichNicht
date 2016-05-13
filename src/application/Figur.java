package application;

public class Figur
{
	//private String figurFarbe;
	//private int figurID;
	private int figurPosition;
	private int alteFigurPosition;
	
	public Figur()
	{
		//figurFarbe = "blau";
		//figurID = 1;
	}
	
	public int getFigurPosition()
	{
		return figurPosition;
	}
	
	public int getAlteFigurPosition()
	{
		return alteFigurPosition;
	}
	
	public void setAlteFigutPosition(int p)
	{
		alteFigurPosition = p;
	}
	
	public void Setzen(int anzahlFelder)
	{
		alteFigurPosition = figurPosition;
		figurPosition = figurPosition + anzahlFelder;
	}
	
	public void neuAufFeldSetzen()
	{
		figurPosition = 2;
		alteFigurPosition = 0;
	}
}
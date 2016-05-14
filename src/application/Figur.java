package application;

public class Figur
{
	private int figurPosition;
	private int alteFigurPosition;
	
	public Figur()
	{
		
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
		figurPosition = 1;
		alteFigurPosition = 0;
	}
}
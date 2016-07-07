package application;

public class Figur
{
	/*
	 * relative Position der Figur
	 */
	private int figurPosition;
	/*
	 * vorherige relative Position der Figur
	 */
	private int alteFigurPosition;
	/*
	 * Spieler der Figur (1 = blau, 2 = rot, 3 = gruen, 4 = gelb)
	 */
	private int figurSpieler;
	/*
	 * Nummer der Figur (1 bis 4)
	 */
	private int figurNummer;
	/*
	 * Ort der Figur (false = auf normalen Spielfeldern, true = auf Zielfeldern)
	 */
	private boolean inZielFeldern;
	/*
	 * Zustand geschlagen (false = Figur wurde nicht geschlagen, true = Figur wurde geschlagen)
	 */
	private boolean geschlagen;
	
	/*
	 * Konstruktor fuer Figur mit Uebergabe von Spieler- und Figurnummer 
	 * 
	 * Jede Figur steht bei ihrer Erzeugung im Startfeld.
	 * Dementsprechend werden die anderen Eigenschaften initialisiert. 
	 */
	public Figur(int s, int n)
	{
		figurSpieler = s;
		figurNummer = n;
		figurPosition = 0;
		alteFigurPosition = 0;
		inZielFeldern = false;
		geschlagen = false;
	}
	
	/*
	 * get-Methode fuer relative Position der Figur
	 */
	public int getFigurPosition()
	{
		return figurPosition;
	}
	/*
	 * get-Methode fuer absolute Position der Figur
	 */
	public int getAbsolutePosition(int p)
	{
		if (figurPosition != 0)
		{
			if (figurSpieler == 1) {return figurPosition + p;}
			if (figurSpieler == 2) {if (figurPosition + p <= 30) {return figurPosition + p + 10;} else {return figurPosition + p - 30;}}
			if (figurSpieler == 3) {if (figurPosition + p <= 20) {return figurPosition + p + 20;} else {return figurPosition + p - 20;}}
			if (figurSpieler == 4) {if (figurPosition + p <= 10) {return figurPosition + p + 30;} else {return figurPosition + p - 10;}}
		}
		return 0;
	}
	/*
	 * get-Methode fuer vorherige relative Position der Figur
	 */
	public int getAlteFigurPosition()
	{
		return alteFigurPosition;
	}
	/*
	 * set-Methode fuer vorherige relative Position der Figur
	 */
	public void setAlteFigurPosition(int p)
	{
		alteFigurPosition = p;
	}
	/*
	 * get-Methode fuer Spielernummer
	 */
	public int getFigurSpieler()
	{
		return figurSpieler;
	}
	/*
	 * get-Methode fuer Figurnummer
	 */
	public int getFigurNummer()
	{
		return figurNummer;
	}
	/*
	 * get-Methode fuer Zustand der Figur
	 */
	public boolean getInZielFeldern()
	{
		return inZielFeldern;
	}
	/*
	 * set Methode fuer Zustand der Figur
	 */
	public void setInZielFeldern(boolean z)
	{
		inZielFeldern = z;
	}
	/*
	 * get Methode fuer einen Schlagzug
	 */
	public boolean getGeschlagen()
	{
		return geschlagen;
	}
	/*
	 * set Methode fuer einen Schlagzug
	 */
	public void setGeschlagen(boolean y)
	{
		geschlagen = y;
	}
	/*
	 * Methode fuer logisches Setzen der Figur
	 */
	public void Setzen(int anzahlFelder)
	{
		alteFigurPosition = figurPosition;
		figurPosition = figurPosition + anzahlFelder;
	}
	/*
	 * Methode fuer logisches Setzen von der Basis auf das Spielfeld
	 */
	public void neuAufFeldSetzen()
	{
		alteFigurPosition = 0;
		figurPosition = 1;
	}
	/*
	 * Methode fuer logisches Setzen vom Spielfeld in die Basis
	 */
	public void schlagen()
	{
		alteFigurPosition = figurPosition;
		figurPosition = 0;
	}
}

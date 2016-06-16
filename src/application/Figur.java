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
	 * Zustand der Figur (false = auf normalen Spielfeldern, true = auf Zielfeldern)
	 */
	private boolean inZielFeldern;
	/*
	 * Konstruktor fuer Figur mit Uebergabe der Spielernummer
	 */
	public Figur(int s, int n)
	{
		figurPosition = 0;
		alteFigurPosition = 0;
		figurSpieler = s;
		figurNummer = n;
		inZielFeldern = false;
	}
	
	/*
	 * get-Methode fuer relative Position der Figur
	 */
	public int getFigurPosition()
	{
		return figurPosition;
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
	 * Methode fuer logisches Setzen der Figur
	 */
	public void Setzen(int anzahlFelder)
	{
		alteFigurPosition = figurPosition;
		figurPosition = figurPosition + anzahlFelder;
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
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
	 * Spieler der Figur (1 = blau, 2 = rot, 3 = grün, 4 = gelb)
	 */
	private int figurSpieler;
	
	/*
	 * Konstruktor fuer Figur mit Übergabe der Spielernummer
	 */
	public Figur(int s)
	{
		figurPosition = 0;
		alteFigurPosition = 0;
		figurSpieler = s;
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
		figurPosition = 1;
		alteFigurPosition = 0;
	}
}
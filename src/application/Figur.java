package application;

/**
 * Von der Klasse Figur werden im Spiel 16 Instanzen verwendet, um
 * die Spielfiguren mit ihren Eigenschaften zu repraesentieren.
 * @author Lucas Johns
 * @version 1.0
 */
public class Figur
{
	/**
	 * relative Position der Figur
	 */
	private int figurPosition;
	/**
	 * vorherige relative Position der Figur
	 */
	private int alteFigurPosition;
	/**
	 * Spieler der Figur (1 = blau, 2 = rot, 3 = gruen, 4 = gelb)
	 */
	private int figurSpieler;
	/**
	 * Ort der Figur (false = auf normalen Spielfeldern, true = auf Zielfeldern)
	 */
	private boolean inZielFeldern;
	/**
	 * Zustand geschlagen (false = Figur wurde nicht geschlagen, true = Figur wurde geschlagen)
	 */
	private boolean geschlagen;
	
	/**
	 * Der Konstruktor fuer eine Figur mit Uebergabe von Spieler- und Figurnummer.
	 * Jede Figur steht bei ihrer Erzeugung im Startfeld.
	 * Dementsprechend werden die anderen Eigenschaften initialisiert.
	 * @param s Nummer des Spielers der Figur
	 */
	public Figur(int s)
	{
		figurSpieler = s;
		figurPosition = 0;
		alteFigurPosition = 0;
		inZielFeldern = false;
		geschlagen = false;
	}
	
	/**
	 * get-Methode fuer relative Position der Figur
	 * @return relative Position der Figur
	 */
	public int getFigurPosition()
	{
		return figurPosition;
	}
	/**
	 * get-Methode fuer absolute Position der Figur
	 * @param p Wert, der mit der Position der Figur summiert wird und so das Feld angibt, fuer das die Position berechnet werden soll
	 * @return absolute Position auf dem Spielbrett
	 */
	public int getAbsolutePosition(int p)
	{
		if (figurPosition != 0)// Die Position "0" beschreibt die Startfelder des Spielers und wird auch immer mit "0" zurückgegeben.
		{
			if (figurSpieler == 1) {return figurPosition + p;}
			if (figurSpieler == 2) {if (figurPosition + p <= 30) {return figurPosition + p + 10;} else {return figurPosition + p - 30;}}
			if (figurSpieler == 3) {if (figurPosition + p <= 20) {return figurPosition + p + 20;} else {return figurPosition + p - 20;}}
			if (figurSpieler == 4) {if (figurPosition + p <= 10) {return figurPosition + p + 30;} else {return figurPosition + p - 10;}}
		}
		return 0;
	}
	/**
	 * get-Methode fuer vorherige relative Position der Figur
	 * @return vorherige Position der Figur
	 */
	public int getAlteFigurPosition()
	{
		return alteFigurPosition;
	}
	/**
	 * set-Methode fuer vorherige relative Position der Figur
	 * @param p Wert, auf den die vorherige Position gesetzt werden soll
	 */
	public void setAlteFigurPosition(int p)
	{
		alteFigurPosition = p;
	}
	/**
	 * get-Methode fuer Spielernummer
	 * @return Nummer des Spielers der Figur
	 */
	public int getFigurSpieler()
	{
		return figurSpieler;
	}
	/**
	 * get-Methode fuer Zustand der Figur
	 * @return Zustand, ob sich die Figur in den Zielfeldern befindet
	 */
	public boolean getInZielFeldern()
	{
		return inZielFeldern;
	}
	/**
	 * set Methode fuer Zustand der Figur
	 * @param z Zustand, auf den "inZielFeldern" gesetzt werden soll
	 */
	public void setInZielFeldern(boolean z)
	{
		inZielFeldern = z;
	}
	/**
	 * get Methode fuer einen Schlagzug
	 * @return Zustand, ob die Figur geschlagen wurde
	 */
	public boolean getGeschlagen()
	{
		return geschlagen;
	}
	/**
	 * set Methode fuer einen Schlagzug
	 * @param y Zustand, auf den "geschlagen" gesetzt werden soll
	 */
	public void setGeschlagen(boolean y)
	{
		geschlagen = y;
	}
	/**
	 * Methode fuer logisches Setzen der Figur
	 * @param anzahlFelder Anzahl der Felder, die die Figur setzen soll
	 */
	public void Setzen(int anzahlFelder)
	{
		alteFigurPosition = figurPosition;
		figurPosition = figurPosition + anzahlFelder;
	}
	/**
	 * Methode fuer logisches Setzen von der Basis auf das Spielfeld
	 */
	public void neuAufFeldSetzen()
	{
		alteFigurPosition = 0;
		figurPosition = 1;
	}
	/**
	 * Methode fuer logisches Setzen vom Spielfeld in die Basis
	 */
	public void schlagen()
	{
		alteFigurPosition = figurPosition;
		figurPosition = 0;
	}
}

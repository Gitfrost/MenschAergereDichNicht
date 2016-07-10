package application;

/**
 * Von der Klasse Spieler werden im Spiel 4 Instanzen verwendet, um die
 * Mitspieler (Mensch und KI) mit ihren Eigenschaften zu repraesentieren.
 * @author Lucas Johns
 * @version 1.0
 */
public class Spieler
{
	/**
	 * Nummer des Spielers (1 bis 4)
	 */
	private int spielernummer;
	/**
	 * Zustand des Spielers
	 */
	private boolean istAmZug;
	
	/**
	 * Konstruktor fuer Spieler mit Übergabe der Spielernummer
	 * @param n Wert, auf den "spielernummer" gesetzt werden soll
	 */
	public Spieler(int n)
	{
		spielernummer = n;
		istAmZug = false;
	}
	
	/**
	 * get-Methode fuer spielernummer
	 * @return Nummer des Spielers
	 */
	public int getSpielernummer()
	{
		return spielernummer;
	}
	/**
	 * get-Methode fuer istAmZug
	 * @return Zustand, ob der Spieler gerade am Zug ist
	 */
	public boolean getIstAmZug()
	{
		return istAmZug;
	}
	/**
	 * set-Methode fuer istAmZug
	 * @param b Zustand, auf den "istAmZug" gesetzt werden soll
	 */
	public void setIstAmZug(boolean b)
	{
		istAmZug = b;
	}
}

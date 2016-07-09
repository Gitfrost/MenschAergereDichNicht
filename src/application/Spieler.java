package application;

/*
 * Von der Klasse Spieler werden im Spiel 4 Instanzen verwendet, um die
 * Mitspieler (Mensch und KI) mit ihren Eigenschaften zu repraesentieren.
 * 
 * @author Lucas Johns
 */
public class Spieler
{
	/*
	 * Nummer des Spielers (1 bis 4)
	 */
	private int spielernummer;
	/*
	 * Zustand des Spielers
	 */
	private boolean istAmZug;
	
	/*
	 * Konstruktor fuer Spieler mit Übergabe der Spielernummer
	 */
	public Spieler(int n)
	{
		spielernummer = n;
		istAmZug = false;
	}
	
	/*
	 * get-Methode fuer spielernummer
	 */
	public int getSpielernummer()
	{
		return spielernummer;
	}
	/*
	 * get-Methode fuer istAmZug
	 */
	public boolean getIstAmZug()
	{
		return istAmZug;
	}
	/*
	 * set-Methode fuer istAmZug
	 */
	public void setIstAmZug(boolean b)
	{
		istAmZug = b;
	}
}

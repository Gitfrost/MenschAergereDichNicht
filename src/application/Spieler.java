package application;

public class Spieler
{
	private int spielernummer;
	//private boolean nutztKI;
	private boolean istAmZug;
	//private boolean hatGewonnen;
	/*
	 * Konstruktor fuer Spieler mit Übergabe der Spielernummer
	 */
	public Spieler(int n)
	{
		spielernummer = n;
		//hatGewonnen = false;
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
	/*
	 * get-Methode fuer hatGewonnen
	 */
//	public boolean getHatGewonnen()
//	{
//		return hatGewonnen;
//	}
	/*
	 * set-Methode fuer hatGewonnen
	 */
//	public void setHatGewonnen(boolean b)
//	{
//		hatGewonnen = b;
//	}
	/*
	public String toString()
	{
		return "Spieler " + spielernummer;
	}
	*/
}
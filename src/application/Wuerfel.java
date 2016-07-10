package application;

/**
 * Von der Klasse Wuerfel wird im Spiel eine Instanz verwendet,
 * um einen Wuerfel mit seinen Eigenschaften zu repräsentieren.
 * @author Lucas Johns
 * @version 1.0
 */
public class Wuerfel
{
	/**
	 * Zuletzt gewuerfelter Wert (1 bis 6)
	 */
	private int augenzahl;
	/**
	 * Anzahl der Wuerfe, die innerhalb eines Zuges bereits gemacht wurden
	 */
	private int wurfanzahl;
	
	/**
	 * Diese Methode setzt augenzahl auf eine zufaellige Zahl zwischen 1 und 6
	 */
	public void wuerfeln()
	{
		wurfanzahl++;
		augenzahl = (int)(Math.random() * 6) + 1;
	}
	/**
	 * Zustand des Wuerfels ("true" = letzter Wurf war eine sechs, "false" = letzter Wurf war keine sechs)
	 * @return Zustand, ob eine sechs gewuerfelt wurde
	 */
	public boolean sechsGewuerfelt()
	{
		if (augenzahl == 6)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * get-Methode fuer die Augenzahl
	 * @return Augenzahl des letzten Wurfes
	 */
	public int getAugenzahl()
	{
		return augenzahl;
	}
	/**
	 * get-Methode fuer die Wurfanzahl
	 * @return Anzahl der Wuerfe
	 */
	public int getWurfanzahl()
	{
		return wurfanzahl;
	}
	/**
	 * Setzen von Wurfanzahl auf 0
	 */
	public void resetWurfanzahl()
	{
		wurfanzahl = 0;
	}
}

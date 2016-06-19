package application;

public class Wuerfel
{
	private int augenzahl;
	private int wurfnummer;

	public int wuerfeln() //liefert zufällige Zahl zwischen 1 und 6
	{
		wurfnummer++;
		augenzahl = (int)(Math.random() * 6) + 1;
		return augenzahl;
	}
	
	public boolean sechsGewuerfelt()
	{
		if (augenzahl == 6)
			return true;
		else
			return false;
	}
	public int getAugenzahl()
	{
		return augenzahl;
	}
	public void resetWurfnummer()
	{
		wurfnummer = 0;
	}
	public int getWurfnummer()
	{
		return wurfnummer;
	}
}

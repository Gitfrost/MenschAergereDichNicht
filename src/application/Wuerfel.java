package application;

public class Wuerfel
{
	private int augenzahl;
	private int wurfanzahl;

	public int wuerfeln() //liefert zufaellige Zahl zwischen 1 und 6
	{
		wurfanzahl++;
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
	public void resetWurfanzahl()
	{
		wurfanzahl = 0;
	}
	public int getWurfanzahl()
	{
		return wurfanzahl;
	}
}

package application;

public class Wuerfel
{
	private int augenzahl;
	
	public int wuerfeln() //liefert zufällige Zahl zwischen 1 und 6
	{
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
}
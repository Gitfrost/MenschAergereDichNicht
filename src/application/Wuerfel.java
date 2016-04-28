package application;

public class Wuerfel
{
	public static int wuerfeln() //liefert zufällige Zahl zwischen 1 und 6
	{
		return (int)(Math.random() * 6) + 1;
	}
}
package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainWindowController
{
	@FXML private Button testButton;
	
	private Figur b1;
	//public boolean spielLäuft = false;
	//private int[] blauFelder = new int[5];
	
	@FXML public void handleNeuesSpielMenu()
	{
		b1 = new Figur();
		System.out.println(b1.Abfragen());
		//aktualisiereSpielfeld();
	}
	
	@FXML public void handleBeendenMenu()
	{
		
	}
	
	@FXML public void handleTestButton()
	{
			b1.Setzen(3);
			System.out.println(b1.Abfragen());
	}
	
	public void aktualisiereSpielfeld()
	{
		
	}
}
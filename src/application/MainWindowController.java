package application;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class MainWindowController
{
	private Figur blau1;
	//private int[] blaueFelder = {0,0,0,0,0};
	//private int[] blaueFelderVorherigeRunde;
	
	@FXML private Circle f1;
	@FXML private Circle f2;
	@FXML private Circle f3;
	@FXML private Circle f4;
	@FXML private Circle f5;
	
	private Circle[] felder = new Circle[5];

	/*
	 * neues Spiel wird gestartet, Felder und Figuren werden initialisiert
	 */
	@FXML public void handleNeuesSpielMenu()
	{
		felder[0] = f1; felder[1] = f2; felder[2] = f3;felder[3] = f4; felder[4] = f5;
		
		for (int i=0; i<felder.length; i++)
		{
			felder[i].setVisible(false);
		}
		
		blau1 = new Figur();
		blau1.neuAufFeldSetzen();
		System.out.println(blau1.getFigurPosition());
		aktualisiereSpielfeld();
	}
	
	@FXML public void handleBeendenMenu()
	{
		
	}
	
	@FXML public void handleAboutMenu()
	{
		
	}
	
	@FXML public void handleTestButton()
	{
		blau1.Setzen(3);
		System.out.println(blau1.getFigurPosition());
		aktualisiereSpielfeld();
	}
	
	public void aktualisiereSpielfeld()
	{
		/*
		 * aktuellen Werte werden in das Array der blauen Felder geladen
		 */
		//blaueFelder[blau1.getFigurPosition() - 1] = 1;
		
		
		//blaueFelder[blau1.getAlteFigurPosition() - 1] = 0;
		/*
		 * Array der blauen felder wird auf Aenderungen seit dem letzten Zug geprüft
		 */
		//if (blaueFelder.equals(blaueFelderVorherigeRunde) != true)
		//{
			if (blau1.getAlteFigurPosition() != blau1.getFigurPosition());
			/*
			 * GUI Circle Elemente werden für blau1 aktualisiert
			 */
			{
				Thread animationUpdate = new Thread(new Runnable()
				{
					public void run()
					{
						for (int i = blau1.getAlteFigurPosition(); i < blau1.getFigurPosition(); i++)
						{
							
						}
						
						if (blau1.getAlteFigurPosition() != 0)
						felder[blau1.getAlteFigurPosition() - 1].setVisible(false);
						felder[blau1.getFigurPosition() - 1].setVisible(true);
					}
				});
				animationUpdate.start();
				
				
			}
		//}
		
	}
}
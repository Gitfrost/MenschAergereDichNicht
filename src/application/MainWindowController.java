package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/*
 * Hauptklasse für das Spielfeld und alle dazugehörigen Elemente
 * Controller fuer die grafische Oberfläche
 */
public class MainWindowController
{
	/*
	 * 16 am Spiel beteiligte Figuren
	 */
	private Figur blau1, blau2, blau3, blau4, rot1, rot2, rot3, rot4, gruen1, gruen2, gruen3, gruen4, gelb1, gelb2, gelb3, gelb4;
	/*
	 * Bezeichnungen der einzelnen Felder (JavaFX Circles)
	 */
	@FXML private Circle f1, f2, f3, f4, f5, f6, f7, f8, f9, f10,
						 f11, f12, f13, f14, f15, f16, f17, f18, f19, f20,
						 f21, f22, f23, f24, f25, f26, f27, f28, f29, f30,
						 f31, f32, f33, f34, f35, f36, f37, f38, f39, f40;
	/*
	 * Anlegen eines Arrays fuer die Spielfelder
	 */
	private Circle[] felder = new Circle[40];
	
	/*
	 * neues Spiel wird gestartet, Felder und Figuren werden initialisiert
	 */
	@FXML public void handleNeuesSpielMenu()
	{
		/*
		 * Initialisierung des Arrays mit Spielfeldelementen
		 */
		felder[0] = f1; felder[1] = f2; felder[2] = f3; felder[3] = f4; felder[4] = f5; felder[5] = f6; felder[6] = f7; felder[7] = f8; felder[8] = f9; felder [9] = f10;
		felder[10] = f11; felder[11] = f12; felder[12] = f13; felder[13] = f14; felder[14] = f15; felder[15] = f16; felder[16] = f17; felder[17] = f18; felder[18] = f19; felder[19] = f20;
		felder[20] = f21; felder[21] = f22; felder[22] = f23; felder[23] = f24; felder[24] = f25; felder[25] = f26; felder[26] = f27; felder[27] = f28; felder[28] = f29; felder[29] = f30;
		felder[30] = f31; felder[31] = f32; felder[32] = f33; felder[33] = f34; felder[34] = f35; felder[35] = f36; felder[36] = f37; felder[37] = f38; felder[38] = f39; felder[39] = f40;
		/*
		 * zuruecksetzen aller Felder auf nicht sichtbaren Zustand
		 */
		for (int i = 0; i < felder.length; i++)
		{
			felder[i].setVisible(false);
		}
		/*
		 * Anlegen der Figuren
		 */
		blau1 = new Figur(1); blau2 = new Figur(1); blau3 = new Figur(1); blau4 = new Figur(1);
		rot1 = new Figur(2); rot2 = new Figur(2); rot3 = new Figur(2); rot4 = new Figur(2);
		gruen1 = new Figur(3); gruen2 = new Figur(3); gruen3 = new Figur(3); gruen4 = new Figur(3); 
		gelb1 = new Figur(4); gelb2 = new Figur(4); gelb3 = new Figur(4); gelb4 = new Figur(4);
		/*
		 * GUI Update fuer die Figur blau1
		 */
		//aktualisiereGUI(blau1);
		System.out.println(blau1.getFigurPosition());
	}
	
	@FXML public void handleBeendenMenu()
	{
		Platform.exit();
	}
	
	@FXML public void handleAboutMenu()
	{
		
	}
	
	@FXML public void handleTestButton()
	{
		blau1.Setzen(4);
		System.out.println(blau1.getFigurPosition());
		aktualisiereGUI(blau1);
	}
	@FXML public void handleFigurButton()
	{
		blau1.neuAufFeldSetzen();
		System.out.println(blau1.getFigurPosition());
		aktualisiereGUI(blau1);
	}
	
	/*
	 * aktualisiert Spielfeld für angegebene Figur
	 */
	public void aktualisiereGUI(Figur f)
	{
		/*
		 * testen auf eventuelle Aenderungen 
		 */
		if (f.getAlteFigurPosition() != f.getFigurPosition());
		/*
		 * aktualisieren der GUI Circle Elemente fuer Figur f
		 */
		{
			Thread animationUpdate = new Thread(new Runnable()
			{
				public void run()
				{
					/*
					 * testen,ob Figur f in die Basis zurückgesetzt wird (relative Position = 0)
					 */
					if (f.getFigurPosition() == 0)
					{
						
					}
					/*
					 * testen, ob Figur f aus der Basis auf das erste Feld gesetzt wird (relative Position = 1)
					 */
					if (f.getFigurPosition() == 1)
					{
						if (f.getFigurSpieler() == 1)
						{
							felder[0].setFill(Color.web("2c7dff"));
							felder[0].setVisible(true);
						}
						if (f.getFigurSpieler() == 2)
						{
							felder[10].setFill(Color.web("ff4343"));
							felder[10].setVisible(true);
						}
						if (f.getFigurSpieler() == 2)
						{
							felder[20].setFill(Color.web("ff4343"));
							felder[20].setVisible(true);
						}
						if (f.getFigurSpieler() == 2)
						{
							felder[30].setFill(Color.web("83d04f"));
							felder[30].setVisible(true);
						}
					}
					else
					{
						int p = f.getAlteFigurPosition() - 1;
						for (int i = f.getAlteFigurPosition(); i < f.getFigurPosition(); i++)
						{
							felder[p].setVisible(false);
							felder[p + 1].setVisible(true);
							p++;
							try
							{
								Thread.sleep(250);
							}
							catch (InterruptedException e)
							{
								e.printStackTrace();
							}
						}
					}
				}
			});
			animationUpdate.start();
		}
	}
}
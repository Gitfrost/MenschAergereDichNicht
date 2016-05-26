package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class MainWindowController
{
	private Figur blau1, blau2, blau3, blau4, rot1, rot2, rot3, rot4, grün1, grün2, grün3, grün4, gelb1, gelb2, gelb3, gelb4;
	//private int[] blaueFelder = {0,0,0,0,0};
	//private int[] blaueFelderVorherigeRunde;
	
	@FXML private Circle f1, f2, f3, f4, f5, f6, f7, f8, f9, f10,
						f11, f12, f13, f14, f15, f16, f17, f18, f19, f20,
						f21, f22, f23, f24, f25, f26, f27, f28, f29, f30,
						f31, f32, f33, f34, f35, f36, f37, f38, f39, f40;
	
	private Circle[] felder = new Circle[40];
	
	/*
	 * neues Spiel wird gestartet, Felder und Figuren werden initialisiert
	 */
	@FXML public void handleNeuesSpielMenu()
	{
		/*
		 * Initialisierung des Arrays wird mit Spielfeldelementen
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
		 * Erzeugung und Initialisierung neuer Objekte
		 */
		blau1 = new Figur();
		blau2 = new Figur();
		blau3 = new Figur();
		
		blau1.neuAufFeldSetzen();
		aktualisiereSpielfeld();
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
		 * Array der blauen felder wird auf Aenderungen seit dem letzten Zug geprueft
		 */
		//if (blaueFelder.equals(blaueFelderVorherigeRunde) != true)
		//{
			if (blau1.getAlteFigurPosition() != blau1.getFigurPosition());
			/*
			 * GUI Circle Elemente werden fuer blau1 aktualisiert
			 */
			{
				Thread animationUpdate = new Thread(new Runnable()
				{
					public void run()
					{
						if (blau1.getAlteFigurPosition() != 0)
						{
							int p = blau1.getAlteFigurPosition() - 1;
							for (int i = blau1.getAlteFigurPosition(); i < blau1.getFigurPosition(); i++)
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
						else
							felder[0].setVisible(true);
					}
				});
				animationUpdate.start();
				
				
			}
		//}
		
	}
}
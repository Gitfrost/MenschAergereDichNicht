package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/*
 * Hauptklasse fuer das Spielfeld und alle dazugehoerigen Elemente
 * Controller fuer die grafische Oberflaeche
 * enth�lt Methode zur Aktualisierung des GUI
 */
public class MainWindowController
{
	/*
	 * 4 am Spieler beteiligte Spieler
	 */
	private Spieler[] spieler = new Spieler[4];
	/*
	 * 16 am Spiel beteiligte Figuren
	 */
	//private Figur blau1, blau2, blau3, blau4, rot1, rot2, rot3, rot4, gruen1, gruen2, gruen3, gruen4, gelb1, gelb2, gelb3, gelb4;
	/*
	 * Array fuer Figuren
	 */
	private Figur[][] figur = new Figur[4][4];
	/*
	 * 1 am Spiel beteiligter Wuerfel
	 */
	private Wuerfel wuerfel = new Wuerfel();
	/*
	 * Steuervariable, spielZuEnde == true ist Abbruchbedingung der Hauptschleife
	 */
	private boolean spielZuEnde;
	/*
	 * Anlegen der einzelnen Felder (JavaFX Circles)
	 */
	@FXML private Circle f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20,
						 f21, f22, f23, f24, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f36, f37, f38, f39, f40,
						 startBlau1, startBlau2, startBlau3, startBlau4, startRot1, startRot2, startRot3, startRot4,
						 startGruen1, startGruen2, startGruen3, startGruen4, startGelb1, startGelb2, startGelb3, startGelb4,
						 zielBlau1, zielBlau2, zielBlau3, zielBlau4, zielRot1, zielRot2, zielRot3, zielRot4,
						 zielGruen1, zielGruen2, zielGruen3, zielGruen4, zielGelb1, zielGelb2, zielGelb3, zielGelb4;
	/*
	 * Anlegen einer TextArea, die in der Seitenleiste der Textausgabe dient
	 */
	@FXML private TextArea textAusgabe;
	/*
	 * Anlegen eines Buttons 'Wuerfeln' fuer die Seitenleiste
	 */
	@FXML private Button wuerfelButton;
	/*
	 * Anlegen des Arrays fuer die Spielfelder
	 */
	private Circle[] felder = new Circle[40];
	/*
	 * Anlegen der Arrays fuer Startfelder
	 */
	private Circle[] startFelderBlau = new Circle[4];
	private Circle[] startFelderRot = new Circle[4];
	private Circle[] startFelderGruen = new Circle[4];
	private Circle[] startFelderGelb = new Circle[4];
	/*
	 * Anlegen der Arrays fuer Zielfelder
	 */
	private Circle[] zielFelderBlau = new Circle[4];
	private Circle[] zielFelderRot = new Circle[4];
	private Circle[] zielFelderGruen = new Circle[4];
	private Circle[] zielFelderGelb = new Circle[4];
	/*
	 * handler-Methoden fuer Felder
	 */
	@FXML public void handleF1()
	{
		geklickteFigurErmitteln(1);
	}
	@FXML public void handleF0()
	{
		geklickteFigurErmitteln(0);
	}
	/*
	 * neues Spiel wird gestartet, Felder und Figuren werden initialisiert
	 */
	@FXML public void handleNeuesSpielMenu()
	{
		textL�schen();
		textAusgeben("Initialisiere Spielfeld...");
		/*
		 * Initialisierung des Arrays mit Spielfeldelementen
		 */
		felder[0] = f1; felder[1] = f2; felder[2] = f3; felder[3] = f4; felder[4] = f5; felder[5] = f6; felder[6] = f7; felder[7] = f8; felder[8] = f9; felder [9] = f10;
		felder[10] = f11; felder[11] = f12; felder[12] = f13; felder[13] = f14; felder[14] = f15; felder[15] = f16; felder[16] = f17; felder[17] = f18; felder[18] = f19; felder[19] = f20;
		felder[20] = f21; felder[21] = f22; felder[22] = f23; felder[23] = f24; felder[24] = f25; felder[25] = f26; felder[26] = f27; felder[27] = f28; felder[28] = f29; felder[29] = f30;
		felder[30] = f31; felder[31] = f32; felder[32] = f33; felder[33] = f34; felder[34] = f35; felder[35] = f36; felder[36] = f37; felder[37] = f38; felder[38] = f39; felder[39] = f40;
		/*
		 * Initialisierung der Arrays mit Startelementen
		 */
		startFelderBlau[0] = startBlau1; startFelderBlau[1] = startBlau2; startFelderBlau[2] = startBlau3; startFelderBlau[3] = startBlau4;
		startFelderRot[0] = startRot1; startFelderRot[1] = startRot2; startFelderRot[2] = startRot3; startFelderRot[3] = startRot4;
		startFelderGruen[0] = startGruen1; startFelderGruen[1] = startGruen2; startFelderGruen[2] = startGruen3; startFelderGruen[3] = startGruen4;
		startFelderGelb[0] = startGelb1; startFelderGelb[1] = startGelb2; startFelderGelb[2] = startGelb3; startFelderGelb[3] = startGelb4;
		/*
		 * Initialisierung der Arrays mit Zielelementen
		 */
		zielFelderBlau[0] = zielBlau4; zielFelderBlau[1] = zielBlau3; zielFelderBlau[2] = zielBlau2; zielFelderBlau[3] = zielBlau1;
		zielFelderRot[0] = zielRot4; zielFelderRot[1] = zielRot3; zielFelderRot[2] = zielRot2; zielFelderRot[3] = zielRot1;
		zielFelderGruen[0] = zielGruen4; zielFelderGruen[1] = zielGruen3; zielFelderGruen[2] = zielGruen2; zielFelderGruen[3] = zielGruen1;
		zielFelderGelb[0] = zielGelb4; zielFelderGelb[1] = zielGelb3; zielFelderGelb[2] = zielGelb2; zielFelderGelb[3] = zielGelb1;
		/*
		 * Anlegen der Figuren
		 */
		/*
		blau1 = new Figur(1); blau2 = new Figur(1); blau3 = new Figur(1); blau4 = new Figur(1);
		rot1 = new Figur(2); rot2 = new Figur(2); rot3 = new Figur(2); rot4 = new Figur(2);
		gruen1 = new Figur(3); gruen2 = new Figur(3); gruen3 = new Figur(3); gruen4 = new Figur(3); 
		gelb1 = new Figur(4); gelb2 = new Figur(4); gelb3 = new Figur(4); gelb4 = new Figur(4);
		/*
		 * Initialisieren des Arrays fuer die Figuren
		 */
		for (int i = 0; i < 4; i++)
		{
			for (int n = 0; n < 4; n++)
			{
				figur [i][n] = new Figur(i + 1, n + 1);
			}
		}
		/*
		 * Anlegen der Spieler
		 */
		for (int i = 0; i < 4; i++)
		{
			spieler[i] = new Spieler(i + 1);
		}
		//spieler1 = new Spieler(1); spieler2 = new Spieler(2); spieler3 = new Spieler(3); spieler4 = new Spieler(4);
		/*
		 * Zuruecksetzen aller Felder in nicht sichtbaren und deaktivierten Zustand
		 */
		for (int i = 0; i < felder.length; i++)
		{
			felder[i].setVisible(false);
			felder[i].setDisable(true);
		}
		/*
		 * Setzen aller Startfelder in sichtbaren Zustand und
		 * Zuruecksetzen aller Zielfelder in nicht sichtbaren Zustand
		 */
		for (int i = 0; i < 4; i++)
		{
			startFelderBlau[i].setVisible(true);
			zielFelderBlau[i].setVisible(false);
			startFelderRot[i].setVisible(true);
			zielFelderRot[i].setVisible(false);
			startFelderGruen[i].setVisible(true);
			zielFelderGruen[i].setVisible(false);
			startFelderGelb[i].setVisible(true);
			zielFelderGelb[i].setVisible(false);
		}
		/*
		 * Aktualisieren der Textausgabe
		 */
		textAusgeben("Neues Spiel gestartet...");
		textAusgeben("Sie sind Spieler 1 (blau).");
		/*
		 * Setzen von spielZuEnde auf false, da noch keiner gewonnen hat
		 */
		spielZuEnde = false;
		/*
		 * Spieler 1 (blau) f�ngt an
		 */
		spieler[0].setIstAmZug(true);
		/*
		 * Abfragen, welcher Spieler am Zug ist
		 */
		zugInit(spieler[0]);
		//for (int i = 0; i < 4; i++) {if (spieler[i].getIstAmZug() == true){zugAusf�hren(i + 1);}}
		/*
		 * Testen, ob ein Spieler gewonnen hat
		 
		for (int i = 0; i < 4; i++)
		{
			if (spieler[i].getHatGewonnen() == true)
			{
				if (i == 1) {textAusgeben("Sie haben gewonnen."); textAusgeben("Herzlichen Gl�ckwunsch!");}
				else {textAusgeben("Sie haben verloren."); textAusgeben("Spieler " + spieler[i].getSpielernummer() + " ist der Sieger.");}
				spielZuEnde = true;
				break;
			}
		}
		*/
	}
	@FXML public void handleBeendenMenu()
	{
		Platform.exit();
	}
	@FXML public void handleAboutMenu()
	{
		
	}
	/*
	 * Einleiten des Spielzuges
	 */
	public void zugInit(Spieler s)
	{
		if (s.getSpielernummer() == 1)
		{
			s.setIstAmZug(true);
			textAusgeben("Sie sind an der Reihe.");
			wuerfelButton.setDisable(false);
		}
		else
		{
			s.setIstAmZug(true);
			textAusgeben("Spieler " + s.getSpielernummer() + " ist an der Reihe.");
			wuerfel.wuerfeln();
			textAusgeben("Spieler " + s.getSpielernummer() + " hat eine " + wuerfel.getAugenzahl() + " gew�rfelt.");
			zug(figur[s.getSpielernummer()][(int)(Math.random() * 4)]);
		}
	}
	@FXML public void handleWuerfelButton()
	{
		wuerfelButton.setDisable(true);
		wuerfel.wuerfeln();
		textAusgeben("Sie haben eine " + wuerfel.getAugenzahl() + " gew�rfelt.");
		for (int i = 0; i < 4; i++)
		{
			if (figur[0][i].getFigurPosition() == 0) {for (int s = 0; s < 4; s++) {startFelderBlau[s].setDisable(false);}}
			else if (figur[0][i].getFigurPosition() <= 40) {felder[figur[0][i].getFigurPosition() - 1].setDisable(false);}
			else {zielFelderBlau[figur[0][i].getFigurPosition() - 40].setDisable(false);}
		}
	}
	public void geklickteFigurErmitteln(int feldnummer)
	{
		for (int i = 0; i < 4; i++)
		{
			if (figur[0][i].getFigurPosition() == feldnummer)
			{
				zug(figur[0][i]); break;
			}
		}
	}
	public void zug(Figur f)
	{
		if (f.getFigurPosition() + wuerfel.getAugenzahl() <= 44)
		{
			if (f.getFigurPosition() == 0 && wuerfel.sechsGewuerfelt() == true)
			{
				f.neuAufFeldSetzen();
				aktualisiereGUI(f);
			}
			else if (f.getFigurPosition() == 0 && wuerfel.sechsGewuerfelt() == false)
			{
				textAusgeben("Kein g�ltiger Spielzug.");
				textAusgeben("Nur bei einer 6 d�rfen Sie eine neue Figur raussetzen.");
			}
			else
			{
				f.Setzen(wuerfel.getAugenzahl());
			}
		}
		else {textAusgeben("Kein g�ltiger Spielzug.");}
	}
	/*
	 * Methode fuer Textausgabe in der Seitenleiste
	 */
	public void textAusgeben(String s)
	{
		textAusgabe.appendText(s + "\n");
	}
	/*
	 * Methode zum Zur�cksetzen der Textausgabe
	 */
	public void textL�schen()
	{
		textAusgabe.setText("");
	}
	/*
	 * aktualisiert Spielfeld fuer angegebene Figur
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
					 * testen,ob Figur f in die Basis zurueckgesetzt wird (relative Position = 0)
					 */
					if (f.getFigurPosition() == 0)
					{
						if (f.getFigurSpieler() == 1)
						{
							felder[f.getAlteFigurPosition() - 1].setVisible(false);
							for (int i = 0; i < 4; i++)
							{
								if (startFelderBlau[i].isVisible() == false) {startFelderBlau[i].setVisible(true); break;}
							}
						}
						if (f.getFigurSpieler() == 2)
						{
							if (f.getAlteFigurPosition() <= 30) {felder[f.getAlteFigurPosition() + 9].setVisible(false);}
							else {felder[f.getAlteFigurPosition() - 31].setVisible(false);}
							for (int i = 0; i < 4; i++)
							{
								if (startFelderBlau[i].isVisible() == false) {startFelderBlau[i].setVisible(true); break;}
							}
						}
						if (f.getFigurSpieler() == 3)
						{
							if (f.getAlteFigurPosition() <= 20) {felder[f.getAlteFigurPosition() + 19].setVisible(false);}
							else {felder[f.getAlteFigurPosition() - 21].setVisible(false);}
							for (int i = 0; i < 4; i++)
							{
								if (startFelderBlau[i].isVisible() == false) {startFelderBlau[i].setVisible(true); break;}
							}
						}
						if (f.getFigurSpieler() == 4)
						{
							if (f.getAlteFigurPosition() <= 10) {felder[f.getAlteFigurPosition() + 29].setVisible(false);}
							else {felder[f.getAlteFigurPosition() - 11].setVisible(false);}
							for (int i = 0; i < 4; i++)
							{
								if (startFelderBlau[i].isVisible() == false) {startFelderBlau[i].setVisible(true); break;}
							}
						}
					}
					/*
					 * testen, ob Figur f aus der Basis auf das erste Feld gesetzt wird (relative Position = 1)
					 */
					else if (f.getFigurPosition() == 1)
					{
						if (f.getFigurSpieler() == 1)
						{
							for (int i = 0; i < 4; i++)
							{
								if (startFelderBlau[i].isVisible() == true) {startFelderBlau[i].setVisible(false); break;}
							}
							felder[0].setFill(Color.web("3daeff99"));
							felder[0].setVisible(true);
						}
						if (f.getFigurSpieler() == 2)
						{
							for (int i = 0; i < 4; i++)
							{
								if (startFelderRot[i].isVisible() == true) {startFelderRot[i].setVisible(false); break;}
							}
							felder[10].setFill(Color.web("ff4343"));
							felder[10].setVisible(true);
						}
						if (f.getFigurSpieler() == 3)
						{
							for (int i = 0; i < 4; i++)
							{
								if (startFelderGruen[i].isVisible() == true) {startFelderGruen[i].setVisible(false); break;}
							}
							felder[20].setFill(Color.web("83d04f"));
							felder[20].setVisible(true);
						}
						if (f.getFigurSpieler() == 4)
						{
							for (int i = 0; i < 4; i++)
							{
								if (startFelderGelb[i].isVisible() == true) {startFelderGelb[i].setVisible(false); break;}
							}
							felder[30].setFill(Color.web("fff438"));
							felder[30].setVisible(true);
						}
					}
					/*
					 * normales Setzen der Figur f
					 */
					else
					{
						if (f.getFigurSpieler() == 1)
						{
							int pos, count = 0;
							for (int i = f.getAlteFigurPosition(); i < f.getFigurPosition(); i++)
							{
								if (f.getAlteFigurPosition() + count <= 39) {pos = f.getAlteFigurPosition() + count - 1;}
								else {pos = f.getAlteFigurPosition() + count - 1;}
								if (pos == 39 || f.getInZielFeldern() == true)
								{
									if (f.getInZielFeldern() == false) {felder[pos].setVisible(false);}
									else {zielFelderBlau[pos - 40].setVisible(false);}
									f.setInZielFeldern(true);
									zielFelderBlau[pos - 39].setFill(Color.web("3daeff99"));
									zielFelderBlau[pos - 39].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{	
									felder[pos].setVisible(false);
									felder[pos + 1].setFill(Color.web("3daeff99"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
							}
						}
						if (f.getFigurSpieler() == 2)
						{
							int pos, count = 0;
							for (int i = f.getAlteFigurPosition(); i < f.getFigurPosition(); i++)
							{
								if (f.getAlteFigurPosition() + count <= 30) {pos = f.getAlteFigurPosition() + count + 9;}
								else {pos = f.getAlteFigurPosition() + count - 31;}
								if (pos == 9 || f.getInZielFeldern() == true)
								{
									if (f.getInZielFeldern() == false) {felder[pos].setVisible(false);}
									else {zielFelderRot[pos - 10].setVisible(false);}
									f.setInZielFeldern(true);
									zielFelderRot[pos - 9].setFill(Color.web("ff4343"));
									zielFelderRot[pos - 9].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else if (pos == 39)
								{
									felder[39].setVisible(false);
									felder[0].setFill(Color.web("ff4343"));
									felder[0].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{										
									felder[pos].setVisible(false);							
									felder[pos + 1].setFill(Color.web("ff4343"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
							}						
						}
						if (f.getFigurSpieler() == 3)
						{
							int pos, count = 0;
							for (int i = f.getAlteFigurPosition(); i < f.getFigurPosition(); i++)
							{
								if (f.getAlteFigurPosition() + count <= 20) {pos = f.getAlteFigurPosition() + count + 19;}
								else {pos = f.getAlteFigurPosition() + count - 21;}
								if (pos == 19 || f.getInZielFeldern() == true)
								{
									if (f.getInZielFeldern() == false) {felder[pos].setVisible(false);}
									else {zielFelderGruen[pos - 20].setVisible(false);}
									f.setInZielFeldern(true);
									zielFelderGruen[pos - 19].setFill(Color.web("83d04f"));
									zielFelderGruen[pos - 19].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else if (pos == 39)
								{
									felder[39].setVisible(false);
									felder[0].setFill(Color.web("83d04f"));
									felder[0].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{										
									felder[pos].setVisible(false);							
									felder[pos + 1].setFill(Color.web("83d04f"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
							}
						}
						if (f.getFigurSpieler() == 4)
						{
							int pos, count = 0;
							for (int i = f.getAlteFigurPosition(); i < f.getFigurPosition(); i++)
							{
								if (f.getAlteFigurPosition() + count <= 10) {pos = f.getAlteFigurPosition() + count + 29;}
								else {pos = f.getAlteFigurPosition() + count - 11;}
								if (pos == 29 || f.getInZielFeldern() == true)
								{
									if (f.getInZielFeldern() == false) {felder[pos].setVisible(false);}
									else {zielFelderGelb[pos - 30].setVisible(false);}
									f.setInZielFeldern(true);
									zielFelderGelb[pos - 29].setFill(Color.web("fff438"));
									zielFelderGelb[pos - 29].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else if (pos == 39)
								{
									felder[39].setVisible(false);
									felder[0].setFill(Color.web("fff438"));
									felder[0].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{
									felder[pos].setVisible(false);							
									felder[pos + 1].setFill(Color.web("fff438"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
							}						
						}
					}
				}
			});
			animationUpdate.start();
		}
	}
}
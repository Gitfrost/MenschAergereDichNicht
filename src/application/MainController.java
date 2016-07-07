package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
/*
 * Hauptklasse fuer das Spielfeld und alle dazugehoerigen Elemente
 * Controller fuer die grafische Oberflaeche
 * enthaelt Methode zur Aktualisierung des GUI
 */
public class MainController implements AnimationFertigListener
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
	@FXML public void handleF0() {zugMensch(figurErmitteln(0));}
	@FXML public void handleF1() {zugMensch(figurErmitteln(1));}
	@FXML public void handleF2() {zugMensch(figurErmitteln(2));}
	@FXML public void handleF3() {zugMensch(figurErmitteln(3));}
	@FXML public void handleF4() {zugMensch(figurErmitteln(4));}
	@FXML public void handleF5() {zugMensch(figurErmitteln(5));}
	@FXML public void handleF6() {zugMensch(figurErmitteln(6));}
	@FXML public void handleF7() {zugMensch(figurErmitteln(7));}
	@FXML public void handleF8() {zugMensch(figurErmitteln(8));}
	@FXML public void handleF9() {zugMensch(figurErmitteln(9));}
	@FXML public void handleF10() {zugMensch(figurErmitteln(10));}
	@FXML public void handleF11() {zugMensch(figurErmitteln(11));}
	@FXML public void handleF12() {zugMensch(figurErmitteln(12));}
	@FXML public void handleF13() {zugMensch(figurErmitteln(13));}
	@FXML public void handleF14() {zugMensch(figurErmitteln(14));}
	@FXML public void handleF15() {zugMensch(figurErmitteln(15));}
	@FXML public void handleF16() {zugMensch(figurErmitteln(16));}
	@FXML public void handleF17() {zugMensch(figurErmitteln(17));}
	@FXML public void handleF18() {zugMensch(figurErmitteln(18));}
	@FXML public void handleF19() {zugMensch(figurErmitteln(19));}
	@FXML public void handleF20() {zugMensch(figurErmitteln(20));}
	@FXML public void handleF21() {zugMensch(figurErmitteln(21));}
	@FXML public void handleF22() {zugMensch(figurErmitteln(22));}
	@FXML public void handleF23() {zugMensch(figurErmitteln(23));}
	@FXML public void handleF24() {zugMensch(figurErmitteln(24));}
	@FXML public void handleF25() {zugMensch(figurErmitteln(25));}
	@FXML public void handleF26() {zugMensch(figurErmitteln(26));}
	@FXML public void handleF27() {zugMensch(figurErmitteln(27));}
	@FXML public void handleF28() {zugMensch(figurErmitteln(28));}
	@FXML public void handleF29() {zugMensch(figurErmitteln(29));}
	@FXML public void handleF30() {zugMensch(figurErmitteln(30));}
	@FXML public void handleF31() {zugMensch(figurErmitteln(31));}
	@FXML public void handleF32() {zugMensch(figurErmitteln(32));}
	@FXML public void handleF33() {zugMensch(figurErmitteln(33));}
	@FXML public void handleF34() {zugMensch(figurErmitteln(34));}
	@FXML public void handleF35() {zugMensch(figurErmitteln(35));}
	@FXML public void handleF36() {zugMensch(figurErmitteln(36));}
	@FXML public void handleF37() {zugMensch(figurErmitteln(37));}
	@FXML public void handleF38() {zugMensch(figurErmitteln(38));}
	@FXML public void handleF39() {zugMensch(figurErmitteln(39));}
	@FXML public void handleF40() {zugMensch(figurErmitteln(40));}
	@FXML public void handleF41() {zugMensch(figurErmitteln(41));}
	@FXML public void handleF42() {zugMensch(figurErmitteln(42));}
	@FXML public void handleF43() {zugMensch(figurErmitteln(43));}
	@FXML public void handleF44() {zugMensch(figurErmitteln(44));}	
	/*
	 * neues Spiel wird gestartet, Felder und Figuren werden initialisiert
	 */
	@FXML public void handleNeuesSpielMenu()
	{
		textLoeschen();
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
		 * Spieler 1 (blau) faengt an
		 */
		zugInit(spieler[0]);
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
	 * Zuruecksetzen aller Spieler auf istAmZug = false
	 * Setzen des aktuellen Spielers (s) auf istAmZug = true
	 * d.h. es kann immer nur ein Spieler am Zug sein
	 */
	public void zugInit(Spieler s)
	{
		for (int i = 0; i < 4; i++) {spieler[i].setIstAmZug(false);}
		s.setIstAmZug(true);
		wuerfel.resetWurfanzahl();
		if (s.getSpielernummer() == 1)
		{
			textAusgeben("");
			textAusgeben("Sie sind an der Reihe.");
			wuerfelButton.setDisable(false);
		}
		else
		{
			textAusgeben("");
			textAusgeben("Spieler " + s.getSpielernummer() + " ist an der Reihe.");
			wuerfelnKI(s);
		}
	}
	/*
	 * Handler-Methode fuer den Wuerfelbutton
	 */
	@FXML public void handleWuerfelButton()
	{
		wuerfelButton.setDisable(true);
		wuerfel.wuerfeln();
		textAusgeben("Sie haben eine " + wuerfel.getAugenzahl() + " gewuerfelt.");
		/*
		 * Aktivieren der Spielfeldelemente, auf denen eine Figur steht
		 * d.h. Auslösen eines Handlers möglich
		 */
		int z = 0;// Zaehlvariable fuer Figuren in den Startfeldern
		for (int i = 0; i < 4; i++)
		{
			if (figur[0][i].getFigurPosition() == 0) {for (int s = 0; s < 4; s++) {startFelderBlau[s].setDisable(false);} z++;}
			else if (figur[0][i].getFigurPosition() <= 40) {felder[figur[0][i].getFigurPosition() - 1].setDisable(false);}
			else {zielFelderBlau[figur[0][i].getFigurPosition() - 41].setDisable(false);}
		}
		/*
		 * Ermitteln, ob der Zug bereits beendet wird, ohne ein Figur zu setzen
		 * d.h. 3 mal keine sechs, wenn alle Figuren in den Startfeldern stehen (z=4)
		 */
		if (z == 4)
		{
			if (wuerfel.getWurfanzahl() < 3 || wuerfel.sechsGewuerfelt() == true) {wuerfelButton.setDisable(false);}
			else {zugEnde();}
		}
		else
		{
			int p = 0;
			for (int i = 0; i < 4; i++)
			{
				if (zugPruefen(figur[0][i]) == false) {p++;}
			}
			if (p == 4 && wuerfel.sechsGewuerfelt() == false)
			{
				textAusgeben("Kein Zug mit einer " + wuerfel.getAugenzahl() + " moeglich.");
				textAusgeben("Sie muessen aussetzen.");
				zugEnde();
				return;
			}
		}
	}
	public void handleZugBeendenButton()
	{
	}
	/*
	 * Diese Methode ermittelt zu einer uebergebenen Feldnummer, die
	 * eventuell auf diesem Feld stehende Figur und gibt diese zurueck.
	 * Steht keine Figur auf dem Feld, wird null zurückgegeben.
	 */
	public Figur figurErmitteln(int feldnummer)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int c = 0; c < 4; c++)
			{
				if (figur[i][c].getAbsolutePosition(0) == feldnummer) {return figur[i][c];}
			}
		}
		return null;
	}
	public void disableFelder()
	{
		for (int s = 0; s < 4; s++) {startFelderBlau[s].setDisable(true); zielFelderBlau[s].setDisable(false);}
		for (int i = 0; i < 40; i++) {felder[i].setDisable(true);}
	}
	public void zugMensch(Figur f)
	{
		/*
		 * Testen, ob der Zug auf dem Spielbrett ueberhaupt zulässig ist
		 */
		if (f.getFigurPosition() + wuerfel.getAugenzahl() <= 44)
		{
			if (f.getFigurPosition() == 0 && wuerfel.sechsGewuerfelt() == true)
			{
				if (figurErmitteln(1) != null && figurErmitteln(1).getFigurSpieler() == 1) {textAusgeben("Erst das Startfeld freimachen.");}
				else
				{
					if (figurErmitteln(1) != null && figurErmitteln(1).getFigurSpieler() != 1)
					{
						figurErmitteln(1).setGeschlagen(true);
					}
					disableFelder();
					f.neuAufFeldSetzen();
					aktualisiereGUI(f);
				}
			}
			else if (f.getFigurPosition() == 0 && wuerfel.sechsGewuerfelt() == false)
			{
				textAusgeben("Kein gueltiger Spielzug.");
				textAusgeben("Nur bei einer 6 duerfen Sie eine neue Figur raussetzen.");
				wuerfelButton.setDisable(false);
			}
			else
			{
				if (figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()) != null &&
					figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()).getFigurSpieler() == 1)
				{
					textAusgeben("Kein gueltiger Spielzug.");
				}
				else
				{
					if (figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()) != null &&
						figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()).getFigurSpieler() != 1)
					{
						figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()).setGeschlagen(true);
					}
					disableFelder();
					f.Setzen(wuerfel.getAugenzahl());
					aktualisiereGUI(f);
				}
			}
		}
		else {textAusgeben("Kein gueltiger Spielzug.");}
	}
	public void wuerfelnKI(Spieler s)
	{
		int z;
		do
		{
			z = 0; // Zaehlvariable fuer Figuren in den Startfeldern
			wuerfel.wuerfeln();
			textAusgeben("Spieler " + s.getSpielernummer() + " hat eine " + wuerfel.getAugenzahl() + " gewuerfelt.");
			for (int i = 0; i < 4; i++) {if (figur[s.getSpielernummer() - 1][i].getFigurPosition() == 0) {z++;}}
			if (z == 4 && wuerfel.sechsGewuerfelt() == true) // wenn alle Figuren in Startfeldern und Augenzahl = 6
			{
				zugKI(s);
				return;
			}
		}
		while (z == 4 && wuerfel.getWurfanzahl() < 3);
		if (z == 4 && wuerfel.getWurfanzahl() >= 3) {zugEnde();}
		else {zugKI(s);}
	}
	public void zugKI(Spieler s)
	{
		int n = 0;
		for (int i = 0; i < 4; i++)
		{
			if (zugPruefen(figur[s.getSpielernummer() - 1][i]) == false) {n++;}
		}
		if (n == 4)
		{
			textAusgeben("Spieler " + s.getSpielernummer() + " muss aussetzen.");
			zugEnde();
		}
		int r = (int)(Math.random() * 4);
		while (zugPruefen(figur[s.getSpielernummer() - 1][r]) == false)
		{
			r = (int)(Math.random() * 4);
		}
		if (figur[s.getSpielernummer() - 1][r].getFigurPosition() == 0)
		{
			if (s.getSpielernummer() == 2) {if (figurErmitteln(11) != null) {figurErmitteln(11).setGeschlagen(true);}}
			if (s.getSpielernummer() == 3) {if (figurErmitteln(21) != null) {figurErmitteln(21).setGeschlagen(true);}}
			if (s.getSpielernummer() == 4) {if (figurErmitteln(31) != null) {figurErmitteln(31).setGeschlagen(true);}}
			figur[s.getSpielernummer() - 1][r].neuAufFeldSetzen(); aktualisiereGUI(figur[s.getSpielernummer() - 1][r]);
		}
		else
		{
			if (figurErmitteln(figur[s.getSpielernummer() - 1][r].getAbsolutePosition(wuerfel.getAugenzahl())) != null)
			{
				figurErmitteln(figur[s.getSpielernummer() - 1][r].getAbsolutePosition(wuerfel.getAugenzahl())).setGeschlagen(true);
			}
			figur[s.getSpielernummer() - 1][r].Setzen(wuerfel.getAugenzahl()); aktualisiereGUI(figur[s.getSpielernummer() - 1][r]);
		}
	}
	/*
	 * Testen, ob der Zug mit der uebergebenen Figur zulässig ist
	 * zugPruefen liefert false, wenn der Zug durch die Spielregeln verboten ist
	 */
	public boolean zugPruefen(Figur f)
	{
		if (f.getFigurPosition() + wuerfel.getAugenzahl() <= 44)
		{
			if (f.getFigurPosition() == 0)
			{
				if (wuerfel.getAugenzahl() != 6) {return false;}
				else
				{
					/*
					 * testen, ob vor der Spielerbasis eine eigene Figur steht
					 */
					for (int i = 0; i < 4; i++)
					{
							if (figur[f.getFigurSpieler() - 1][i].getFigurPosition() == 1) {return false;}
					}
//					if (f.getFigurSpieler() == 2) {if (figurErmitteln(11) != null && figurErmitteln(11).getFigurSpieler() == 2) {return false;}}
//					if (f.getFigurSpieler() == 3) {if (figurErmitteln(21) != null && figurErmitteln(21).getFigurSpieler() == 3) {return false;}}
//					if (f.getFigurSpieler() == 4) {if (figurErmitteln(31) != null && figurErmitteln(31).getFigurSpieler() == 4) {return false;}}
					return true;
				}	
			}
			else
			{
				if (figurErmitteln(f.getAbsolutePosition(wuerfel.getAugenzahl())) != null &&
						figurErmitteln(f.getAbsolutePosition(wuerfel.getAugenzahl())).getFigurSpieler() == f.getFigurSpieler()) {return false;}
				else {return true;}
			}
		}
		return false;
	}
	/*
	 * Aufruf von zugInit() fuer den Spielers, der als nächstes an der Reihe ist
	 */
	public void zugEnde()
	{
		for (int i = 0; i < 4; i++)
		{
			if (spieler[i].getIstAmZug() == true)
			{
				if (spieler[i].getSpielernummer() == 4) {zugInit(spieler[0]); break;}
			else {zugInit(spieler[i + 1]); break;}
			}
		}
	}
	/*
	 * Methode fuer Textausgabe in der Seitenleiste
	 */
	public void textAusgeben(String s)
	{
		textAusgabe.appendText(s + "\n");
	}
	/*
	 * Methode zum Zuruecksetzen der Textausgabe
	 */
	public void textLoeschen()
	{
		textAusgabe.setText("");
	}
	/*
	 * Methode, die ausgeführt wird, sobald der animationUpdate-Thread beendet ist
	 */
	@Override
	public void auslösenAnimationFertig(Thread thread)
	{
		/*
		 * Ermitteln, ob eine Figur geschlagen werden muss 
		 */
		for(int i = 0; i < 4; i++)
		{
			for (int c = 0; c < 4; c++)
			{
				if (figur[i][c].getGeschlagen() == true)
				{
					figur[i][c].schlagen();
					figur[i][c].setGeschlagen(false);
					if (figur[i][c].getFigurSpieler() == 1) {textAusgeben("Ihre Figur wurde geschlagen!");}
					for (int n = 2; n < 5; n++)
					{
						if (figur[i][c].getFigurSpieler() == n) {textAusgeben("Eine Figur von Spieler " + n + " wurde geschlagen!");}
					}
					aktualisiereGUI(figur[i][c]);
					return;
				}
			}
		}
		/*
		 * Ermitteln des Spielers, der am Zug ist
		 */
		for(int i = 0; i < 4; i++)
		{
			if (spieler[i].getIstAmZug() == true)
			{
				/*
				 * testen, ob der Spieler durch diesen Zug gewonnen hat
				 */
				int z = 0;
				for (int c = 4; c < 0; c++)
				{
					if (figur[spieler[i].getSpielernummer()][c].getInZielFeldern() == true) {z++;}
				}
				if (z == 4)
				{
					if (spieler[i].getSpielernummer() == 1) {textAusgeben("Sie haben gewonnen."); textAusgeben("Herzlichen Glueckwunsch!");}
					else {textAusgeben("Sie haben verloren."); textAusgeben("Spieler " + spieler[i].getSpielernummer() + " ist der Sieger.");}
				}
				else
				{
					if (wuerfel.sechsGewuerfelt() == true)
					{
						if (spieler[i].getSpielernummer() == 1) {wuerfelButton.setDisable(false); break;}
						else {wuerfelnKI(spieler[i]); break;}
					}
					else {zugEnde(); break;}
				}
			}
		}
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
			AnimationThread animationUpdate = new AnimationThread()
			{
				private Paint nextColor;
				public void doRun()
				{
					/*
					 * testen, ob Figur f geschlagen, d.h. in die Basis zurueckgesetzt wird (relative Position = 0)
					 */
					if (f.getFigurPosition() == 0)
					{
						if (f.getFigurSpieler() == 1)
						{
							for (int i = 0; i < 4; i++)
							{
								if (startFelderBlau[i].isVisible() == false) {startFelderBlau[i].setVisible(true); break;}
							}
						}
						if (f.getFigurSpieler() == 2)
						{
							for (int i = 0; i < 4; i++)
							{
								if (startFelderRot[i].isVisible() == false) {startFelderRot[i].setVisible(true); break;}
							}
						}
						if (f.getFigurSpieler() == 3)
						{
							for (int i = 0; i < 4; i++)
							{
								if (startFelderGruen[i].isVisible() == false) {startFelderGruen[i].setVisible(true); break;}
							}
						}
						if (f.getFigurSpieler() == 4)
						{
							for (int i = 0; i < 4; i++)
							{
								if (startFelderGelb[i].isVisible() == false) {startFelderGelb[i].setVisible(true); break;}
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
									if (nextColor != null)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[pos + 1].isVisible() == true) {nextColor = felder[pos + 1].getFill();}
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
									if (nextColor != null)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[0].isVisible() == true) {nextColor = felder[0].getFill();}
									felder[0].setFill(Color.web("ff4343"));
									felder[0].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{										
									if (nextColor != null)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[pos + 1].isVisible() == true) {nextColor = felder[pos + 1].getFill();}							
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
									if (nextColor != null)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[0].isVisible() == true) {nextColor = felder[0].getFill();}
									felder[0].setFill(Color.web("83d04f"));
									felder[0].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{										
									if (nextColor != null)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[pos + 1].isVisible() == true) {nextColor = felder[pos + 1].getFill();}							
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
									if (nextColor != null)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[0].isVisible() == true) {nextColor = felder[0].getFill();}
									felder[0].setFill(Color.web("fff438"));
									felder[0].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{
									if (nextColor != null)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[pos + 1].isVisible() == true) {nextColor = felder[pos + 1].getFill();}							
									felder[pos + 1].setFill(Color.web("fff438"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								
							}						
						}
					}
					try {
						AnimationThread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			};
			animationUpdate.addListener(this);
			animationUpdate.start();
		}
	}
}

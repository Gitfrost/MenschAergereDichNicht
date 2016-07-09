package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
/*
 * Diese Klasse ist die Hauptklasse fuer das Spielfeld und alle dazugehoerigen Elemente.
 * Sie dient auﬂerdem als Controller fuer die Oberflaeche.
 * 
 * @author Lucas Johns
 */
public class MainController implements AnimationFertigListener
{
	/*
	 * 4 am Spieler beteiligte Spieler
	 */
	private Spieler[] spieler = new Spieler[4];
	/*
	 * Array fuer Figuren (16)
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
	 * Anlegen der Panes fuer die Wuerfelausgabe (6 Seiten)
	 */
	@FXML private Pane wuerfelPane1, wuerfelPane2, wuerfelPane3, wuerfelPane4, wuerfelPane5, wuerfelPane6, wuerfelPaneInit;
	/*
	 * Anlegen eines Buttons 'Wuerfeln' fuer die Seitenleiste
	 */
	@FXML private StackPane wuerfelStackPane;
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
	 * Anlegen des Arrays fuer die Wuerfelanzeige
	 */
	private Pane[] wuerfelAnzeige = new Pane[6];
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
		textLoeschen();// reset der Textausgabe
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
		 * Initialisierung des Arrays mit Wuerfelelementen
		 */
		wuerfelAnzeige[0] = wuerfelPane1; wuerfelAnzeige[1] = wuerfelPane2; wuerfelAnzeige[2] = wuerfelPane3;
		wuerfelAnzeige[3] = wuerfelPane4; wuerfelAnzeige[4] = wuerfelPane5; wuerfelAnzeige[5] = wuerfelPane6;
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
		 * Zuruecksetzen der WuerfelPanes in nicht sichtbaren Zustand
		 */
		for (int i = 0; i < 6; i++)
		{
			wuerfelAnzeige[i].setVisible(false);
		}
		wuerfelPaneInit.setVisible(true);// Anzeige des WuerfelPanes mit der Aufschrift "Wuerfeln"
		/*
		 * Aktualisieren der Textausgabe
		 */
		textAusgeben("Neues Spiel gestartet...");
		textAusgeben("Sie sind Spieler 1 (blau).");
		/*
		 * Start des Spielzyklus
		 * Spieler 1 (blau) faengt an
		 */
		zugInit(spieler[0]);
	}
	/*
	 * Handler-Methode fuer den Menupunkt "Beenden"
	 */
	@FXML public void handleBeendenMenu()
	{
		Platform.exit();// Beenden der Anwendung
	}
	/*
	 * Handler-Methode fuer des Menupunkt "About"
	 */
	@FXML public void handleAboutMenu()
	{
		Alert alert = new Alert(AlertType.INFORMATION);// Anzeige eines Informationsdialog
		alert.setTitle("About");
		alert.setHeaderText("Mensch Aergere Dich Nicht");
		alert.setContentText("Mensch Aergere Dich Nicht \nVersion 1.0 \n \n Autor: Lucas Johns");
		alert.showAndWait();
	}
	/*
	 * Einleiten eines Spielzuges
	 */
	public void zugInit(Spieler s)
	{
		for (int i = 0; i < 4; i++) {spieler[i].setIstAmZug(false);}// Zuruecksetzen aller Spieler auf istAmZug = false
		s.setIstAmZug(true);// Setzen des aktuellen Spielers (s) auf istAmZug = true
		wuerfel.resetWurfanzahl(); // wurfanzahl = 0
		if (s.getSpielernummer() == 1)// Abfrage, ob es sich bei Spieler s um Spieler 1, also einen Menschen handelt
		{
			textAusgeben("");
			textAusgeben("Sie sind an der Reihe.");
			wuerfelStackPane.setDisable(false);// Aktivierung des wuerfelStackPane, Handler kann ausgefuehrt werden
		}
		else// sonst statt Aktivierung des wuerfelStackPane, Aufruf der KI-spezifischen Methoden
		{
			textAusgeben("");
			textAusgeben("Spieler " + s.getSpielernummer() + " ist an der Reihe.");
			wuerfelnKI(s);
		}
	}
	/*
	 * Handler-Methode fuer das WuerfelStackPane
	 */
	@FXML public void handleWuerfelStackPane()
	{
		wuerfelStackPane.setDisable(true);// Deaktivierung, um erneutes Ausloesen zu verhindern
		wuerfelPaneInit.setVisible(false);// Ausblenden der Grafik mit der Aufschrift "Wuerfeln"
		wuerfel.wuerfeln();
		wuerfelAnzeigen();// Aktualisierung der Wuerfelgrafik
		textAusgeben("Sie haben eine " + wuerfel.getAugenzahl() + " gewuerfelt.");
		/*
		 * Aktivieren der Spielfeldelemente, auf denen eine Figur steht
		 * Handler kann ausgefuehrt werden
		 */
		int z = 0;// Zaehlvariable fuer Figuren in den Startfeldern
		for (int i = 0; i < 4; i++)
		{
			/*
			 * Abfrage, in welchem Bereich (startfelder, felder oder zielfelder) die entsprechenden Elemente aktiviert werden muessen
			 */
			if (figur[0][i].getFigurPosition() == 0)
			{
				for (int s = 0; s < 4; s++) {startFelderBlau[s].setDisable(false);}
				z++;
			}
			else if (figur[0][i].getFigurPosition() <= 40)
			{
				felder[figur[0][i].getFigurPosition() - 1].setDisable(false);
			}
			else
			{
				zielFelderBlau[figur[0][i].getFigurPosition() - 41].setDisable(false);
			}
		}
		/*
		 * Ermitteln, ob der Zug bereits beendet wird, ohne ein Figur zu setzen
		 * d.h. 3 mal keine sechs, wenn alle Figuren in den Startfeldern stehen (z=4)
		 */
		if (z == 4)
		{
			if (wuerfel.getWurfanzahl() < 3 || wuerfel.sechsGewuerfelt() == true) {wuerfelStackPane.setDisable(false);} // erneutes Wuerfeln erlaubt
			else {zugEnde();}
		}
		else
		{
			/*
			 * Ueberpruefen, ob eine Situation ohne moegliche Ausfuehrung eines legitimen Spielzugs entsteht
			 */
			int p = 0;
			for (int i = 0; i < 4; i++)
			{
				if (zugPruefen(figur[0][i]) == false) {p++;}
			}
			if (p == 4 && wuerfel.sechsGewuerfelt() == false)// Wenn kein Zug moeglich ist (p=4) und keine sechs gewuerfelt wurde, endet der Zug
			{
				textAusgeben("Kein Zug mit einer " + wuerfel.getAugenzahl() + " moeglich.");
				textAusgeben("Sie muessen aussetzen.");// Ausgabe eines entsprechenden Hinweises
				zugEnde();
				return;
			}
		}
	}
	/*
	 * Diese Methode ermittelt zu einer uebergebenen Feldnummer, die eventuell auf diesem Feld
	 * stehende Figur und gibt diese zurueck. Steht keine Figur auf dem Feld, wird null zurueckgegeben.
	 */
	public Figur figurErmitteln(int feldnummer)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int c = 0; c < 4; c++)
			{
				if (figur[i][c].getAbsolutePosition(0) == feldnummer) {return figur[i][c];}// zurueckgeben der gefundenen Figur
			}
		}
		return null;// zurueckgeben von null, wenn keine absolute Figurposition der feldnummer entsprochen hat
	}
	/*
	 * Methode zum Zuruecksetzen aller Felder in deaktivierten Zustand, keine Ausfuehrung eines Handlers moeglich
	 */
	public void disableFelder()
	{
		for (int s = 0; s < 4; s++) {startFelderBlau[s].setDisable(true); zielFelderBlau[s].setDisable(false);}
		for (int i = 0; i < 40; i++) {felder[i].setDisable(true);}
	}
	/*
	 * Methode zum Pruefen und Ausfuehren des Spielzugs eines menschlichen Spielers (Spieler 1)
	 * Bei nicht legitimen Zuegen, erfolgt die Ausgabe von entsprechenden Hinweisen.
	 */
	public void zugMensch(Figur f)
	{
		/*
		 * Testen, ob der Zug auf dem Spielbrett ueberhaupt zulaessig ist
		 */
		if (f.getFigurPosition() + wuerfel.getAugenzahl() <= 44)
		{
			/*
			 * Abfrage, ob die Bedingungen fuer ein "Raussetzen" erfuellt sind (sechs gewuerfelt und Figur befindet sich auf dem Startfeld)
			 */
			if (f.getFigurPosition() == 0 && wuerfel.sechsGewuerfelt() == true)
			{
				/*
				 * Abfrage, ob das Startfeld von einer eigenen Figur besetzt wird
				 */
				if (figurErmitteln(1) != null && figurErmitteln(1).getFigurSpieler() == f.getFigurSpieler())
				{
					textAusgeben("Erst das Startfeld freimachen.");// Ausgabe eines entsprechenden Hinweises
				}
				else
				{
					/*
					 * Abfrage, ob das Startfeld von einer anderen Figur besetzt wird
					 */
					if (figurErmitteln(1) != null && figurErmitteln(1).getFigurSpieler() != f.getFigurSpieler())
					{
						figurErmitteln(1).setGeschlagen(true);// d.h. nach dem Zug wird aktualisiereGUI() erneut aufgerufen, um diese Figur zu schlagen
					}
					/*
					 * unabhaengig davon, ob jemand geschagen wird -> gewoehnliche Ausfuehrung des Spielzugs
					 */
					disableFelder();// Deaktivieren der Felder
					f.neuAufFeldSetzen();// Aktualisierung der Figurdaten
					aktualisiereGUI(f);// Aktualisierung des GUI
				}
			}
			/*
			 * Abfrage, ob die Bedingungen fuer ein "Raussetzen" nur teilweise erfuellt sind (keine sechs gewuerfelt, aber Figur befindet sich auf dem Startfeld)
			 */
			else if (f.getFigurPosition() == 0 && wuerfel.sechsGewuerfelt() == false)
			{
				textAusgeben("Kein gueltiger Spielzug.");
				textAusgeben("Nur bei einer 6 duerfen Sie eine neue Figur raussetzen.");// Ausgabe eines entsprechenden Hinweises
			}
			else
			{
				/*
				 * Abfrage, ob das Zielfeld des Zuges von einer eigenen Figur besetzt wird
				 */
				if (figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()) != null &&
					figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()).getFigurSpieler() == 1)
				{
					textAusgeben("Kein gueltiger Spielzug.");
				}
				else
				{
					/*
					 * Abfrage, ob das Startfeld von einer anderen Figur besetzt wird
					 */
					if (figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()) != null &&
						figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()).getFigurSpieler() != 1)
					{
						figurErmitteln(f.getFigurPosition() + wuerfel.getAugenzahl()).setGeschlagen(true);
					}
					/*
					 * unabhaengig davon, ob jemand geschagen wird -> gewoehnliche Ausfuehrung des Spielzugs
					 */
					disableFelder();// Deaktivieren der Felder
					f.Setzen(wuerfel.getAugenzahl());// Aktualisierung der Figurdaten
					aktualisiereGUI(f);// Aktualisierung des GUI
				}
			}
		}
		else {textAusgeben("Kein gueltiger Spielzug.");}
	}
	/*
	 * Der Aufbau dieser Methode ist aehnlich dem, der Handler-Methode des WuerfelStackPanes.
	 * 
	 */
	public void wuerfelnKI(Spieler s)
	{
		int z;
		do
		{
			z = 0; // Zaehlvariable fuer Figuren in den Startfeldern
			wuerfel.wuerfeln();
			wuerfelAnzeigen();
			textAusgeben("Spieler " + s.getSpielernummer() + " hat eine " + wuerfel.getAugenzahl() + " gewuerfelt.");// Ausgabe eines entsprechenden Hinweises
			for (int i = 0; i < 4; i++) {if (figur[s.getSpielernummer() - 1][i].getFigurPosition() == 0) {z++;}}
			/*
			 * Ermitteln, ob der Zug bereits beendet wird, ohne ein Figur zu setzen
			 * d.h. 3 mal keine sechs, wenn alle Figuren in den Startfeldern stehen (z=4)
			 */
			if (z == 4 && wuerfel.sechsGewuerfelt() == true)// Abfrage, ob alle Figuren in den Startfeldern stehen und Augenzahl = 6 ist
			{
				zugKI(s);
				return;
			}
		}
		while (z == 4 && wuerfel.getWurfanzahl() < 3); // dreimaliges Wuerfeln erlaubt, wenn alle Figuren in den Startfeldern stehen (z=4)
		if (z == 4 && wuerfel.getWurfanzahl() >= 3) {zugEnde();}
		else {zugKI(s);}
	}
	public void zugKI(Spieler s)
	{
		/*
		 * Ueberpruefen, ob eine Situation ohne moegliche Ausfuehrung eines legitimen Spielzugs entsteht
		 */
		int n = 0;
		for (int i = 0; i < 4; i++)
		{
			if (zugPruefen(figur[s.getSpielernummer() - 1][i]) == false) {n++;}// jede Figur des Spielers auf einen moeglichen Zug testen
		}
		if (n == 4)// wenn kein Zug moeglich (n=4)
		{
			textAusgeben("Spieler " + s.getSpielernummer() + " muss aussetzen.");// Ausgabe eines entsprechenden Hinweises
			zugEnde();
		}
		/*
		 * Wenn bekannt ist, das mindestens ein Zug moeglich ist, erfolgt eine zufaellige Auswahl dieser moeglichen Zuege.
		 */
		int r = (int)(Math.random() * 4);// r = zufaellige Zahl zwischen 0 und 3
		while (zugPruefen(figur[s.getSpielernummer() - 1][r]) == false)// Verlassen, bei einem gefundenen moeglichen Zug
		{
			r = (int)(Math.random() * 4);// erneuter Versuch
		}
		/*
		 * Die KI muss an dieser Stelle nicht pruefen, ob eine eigene Figur auf dem Zielfeld dieses Zuges steht.
		 * Da zugPruefen() "true" zurueckgegeben hat, ist dies bereits ausgeschlossen.
		 */
		if (figur[s.getSpielernummer() - 1][r].getFigurPosition() == 0)//Abrage, ob die Figur im Startfeld steht
		{
			/*
			 * Ist das fuer den Spieler entsprechende Startfeld nicht leer, wird die darauf stehende Figur geschlagen.
			 */
			if (s.getSpielernummer() == 2) {if (figurErmitteln(11) != null) {figurErmitteln(11).setGeschlagen(true);}}
			if (s.getSpielernummer() == 3) {if (figurErmitteln(21) != null) {figurErmitteln(21).setGeschlagen(true);}}
			if (s.getSpielernummer() == 4) {if (figurErmitteln(31) != null) {figurErmitteln(31).setGeschlagen(true);}}
			/*
			 * unabhaengig davon, ob jemand geschagen wurde -> gewoehnliche Ausfuehrung des Spielzugs
			 */
			figur[s.getSpielernummer() - 1][r].neuAufFeldSetzen(); aktualisiereGUI(figur[s.getSpielernummer() - 1][r]);
		}
		else
		{
			/*
			 * Ist das Zielfeld dieses Zuges nicht leer, wird die darauf stehende Figur geschlagen.
			 */
			if (figurErmitteln(figur[s.getSpielernummer() - 1][r].getAbsolutePosition(wuerfel.getAugenzahl())) != null)
			{
				figurErmitteln(figur[s.getSpielernummer() - 1][r].getAbsolutePosition(wuerfel.getAugenzahl())).setGeschlagen(true);
			}
			/*
			 * unabhaengig davon, ob jemand geschagen wurde -> gewoehnliche Ausfuehrung des Spielzugs
			 */
			figur[s.getSpielernummer() - 1][r].Setzen(wuerfel.getAugenzahl()); aktualisiereGUI(figur[s.getSpielernummer() - 1][r]);
		}
	}
	/*
	 * Die Methode zugPruefen() testet, ob der Zug fuer die uebergebenen Figur zulaessig ist.
	 * zugPruefen() liefert "false", wenn der Zug durch die Spielregeln verboten ist, sonst "true"
	 */
	public boolean zugPruefen(Figur f)
	{
		if (f.getFigurPosition() + wuerfel.getAugenzahl() <= 44)// Abfrage ob der Zug ueber das Spielfeld hinaus gehen wuerde
		{
			if (f.getFigurPosition() == 0)// Abfrage, ob sich die Figur in den Startfeldern befinden
			{
				if (wuerfel.getAugenzahl() != 6) {return false;}// Abfrage, ob eine sechs gewuerfelt wurde, sonst zurueckgeben von "false"
				else
				{
					/*
					 * Testen, ob vor der Spielerbasis eine eigene Figur steht
					 */
					for (int i = 0; i < 4; i++)
					{
							if (figur[f.getFigurSpieler() - 1][i].getFigurPosition() == 1) {return false;}
					}
					return true;
				}	
			}
			else
			{
				/*
				 * Abfrage, ob das Zielfeld dieses Zuges nicht leer ist und darauf eine eigene Figur steht
				 */
				if (figurErmitteln(f.getAbsolutePosition(wuerfel.getAugenzahl())) != null &&
					figurErmitteln(f.getAbsolutePosition(wuerfel.getAugenzahl())).getFigurSpieler() == f.getFigurSpieler()) {return false;}
				else {return true;}
			}
		}
		return false;
	}
	/*
	 * Diese Methode ruft zugInit() fuer den Spieler auf, der als naechstes an der Reihe ist.
	 */
	public void zugEnde()
	{
		for (int i = 0; i < 4; i++)
		{
			if (spieler[i].getIstAmZug() == true)
			{
				/*
				 * Die Spieler sind wie folgt an der Reihe: 1,2,3,4,1,usw.
				 */
				if (spieler[i].getSpielernummer() == 4) {zugInit(spieler[0]); break;}
				else {zugInit(spieler[i + 1]); break;}
			}
		}
	}
	/*
	 * Methode fuer die Wuerfelanzeige in der Mitte des Spielfelds
	 */
	public void wuerfelAnzeigen()
	{
		for (int i = 0; i < 6; i++)
		{
			wuerfelAnzeige[i].setVisible(false);// Alle Panes werden zunaechst ausgeblendet.
		}
		wuerfelAnzeige[wuerfel.getAugenzahl() - 1].setVisible(true);// Das der Augenzahl entsprechende Pane wird sichtbar gemacht.
	}
	/*
	 * Methode fuer Textausgabe in der Seitenleiste
	 */
	public void textAusgeben(String s)
	{
		textAusgabe.appendText(s + "\n");// Bei einer Textausgabe wird jedesmal im Anschluss ein Zeilenumbruch eingefuegt.
	}
	/*
	 * Methode zum Zuruecksetzen der Textausgabe
	 */
	public void textLoeschen()
	{
		textAusgabe.setText("");
	}
	/*
	 * Dies ist eine Listener-Methode, die ausgefuehrt wird, sobald der animationUpdate-Thread beendet ist.
	 */
	@Override
	public void ausloesenAnimationFertig(Thread thread)
	{
		/*
		 * Ermitteln, ob eine Figur geschlagen werden muss (geschlagen=true)
		 */
		for(int i = 0; i < 4; i++)
		{
			for (int c = 0; c < 4; c++)
			{
				if (figur[i][c].getGeschlagen() == true)
				{
					figur[i][c].schlagen();// Aktualisierung der Figurdaten
					figur[i][c].setGeschlagen(false);// Zuruecksetzen der "geschlagen"-Eigenschaft auf "false"
					if (figur[i][c].getFigurSpieler() == 1) {textAusgeben("Ihre Figur wurde geschlagen!");}// Ausgabe eines entsprechenden Hinweises
					for (int n = 2; n < 5; n++)// Ausgabe eines entsprechenden Hinweises
					{
						if (figur[i][c].getFigurSpieler() == n) {textAusgeben("Eine Figur von Spieler " + n + " wurde geschlagen!");}
					}
					aktualisiereGUI(figur[i][c]);// Aktualisierung des GUI
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
				 * Testen, ob der Spieler durch diesen Zug gewonnen hat
				 */
				int z = 0;
				for (int c = 4; c < 0; c++)
				{
					if (figur[spieler[i].getSpielernummer()][c].getInZielFeldern() == true) {z++;}
				}
				if (z == 4)// Abfrage, ob alle Figuren in den Zielfeldern stehen
				{
					/*
					 * Ausgabe eines entsprechenden Hinweises
					 * Ende des Spiels
					 */
					if (spieler[i].getSpielernummer() == 1) {textAusgeben("Sie haben gewonnen."); textAusgeben("Herzlichen Glueckwunsch!");}
					else {textAusgeben("Sie haben verloren."); textAusgeben("Spieler " + spieler[i].getSpielernummer() + " ist der Sieger.");}
				}
				else
				{
					if (wuerfel.sechsGewuerfelt() == true)// Abfrage, ob erneut gewuerfelt werden darf (sechs gewuerfelt)
					{
						if (spieler[i].getSpielernummer() == 1) {wuerfelStackPane.setDisable(false); break;}
						else {wuerfelnKI(spieler[i]); break;}
					}
					else {zugEnde(); break;}// Beenden des Zuges
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
		 * Testen auf eventuelle Aenderungen
		 * 
		 * Hinweis:
		 * Sollte aktualisiereGUI() fuer eine Figur aufgerufen werden, fuer die sich nichts
		 * geaendert hat, wird die Setzanimation nicht erneut ausgefuehrt.
		 * Diese Fall sollte aber in der aktuellen Version der Anwendung nicht auftreten.
		 */
		if (f.getAlteFigurPosition() != f.getFigurPosition());
		/*
		 * aktualisieren der JavaFX Circle Elemente fuer Figur f
		 */
		{
			AnimationThread animationUpdate = new AnimationThread()
			{
				private Paint nextColor;// Zwischenspeicher fuer eine zeitweise ueberschriebene Farbe (Setzen einer Figur "ueber" eine andere)
				public void doRun()
				{
					/*
					 * Testen, ob Figur f geschlagen, d.h. in die Basis zurueckgesetzt wird (relative Figurposition = 0)
					 */
					if (f.getFigurPosition() == 0)
					{
						/*
						 * Einblenden eines Circles im entsprechenden Startfeld
						 */
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
					 * Testen, ob Figur f aus der Basis auf das erste Feld gesetzt wird (relative Figurposition = 1)
					 */
					else if (f.getFigurPosition() == 1)
					{
						/*
						 * Ausblenden eines bereits sichtbaren Circles in den Startfeldern
						 * Einblenden des Circles auf der fuer den Spieler entsprechenden ersten Feldes
						 */
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
						/*
						 * Es wird fuer jeden Spieler entsprechend das aktuelle Feld ausgeblendet und das naechste Feld
						 * auf dem Spielplan sichtbar gemacht. Die Anzahl dieser Schritte ergibt sich aus der Differenz
						 * von "alteFigurPosition" und "figurPosition". Nach jedem Schritt wartet der Thread 250 ms.
						 * In "count" wird mitgezaehlt wie oft insgesamt hochgezaehlt wurde.
						 * In "pos" wird je nach Spieler rechnerisch die aktuelle Position im Array "felder[]" ermittelt.
						 * 
						 * Das Prinzip ist bei allen Farben das Gleiche. Alle zuberuecksichtigenden Faelle werden
						 * entsprechend behandelt.
						 * z.B. 	- (1) Verlassen des Arrays "felder[]" und betreten des spielereigenen zielFelder-Arrays
						 * 			- (2) Setzen von "felder[39]" auf "felder[0]"
						 * 			- (3) Setzen einer Figur "ueber" eine andere hinweg, sodass diese kurzzeitig nicht zusehen ist
						 * 
						 * Bei Spieler 1 (blau) entfaellt der Fall (2), da felder[39] das letzte Feld vor den Zielfeldern ist.
						 */
						if (f.getFigurSpieler() == 1)// blau
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
									zielFelderBlau[pos - 39].setVisible(true);// (1)
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{
									if (nextColor != null)// (3)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[pos + 1].isVisible() == true) {nextColor = felder[pos + 1].getFill();}// (3)
									felder[pos + 1].setFill(Color.web("3daeff99"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
							}
						}
						if (f.getFigurSpieler() == 2)// rot
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
									zielFelderRot[pos - 9].setVisible(true);// (1)
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else if (pos == 39)
								{
									if (nextColor != null)// (3)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[0].isVisible() == true) {nextColor = felder[0].getFill();}// (3)
									felder[0].setFill(Color.web("ff4343"));
									felder[0].setVisible(true);// (2)
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{										
									if (nextColor != null)// (3)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[pos + 1].isVisible() == true) {nextColor = felder[pos + 1].getFill();}// (3)
									felder[pos + 1].setFill(Color.web("ff4343"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
							}						
						}
						if (f.getFigurSpieler() == 3)// gruen
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
									zielFelderGruen[pos - 19].setVisible(true);// (1)
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else if (pos == 39)
								{
									if (nextColor != null)// (3)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[0].isVisible() == true) {nextColor = felder[0].getFill();}// (3)
									felder[0].setFill(Color.web("83d04f"));
									felder[0].setVisible(true);// (2)
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{										
									if (nextColor != null)// (3)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[pos + 1].isVisible() == true) {nextColor = felder[pos + 1].getFill();}// (3)
									felder[pos + 1].setFill(Color.web("83d04f"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
							}
						}
						if (f.getFigurSpieler() == 4)// gelb
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
									zielFelderGelb[pos - 29].setVisible(true);// (1)
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else if (pos == 39)
								{
									if (nextColor != null)// (3)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[0].isVisible() == true) {nextColor = felder[0].getFill();}// (3)
									felder[0].setFill(Color.web("fff438"));
									felder[0].setVisible(true);// (2)
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								else
								{
									if (nextColor != null)// (3)
									{
										felder[pos].setFill(nextColor);
										nextColor = null;
									}
									else {felder[pos].setVisible(false);}
									if (felder[pos + 1].isVisible() == true) {nextColor = felder[pos + 1].getFill();}// (3)
									felder[pos + 1].setFill(Color.web("fff438"));
									felder[pos + 1].setVisible(true);
									try {Thread.sleep(250);}
									catch (InterruptedException e) {e.printStackTrace();}
									count++;
								}
								
							}						
						}
					}
					/*
					 * 500ms warten
					 */
					try {
						AnimationThread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			};
			animationUpdate.addListener(this);// Hinzufuegen des Listeners
			animationUpdate.start();// Ausfuehren von animationUpdate
		}
	}
}

package vorkurs_example;

import java.lang.Math;
import java.util.Scanner;

public class Hausaufgabe {
	public static void main(String[] args) {

		Scanner eingabe = new Scanner(System.in);
		System.out.print("Größe des Spielfeldes festlegen: ");

		int n = eingabe.nextInt();
		int spalten = n;
		int reihen = n;
		int a;
		int b;
		int x;
		int y;
		

		// (a,b) als zufällig generierte Zielkoordinaten.
		// Die do Schleife verhindert, dass die Koordinaten sich gleichen.

		do {
			a = (int) Math.round(Math.random()) * n;
			b = (int) Math.round(Math.random() * n);

			x = (int) Math.round(Math.random()) * n;
			y = (int) Math.round(Math.random()) * n;
		} while (a == y && b == x);

		// x entspricht der Reihenbezeichnung. Beginnend bei 0.
		// y entspricht der Spaltenbezeichnung
		// bei den Koordinaten handelt es sich um ganze Zahlen zwischen 0 und n.

		int schritte = 0; // Variable, die die Anzahl der benötigten Schritte zum Zielpunkt zählt und nach
							// erreichen des Ziels die Anzahl ausgibt.

		int auswahl; // Variable, die die Auswahl festlegt.

		// Berechnet die Distanz zwischen Spielerpunkt und Zielpunkt mithilfe des
		// Betrags.

		double distanz = Math.sqrt(Math.pow((a - y), 2) + (Math.pow(b - x, 2)));

		String feld = "_" + "|";
		String wandr = "_" + "|";
		String wandl = "|" + "_" + "|";
		String spielerf = "S" + "|";
		String spielerfl = "|" + "S" + "|";
		String zielf = "Z" + "|";
		String zielfl = "|" + "Z" + "|";
		String ziel = "G" + "|";
		String ziell = "|" + "G" + "|";

		System.out.println("Zur Steuerung der Spielerfigur, gebe die natürichen Zahlen zwischen 1 und 4 ein.");
		System.out.println("1 = Oben");
		System.out.println("2 = Unten");
		System.out.println("3 = Links");
		System.out.println("4 = Rechts" + "\n");

		try {
			do {

				for (int i = 0; i <= reihen; i++) {
					for (int k = 0; k <= spalten; k++)

						if ((i == x) && (k == y))

							if ((i == x) && (k == y) && (x == b) && (y == a)) {
								System.out.print(ziel);
							} else if ((i == x) && (k == y) && (x == b) && (y == a) && (k == 0)) {
								System.out.print(ziell);
							} else if ((i == x) && (k == y) && (k == 0)) {
								System.out.print(spielerfl);
							} else {
								System.out.print(spielerf);

							}
						else if ((i == b) && (k == a)) {
							if ((i == b) && (k == a) && (k == 0)) {
								System.out.print(zielfl);
							} else {
								System.out.print(zielf);
							}

						} else if (k == 0) {
							System.out.print(wandl);
						} else if (k == n) {
							System.out.print(wandr);
						} else {
							{
								System.out.print(feld);
							}
						}
					System.out.print("\n");
				}

				System.out.println("\n" + "Distanz: " + distanz);
				System.out.println("Aktuelle Position: " + "(" + x + "," + y + ")");
				System.out.print("Wähle die Richtung: 8 = oben, 2 = unten, 4 = links, 6 = rechts");

				auswahl = eingabe.nextInt();

				// Die vier verschiedenen Auswahlmöglichkeiten. Oben, unten, links, rechts.
				// Festgelegt durch die x und y Variable des Spielers.
				// x steht für die Reihen.
				// y für die Spalten.

				if ((auswahl == 8) && (x > 0)) { // Reihe wird um eins erniedrigt --> Bewegung nach oben
					x = x - 1;
				} else if ((auswahl == 2) && (x < n)) { // Reihe wird um eins erhöhz --> Bewegung nach unten
					x = x + 1;
				} else if ((auswahl == 4) && (y > 0)) { // Spalte wird um eins erniedrigt --> Bewegung nach links
					y = y - 1;
				} else if ((auswahl == 6) && (y < n)) { // Spalte wird um eins erhöht --> Bewegung nach rechts
					y = y + 1;
				} else {
					System.out.println("Auswahl nicht möglich" + "\n");
				}

				schritte++;

			} while (!((x == b) && (y == a)));

			System.out.println("Ziel erreicht: (" + x + "," + y + ")");
			System.out.print("Anzahl der Schritte: " + schritte);

		} catch (Exception e) {

			System.out.println("Bitte gib eine natürliche Zahl zwischen 1 und 4 ein.");
		}
		eingabe.close();

	}
}

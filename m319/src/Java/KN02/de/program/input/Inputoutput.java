
package TBZ.m319.Java.KN02.de.program.input;

import java.util.Scanner;

/**
 * Dieses Programm demonstriert das Einlesen von Benutzereingaben von der Konsole
 * und das anschließende Ausgeben dieser Eingaben zurück an die Konsole.
 */
public class Inputoutput {

    public static void main(String[] args) {
        // Ein Scanner-Objekt wird erstellt, um Eingaben vom Standard-Eingabestrom (System.in) zu lesen.
        Scanner scanner = new Scanner(System.in);

        // Der Benutzer wird aufgefordert, einen Text einzugeben.
        System.out.print("Bitte geben Sie einen Text ein und bestätigen Sie mit Enter: ");

        // Die nächste Zeile, die der Benutzer eingibt, wird gelesen und in einer String-Variable gespeichert.
        String benutzereingabe = scanner.nextLine();

        // Der eingegebene Text wird zusammen mit einer Bestätigungsnachricht auf der Konsole ausgegeben.
        System.out.println("Sie haben eingegeben: " + benutzereingabe);

        // Es ist eine gute Praxis, den Scanner zu schließen, wenn er nicht mehr benötigt wird, um Ressourcen freizugeben.
        scanner.close();
    }
}

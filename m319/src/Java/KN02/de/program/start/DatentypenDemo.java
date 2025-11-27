package TBZ.m319.Java.KN02.de.program.start;
public class DatentypenDemo {

    public static void main(String[] args) {
        // --- 1. Deklaration der Basis-Datentypen ---
        int ganzzahlA = 20;
        int ganzzahlB = 7;

        float fliesskommazahlA = 20.0f; // Das 'f' ist wichtig für float
        float fliesskommazahlB = 7.0f;

        char zeichen = 'A'; // Ein einzelnes Zeichen in einfachen Anführungszeichen
        boolean wahrheitswert = true; // Kann nur true oder false sein


        // --- 2. Demonstration der mathematischen Operationen ---
        System.out.println("--- Integer-Operationen (int) ---");
        System.out.println(ganzzahlA + " + " + ganzzahlB + " = " + (ganzzahlA + ganzzahlB)); // Addition
        System.out.println(ganzzahlA + " - " + ganzzahlB + " = " + (ganzzahlA - ganzzahlB)); // Subtraktion
        System.out.println(ganzzahlA + " * " + ganzzahlB + " = " + (ganzzahlA * ganzzahlB)); // Multiplikation
        System.out.println(ganzzahlA + " / " + ganzzahlB + " = " + (ganzzahlA / ganzzahlB)); // Division (Achtung: Ergebnis ist 2, Rest wird abgeschnitten!)
        System.out.println(ganzzahlA + " % " + ganzzahlB + " = " + (ganzzahlA % ganzzahlB)); // Modulo (Rest der Division), 20 / 7 = 2 Rest 6

        System.out.println("\n--- Fliesskommazahl-Operationen (float) ---");
        System.out.println(fliesskommazahlA + " / " + fliesskommazahlB + " = " + (fliesskommazahlA / fliesskommazahlB)); // Division mit Nachkommastellen

        System.out.println("\n--- Zeichen-Operationen (char) ---");
        // Ein char wird intern als Zahl (ASCII/Unicode-Wert) behandelt. 'A' ist 65.
        System.out.println("Das Zeichen '" + zeichen + "' plus 1 ist: " + (char)(zeichen + 1)); // Ergibt das Zeichen 'B'

        System.out.println("\n--- Wahrheitswert-Operationen (boolean) ---");
        // Booleans können NICHT für mathematische Operationen verwendet werden.
        System.out.println("Booleans wie '" + wahrheitswert + "' können nicht addiert, subtrahiert etc. werden.");
    }
}
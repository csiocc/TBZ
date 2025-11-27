package TBZ.m319.Java.KN06;

public class Demo {
    public static void main(String[] args) {
        // Klasse: Auto ist eine Bauanleitung
        // Instanz: Ein konkretes Auto, das mit "new" erstellt wird
        // Objekt: Das Ding, das im Speicher existiert

        Auto auto1 = new Auto("VW", "Blau", 2015);   // Instanz/Objekt 1
        Auto auto2 = new Auto("Toyota", "Rot", 2020); // Instanz/Objekt 2

        auto1.anzeigen();
        auto1.fahren();

        auto2.anzeigen();
        auto2.fahren();

        // Unterschied sichtbar machen
        System.out.println("Sind auto1 und auto2 dasselbe Objekt? " + (auto1 == auto2));
    }
}


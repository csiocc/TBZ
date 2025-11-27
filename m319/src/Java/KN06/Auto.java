package TBZ.m319.Java.KN06;
// Datei: Auto.java
public class Auto {
    String marke;
    String farbe;
    int baujahr;

    // Konstruktor
    public Auto(String marke, String farbe, int baujahr) {
        this.marke = marke;
        this.farbe = farbe;
        this.baujahr = baujahr;
    }

    // Methoden
    public void fahren() {
        System.out.println(marke + " fährt auf der Strasse.");
    }


    // mit this (lesbarkeit // fals namenskonflikte)
    public void print() {
        System.out.println("Das Auto ist " + this.farbe);
    }

    // ohne this, kürzer funktioniert auch solange kein konflikt
    public void anzeigen() {
        System.out.println("Marke: " + marke + ", Farbe: " + farbe + ", Baujahr: " + baujahr);
    }
}

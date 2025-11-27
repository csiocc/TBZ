package TBZ.m319.Java.KN06;

// Datei: DemoStatic.java
public class DemoStatic {
    public static void main(String[] args) {
        // Erzeugen von Objekten (Instanzen)
        Zaehler z1 = new Zaehler();
        Zaehler z2 = new Zaehler();
        Zaehler z3 = new Zaehler();

        // Jede Instanz hat ihre eigene "individuell"-Variable
        z1.zeigeIndividuell(); // → 1
        z2.zeigeIndividuell(); // → 1
        z3.zeigeIndividuell(); // → 1

        // Aber die static-Variable wird von allen gemeinsam benutzt
        Zaehler.zeigeGemeinsam(); // → 3

        // static Methoden können auch über ein Objekt aufgerufen werden
        z1.zeigeGemeinsam(); // → 3 (gleiche Ausgabe, aber unüblicher Stil)
    }
}


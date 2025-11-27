package TBZ.m319.Java.KN06;

// Datei: Zaehler.java
public class Zaehler {
    // normale Variable (jedes Objekt hat seine eigene Kopie)
    int individuell = 0;

    // static Variable (gehört zur Klasse, nur 1x vorhanden)
    static int gemeinsam = 0;

    // konstruktor wird beim erstellen ausgeführt
    public Zaehler() {
        individuell++;
        gemeinsam++;
    }

    // normale Methode
    public void zeigeIndividuell() {
        System.out.println("Individuelle Zahl: " + individuell);
    }

    // static Methode (kann ohne Objekt aufgerufen werden)
    public static void zeigeGemeinsam() {
        System.out.println("Gemeinsame Zahl: " + gemeinsam);
    }
}

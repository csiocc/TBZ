package TBZ.m319.Java.KN11;

// Datei: CodeKonventionenDemo.java
// Hinweise zu üblichen Java-Konventionen sind im Code kommentiert.
public class CodeKonventionenDemo {

    // 🔹 KONSTANTEN: UPPER_SNAKE_CASE, final + type (oder public static final, wenn API-Konstante)
    private static final double STEUERSATZ_STANDARD = 0.077; // 7.7% (CH)
    private static final int    MAX_ANZAHL_NUTZER   = 100;

    // 🔹 FELDER/VARIABLEN: lowerCamelCase, aussagekräftig, KEINE unklaren Abkürzungen
    private static int aktuelleNutzerzahl = 0;       // gut
    // private int anz;                      // schlecht: zu kurz/unklar
    // private int ANZAHL = 0;               // schlecht: UPPER_CASE ist für Konstanten reserviert

    private CodeKonventionenDemo() {
      aktuelleNutzerzahl++;
    }

    public static void main(String[] args) {
        // Hauptmethode bleibt statisch; rest lieber als Instanzmethoden
        CodeKonventionenDemo app = new CodeKonventionenDemo();
        app.demonstriereVariablenUndKonstanten();
        app.demonstriereMethodenBenennung();
        app.demonstriereBooleanNamen();
        app.demonstriereSammlungenBenennung();
        app.demonstriereFormatierungUndEinrueckung();
        app.demonstriereKommentareUndMagicNumbers();
    }

    // 🔹 Methoden: lowerCamelCase, Verben für Aktionen, präzise Namen
    private void demonstriereVariablenUndKonstanten() {
        System.out.println("== Variablen & Konstanten ==");
        double netto = 100.00;
        double mwst  = berechneMwst(netto, STEUERSATZ_STANDARD); // gut: sprechende Namen

        // schlechte Variante (zur Demonstration, NICHT so benutzen):
        // double x = calc(netto, 0.077); // schlecht: vage Namen, Magic Number

        System.out.println("Netto: " + netto);
        System.out.println("MWST (" + (STEUERSATZ_STANDARD * 100) + "%): " + mwst);
        System.out.println("Brutto: " + (netto + mwst));
        System.out.println("Max. Nutzer erlaubt: " + MAX_ANZAHL_NUTZER);
        System.out.println();
    }

    private void demonstriereMethodenBenennung() {
        System.out.println("== Methodenbenennung ==");
        // gut: Verb + Objekt
        double flaeche = berechneRechteckFlaeche(5, 3);
        System.out.println("Flaeche 5x3: " + flaeche);

        // schlecht (nur Kommentar, nicht ausführen):
        // double f = calcRect(5, 3);    // unklar/engl.-deutsch gemischt, Abkürzung
        // double Rechteck_BERECHNEN()   // SCREAMING_SNAKE + Unterstriche → nicht Java-idiomatisch
        System.out.println();
    }

    private void demonstriereBooleanNamen() {
        System.out.println("== Boolean-Namen ==");
        boolean istEingeloggt = true;   // gut: is/has/should/enable-Präfixe
        boolean hatLizenz     = false;  // gut

        // schlecht:
        // boolean login = true;        // Substantiv ohne Aussage, ob true/false etwas bedeutet
        // boolean notActive = false;   // Negationen verwirren oft

        if (istEingeloggt && hatLizenz) {
            System.out.println("Zugriff: erlaubt");
        } else {
            System.out.println("Zugriff: eingeschraenkt");
        }
        System.out.println();
    }

    private void demonstriereSammlungenBenennung() {
        CodeKonventionenDemo app2 = new CodeKonventionenDemo();
        System.out.println("== Sammlungen-Namen ==");
        // Plural für Listen/Collections, sprechender Kontext
        java.util.List<String> produktnamen = new java.util.ArrayList<>();
        produktnamen.add("Tastatur");
        produktnamen.add("Maus");

        // schlecht:
        // java.util.List<String> p = new ArrayList<>();   // zu kurz
        // java.util.List<String> produkt = new ArrayList<>(); // Singular für Liste

        System.out.println("Produkte: " + produktnamen);
        System.out.println();
    }

    private void demonstriereFormatierungUndEinrueckung() {
      CodeKonventionenDemo app3 = new CodeKonventionenDemo();
      System.out.println("== Formatierung & Einrueckung ==");
      // 🔹 Einrückung: 4 Leerzeichen (kein Tab) ist üblich.
      // 🔹 Klammerstil: Öffnende Klammer in derselben Zeile wie die Signatur/if/for.
      int summe = 0;
      for (int i = 1; i <= 5; i++) { // Leerzeichen nach ; für Lesbarkeit
        summe += i;
      }
      System.out.println("Summe 1..5: " + summe);

      // 🔹 if/else Format
      int alter = 17;
      if (alter >= 18) {
        System.out.println("Volljaehrig");
      } else {
        System.out.println("Minderjaehrig");
      }

      // 🔹 switch: klar strukturieren, default nicht vergessen (wenn sinnvoll)
      String rolle = "USER";
      switch (rolle) {
        case "ADMIN":
          System.out.println("Rolle: Admin");
          break;
        case "USER":
          System.out.println("Rolle: User");
          break;
        default:
          System.out.println("Rolle: Unbekannt");
      }
      System.out.println();
    }
    

    private void demonstriereKommentareUndMagicNumbers() {
        System.out.println("== Kommentare & Magic Numbers ==");
        // 🔹 Kommentare: „Warum“ erklären, nicht Selbstverständliches.
        // 🔹 Magic Numbers vermeiden → benannte Konstanten verwenden.
        // Beispiel: Versandkosten frei ab SCHWELLWERT_FREI_VERSAND
        final double SCHWELLWERT_FREI_VERSAND = 50.0; // lokale Konstante (nur in dieser Methode)
        double warenkorb = 42.0;

        // schlecht:
        // if (warenkorb >= 50.0) { ... } // 50.0 ist eine Magic Number

        if (warenkorb >= SCHWELLWERT_FREI_VERSAND) {
            System.out.println("Versand: kostenlos");
        } else {
            System.out.println("Versand: 5.90");
        }

        // 🔹 Zeilenlänge: ~100–120 Zeichen als Richtwert; lange Ausdrücke umbrechen.
        String beschreibung =
            "Beschreibung sollte klar und prägnant sein, ohne unnoetig lange Zeilen zu erzeugen.";
        System.out.println(beschreibung);
        System.out.println();
    }

    // ======= Hilfsmethoden (gut benannt) =======

    private double berechneMwst(double betrag, double steuersatz) {
        return betrag * steuersatz;
    }

    private double berechneRechteckFlaeche(double breite, double hoehe) {
        return breite * hoehe;
    }
}


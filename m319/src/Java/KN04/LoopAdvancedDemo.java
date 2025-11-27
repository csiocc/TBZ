package TBZ.m319.Java.KN04;
public class LoopAdvancedDemo {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 1) FOR: Zahlen 1..20 – "FizzBuzz light":
        //    Drucke Zahlen, die durch 3 ODER 5 teilbar sind,
        //    aber NICHT durch beide (XOR mit && und || und !).
        //    Operatoren: %, &&, ||, !
        // ------------------------------------------------------------
        System.out.println("1) FOR + logische Operatoren (XOR mit &&, ||, !)");
        for (int n = 1; n <= 20; n++) {
            boolean durch3 = (n % 3 == 0);
            boolean durch5 = (n % 5 == 0);
            if ((durch3 || durch5) && !(durch3 && durch5)) {
                System.out.println(n + " -> teilbar durch 3 ODER 5, aber nicht beide");
            }
        }
        System.out.println();

        // ------------------------------------------------------------
        // 2) WHILE: Finde die erste Zahl >= 100, die durch 7 UND 9 teilbar ist
        //    (also durch 63). Nutzt &&, >=, break.
        // ------------------------------------------------------------
        System.out.println("2) WHILE + && + Vergleichsoperatoren + break");
        int m = 100;
        while (m < 1000) {
            if (m % 7 == 0 && m % 9 == 0) {
                System.out.println("Erste Zahl >= 100, die durch 7 und 9 teilbar ist: " + m);
                break; // gefunden
            }
            m++;
        }
        System.out.println();

        // ------------------------------------------------------------
        // 3) DO-WHILE: Zähle abwärts und stoppe, wenn Zahl < 0 ODER
        //    der Zähler gleichzeitig gerade UND durch 3 teilbar ist.
        //    Bedingung zeigt Kombination von || und && mit Klammern.
        // ------------------------------------------------------------
        System.out.println("3) DO-WHILE + Kombination aus || und &&");
        int x = 10;
        do {
            System.out.println("x = " + x);
            x--;
        } while (x >= 0 && !((x % 2 == 0) && (x % 3 == 0)));
        // Erläuterung: läuft mindestens einmal; endet, wenn x < 0 ODER x gleichzeitig gerade UND durch 3 teilbar ist.
        System.out.println("Stop bei x = " + x + " (entweder < 0 oder sogar/3-teilig).");
        System.out.println();

        // ------------------------------------------------------------
        // 4) FOR + if-else: Kategorisiere Zahlen -5..5 nach Vorzeichen und Parität.
        //    Vergleichsoperatoren: <, >, == ; logische Verknüpfungen in Bedingungen.
        // ------------------------------------------------------------
        System.out.println("4) FOR + if-else: Vorzeichen- und Paritäts-Klassifikation");
        for (int z = -5; z <= 5; z++) {
            if (z == 0) {
                System.out.println(z + " -> Null");
            } else if (z > 0 && z % 2 == 0) {
                System.out.println(z + " -> positiv & gerade");
            } else if (z > 0 && z % 2 != 0) {
                System.out.println(z + " -> positiv & ungerade");
            } else if (z < 0 && z % 2 == 0) {
                System.out.println(z + " -> negativ & gerade");
            } else { // z < 0 && z % 2 != 0
                System.out.println(z + " -> negativ & ungerade");
            }
        }
        System.out.println();

        // ------------------------------------------------------------
        // 5) FOR + switch: Wochentage 1..7 klassifizieren.
        //    Nutzt switch mit mehreren Labels und default.
        // ------------------------------------------------------------
        System.out.println("5) FOR + switch: Wochentags-Klassifikation");
        for (int tag = 1; tag <= 7; tag++) {
            String typ;
            switch (tag) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    typ = "Werktag";
                    break;
                case 6:
                case 7:
                    typ = "Wochenende";
                    break;
                default:
                    typ = "Ungültig";
            }
            System.out.println("Tag " + tag + " -> " + typ);
        }
        System.out.println();

        // ------------------------------------------------------------
        // 6) WHILE + verschachtelte Bedingungen: Finde kleinstes n >= 1,
        //    bei dem (n % 4 == 0 ODER n % 6 == 0) UND n NICHT durch 5 teilbar ist.
        //    Zeigt komplexere Bedingung mit Klammern.
        // ------------------------------------------------------------
        System.out.println("6) WHILE: komplexe Bedingung mit Klammern");
        int n = 1;
        while (true) {
            boolean ok = ((n % 4 == 0) || (n % 6 == 0)) && (n % 5 != 0);
            if (ok) {
                System.out.println("Kleinstes n mit (n%4==0 ODER n%6==0) UND n%5!=0: " + n);
                break;
            }
            n++;
        }
        System.out.println();

        // ------------------------------------------------------------
        // 7) DO-WHILE + switch + break/continue:
        //    Gehe Zähler hoch; bei Vielfachen von 7 -> "Skip" (continue),
        //    bei Vielfachen von 11 -> "Abbruch" (break),
        //    sonst per switch Parität melden.
        // ------------------------------------------------------------
        System.out.println("7) DO-WHILE + switch + continue/break");
        int t = 1;
        do {
            if (t % 11 == 0) {
                System.out.println("t = " + t + " -> Vielfaches von 11: Abbruch");
                break;
            }
            if (t % 7 == 0) {
                System.out.println("t = " + t + " -> Vielfaches von 7: Überspringen");
                t++;
                continue;
            }

            int paritaet = (t % 2 == 0) ? 0 : 1; // 0 = gerade, 1 = ungerade
            switch (paritaet) {
                case 0:
                    System.out.println("t = " + t + " -> gerade");
                    break;
                case 1:
                    System.out.println("t = " + t + " -> ungerade");
                    break;
                default:
                    System.out.println("t = " + t + " -> unbekannt");
            }
            t++;
        } while (t <= 20);
    }
}

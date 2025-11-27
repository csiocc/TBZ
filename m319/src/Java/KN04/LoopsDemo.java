package TBZ.m319.Java.KN04;

public class LoopsDemo {

    public static void main(String[] args) {

        // 1) WHILE-SCHLEIFE
        // Die Bedingung wird VOR dem Schleifendurchlauf geprüft.
        // Wenn die Bedingung false ist, wird die Schleife nie ausgeführt.
        int i = 1;
        System.out.println("WHILE-Schleife:");
        while (i <= 5) {
            System.out.println("i = " + i);
            i++;
        }

        System.out.println(); // Leerzeile zur Trennung

        // 2) DO-WHILE-SCHLEIFE
        // Die Bedingung wird NACH dem Schleifendurchlauf geprüft.
        // Die Schleife läuft also mindestens einmal, auch wenn die Bedingung false ist.
        int j = 1;
        System.out.println("DO-WHILE-Schleife:");
        do {
            System.out.println("j = " + j);
            j++;
        } while (j <= 5);

        System.out.println(); // Leerzeile zur Trennung

        // 3) FOR-SCHLEIFE
        // Hier stehen Startwert, Bedingung und Schritt im Kopf der Schleife.
        // Eignet sich gut, wenn man die Anzahl der Durchläufe schon kennt.
        System.out.println("FOR-Schleife:");
        for (int k = 1; k <= 5; k++) {
            System.out.println("k = " + k);
        }
    }
}

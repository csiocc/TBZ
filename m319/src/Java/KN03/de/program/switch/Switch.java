

/**
 * Diese Klasse demonstriert die Verwendung einer switch-Anweisung,
 * um den Programmfluss basierend auf dem Wert einer Variable zu steuern.
 * Hinweis: Der Klassenname ist "IfelseDemo" gemäß der Pfadangabe,
 * der Inhalt demonstriert jedoch eine switch-Anweisung.
 */
public class Switch {

    public static void main(String[] args) {
        // Wir definieren einen Wochentag, den wir überprüfen wollen.
        // Ändern Sie diesen Wert, um die verschiedenen Ausgaben zu sehen (z.B. "Samstag" oder "Mittwoch").
        String tag = "Montag";

        System.out.println("Der zu überprüfende Tag ist: " + tag);

        // Die switch-Anweisung wertet die Variable `tag` aus.
        switch (tag) {
            // Ein "case" für den Wert "Montag".
            case "Montag":
                System.out.println("Die Arbeitswoche beginnt.");
                break; // Das 'break' verhindert, dass die folgenden 'cases' ausgeführt werden.

            // Ein "case" für den Wert "Freitag".
            case "Freitag":
                System.out.println("Das Wochenende ist nah!");
                break;

            // Ein "case" für die Werte "Samstag" oder "Sonntag".
            case "Samstag":
            case "Sonntag":
                System.out.println("Es ist Wochenende!");
                break;

            // Der 'default'-Block wird ausgeführt, wenn keiner der obigen 'cases' zutrifft.
            default:
                System.out.println("Es ist ein normaler Wochentag.");
                break;
        }

        System.out.println("Die Überprüfung ist abgeschlossen.");
    }
}

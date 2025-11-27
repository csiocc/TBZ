package TBZ.m319.Java.KN05;

/* Ki erstellt */

public class StringDemo {
    public static void main(String[] args) {
        // Einführung in Strings
        System.out.println("=== Strings in Java ===");
        System.out.println("Ein String ist eine Zeichenkette, z.B. \"Hallo Welt\".");

        // String erstellen
        String text1 = "Hallo";
        String text2 = "Welt";
        System.out.println("\nString 1: " + text1);
        System.out.println("String 2: " + text2);

        // Konkatenation (Verkettung von Strings)
        String zusammen = text1 + " " + text2 + "!";
        System.out.println("\nKonkatenation: text1 + \" \" + text2 + \"!\" = " + zusammen);

        // Länge eines Strings
        System.out.println("\nDie Länge von \"" + zusammen + "\" ist: " + zusammen.length());

        // Zugriff auf einzelne Zeichen (Index beginnt bei 0!)
        System.out.println("Das erste Zeichen von \"" + zusammen + "\" ist: " + zusammen.charAt(0));
        System.out.println("Das letzte Zeichen ist: " + zusammen.charAt(zusammen.length() - 1));

        // Teilstrings (Substring)
        System.out.println("\nSubstring-Beispiel: \"" + zusammen.substring(0, 5) + "\" (von Index 0 bis 4)");

        // Strings vergleichen (== vs. equals)
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java"); // explizit neues Objekt

        System.out.println("\nVergleich mit == (prüft Referenz):");
        System.out.println("s1 == s2: " + (s1 == s2));   // true, da beide im String-Pool
        System.out.println("s1 == s3: " + (s1 == s3));   // false, da s3 ein neues Objekt ist

        System.out.println("\nVergleich mit equals() (prüft Inhalt):");
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true

        // Groß- / Kleinschreibung
        System.out.println("\nGroß-/Kleinschreibung:");
        System.out.println("\"java\".equals(\"Java\"): " + "java".equals("Java"));
        System.out.println("\"java\".equalsIgnoreCase(\"Java\"): " + "java".equalsIgnoreCase("Java"));

        // Nützliche Standardmethoden
        String beispiel = "  Programmieren macht Spass!  ";
        System.out.println("\nBeispiel-String: \"" + beispiel + "\"");

        System.out.println("toUpperCase(): " + beispiel.toUpperCase());
        System.out.println("toLowerCase(): " + beispiel.toLowerCase());
        System.out.println("trim(): \"" + beispiel.trim() + "\" (Entfernt Leerzeichen vorne und hinten)");
        System.out.println("replace(\"a\", \"@\")): " + beispiel.replace("a", "@"));
        System.out.println("contains(\"macht\"): " + beispiel.contains("macht"));
        System.out.println("startsWith(\"  Pro\"): " + beispiel.startsWith("  Pro"));
        System.out.println("endsWith(\"!  \"): " + beispiel.endsWith("!  "));

        System.out.println("\n=== Ende der String-Demonstration ===");
    }
}

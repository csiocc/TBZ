# Vertraulichkeit:
Vertraulichkeit gewährleistet das Informationen nur Authorisierten Personen/Systemen zugänglich gemacht werden.
Es geht daraum das unbefugte lesen/schreiben/kopieren/bearbeiten von Daten zu verhindern.

# Integrität
Gewährleisten dass Daten und Systeme über ihre gesammte Lebensdauer vollständig und unverändert sind, änderungen dürfen nur authorisiert/nachvollziehbar(logs) vorgenommen werden.

# Verfügbarkeit
Systeme und Daten müssen für authorisierte Benutzer jederzeit innert angemessener Zeit zur Verfügung stehen.




# Dev/Testing

## Vertraulichkeit:
-Sensible Daten(Passwörter, Kundendaten, persönliche Infos) nur verschlüsselt speichern/übertragen. z.b HTTPS  
-Mit Penetrationstests versuchen auf unbefugte Daten zuzugreifen z.b durch SQL injection oder Directory Traversal.  
-Zugriffskontrolle überprüfen ob Benutzer nur auf die entsprechend friegegebenen Daten zugreifen können.  
-Code prüfen ob keine Geheimnisse im Code sind.  
## Integriät:
-Prüfsummen oder digitale Signaturen einsetzen um die Echtheit der Daten zu verifizieren. Validierungsregeln für Formulare implementieren.  
## Verfügbarkeit:  
-Redundante Systeme aufbauen(Load Balancer, Datenbank-Cluster)  
-Mechanismen zur Fehlerbehandlung und Skalierbarkeit  
-Last und Performancetests messung der Antwortzeiten prüfen ob Systeme auch unter hoher Last funktionsähig bleiben  
-Stresstests: Belastungslimits finden damit man weiss wann etwas ausfallen würde  
-FailoverTests: Ausfall einer Systemkomponente simulieren und prüfen ob ersatzsysteme übernehmen.  
-Recoverytests: Prüfen ob das System nach einem ausfall schnell und vollständig wiederhergestellt werden kann  


# Buchhaltung 

## Vertraulichkeit:  
-Sensible Finanzdaten nur an Personen/Systemen zugänglich machen die diese zur erledigung ihrer aufgabe wirklich benötigen  
-Lohndaten darf nur der entsprechende Mitarbeiter/Personalabteilung/GL erhalten sonst niemand  
-Kunden/Lieferantendaten müssen vor externem zugriff oder unbefugten Mitarbeitern geschützt sein  
-Wirtschaftsprüfungsberichte dürfen nicht an die Öffentlichkeit gelangen bevor sie freigegeben wurden  
-Rollenbasierte zugriffskontrolle  
-Verschlüsselung von sensiblen Daten  
-Zur übertragung nur verschlüsselte dienste nutzen wie z.b HTTPS  
## Integriät:
-Buchungen, Finanzdaten usw müssen korrekt vollständig und manipulationssicher sein.  
-Änderungen müssen autorisiert sein und vollständig nachvollziehbar(logs)  
-Manipulationsschutz: z.b nachträgliche änderung von Buchungen verhindern  
-Doppelte Buchführung: Soll / Ist jederzeit vergleichen um abweichungen schnell festzustellen  
-Logs: Jede Transaktion/Buchung/Änderung muss lückenlos geloggt sein inkl. zeitpunkt und Benutzer  
-Validierungsregeln festlegen  
-Unveränderbarkeit gewährleisten: Getätigte buchungen können nicht mehr geänder toder gelöscht werden nur durch Stornobuchungen korrigiert werden.  
## Verfügbarkeit:
-Finanzsysteme und Daten müssen jederzeit funktionsfähig sein. Besonders in kritischen Zeiten wie dem Monats/Jahres abschluss.  
-Zahlungssysteme müssen reibungslos funktionieren  
-Monats/Jahresabschlüsse müssen schnell und zuverlässig abrufbar sein.  
-Historie muss jederzeit verfügbar und einsehbar sein für kontrollen.  

# Server/Netzwerk

## Vertraulichkeit:
-Mögliche Bedrohungen: Datenverkehr abhören / mithören. Serverdaten auslesen(Passwörter, Configdaten usw)  
-Sicherstellen das per Netzwerk/Internet übertragene oder auf Server gespeicherte Daten nur von autorisierten Benutzern/Systemen eingesehen werden können.  
-Einsatz von VPNS / Verschlüsselungen benutzen(SSL/TLS)  
-Server: Strenge zugriffskontrollen verschlüsselung von Festplatten  
## Integriät:  
-Bedrohungen: Manipulation von Daten wärend der übertragung, Einschleusen von Malware  
-Digitale Signaturen und Prüfsummen verwenden um zu erkennen ob Daten verändert wurden.  
-Strenge rechteverwaltung für Server, Dateiintegritätschecks um änderungen an kritischen Systemen zu erkennen.  
## Verfügbarkeit:
-Bedrohungen: DDoS-Angriffe um das Netzwerk zu überlasten. Hardware ausfälle. Stromunterbrüche. Fehlerhafte Software Updates  
-Server und Netzwerkdienste sowie die darauf gespeicherten Daten müssen für Authorisierte Benutzer jederzeit zuverlässig und ohne Unterbrechung zugänglich sein.  
-Redundante Netzwerkkomponenten(Switches, Router)  
-Loadbalancer um den Datenverkehr zu verteilen  
-Failoversysteme für Ausfallschutz und oder verteilung der last  
-Server: Hochverfügbarkeits-Cluster zb mit VM/Kubernetes  
-Redundante Stromversorgung(Notfallgeneratoren + Dauerbetriebenes Schwungrad das instant übernimmt)   
-Regelmässige Backups mit getesteter Wiederherstellung  

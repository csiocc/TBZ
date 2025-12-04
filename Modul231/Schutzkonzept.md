# IT Sicherheitskonzept
# Planung: 
  ## Festlegung Geltungsbereich
  -Teilbereich: Datacenter-Server

  ## Strukturanalyse: 
    -Dabei werden alle Informationen und Prozesse der betroffenen technischen Systeme analysiert und als Basis für das Konzept zusammengefasst

    -VM-Cluster(Virtualisierungsumgebung) Bereitstellung geschäftskritischer Server
    -Storage-System(Nas mit redundanten Controllern(Raid))
    -Backup Infrastruktur(Cloudbackup) Wiederherstellung / Desasterrecovery
    -Netzwerkkomponenten(Switches, Firewall, Vlan-Segmente(Virtual Lan)) 
    -Management Server(Monitoring, Logging, Patchmanagement) Betrieb, überwachung, sicherheit

  ## Feststellung des Schutzbereichs
    -Welcher Bereich muss wie geschützt werden?
    -Personendaten(Benutzerkonten, Logs) Schutzbedarf: Hoch / Sensible Daten
    -Geschäftsgeheimnisse(Quellcode, interne Dokumente) Schutzbedarf: Hoch / Interne Daten
    -Finanzdaten(Verträge, Rechnungen) Schutzbedarf: Mittel - Hoch / Interne Daten
    -Technische Betriebsdaten(Monitoring, Konfigurationen) Schutzbedarf: Mittel - Interne Daten
    -Backups(Images, Datenbestände) Schutzbedarf: Hoch / können Sensibe Daten beinhalten

    -VM-Cluster - Ransomware angriffe, DDoS angriffe
    -Storage-System - Hardware ausfälle / Datenabflüsse
    -Netzwerkkomponenten - Hardware ausfälle 
    



  ## Modellierungsphase: 
    Zusammenführung der Ergebnisse aus den beiden vorherigen Phasen und Ableitung der notwendigen Sicherheitsmassnahmen
    - Bedrohungsmodell erstellen(Identifikation der relevanten Bedrohungen und Angreifergruppen)
    - Schwachstellenmodell erstellen(Zuordnung der potenziellen Schwachstellen in Bezug auf Systeme und Prozesse)
    - Risiko Modellierung(Risiken werden durch Kombination von Bedrohung × Schwachstelle × Schutzbedarf bewertet)
  ## Basis Sicherheitscheck
    -Den Momentanen sicherheitsstatus analysieren und testen.
  ## Ergänzende Sicherheitsanalyse
    -Risiken ermitteln die noch nicht abgedeckt sind
  ## Risikoanalyse erstellen

# Do Phase - Umsetzung

  ## Sicherheitsplan umsetzen
    Sicherheitssysteme wie geplant installieren - sauber testen - Probleme Behandeln

  
# Abschlussphase - Erfolgs Kontrolle und überwachung

# Kontinuierliche verbesserungen und überprüfungen




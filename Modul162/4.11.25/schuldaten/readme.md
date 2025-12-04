# Schuldaten – kleine In-Memory-Datenbank

Dieses Script modelliert Lernende, Module und Leistungsbeurteilungen in Ruby. Alle Daten liegen im Speicher, eine externe DB gibt es nicht. Die Klassen spiegeln die Beziehungen:

- **Database** (Singleton): hält Listen der Lernenden, Module und Leistungsbeurteilungen und vergibt IDs.
- **Lernender**: kennt seine Module (`module_liste`) und Leistungsbeurteilungen (`lbs`).
- **SchulModul**: kennt seine Lernenden und alle zugehörigen Leistungsbeurteilungen.
- **LeistugsBeurteilung**: verknüpft genau einen Lernenden mit genau einem Modul und trägt eine Note.

## Beziehungen

- Lernender <-> SchulModul: viele-zu-viele (ein Lernender hat viele Module, ein Modul hat viele Lernende).
- Lernender <-> LeistugsBeurteilung: 1:n (ein Lernender kann viele Leistungsbeurteilungen haben).
- SchulModul <-> LeistugsBeurteilung: 1:n (ein Modul kann viele Leistungsbeurteilungen haben).
- LeistugsBeurteilung referenziert genau **einen** Lernenden und genau **ein** Modul.

## Hauptmethoden

- `Lernender#add_modul(modul)`: hängt ein Modul an den Lernenden und umgekehrt.
- `Lernender#add_lb(note, modul)`: erzeugt eine Leistungsbeurteilung mit Note und Modul; verknüpft sich automatisch mit Lernendem, Modul und Database.
- `SchulModul#add_lernender(lernender)`: fügt den Lernenden dem Modul hinzu.
- `SchulModul#add_lb(lb)`: fügt eine Leistungsbeurteilung zum Modul hinzu.
- `Database#list_lernende`: listet alle Lernenden in der Datenbank.

## Demo-Ablauf (in `main.rb`)

- Es werden acht Lernende und drei Module erstellt.
- Jeder Lernende wird in jedes Modul eingetragen.
- Für jeden Lernenden in jedem Modul werden fünf Leistungsbeurteilungen mit zufälligen Noten aus `[4, 4.5, 5, 5.5, 6]` generiert.
- Optionales Logging: `DEBUG = true` setzt detailierte Ausgaben beim Erstellen frei.

## Ausführen

```bash
aus /TBZ
ruby Modul162/4.11.25/schuldaten/main.rb
```

## Nützliche Aufrufe im Script

- `db.list_lernende` – alle Lernenden ausgeben.
- `db.module_liste[0].list_lbs(lernende.first)` – alle LBs eines Lernenden in einem Modul anzeigen.
- `lernende.first.list_lbs` – alle LBs eines Lernenden anzeigen (mit Modulnamen).
- `Lernender.where(vorname: "MaX").fullname` – der fullname des lernenden mit dem Vornamen Max wird angezeigt.
    -vorname ist hier austauschbar gegen alle anderen werte von Lernender z.b email:, nachname: 
- `Lernender.where(module_liste: "mathe")` – gibt ein Array zurück mit allen Lernenden mit dem Modul Mathe

## Schlusswort

Ich habe überall direkte objekte referenziert, das würde man normal natürlich nicht machen,
sonder per ID referenzieren. Das hätte jedoch nochmal zusätzliche Funktionen und aufwand bedeutet.
Deswegen habe ich mir das erspart, die funktionsweise ist ja die selbe.



ich habe ein java projekt mit folgender logik: !!bitte beibehalten!!
elevator mit: currentFloor(int), passengers(ArrayList<Person>), requests(ArrayList<Integer>), capacity(int)
floor mit: waitingPeople(ArrayList<Person>) für personen
person mit: startFloor(int) und destinationFloor(int)
elevatorcontroller steuert aufzug und floors, enthält: elevator, floors(ArrayList<Floor>), 

deine aufgabe
baue mir eine optisch ansprechende gui mit java swing oder javafx
das gui soll den fahrstuhl grafisch darstellen animierter block oder im notfall rechteck (fals ich texturen oder ein gltf oder sowas liefern soll sag bescheid)
zeige die stockwerke deutlich sichtbar an linien und textlabels animiere auch das haus und die stockwerke schön
zeige wartende personen neben dem stockwerk strichmännchen oder animiert(fals ich texturen oder ein gltf oder sowas liefern soll sag bescheid)
zeige die anzahl der personen im fahrstuhl

ergäze buttons:
add person; zufällige person erzeugen
start simulation; starten
stop simulation; stoppen
optional: step einzelschritt

verwende sauberes layout zum beispiel borderlayout mit control panel unten
nutze farben und schriftarten damit es wie eine kleine simulation aussieht und nicht nur einfache rechtecke
verwende timer oder animation um die bewegung des fahrstuhls smooth darzustellen nicht nur sprünge sondern gleitend
achte darauf dass die logik klassen elevator floor person elevatorcontroller nicht verändert werden sondern nur von der gui benutzt werden
das ergebnis soll professionell aussehen aber in übersichtlichem java code geschrieben sein


$${\color{green}--->> Code ausgabe nach diesem Prompt ist die gui/ElevatorSimulatorGUI_Original.md }$$

$${\color{red}Zweiter Prompt:}$$

import java.awt.event.*; ist überflüssig
der lift bewegt sich zu schnell und sollte halb so schnell sein.
ersetze die passagiere durch strichmännchen, links die wartenden in grün darüber das zielstockwerk, rechts die ausgestiegenen in blau darstellen.
lösche die Step funktion, funktioniert eh nicht.
der lift belädt/lädt nicht in der mitte des stockwerks

$${\color{green}--->> Code ausgabe nach diesem Prompt ist die gui/ElevatorSimulatorGUI01.md }$$

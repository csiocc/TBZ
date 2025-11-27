import { SurveyData } from './types';

// HINWEIS: Hier können Sie die echten Daten eintragen, sobald die Umfrageergebnisse vorliegen.
// Ändern Sie einfach die "value"-Zahlen entsprechend der Anzahl der Stimmen.

export const mockSurveyData: SurveyData = {
  totalParticipants: 42, // Beispielhafte Gesamtanzahl

  // 1. Wie viele Stunden trainierst du durchschnittlich pro Woche?
  hoursPerWeek: [
    { name: '0h', value: 2 },
    { name: '2-5h', value: 15 },
    { name: '5h+', value: 20 },
    { name: 'Sonstiges', value: 5 },
  ],

  // 2. Was ist dein Rekord im Bankdrücken?
  benchPressRecord: [
    { name: '25kg', value: 5 },
    { name: '50kg', value: 8 },
    { name: '75kg', value: 12 },
    { name: '100kg', value: 10 },
    { name: '125kg', value: 4 },
    { name: '150kg', value: 2 },
    { name: 'Sonstiges', value: 1 },
  ],

  // 3. Wie oft trainierst du pro Woche?
  frequencyPerWeek: [
    { name: '1x', value: 2 },
    { name: '2x', value: 5 },
    { name: '3x', value: 10 },
    { name: '4x', value: 12 },
    { name: '5x', value: 8 },
    { name: '6x', value: 4 },
    { name: '7x', value: 1 },
  ],

  // 4. Wie würdest du dein aktuelles Fitnesslevel einschätzen? (1-6)
  fitnessLevel: [
    { name: '1 (Niedrig)', value: 3 },
    { name: '2', value: 5 },
    { name: '3', value: 10 },
    { name: '4', value: 15 },
    { name: '5', value: 6 },
    { name: '6 (Hoch)', value: 3 },
  ],

  // 5. Was ist deine Lieblingsübung?
  favoriteExercise: [
    { name: 'Bankdrücken', value: 12 },
    { name: 'Kreuzheben', value: 8 },
    { name: 'Kniebeugen', value: 9 },
    { name: 'Bizepscurls', value: 6 },
    { name: 'Klimmzüge', value: 4 },
    { name: 'Handy Scrollen', value: 2 },
    { name: 'Sonstiges', value: 1 },
  ],

  // 6. Wie viele Jahre trainierst du schon?
  yearsTraining: [
    { name: '1 Jahr', value: 10 },
    { name: '2 Jahre', value: 8 },
    { name: '3 Jahre', value: 6 },
    { name: '4 Jahre', value: 5 },
    { name: '5 Jahre', value: 4 },
    { name: 'Sonstiges', value: 9 },
  ],

  // 7. Welche Trainingsziele hast du? (Mehrfachauswahl möglich)
  trainingGoals: [
    { name: 'Muskelaufbau', value: 35, fullMark: 42 },
    { name: 'Fettabbau', value: 20, fullMark: 42 },
    { name: 'Ausdauer', value: 15, fullMark: 42 },
    { name: 'Gesundheit', value: 25, fullMark: 42 },
    { name: 'Beweglichkeit', value: 10, fullMark: 42 },
    { name: 'Stressabbau', value: 18, fullMark: 42 },
    { name: 'Wettkampf', value: 5, fullMark: 42 },
    { name: 'Fette Bizeps', value: 12, fullMark: 42 },
  ],

  // 8. Was ist dein primärer Grund, sportlich aktiv zu sein?
  primaryReason: [
    { name: 'Gesundheit', value: 15 },
    { name: 'Aussehen', value: 12 },
    { name: 'Leistung', value: 5 },
    { name: 'Soziales', value: 4 },
    { name: 'Kein Lauch sein', value: 6 }, // "Dem Lauch sein entkommen"
  ],
};

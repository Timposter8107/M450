# Aufgaben M450

## 22.08.2025

### Welche Formen von Tests kennen Sie aus der Informatik?

Unit-Tests
Integrationstests
System- / End-to-End-Tests

### Nennen Sie ein Beispiel eines SW-Fehlers und eines SW-Mangels. Nennen Sie ein Beispiel für einen hohen Schaden bei einem SW-Fehler.

* SW-Fehler: Programm gibt falsch berechnete Wehrte zurück
* SW-Mangel: Programm gibt richtige, aber unvollständige Daten zurück

Tool zur zeichnung und erstellung von Teilen in einer Fabrik exportiert grösse der Teile falsch, führt dazu, dass die Teile in der Fabrik mit falschen Massen hergestellt werden.

## 29.08.2025

### Übung 1

#### Abstrakte Testfälle

| Preis in CHF | Rabatt in % |
|--------------|-------------|
| <  15'000    | 0           |
| <  20'000    | 5           |
| <  25'000    | 7           |
| >= 25'000    | 8.5         |

#### Konkrete Testfälle

| Preis in CHF | Rabatt in % |
|--------------|-------------|
| 10'000       | 0           |
| 17'000       | 5           |
| 21'000       | 7           |
| 40'000       | 8.5         |

### Übung 2 (Website Europcar)

## Blackbox Tests

| Beschreibung                 | Erwartetes Resultat                               | Effektives Resultat                                   | Mögliche Ursache          |
|------------------------------|---------------------------------------------------|-------------------------------------------------------|---------------------------|
| User ruft Website auf        | Website lädt und zeigt optionen                   | Erwartetes Resultat                                   | -                         |
| User sucht nach Ort und Zeit | Website zeigt Verfügbare Fahrzeuge                | Erwartetes Resultat                                   | -                         |
| User klickt Login            | Login Fenster erscheint                           | Erwartetes Resultat                                   | -                         |
| User wählt Extras            | Website fügt gewählte Extras zu  Bestellung hinzu | Ab 18 Extras: "Sorry an error occurred, please retry" | Limit für Extras erreicht |
| User klickt Checkout         | Website fragt nach Kundeninformationen            | Erwartetes Resultat                                   | -                         |

### Übung 3

## Black-Box Tests

| Beschreibung                | Erwartetes Resultat                                    | Effektives Resultat                              | Mögliche Ursache                       |
|-----------------------------|--------------------------------------------------------|--------------------------------------------------|----------------------------------------|
| A zum Anzeigen aller Konten | Programm zeigt alle  vorprogrammierten Konten an       | Erwartetes Resultat                              | -                                      |
| E für Konto erstellen       | Programm fügt neues Konto hinzu mit Name und Währung   | Erwartetes Resultat                              | -                                      |
| W für Wechselkurs eingeben  | Programm zeigt Wechselkurs für  eingegebenen Währungen | Error bei der Abfrage des Wechselkurses: Timeout | API kann den Wechselkurs nicht abrufen |
| Q für beenden               | Programm schliesst                                     | Erwartetes Resultat                              | -                                      |

## Methoden für White-Box Tests

### Counter Klasse

* printAccountDetails
* printBalance
* printAccountsList

### ExchangeRateOkhttp Klasse

* getExchangeRate

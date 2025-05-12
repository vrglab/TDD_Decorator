# Bonussystem für Mitarbeiter

## Projektübersicht
Dieses Projekt implementiert ein flexibles und erweiterbares Bonussystem für Mitarbeiter mithilfe des **Decorator Pattern**.  
Es berechnet den jährlichen Bonus anhand folgender Faktoren:
- **Grundbonus** (fester Basisbetrag)  
- **Performance-Bonus** (Multiplikator nach Leistungsbewertung)  
- **Seniority-Bonus** (Betriebszugehörigkeit alle 5 Jahre)  
- **Project-Completion-Bonus** (pro abgeschlossenem Projekt)  
- **Teamleader-Bonus** (falls Teamleiter)  
- **Absence-Bonus** (Bonus/Strafabzug je nach Fehlzeiten)  
- **BonusService** wendet Unternehmens-Restriktionen (Min/Max) auf das Ergebnis an.

## Architektur & Design
- **Decorator Pattern**:  
  - `BonusComponent` (abstrakte Basisklasse)  
  - `GroundBonus`, `PerformanceBonus`, `SeniorityBonus` etc. erben von `BonusDecorator`  
  - `BonusCalculator` (Client) baut die Dekorator-Kette auf und ruft die Gesamtberechnung auf  
- **TDD** mit JUnit, AssertJ und Mockito
- ![image](https://github.com/user-attachments/assets/c824d12d-f387-4963-99ce-2006d6740e4d)

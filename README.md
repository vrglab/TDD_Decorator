# Bonussystem für Mitarbeiter

## Projektübersicht
Im Rahmen dieses Projekts wurde ein flexibles und erweiterbares Bonussystem für Mitarbeiterbewertungen entwickelt.  
Der jährliche Bonus eines Mitarbeiters wird anhand folgender Einflussfaktoren berechnet:

- **Grundbonus**: Fester Basisbetrag  
- **Performance-Bonus**: Multiplikator basierend auf individueller Leistungsbewertung (drei Abstufungen)  
- **Seniority-Bonus**: Je 5 Jahre Betriebszugehörigkeit +150 €  
- **Project-Completion-Bonus**: +100 € pro abgeschlossenem Projekt  
- **Teamleader-Bonus**: +500 €, sofern der Mitarbeiter Teamleiter ist  
- **Absence-Bonus / -Penalty**:  
  - Bonus bei sehr geringer Fehlzeit (zwei Stufen)  
  - Abzüge bei hoher Fehlzeit (zwei Stufen)  
- **BonusService**: Wendet Min-/Max-Restriktionen (z. B. 500 € ≤ Bonus ≤ 5.000 €) auf das Gesamtergebnis an  

Die Berechnung nutzt das **Decorator Pattern**, um die Boni modular und dynamisch kombinierbar zu halten.  

---

## Architektur & Design

- **Decorator Pattern**  
  - `BonusComponent` (abstrakte Basisklasse)  
  - `BonusDecorator` (Basis-Klasse für alle konkreten Boni)  
  - Konkrete Decorators:  
    - `GroundBonus`  
    - `PerformanceBonus`  
    - `SeniorityBonus`  
    - `ProjectCompletionBonus`  
    - `TeamleiterBonus`  
    - `AbsenceBonus`  
- **BonusCalculator** (Client)  
  - Stellt die Dekorator-Kette zusammen  
  - Ruft `berechneBonus()` auf und wendet Unternehmensrestriktionen an  
- **TDD**  
  - JUnit 4  
  - AssertJ für Assertions  
  - Mockito für Mocks 
- ![image](https://github.com/user-attachments/assets/c824d12d-f387-4963-99ce-2006d6740e4d)

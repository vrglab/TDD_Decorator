package org.Vrglab.Decorator;

import org.Vrglab.Mitarbeiter;

public class PerformanceBonus extends BonusDecorator {
    public PerformanceBonus(BonusComponent component) {
        super(component);
    }

    @Override
    public double berechneBonus(Mitarbeiter mitarbeiter) {
        double bonus = decoratedBonus.berechneBonus(mitarbeiter);
        bonus *= mitarbeiter.getPerformance();
        return bonus;
    }
}

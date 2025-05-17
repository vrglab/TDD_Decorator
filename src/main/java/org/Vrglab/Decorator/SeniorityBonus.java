package org.Vrglab.Decorator;

import org.Vrglab.Bonus;
import org.Vrglab.Mitarbeiter;

public class SeniorityBonus extends BonusDecorator {
    public SeniorityBonus(Bonus component) {
        super(component);
    }

    @Override
    public double berechneBonus(Mitarbeiter mitarbeiter) {
        double bonus = decoratedBonus.berechneBonus(mitarbeiter);
        int years = mitarbeiter.getFZG().getYear();
        bonus += (years / 5) * 150.0;
        return bonus;
    }
}

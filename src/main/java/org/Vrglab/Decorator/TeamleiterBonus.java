package org.Vrglab.Decorator;

import org.Vrglab.Mitarbeiter;

public class TeamleiterBonus extends BonusDecorator{
    public TeamleiterBonus(BonusComponent component) {
        super(component);
    }

    @Override
    public double berechneBonus(Mitarbeiter mitarbeiter) {
        double bonus = decoratedBonus.berechneBonus(mitarbeiter);
        if (mitarbeiter.isTeamLeader()) {
            bonus += 500.0;
        }
        return bonus;
    }
}

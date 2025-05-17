package org.Vrglab.Decorator;

import org.Vrglab.Bonus;
import org.Vrglab.Mitarbeiter;

public class TeamleiterBonus extends BonusDecorator {
    public TeamleiterBonus(Bonus component) {
        super(component);
    }

    @Override
    public double berechneBonus(Mitarbeiter mitarbeiter) {
        boolean isTeamLead = mitarbeiter.isTeamLeader();
        double bonus = decoratedBonus.berechneBonus(mitarbeiter);
        if (mitarbeiter.isTeamLeader()) {
            bonus += 500.0;
        }
        return bonus;
    }
}

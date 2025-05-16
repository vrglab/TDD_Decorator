package org.Vrglab.Decorator;

import org.Vrglab.Mitarbeiter;

public class ProjectBonus extends BonusDecorator{
    public  ProjectBonus(BonusComponent component) {
        super(component);
    }

    @Override
    public double berechneBonus(Mitarbeiter mitarbeiter) {
        double bonus = decoratedBonus.berechneBonus(mitarbeiter);
        bonus += mitarbeiter.getAbgesProjekte() * 50.0;
        return bonus;
    }
}

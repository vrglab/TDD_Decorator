package org.Vrglab.Decorator;

import org.Vrglab.Mitarbeiter;

public abstract class BonusDecorator extends BonusComponent {
    protected BonusComponent decoratedBonus;  // The component we wrap

    public BonusDecorator(BonusComponent bonus) {
        this.decoratedBonus = bonus;
    }
    public abstract double berechneBonus(Mitarbeiter mitarbeiter);
}


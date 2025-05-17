package org.Vrglab.Decorator;

import org.Vrglab.Bonus;
import org.Vrglab.Mitarbeiter;

public abstract class BonusDecorator implements Bonus {
    protected Bonus decoratedBonus;  // The component we wrap

    public BonusDecorator(Bonus bonus) {
        this.decoratedBonus = bonus;
    }
    public abstract double berechneBonus(Mitarbeiter mitarbeiter);
}


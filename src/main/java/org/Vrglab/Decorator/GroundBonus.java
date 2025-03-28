package org.Vrglab.Decorator;

import org.Vrglab.Mitarbeiter;

public class GroundBonus extends BonusComponent {
    protected BonusComponent decoratedBonus;

    public GroundBonus(BonusComponent decoratedBonus) {
        this.decoratedBonus = decoratedBonus;
    }

    @Override
    public String calculate(Mitarbeiter m) {

        String result = decoratedBonus != null
                ? decoratedBonus.calculate(m)
                : "";

        return result;
    }
}

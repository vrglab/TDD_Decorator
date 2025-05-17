package org.Vrglab.Decorator;

import org.Vrglab.Bonus;
import org.Vrglab.Mitarbeiter;

public class FehlzeitenBonus  extends BonusDecorator {
    public  FehlzeitenBonus(Bonus component) {
        super(component);
    }

    @Override
    public double berechneBonus(Mitarbeiter mitarbeiter) {
        double bonus = decoratedBonus.berechneBonus(mitarbeiter);
        int fehltage = mitarbeiter.getFehlTage();


        if (fehltage == 0) {
            bonus += 200.0;
        } else if (fehltage == 1) {
            // Kein Bonus oder Abzug
        } else if (fehltage > 1) {
            bonus -= 200.0;
        }

        return bonus;
    }
}

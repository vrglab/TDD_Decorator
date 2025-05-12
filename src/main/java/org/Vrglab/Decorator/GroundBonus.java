package org.Vrglab.Decorator;

import org.Vrglab.Mitarbeiter;


 public class GroundBonus extends BonusComponent{

    @Override
    public double berechneBonus(Mitarbeiter mitarbeiter) {
        return 1000.0;
    }
}
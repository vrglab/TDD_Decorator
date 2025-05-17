package org.Vrglab;

public class BaseBonus implements Bonus {
    @Override
    public double berechneBonus(Mitarbeiter mitarbeiter) {
        return 1000.0;
    }
}

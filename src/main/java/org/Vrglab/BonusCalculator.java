package org.Vrglab;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.Vrglab.Decorator.PerformanceBonus;
import org.Vrglab.Decorator.SeniorityBonus;
import org.Vrglab.Decorator.TeamleiterBonus;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;



public class BonusCalculator {
    private Bonus bonus;
    private Mitarbeiter mitarbeiter;

    public BonusCalculator(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public void  BuildInternalBonus(BonusBuilder bonusBuilder) {
        bonus = bonusBuilder.Build();
    }

    public double calculateBonus() {
        return bonus.berechneBonus(this.mitarbeiter);
    }

    public static class BonusBuilder {
        private Bonus bonus;

        public BonusBuilder() {
            bonus = new BaseBonus();
        }

        public <T extends Bonus> BonusBuilder AddBonus(Class<T> _class)  {
            try {
                this.bonus = (Bonus)_class.getConstructors()[0].newInstance(bonus);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return this;
        }

        public <T extends Bonus> BonusBuilder AddBonus(Class<T> _class, Object... parameters)  {
            try {
                Object[] fullParams = new Object[parameters.length + 1];
                fullParams[0] = bonus;
                System.arraycopy(parameters, 0, fullParams, 1, parameters.length);
                this.bonus = (Bonus)_class.getConstructors()[0].newInstance(fullParams);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return this;
        }

        public Bonus Build() {
            return bonus;
        }
    }
}

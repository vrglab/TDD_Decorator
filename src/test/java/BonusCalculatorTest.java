import org.Vrglab.BonusCalculator;
import org.Vrglab.Decorator.*;
import org.Vrglab.Mitarbeiter;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BonusCalculatorTest {

    private Mitarbeiter mitarbeiter;
    private BonusCalculator bonusCalculator;

    @Before
    public void Setup() {
        mitarbeiter = Utils.MockedMitarbeiter();
        bonusCalculator = new BonusCalculator(mitarbeiter);
    }


    @Test
    public void testCalculateGroundBonus() {
        bonusCalculator.BuildInternalBonus(new BonusCalculator.BonusBuilder());
        double bonus = bonusCalculator.calculateBonus();
        assertThat(bonus).isEqualTo(1000.0);
    }

    @Test
    public void testCalculateTeamLeiterBonus() {
        bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(TeamleiterBonus.class)
        );
        double bonus = bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(1500.0);
    }

    @Test
    public void testCalculateSeniorityBonus() {
        bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(SeniorityBonus.class)
        );
        double bonus = bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(1300);
    }

    @Test
    public void testCalculatePerformanceBonus() {
        bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(PerformanceBonus.class)
        );
        double bonus = bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(500);
    }

    @Test
    public void testCalculateFehlzeitenBonus() {
        bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(FehlzeitenBonus.class)
        );
        double bonus = bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(800);
    }

    @Test
    public void testCalculateProjectBonus() {
        bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(ProjectBonus.class)
        );
        double bonus = bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(1100);
    }

    @Test
    public void testCalculateCombinationBonus() {
        bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder()
                        .AddBonus(ProjectBonus.class)
                        .AddBonus(FehlzeitenBonus.class)
                        .AddBonus(SeniorityBonus.class)
                        .AddBonus(TeamleiterBonus.class)
                        .AddBonus(PerformanceBonus.class)
        );
        double bonus = bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(850);
    }
}

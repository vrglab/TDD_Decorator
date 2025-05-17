import org.Vrglab.BonusCalculator;
import org.Vrglab.Decorator.*;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class BonusCalculatorTest {

    private BonusCalculator _bonusCalculator;

    @Before
    public void Setup() {
        _bonusCalculator = new BonusCalculator(Utils.MockedMitarbeiter());
    }

    @Test
    public void testCalculateGroundBonus() {
        _bonusCalculator.BuildInternalBonus(new BonusCalculator.BonusBuilder());
        double bonus = _bonusCalculator.calculateBonus();
        assertThat(bonus).isEqualTo(1000.0);
    }

    @Test
    public void testCalculateTeamLeiterBonus() {
        _bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(TeamleiterBonus.class)
        );
        double bonus = _bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(1500.0);
    }

    @Test
    public void testCalculateSeniorityBonus() {
        _bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(SeniorityBonus.class)
        );
        double bonus = _bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(1300);
    }

    @Test
    public void testCalculatePerformanceBonus() {
        _bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(PerformanceBonus.class)
        );
        double bonus = _bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(500);
    }

    @Test
    public void testCalculateFehlzeitenBonus() {
        _bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(FehlzeitenBonus.class)
        );
        double bonus = _bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(800);
    }

    @Test
    public void testCalculateProjectBonus() {
        _bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder().AddBonus(ProjectBonus.class)
        );
        double bonus = _bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(1100);
    }

    @Test
    public void testCalculateCombinationBonus() {
        _bonusCalculator.BuildInternalBonus(
                new BonusCalculator.BonusBuilder()
                        .AddBonus(ProjectBonus.class)
                        .AddBonus(FehlzeitenBonus.class)
                        .AddBonus(SeniorityBonus.class)
                        .AddBonus(TeamleiterBonus.class)
                        .AddBonus(PerformanceBonus.class)
        );
        double bonus = _bonusCalculator.calculateBonus();

        assertThat(bonus).isEqualTo(850);
    }
}

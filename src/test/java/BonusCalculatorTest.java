import org.Vrglab.BonusCalculator;
import org.Vrglab.Decorator.TeamleiterBonus;
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

    private static String _TEST_NAME = "Mitarbeiter";

    @Before
    public void Setup() {
        mitarbeiter = mock(Mitarbeiter.class);

        when(mitarbeiter.getAbgesProjekte()).thenReturn(2);
        when(mitarbeiter.getFehlTage()).thenReturn(3);
        when(mitarbeiter.getFZG()).thenReturn(LocalDate.now());
        when(mitarbeiter.getName()).thenReturn(_TEST_NAME);
        when(mitarbeiter.getPerformance()).thenReturn(0.5d);
        when(mitarbeiter.isTeamLeader()).thenReturn(true);

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
}

import org.Vrglab.Decorator.BonusComponent;
import org.Vrglab.Decorator.GroundBonus;
import org.Vrglab.Mitarbeiter;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BonusCalculator {

    private Mitarbeiter mitarbeiter;
    private BonusComponent bonusCalculator;

    @Before
    public void Setup() {
        mitarbeiter = mock(Mitarbeiter.class);

        when(mitarbeiter.getAbgesProjekte()).thenReturn(2);
        when(mitarbeiter.getFehlTage()).thenReturn(3);
        when(mitarbeiter.getFZG()).thenReturn(new Date());

        bonusCalculator = new GroundBonus(bonusCalculator);
    }

    @Test
    public void testAbgeschlosseneProjekte() {
        assertThat(mitarbeiter.getAbgesProjekte()).isEqualTo(2);
    }

    @Test
    public void testFehlTage() {
        assertThat(mitarbeiter.getFehlTage()).isEqualTo(3);
    }
}

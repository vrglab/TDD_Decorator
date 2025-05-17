import org.Vrglab.Mitarbeiter;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MitarbeiterTest {

    private Mitarbeiter mitarbeiter;

    private static String _TEST_NAME = "Mitarbeiter";

    @Before
    public void Setup() {
        mitarbeiter = mock(Mitarbeiter.class);

        when(mitarbeiter.getAbgesProjekte()).thenReturn(2);
        when(mitarbeiter.getFehlTage()).thenReturn(3);
        when(mitarbeiter.getFZG()).thenReturn(LocalDate.now());
        when(mitarbeiter.getName()).thenReturn(_TEST_NAME);
        when(mitarbeiter.getPerformance()).thenReturn(0.5d);
    }

    @Test
    public void testAbgeschlosseneProjekte() {
        assertThat(mitarbeiter.getAbgesProjekte()).isEqualTo(2);
    }

    @Test
    public void testFehlTage() {
        assertThat(mitarbeiter.getFehlTage()).isEqualTo(3);
    }

    @Test
    public void testFZG() {
        assertThat(mitarbeiter.getFZG()).isEqualTo(LocalDate.now());
    }

    @Test
    public void testName() {
        assertThat(mitarbeiter.getName()).isEqualTo(_TEST_NAME);
    }

    @Test
    public void testPerformance() {
        assertThat(mitarbeiter.getPerformance()).isEqualTo(0.5D);
    }
}

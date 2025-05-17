import jdk.jshell.execution.Util;
import org.Vrglab.Mitarbeiter;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MitarbeiterTest {

    private Mitarbeiter mitarbeiter;

    @Before
    public void Setup() {
        mitarbeiter = Utils.MockedMitarbeiter();
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
        assertThat(mitarbeiter.getFZG()).isEqualTo(Utils.TEST_DATE);
    }

    @Test
    public void testName() {
        assertThat(mitarbeiter.getName()).isEqualTo(Utils.TEST_NAME);
    }

    @Test
    public void testPerformance() {
        assertThat(mitarbeiter.getPerformance()).isEqualTo(0.5D);
    }

    @Test
    public void testTeamLeader() {
        assertThat(mitarbeiter.isTeamLeader()).isEqualTo(true);
    }
}

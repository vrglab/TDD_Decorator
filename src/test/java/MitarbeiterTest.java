import org.Vrglab.Mitarbeiter;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class MitarbeiterTest {

    private Mitarbeiter _mitarbeiter;

    @Before
    public void Setup() {
        _mitarbeiter = Utils.MockedMitarbeiter();
    }

    @Test
    public void testAbgeschlosseneProjekte() {
        assertThat(_mitarbeiter.getAbgesProjekte()).isEqualTo(2);
    }

    @Test
    public void testFehlTage() {
        assertThat(_mitarbeiter.getFehlTage()).isEqualTo(3);
    }

    @Test
    public void testFZG() {
        assertThat(_mitarbeiter.getFZG()).isEqualTo(Utils.TEST_DATE);
    }

    @Test
    public void testName() {
        assertThat(_mitarbeiter.getName()).isEqualTo(Utils.TEST_NAME);
    }

    @Test
    public void testPerformance() {
        assertThat(_mitarbeiter.getPerformance()).isEqualTo(0.5D);
    }

    @Test
    public void testTeamLeader() {
        assertThat(_mitarbeiter.isTeamLeader()).isEqualTo(true);
    }
}

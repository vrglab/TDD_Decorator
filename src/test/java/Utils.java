import org.Vrglab.Mitarbeiter;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Utils {
    public final static String TEST_NAME = "Mitarbeiter";
    public final static LocalDate TEST_DATE = LocalDate.parse("2015-01-01");

    public static Mitarbeiter MockedMitarbeiter() {
        Mitarbeiter mitarbeiter = mock(Mitarbeiter.class);
        when(mitarbeiter.getAbgesProjekte()).thenReturn(2);
        when(mitarbeiter.getFehlTage()).thenReturn(3);
        when(mitarbeiter.getFZG()).thenReturn(TEST_DATE);
        when(mitarbeiter.getName()).thenReturn(TEST_NAME);
        when(mitarbeiter.getPerformance()).thenReturn(0.5d);
        when(mitarbeiter.isTeamLeader()).thenReturn(true);
        return mitarbeiter;
    }
}

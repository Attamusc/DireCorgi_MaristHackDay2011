import org.junit.*;
import java.util.*;
import java.util.List;
import play.test.*;
import models.*;

public class VotingSessionTest extends UnitTest {
    
    @Before
	public void setup() {
		Fixtures.deleteAll();
	}
	
    @Test
    public void createVotingSessionTest() {
        new VotingSession("Spring 2012", new Date(), new Date()).save();
        
        VotingSession spring_2012 = VotingSession.find("byShort_Name", "Spring 2012").first();
        
        assertEquals(1, VotingSession.count());
    }
}
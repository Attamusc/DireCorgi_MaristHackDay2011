import org.junit.*;
import java.util.*;
import java.util.List;
import play.test.*;
import models.*;

public class VoteTest extends UnitTest {
    
    @Before
	public void setup() {
		Fixtures.deleteAll();
	}
	
    @Test
    public void createVoteTest() {
        School tempSchool = new School("Computer Science").save();
        User sean = new User("Sean", "Dunn", "sean@attamusc.com", "password", tempSchool, "101-10-951").save();
        VotingSession spring_2012 = new VotingSession("Spring 2012", new Date(), new Date()).save();
        
        new Vote("test@temp.com", sean, spring_2012).save();
        
        assertEquals(1, Vote.count());
    }
    
}
import org.junit.*;
import java.util.*;
import java.util.List;
import play.test.*;
import models.*;
import play.libs.Crypto;

public class UserTest extends UnitTest {
    
    @Before
	public void setup() {
		Fixtures.deleteAll();
	}
	
    @Test
    public void createUserTest() {
        School tempSchool = new School("Computer Science").save();
        new User("Sean", "Dunn", "sean@attamusc.com", "password", tempSchool, "101-10-951").save();
        assertEquals(1, User.count());
    }
    
    @Test
    public void schoolConnectionTest() {
        School tempSchool = new School("Computer Science").save();
        new User("Sean", "Dunn", "sean@attamusc.com", "password", tempSchool, "101-10-951").save();
        User sean = User.find("byEmail", "sean@attamusc.com").first();
        assertEquals(tempSchool, sean.school);
        assertEquals("Computer Science", sean.school.name);
    }
    
    @Test
    public void addVoteTest() {
        School tempSchool = new School("Computer Science").save();
        User sean = new User("Sean", "Dunn", "sean@attamusc.com", "password", tempSchool, "101-10-951").save();
        User ryan = new User("Ryan", "Wallner", "ryan@attamusc.com", "password", tempSchool, "101-10-950").save();
        VotingSession spring_2012 = new VotingSession("Spring 2012", new Date(), new Date()).save();
        
        sean.addVote(ryan, spring_2012);
        
        assertEquals(sean.votes.get(0), Vote.find("byVoter", Crypto.passwordHash(sean.email)).first());
    }
    
    @Test
    public void findInSchoolTest() {
        
    }
    
    @Test
    public void connectUser() {
        School tempSchool = new School("Computer Science").save();
        User sean = new User("Sean", "Dunn", "sean@attamusc.com", "password", tempSchool, "101-10-951").save();
        assertEquals(sean, User.connect("sean@attamusc.com", "password"));
        assertEquals(null, User.connect("sean@fakeemail.com", "password"));
        assertEquals(null, User.connect("sean@attamusc.com", "foo"));
    }
}
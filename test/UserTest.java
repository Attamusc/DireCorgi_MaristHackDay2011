import org.junit.*;
import java.util.*;
import java.util.List;
import play.test.*;
import models.*;

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
    public void connectUser() {
        School tempSchool = new School("Computer Science").save();
        User sean = new User("Sean", "Dunn", "sean@attamusc.com", "password", tempSchool, "101-10-951").save();
        assertEquals(sean, User.connect("sean@attamusc.com", "password"));
        assertEquals(null, User.connect("sean@fakeemail.com", "password"));
        assertEquals(null, User.connect("sean@attamusc.com", "foo"));
    }
}
import org.junit.*;
import java.util.*;
import java.util.List;
import play.test.*;
import models.*;

public class SchoolTest extends UnitTest {
    
    @Before
	public void setup() {
		Fixtures.deleteAll();
	}
    
    @Test
    public void createTest() {
        School newSchool = new School("Computer Science").save();
        assertEquals(School.all().first(), newSchool);
    }
}

import play.*;
import play.jobs.*;
import play.test.*;
 
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
 	 
    @SuppressWarnings("deprecation")
	public void doJob() {
            
            //Integer userCount = User.count();
            //Integer votesCount = Votes.count();
            //Integer schoolsCount = School.count();
            //Integer votingSessions = VotingSession.count();
            //if( userCount || votesCount || schoolsCount || votingSessions > 0 ) {
            //    Fixtures.deleteDatabase();
             //   Logger.info("Database Wiped");
            //}
           // else{
            //    Logger.info("Database was already empty");
           // }

        // Doublecheck if the database is empty
        //if(User.count() == 0) {
           // Fixtures.deleteDatabase();
            //Logger.info("Database Wiped");
            //Logger.info("Database is Empty Loading Initial Data");
            //Fixtures.load("initial-data.yml");]
            Logger.info("Initialization Done");
        
 
}

}
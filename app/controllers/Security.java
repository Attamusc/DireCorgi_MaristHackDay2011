package controllers;
 
import models.*;
 
public class Security extends Secure.Security {
 
	static boolean authentify(String email, String password) {
	    return User.connect(email, password) != null;
	}
	
	static void onDisconnected() {
	    Application.index();
	}

	static void onAuthenticated() {
	    Admin.index();
	}
        
        static boolean check(String checkTrue) {
	    if("true".equals(checkTrue)) {
	        return User.find("byEmail", Security.connected()).<User>first().is_admin;
	    }
	    return false;
	}
	
}
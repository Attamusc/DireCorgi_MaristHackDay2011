package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.User;
import models.School;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void register() {
        render();
    }
    
    public static void signup(String first_name, String last_name, String email, String password, String school, String cwid, boolean vested, boolean tenured) {
        School newSchool = new School(school).save();
        User newUser = new User(first_name, last_name, email, password, newSchool, cwid, vested, tenured).save();
        
        if(newUser != null) {
            redirect("/admin");
        }
        else {
            render("Application/register.html");
        }
    }

}
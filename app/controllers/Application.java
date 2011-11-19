package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void register() {
        render();
    }
    
    public static void signup(String first_name, String last_name, String email, String password, School school, String cwid, boolean vested, boolean tenured) {
        User newUser = new User(first_name, last_name, email, password, school, cwid, vested, tenured);
        
        if(user.save()) {
            redirect("/admin");
        }
        else {
            render("Application/register.html");
        }
    }

}
package models;

import play.*;
import play.libs.Crypto;
import play.db.jpa.*;

import javax.persistence.*;
import play.data.validation.*;
import java.util.*;

@Entity(name="voters")
public class User extends Model {
    
    @Required
    public String first_name;
    
    @Required
    public String last_name;
    
    @Email
    @Required
    public String email;
    
    public String password_hash;
    public String salt;
    
    public boolean is_admin;
    
    @ManyToOne
    public School school;
    
    public boolean nominated;
    
    // The faculty's campus wide id
    @Required
    public String cwid;
    
    public User(String first_name, String last_name, String email, String password, School school, String cwid) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.salt = Crypto.passwordHash((new Date()).toString());
        this.password_hash = Crypto.passwordHash(Crypto.passwordHash(password) + this.salt);
        this.is_admin = false;
        this.school = school;
        this.nominated = false;
        this.cwid = cwid;
    }
    
    
    public static User connect(String email, String password) {
        User user = User.find("byEmail", email).first();
        
        if(user != null) {
            String auth_hash = Crypto.passwordHash(Crypto.passwordHash(password) + user.salt);
            return user.password_hash.equals(auth_hash) ? user : null;
        }
        
        return null;
    }
}


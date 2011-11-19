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
    
    public boolean vested;
    public boolean tenured;
    
    @OneToMany(cascade=CascadeType.ALL)
    public List<Vote> votes;
    
    @OneToMany(cascade=CascadeType.ALL)
    public List<Nomination> nominations;
    
    // The faculty's campus wide id
    @Required
    public String cwid;
    
    public User(String first_name, String last_name, String email, String password, School school, String cwid, boolean vested, boolean tenured) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.salt = Crypto.passwordHash((new Date()).toString());
        this.password_hash = Crypto.passwordHash(Crypto.passwordHash(password) + this.salt);
        this.is_admin = false;
        this.school = school;
        this.vested = vested;
        this.tenured = tenured;
        this.cwid = cwid;
        this.votes = new ArrayList<Vote>();
        this.nominations = new ArrayList<Nomination>();
    }
    
    
    public static User connect(String email, String password) {
        User user = User.find("byEmail", email).first();
        
        if(user != null) {
            String auth_hash = Crypto.passwordHash(Crypto.passwordHash(password) + user.salt);
            return user.password_hash.equals(auth_hash) ? user : null;
        }
        
        return null;
    }
    
    public User addVote(Nomination nominee) {
        Vote newVote = new Vote(this.email, nominee).save();
        this.votes.add(newVote);
        this.save();
        return this;
    }
    
    public User addNomination(User user) {
        Vote newNomination = new Nomination(this.email, user).save();
        this.nominations.add(newNomination);
        this.save();
        return this;
    }
}


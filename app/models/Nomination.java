package models;

import play.*;
import play.libs.Crypto;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Nomination extends Model {
    
    @ManyToOne
    public User user;
    
    public String voter;
    public Date date_submitted;
    
    @ManyToOne
    public Vacancy vacancy;
    
    public Nomination(String email, User user, Vacancy vacancy) {
        this.voter = Crypto.passwordHash(this.email);
        this.user = user;
        this.vacancy = vacancy;
    }
    
    public static int nominationsForUser(User user) {
        return Nomination.find('user', user).count();
    }
}


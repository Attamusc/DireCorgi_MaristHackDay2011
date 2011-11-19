package models;

import play.*;
import play.db.jpa.*;
import play.libs.Crypto;

import javax.persistence.*;
import play.data.validation.*;
import java.util.*;

@Entity
public class Vote extends Model {
    
    @Required
    @ManyToOne
    public Nominee nominee;
    
    @Required
    public String voter;
    
    @Required
    public Date date_submitted;
    
    public Vote(String email, Nominee nominee) {
        this.voter = Crypto.passwordHash(email);
        this.nominee = nominee;
        this.date_submitted = new Date();
    }
    
    public String toString() {
        return this.nominee.toString() + " @ " + this.date_submitted.toString();
    }
    
}


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
    public String voter;
    
    @Required
    @ManyToOne
    public User user;
    
    @Required
    public Date date_submitted;
    
    @Required
    @ManyToOne
    public VotingSession voting_session;
    
    public Vote(String email, User user, VotingSession voting_session) {
        this.voter = Crypto.passwordHash(email);
        this.user = user;
        this.date_submitted = new Date();
        this.voting_session = voting_session;
    }
    
    
}


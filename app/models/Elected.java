package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Elected extends Model {
    
    @ManyToOne
    public User user;
    
    @ManyToOne
    public Commitee commitee;
    
    public Elected(User user, Commitee commitee) {
        this.user = user;
        this.commitee = commitee;
    }
    
    public String toString() {
        return this.user.toString();
    }
    
}


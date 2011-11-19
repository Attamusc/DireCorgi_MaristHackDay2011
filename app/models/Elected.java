package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Elected extends Model {
    
    public User user;
    public Commitee commitee;
    
    public Elected(User user, Commitee commitee) {
        this.user;
        this.commitee;
    }
    
}


package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Nominee extends Model {
    
    @ManyToOne
    public User user;
    
    @ManyToOne
    public Vacancy vacancy;
    
    public Nominee(User user, Vacancy vacancy) {
        this.user = user;
        this.vacancy = vacancy;
    }
    
    public String toString() {
        return this.user.toString();
    }
    
}


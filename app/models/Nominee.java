package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Nominee extends Model {
    
    public User user;
    public Vacancy vacancy;
    
    public Nominee(User user, Vacancy vacancy) {
        this.user = user;
        this.vacancy = vacancy;
    }
    
}


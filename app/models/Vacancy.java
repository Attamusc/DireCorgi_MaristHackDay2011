package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Vacancy extends Model {
    
    @ManyToOne
    public Commitee commitee;
    
    @ManyToOne
    public School school;
    
    public Date nomination_start;
    public Date election_start;
    
    public Vacancy(Commitee commitee, School school, Date nomination_start, Date election_start) {
        this.commitee = commitee;
        this.school = school;
        this.nomination_start = nomination_start;
        this.election_start = election_start;
    }
    
    public String toString() {
        return this.commitee.toString() + " - " + this.commitee.toString();
    }
    
}


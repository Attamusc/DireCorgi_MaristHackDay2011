package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import play.data.validation.*;
import java.util.*;

@Entity
public class VotingSession extends Model {
    @Required
    public Date start_date;
    
    @InFuture
    @Required
    public Date end_date;
    
    @Required
    public String short_name;
    
    
    public VotingSession(String short_name, Date start_date, Date end_date) {
        this.short_name = short_name;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
}


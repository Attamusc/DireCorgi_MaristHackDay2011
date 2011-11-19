package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Commitee extends Model {
    
    public String name;
    public boolean tenureRequired;
    
    public Commitee(String name, boolean tenureRequired) {
        this.name = name;
        this.tenureRequired = tenureRequired;
    }
    
}


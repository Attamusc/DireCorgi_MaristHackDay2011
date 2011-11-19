package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import play.data.validation.*;
import java.util.*;

@Entity
public class School extends Model {
    
    @Required
    public String name;
    
    public School(String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
}


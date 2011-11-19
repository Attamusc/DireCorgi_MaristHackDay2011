package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class School extends Model {
    
    @Required
    public String name;
    
    
    public static void School(String name) {
        this.name = name;
    }
}


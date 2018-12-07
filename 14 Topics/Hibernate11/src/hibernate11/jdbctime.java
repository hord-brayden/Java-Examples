/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package hibernate11;


import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Seagull
 */

@Entity
@Table(name="actor")
public class jdbctime implements Serializable {
    
    @Id
    private int id;
    
    @Column(name="first_name")
    private String first_name;
    
    @Column(name="last_name")
    private String last_name;
    
    public jdbctime(){}
    
    public jdbctime(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author jonsi
 */
public enum Actor implements Serializable{
    
    Father("Bob", "He is bob", new Point(0,0));
    
    private String name;
    private String description;
    private Point coordinates;

    Actor(String name, String description, Point coordinates){
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + '}';
    }

      

}

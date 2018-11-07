/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import java.io.Serializable;

/**
 *
 * @author Brayden
 */
public class Farmer extends Player implements Serializable{

    private int stats[] = {5,7,5,5};
    
    public Farmer() {
        super("OldMcdonald", "Farmer'"); 
        generateInventory(stats);
    }    
    

    public Farmer(String name) {
        super(name, "Farmer");
        generateInventory(stats);
    }
    
    
}

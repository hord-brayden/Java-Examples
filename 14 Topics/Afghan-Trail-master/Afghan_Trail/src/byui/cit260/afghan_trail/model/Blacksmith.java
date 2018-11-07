/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import java.io.Serializable;


/**
 *
 * @author jonsi
 */
public class Blacksmith extends Player implements Serializable{
    
    private int stats[] = {5,5,7,5};

    public Blacksmith() {
        super("Souron", "Blacksmith");
        generateInventory(stats);
    }
    
    public Blacksmith(String name) {
        super(name, "Blacksmith");
        generateInventory(stats);
    }
    

}

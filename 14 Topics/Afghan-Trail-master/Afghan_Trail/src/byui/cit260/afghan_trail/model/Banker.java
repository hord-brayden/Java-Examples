/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import java.io.Serializable;

/**
 *
 * @author rizky
 */
public class Banker extends Player implements Serializable{

    private int stats[] = {5,5,5,5};
    
    public Banker() {
        super("Warren", "Banker");
        generateInventory(stats);
    }

    public Banker(String name) {
        super(name, "Banker");
        generateInventory(stats);
    }
    
}

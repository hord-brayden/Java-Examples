/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import byui.cit260.afghan_trail.model.Player;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonsi
 */
public class BrokenWagonTest {
    
    public BrokenWagonTest() {
    }

    /**
     * Test of brokenWagon method, of class BrokenWagon.
     */
    @Test
    public void testBrokenWagon() {
        //input variables
        Player john = new Player("John", 10, "Farmer");
        john.setStamina(60);
        int wagonParts = 30;
        int progress = 100;
        boolean expResults = true;
        
        System.out.println("\tTest case 1");
        boolean result = BrokenWagon.brokenWagon(john.getStamina(), wagonParts, progress);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 2");
        john.setStamina(4);
        wagonParts = 100;
        expResults = false;
        progress = 100;
        result = BrokenWagon.brokenWagon(john.getStamina(), wagonParts, progress);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 3");
        john.setStamina(100);
        wagonParts = 4;
        expResults = false;
        progress = 100;
        result = BrokenWagon.brokenWagon(john.getStamina(), wagonParts, progress);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 4");
        john.setStamina(61);
        wagonParts = 61;
        expResults = true;
        progress = 61;
        result = BrokenWagon.brokenWagon(john.getStamina(), wagonParts, progress);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 5");
        john.setStamina(60);
        wagonParts = 60;
        expResults = false;
        progress = 60;
        result = BrokenWagon.brokenWagon(john.getStamina(), wagonParts, progress);
        assertEquals(expResults, result);
        
        System.out.println("\tTest case 6");
        john.setStamina(100);
        wagonParts = 100;
        expResults = true;
        progress = 100;
        result = BrokenWagon.brokenWagon(john.getStamina(), wagonParts, progress);
        assertEquals(expResults, result);
        
        //fail("The test case is a prototype.");
    }
    
}

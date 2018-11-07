/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonsi
 */
public class HuntTest {
    
    public HuntTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of tryHunt method, of class Hunt.
     */
    @Test
    public void testTryHunt() {
        
        
        //declare variables for testing
        //initialize variables for first test
        long stamina = 70;
        int chance = 30;
        double price = 4.00;
        BigDecimal priceBD = new BigDecimal(price);
        Item expResults = new Item("Duck", 1, priceBD);
        
        System.out.println("\tTest case 1");
        Item result = Hunt.tryHunt(stamina, chance, price);
        if (result != null)
            System.out.println(result.toString());
        assertEquals(expResults, result);
        System.out.println(!(expResults == result));
        
        System.out.println("\tTest case 2");
        stamina = -10;
        chance = 4;
        price = 6.00;
        priceBD = new BigDecimal(price);
        expResults = null;
        result = Hunt.tryHunt(stamina, chance, price);
        if (result != null)
            System.out.println(result.toString());
        assertEquals(expResults, result);
        System.out.println(!(expResults == result));
        
        System.out.println("\tTest case 3");
        stamina = 20;
        chance = -5;
        price = -1.00;
        priceBD = new BigDecimal(price);
        expResults = null;
        result = Hunt.tryHunt(stamina, chance, price);
        if (result != null)
            System.out.println(result.toString());
        assertEquals(expResults, result);
        System.out.println(!(expResults == result));
        
        System.out.println("\tTest case 4");
        stamina = 45;
        chance = 60;
        price = 3.00;
        priceBD = new BigDecimal(price);
        expResults = new Item("Duck", 2, priceBD);
        result = Hunt.tryHunt(stamina, chance, price);
        if (result != null)
            System.out.println(result.toString());
        assertEquals(expResults, result);
        System.out.println(!(expResults == result));
        
        System.out.println("\tTest case 5");
        stamina = 67;
        chance = 20;
        price = 3.00;
        priceBD = new BigDecimal(price);
        expResults = null;
        result = Hunt.tryHunt(stamina, chance, price);
        if (result != null)
            System.out.println(result.toString());
        assertEquals(expResults, result);
        System.out.println(!(expResults == result));

        System.out.println("\tTest case 6");
        stamina = 0;
        chance = 0;
        price = 3.00;
        priceBD = new BigDecimal(price);
        expResults = null;
        result = Hunt.tryHunt(stamina, chance, price);
        if (result != null)
            System.out.println(result.toString());
        assertEquals(expResults, result);
        System.out.println(!(expResults == result));
        
    }
    
}

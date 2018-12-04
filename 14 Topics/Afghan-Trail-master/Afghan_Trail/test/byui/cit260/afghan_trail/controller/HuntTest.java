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
 In this class, we are using many of the JUnit testing classes and tests. Specifically, by importing the Before, After, 
 and Test features, we are able to simulate the tests remotely from within the controller in this example, and it also 
 provides other functionality such as Setup and tearDown constructors. 
 
 The Junit.After declared in the superclass should run after whatever the current classes tests are, unless there is an
 Override somewhere to call it in.
 
 As opposed to the junit.After import, the .Before class runs before each individual test. This is similar to the 
 .BeforeClass, however the Beforeclass runs only once before the entire test fixture, I have heard some call it. Or it
 can be referred to as running before the entire test series/sequence.
 
 
 
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
        //The duck item is just in place of some of the other animals that can be aquired.
        long stamina = 70;
        int chance = 30;
        double price = 4.00;
        BigDecimal priceBD = new BigDecimal(price);
        Item expResults = new Item("Duck", 1, priceBD);
//Case 1       
        System.out.println("\tTest case 1");
        Item result = Hunt.tryHunt(stamina, chance, price);
        if (result != null)
            System.out.println(result.toString());
        assertEquals(expResults, result);
        System.out.println(!(expResults == result));
//Case 2        
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
//Case 3        
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
//Case 4        
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
//Case 5
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
//Case 6
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

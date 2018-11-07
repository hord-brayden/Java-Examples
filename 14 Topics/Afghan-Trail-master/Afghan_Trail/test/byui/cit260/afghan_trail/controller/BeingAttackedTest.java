/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rizky
 */
public class BeingAttackedTest {
        int bullets;
        int stamina;
        int progression;
        boolean expResult;
        
    public BeingAttackedTest() {
      
      
       
    }

    /**
     * Test of attacked method, of class BeingAttacked.
     */
    @Test
    public void testAttacked() {
        System.out.println("Being Attacked!");
        //Test case 1
        System.out.println("Test case 1");
        //define input variables
        stamina = 80;
        bullets = 20;
        progression = 4;
        expResult = true;
       boolean result = BeingAttacked.attacked(stamina, progression, bullets);
       assertEquals(result, expResult);
       if (result== true) {
           System.out.print("You beat the bad guys!\n");
           if (stamina + 10 <= 100) {
               System.out.print("Your stamina is " + (stamina + 10) + "\n");
           } else {
               System.out.print("Your stamina is 100\n");
           }
           
       } else 
           System.out.print("False\n");
       
       
       
       //Test case 2
        System.out.println("\nTest case 2");
        //define input variables
        stamina = 0;
        bullets = 20;
        progression = 10;
        expResult = false;
        result = BeingAttacked.attacked(stamina, progression, bullets);
       assertEquals(result, expResult);
        if (result== true) {
           System.out.print("You beat the bad guys!\n");
           if (stamina + 10 <= 100) {
               System.out.print("Your stamina is " + (stamina + 10) + "\n");
           } else {
               System.out.print("Your stamina is 100\n");
           }
       } else 
           System.out.print("False\n");
       
       
       //Test case 3
        System.out.println("\nTest case 3");
        //define input variables
        stamina = 80;
        bullets = 0;
        progression = 15;
        expResult = false;
        result = BeingAttacked.attacked(stamina, progression, bullets);
       assertEquals(result, expResult);
       if (result== true) {
           System.out.print("You beat the bad guys!\n");
           if (stamina + 10 <= 100) {
               System.out.print("Your stamina is " + (stamina + 10) + "\n");
           } else {
               System.out.print("Your stamina is 100\n");
           }
       } else 
           System.out.print("False\n");
       

       //Test case 4
        System.out.println("\nTest case 4");
        //define input variables
        stamina = 90;
        bullets = 20;
        progression = 8;
        expResult = true;
        result = BeingAttacked.attacked(stamina, progression, bullets);
        
       assertEquals(result, expResult);
       
       if (result== true) {
           System.out.print("You beat the bad guys!\n");
           if (stamina + 10 <= 100) {
               System.out.print("Your stamina is " + (stamina + 10) + "\n");
           } else {
               System.out.print("Your stamina is 100\n");
           }
       } else 
           System.out.print("False\n");
       
       
       //Test case 5
        System.out.println("\nTest case 5");
        //define input variables
        stamina = 15;
        bullets = 10;
        progression = 16;
        expResult = true;
        result = BeingAttacked.attacked(stamina, progression, bullets);
       assertEquals(result, expResult);
       
       if (result== true) {
           System.out.print("You beat the bad guys!\n");
           if (stamina + 10 <= 100) {
               System.out.print("Your stamina is " + (stamina + 10) + "\n");
           } else {
               System.out.print("Your stamina is 100\n");
           }
       } else 
           System.out.print("False\n");
       
       
        //Test case 6
        System.out.println("\nTest case 6");
        //define input variables
        stamina = 100;
        bullets = 100;
        progression = 9;
        expResult = true;
        result = BeingAttacked.attacked(stamina, progression, bullets);
       assertEquals(result, expResult);
       
       if (result== true) {
           System.out.print("You beat the bad guys!\n");
           if (stamina + 10 <= 100) {
               System.out.print("Your stamina is " + (stamina + 10) + "\n");
           } else {
               System.out.print("Your stamina is 100\n");
           }
       } else 
           System.out.print("False\n");
       
    }
    
}
 //Player player = null;
        //BeingAttacked.attacked(player, stamina, bullets);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
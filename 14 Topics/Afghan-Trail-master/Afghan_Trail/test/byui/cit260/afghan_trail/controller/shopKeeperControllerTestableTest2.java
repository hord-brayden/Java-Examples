/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import byui.cit260.afghan_trail.model.Blacksmith;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonsi
 */
public class shopKeeperControllerTestableTest2 {
    
    public shopKeeperControllerTestableTest2() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   
    
    @Test
    public void testSellTest() {
         int userInput;
        //Test case 1
        ArrayList<String> items = new ArrayList<String>();
        items.add("Meat-$2");
        items.add("Pork-$3");
        items.add("Advil-$1");
        items.add("Coca cola-$1");
        items.add("Wheel-$5");
        items.add("Saddle-$5");
        items.add("Bullet 4mm-$2");
        items.add("Bullet 5mm-$2");
        System.out.print("\nTest Case 1\n");
        userInput = 6;
        double sellerMoney = 100;
        boolean expResult = true;
        boolean result = shopKeeperControllerTestable.sellTest(sellerMoney, userInput, items);
        assertEquals(expResult, result);
        System.out.print("\nResult is : " + result);
        if (userInput > items.size()) {
            System.out.print("\n Invalid input! Please select an item number!");
        }
        if (sellerMoney < 0){
            System.out.print("\n I don't have any money!");
        }
        
        //Test case 2
        new ArrayList<String>();        
       
        System.out.print("\n\nTest Case 2\n");
              
        userInput = 1;
        sellerMoney = -1;
        expResult = false;
        
        result = shopKeeperControllerTestable.sellTest(sellerMoney, userInput, items);
        assertEquals(expResult, result);
        System.out.print("\nResult is : " + result);
        if (userInput > items.size()) {
            System.out.print("\n Invalid input! Please select an item number!");
        }
        if (sellerMoney < 0){
            System.out.print("\n I don't have any money!");
        }
        
        
        //Test case 3
        new ArrayList<String>();        
        
        System.out.print("\n\nTest Case 3\n");
              
        userInput = 10;
        sellerMoney = 25;
        expResult = false;
        result = shopKeeperControllerTestable.sellTest(sellerMoney, userInput, items);
        assertEquals(expResult, result);
        System.out.print("\nResult is : " + result);
        if (userInput > items.size()) {
            System.out.print("\n Invalid input! Please select an item number!");
        }
        if (sellerMoney < 0){
            System.out.print("\n I don't have any money!");
        }
        //Test case 4
        System.out.print("\n\nTest Case 4\n");
        new ArrayList<String>();
        
        items.remove(7);items.remove(6);items.remove(5);items.remove(4);items.remove(3);items.remove(2);items.remove(1);
      
        userInput = 1;
        sellerMoney = 50;
        expResult = true;
        result = shopKeeperControllerTestable.sellTest(sellerMoney, userInput, items);
        assertEquals(expResult, result);
        System.out.print("\nResult is : " + result);
        if (userInput > items.size()) {
            System.out.print("\n Invalid input! Please select an item number!");
        }
        if (sellerMoney < 0){
            System.out.print("\n I don't have any money!");
        }
        
        //Test case 5
        System.out.print("\n\nTest Case 5\n");
        new ArrayList<String>();
        
        items.add("Pork-$3");
        items.add("Advil-$1");
        items.add("Coca cola-$1");
        items.add("Wheel-$5");
        items.add("Saddle-$5");
        items.add("Bullet 4mm-$2");
        items.add("Bullet 5mm-$2");
        userInput = 1;
        sellerMoney = 5;
        expResult = true;
        result = shopKeeperControllerTestable.sellTest(sellerMoney, userInput, items);
        assertEquals(expResult, result);
        System.out.print("\nResult is : " + result);
        if (userInput > items.size()) {
            System.out.print("\n Invalid input! Please select an item number!");
        }
        if (sellerMoney < 0){
            System.out.print("\n I don't have any money!");
        }
        
         //Test case 6
        System.out.print("\n\nTest Case 6\n");
        new ArrayList<String>();
        
        userInput = 8;
        sellerMoney = 75;
        expResult = true;
        result = shopKeeperControllerTestable.sellTest(sellerMoney, userInput, items);
        assertEquals(expResult, result);
        System.out.print("\nResult is : " + result);
        if (userInput > items.size()) {
            System.out.print("\n Invalid input! Please select an item number!");
        }
        if (sellerMoney < 0){
            System.out.print("\n I don't have any money!");
        }
    }
    


   
}

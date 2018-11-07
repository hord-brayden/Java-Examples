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
public class shopKeeperControllerTestableTest {
    
    public shopKeeperControllerTestableTest() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   
    /**
     * Test of buy method, of class shopKeeperControllerTestable.
     */
    @Test
    public void testBuy() {
        
        //Set up test variables
        Player player = new Blacksmith();
        BigDecimal money = new BigDecimal(75.00);
        player.setMoney(money);
        ShopKeeper shopKeeper = new ShopKeeper();
        ArrayList<Item> shopKeeperItems = new ArrayList<>();
        shopKeeperItems = shopKeeper.getPlayerInventory().getInventoryItems();
        System.out.print("shopKeeper.size(): " + shopKeeper.getPlayerInventory().getInventoryItems().size() + "\n");
        
        //sort shopkeeper items
            //sort items by price
            int len = shopKeeperItems.size();
            int rightVar; 
            for (int out = len; out >= 0; out--){
                for (int i = 0; i < len - 1; i++){
                    rightVar = i + 1;
                    double left = shopKeeperItems.get(i).getPrice().doubleValue();
                    double right = shopKeeperItems.get(rightVar).getPrice().doubleValue();
                    if (left < right){
                        Item temp;
                        temp = shopKeeperItems.get(i);
                        shopKeeperItems.set(i, shopKeeperItems.get(rightVar));
                        shopKeeperItems.set(rightVar, temp);
                    }
                }
            }
            
         
        
        //user input fakes
        int intFirst;
        char charFirst = 'a';
        boolean firstIsInt = true;
        
       
        
        /*
            COPY THESE TWO BLOCKS FOR EACH TEST TO BE ABLE TO BUILD STRING
        
        */
        //copy this to get current invetory string
        String keeperInvString = "";
        keeperInvString += "Let's take a look at the Shop Keepers inventory\n\n";
        int itemNum = 1;
        for (Item item : shopKeeperItems){  
            keeperInvString += itemNum + ": " +
            item.getDisplayString();
            itemNum++;
        };
        keeperInvString += itemNum + ": Exit\n\n";
        
        //copy this to get prompt string
        String promptString = ""; 
        promptString += "What item would you like to buy?\n" + 
                player.getName() + ": $";
        promptString += String.format("%.2f", player.getMoney());
        promptString += "\nShop Keeper: $";
        promptString += String.format("%.2f", shopKeeper.getMoney());
        promptString += "\nEnter number of the item you want to buy.\n";
        
        String compareString = keeperInvString + promptString +
                "Okay, come back soon\n";
        /*
        
        
            REPEAT THE ABOVE FOR EACH TEST CASE
        */
        
        
        //test 1
        intFirst = 9;
        firstIsInt = true;
        String outputString = shopKeeperControllerTestable.buy(player, shopKeeper, intFirst, charFirst, firstIsInt);
//        System.out.print("shopKeeper.size(): " + shopKeeper.getPlayerInventory().getInventoryItems().size() + "\n");
//        System.out.print("CompareString:\n" + compareString + "\n");
//        System.out.print("outputString:\n" + outputString + "\n");
        assertEquals(compareString, outputString);
        System.out.print("TestResult: " + !(compareString == outputString) + "\n");
        
        /*
            COPY THESE TWO BLOCKS FOR EACH TEST TO BE ABLE TO BUILD STRING
        
        */
        //copy this to get current invetory string
        
        keeperInvString = "";
        keeperInvString += "Let's take a look at the Shop Keepers inventory\n\n";
        itemNum = 1;
        for (Item item : shopKeeperItems){  
            keeperInvString += itemNum + ": " +
            item.getDisplayString();
            itemNum++;
        };
        keeperInvString += itemNum + ": Exit\n\n";
        
        //copy this to get prompt string
        promptString = ""; 
        promptString += "What item would you like to buy?\n" + 
                player.getName() + ": $";
        promptString += String.format("%.2f", player.getMoney());
        promptString += "\nShop Keeper: $";
        promptString += String.format("%.2f", shopKeeper.getMoney());
        promptString += "\nEnter number of the item you want to buy.\n";
        
        compareString = keeperInvString + promptString +
                "Okay, come back soon\n"; 
        System.out.print(compareString);
        
        /*
        
        
            REPEAT THE ABOVE FOR EACH TEST CASE
        */
        
        //test 2
        
        intFirst = 0;
        firstIsInt = true;
        outputString = shopKeeperControllerTestable.buy(player, shopKeeper, intFirst, charFirst, firstIsInt);
        System.out.print("shopKeeper.size(): " + shopKeeper.getPlayerInventory().getInventoryItems().size() + "\n");
        System.out.print("CompareString:\n" + compareString + "\n");
        System.out.print("outputString:\n" + outputString + "\n");
        assertEquals(compareString, outputString);
        System.out.print("TestResult" + (compareString == outputString));       
        
    }

    /**
     * Test of sell method, of class shopKeeperControllerTestable.
     */
    @Test
    public void testSell() {
        System.out.println("sell");
        Player player = null;
        ShopKeeper shopKeeper = null;
        shopKeeperControllerTestable.sell(player, shopKeeper);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rob method, of class shopKeeperControllerTestable.
     */
    @Test
    public void testRob() {
        System.out.println("rob");
        Player player = null;
        ShopKeeper shopKeeper = null;
        shopKeeperControllerTestable.rob(player, shopKeeper);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeItem method, of class shopKeeperControllerTestable.
     */
    @Test
    public void testTakeItem() {
        System.out.println("takeItem");
        Player player = null;
        ShopKeeper shopKeeper = null;
        shopKeeperControllerTestable.takeItem(player, shopKeeper);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sellTest method, of class shopKeeperControllerTestable.
     */
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

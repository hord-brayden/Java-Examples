/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.exceptions.shopKeeperControllerException;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rizky
 */
public class shopKeeperController {
        public static String jailed = "  _____                                                              _                _   _   _ \n" +
" |_   _|                                                            | |              | | | | | |\n" +
"   | |    _ __     ___    __ _   _ __    ___    ___   _ __    __ _  | |_    ___    __| | | | | |\n" +
"   | |   | '_ \\   / __|  / _` | | '__|  / __|  / _ \\ | '__|  / _` | | __|  / _ \\  / _` | | | | |\n" +
"  _| |_  | | | | | (__  | (_| | | |    | (__  |  __/ | |    | (_| | | |_  |  __/ | (_| | |_| |_|\n" +
" |_____| |_| |_|  \\___|  \\__,_| |_|     \\___|  \\___| |_|     \\__,_|  \\__|  \\___|  \\__,_| (_) (_)\n" +
"                                                                                                \n" +
"                                                                                                \n";
    
    /*
        The buy method will return false if the loop is to stop
        Otherwise it will return true
        
    */
    public static boolean buy(Player player, ShopKeeper shopKeeper) throws shopKeeperControllerException {
        
        // getting variables set up
        Inventory playerInv = player.getPlayerInventory();
        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> shopKeeperItems = shopKeeperInv.getInventoryItems();
        PrintWriter outFile = Afghan_Trail.getOutFile();
        
        // return false if the shop keeper is out of items
        if (shopKeeperItems.size() <= 0){
            outFile.print("Shopkeeper doesn't have any items\n\n");
            return false;
            
        // sort the shop keeper items by price
        } else {
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
        }
        
        // print shopkeeper items
        outFile.print("Let's take a look at the Shop Keepers inventory\n\n");
        int itemNum = 1;
        for (Item item : shopKeeperItems){  
            outFile.printf("%-4s", Integer.toString(itemNum) + ": ");
            item.display();
            itemNum++;
        } 
        outFile.printf("%-4s", Integer.toString(itemNum) + ": ");
        outFile.print("Exit\n\n");
        int exitInt = itemNum;
           
        // prompt the user for an item number
        outFile.printf("%-15s %1s %.2f %n", 
                player.getName() + ":",
                "$",
                player.getMoney());
        outFile.printf("%-15s %1s %.2f %n",
                "Shop Keeper:", 
                "$",
                shopKeeper.getMoney());
        outFile.printf("Select the item you want to buy\n");
        outFile.printf("Item number: ");
        

        // get the users choice
        int userChoice = getUserInput();

        // set the item according to the users choice
        // if the choice was out of range the item will be null
        Item userItem = null;
        for (int i = 0; i < shopKeeperItems.size(); i++){
            if ((userChoice - 1) == i){
                userItem = shopKeeperItems.get(i);
            }
        }

        // check that the users choice was in range
        if (userChoice <= shopKeeperItems.size() && userChoice > 0){
            
            // make sure user has enough money
            double playerMoney = player.getMoney().doubleValue();
            if (playerMoney < userItem.getPrice().doubleValue()){
                throw new shopKeeperControllerException("You don't have enough money!\n");
            }
        }
        
        // if the choice was out of range and not exit, throw an error
        else if (userChoice != exitInt){
            String err = "\n\nINVALID INPUT, please select an item number " +
                    "between 1 - " + shopKeeperItems.size() + "\n" +
                    "or choose " + exitInt + " to exit\n";
            throw new shopKeeperControllerException(err);
        } 
        
        // if the user choose to exit, leave the store
        else {
            outFile.print("\nOkay, come back soon\n\n");
            return false; 
        }
            
        // update player money
        double itemPrice = userItem.getPrice().doubleValue();
        double playerMoney = player.getMoney().doubleValue();
        BigDecimal newPlayerMoney = new BigDecimal(playerMoney - itemPrice);
        player.setMoney(newPlayerMoney);
        
        // update shopkeeper money
        double shopKeeperMoney = shopKeeper.getMoney().doubleValue();
        BigDecimal newShopKeeperMoney = new BigDecimal(shopKeeperMoney + itemPrice);
        shopKeeper.setMoney(newShopKeeperMoney);
        
        // update user and shopkeeper inventory
        shopKeeperItems.remove(userItem);
        shopKeeper.getPlayerInventory().setInventoryItems(shopKeeperItems);
        playerInv.addNewItem(userItem);
        
        // display a purchase summary to the screen
        outFile.print("\n\nYou bought: ");
        userItem.display();
        outFile.print("\n");
        return true;
    }
    
    public static boolean sell(Player player, ShopKeeper shopKeeper) 
            throws shopKeeperControllerException {
        
        //inventories
        Inventory playerInv = player.getPlayerInventory();
        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> playerItems = playerInv.getInventoryItems();
        PrintWriter outFile = Afghan_Trail.getOutFile();

        if (playerItems.size() <= 0){
            outFile.print("You don't have any items\n");
            return false;
        } else {
            //sort items by price
            int len = playerItems.size();
            int rightVar; 
            for (int out = len; out >= 0; out--){
                for (int i = 0; i < len - 1; i++){
                    rightVar = i + 1;
                    double left = playerItems.get(i).getPrice().doubleValue();
                    double right = playerItems.get(rightVar).getPrice().doubleValue();
                    if (left < right){
                        Item temp;
                        temp = playerItems.get(i);
                        playerItems.set(i, playerItems.get(rightVar));
                        playerItems.set(rightVar, temp);
                    }
                }
            }
        }

        //print shopkeeper items
        outFile.print("Let's take a look at your inventory\n\n");
        int itemNum = 1;
        for (Item item : playerItems){  
            outFile.printf("%-4s", Integer.toString(itemNum) + ": ");
            item.display();
            itemNum++;
        } 
        outFile.printf("%-4s", Integer.toString(itemNum) + ": ");
        outFile.print("Exit\n\n");
        int exitInt = itemNum;

        
        // prompt the user for an item number
        outFile.printf("%-15s %1s %.2f %n", 
                player.getName() + ":",
                "$",
                player.getMoney());
        outFile.printf("%-15s %1s %.2f %n",
                "Shop Keeper:", 
                "$",
                shopKeeper.getMoney());
        outFile.printf("What item would you like to sell?\n");
        outFile.printf("Item number: ");

        //get userChoice
        int userChoice = getUserInput(); 

        Item userItem = null;
        for (int i = 0; i < playerItems.size(); i++){
            if ((userChoice - 1) == i){
                userItem = playerItems.get(i);
            }
        }

        //validate range
        if (userChoice <= playerItems.size() && userChoice > 0){
            //make sure user has enough money
            double shopKeeperMoney = shopKeeper.getMoney().doubleValue();
            if (shopKeeperMoney < userItem.getPrice().doubleValue()){
                throw new shopKeeperControllerException("The shop keeper is out of money!\n");
            }
        }   
        else if (userChoice != exitInt){
            String err = "\n\nINVALID INPUT, please select an item number " +
                    "between 1 - " + playerItems.size() + "\n";
            throw new shopKeeperControllerException(err);
        } else {
            outFile.print("Okay, come back soon\n\n");
            return false; 
        }
        

        //make adjustments to shopkeeper and player  
        double itemPrice = userItem.getPrice().doubleValue();
        
        //update player money
        double playerMoney = player.getMoney().doubleValue();
        BigDecimal newPlayerMoney = new BigDecimal(playerMoney + itemPrice);
        player.setMoney(newPlayerMoney);
        
        //update shopkeeper money
        double shopKeeperMoney = shopKeeper.getMoney().doubleValue();
        BigDecimal newShopKeeperMoney = new BigDecimal(shopKeeperMoney - itemPrice);
        shopKeeper.setMoney(newShopKeeperMoney);
        
        //update inventories
        playerItems.remove(userItem);
        shopKeeperInv.addNewItem(userItem);
        
        //display something to the screen
        outFile.print("\n\nYou sold: ");
        userItem.display();
        outFile.print("\n");        
        return true;
    }
    
    public static boolean rob(Player player, ShopKeeper shopKeeper) throws shopKeeperControllerException, Throwable {

        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> shopKeeperItems = shopKeeperInv.getInventoryItems();
        PrintWriter outFile = Afghan_Trail.getOutFile();
        
        outFile.printf("How many items do you think you can take? 1-5\n");
        int userChoice = getUserInput();
        if (shopKeeperItems.size() == 0){
            outFile.print("\nShop Keeper is all out of items\n");
            return false;
        } else if(userChoice > 5 || userChoice <= 0) {
            throw new shopKeeperControllerException("Please enter a valid number, between 1 - 5\n");
        } else{
            runRisk(player, shopKeeper, userChoice);
            if (player.isIsDead() || shopKeeperItems.size() == 0){
                if (shopKeeperItems.size() == 0)
                    outFile.println("Shopkeeper is out of items");
                return false;
            } else {
                outFile.println("\n\nDo you want to keep taking things? Y\\N");
                char userChar = getUserChar();
                if (userChar == 'y')
                    return true;
                else
                    return false;
            }
        }
    }
 
    private static void robSuccess(Player player, ShopKeeper shopKeeper, int items){
        
        // get variables
        Inventory playerInv = player.getPlayerInventory();
        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> shopKeeperItems = shopKeeperInv.getInventoryItems();
        PrintWriter outFile = Afghan_Trail.getOutFile();
        
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

        
        ArrayList<Item> splendor = new ArrayList<Item>();
            
        //pass items to player
        for (int i = 0; i < items; i++){
            if (shopKeeperItems.size() > i){
                Item item = shopKeeperItems.get(i);
                playerInv.addNewItem(item);
                shopKeeperInv.removeItem(item);
                splendor.add(item);
            } else {
                outFile.println("Shop keeper is out of items\n");
                break;
            }
        }
        
        //display splendor
        outFile.println("You got:");
        for (Item item : splendor){
            item.display();
        }
        outFile.println('\n');
    } 
    
    private static void runRisk(Player player, ShopKeeper shopKeeper, int risk){
        int rand = (int) Math.ceil(Math.random() * 10);
        
        if (rand < risk){
            player.setIsDead(true);
            Afghan_Trail.getOutFile().print(jailed); 
        }
        else{
            robSuccess(player, shopKeeper, risk); 
        }
    }
    
    private static int getUserInput() throws NumberFormatException {
        String inputString = null;
        int userChoice = 0;
        try {
            inputString = Afghan_Trail.getInFile().readLine();
            userChoice = Integer.parseInt(inputString);
        } catch (Exception e){
            Afghan_Trail.getOutFile().print("Error reading input: " + e.getMessage());
        }
        return userChoice;
    }
    
    private static char getUserChar() throws Throwable {
        char userChoice = '\u0000'; //userChoice == 0 -> returns true
        try {
            do {
                userChoice = Afghan_Trail.getInFile().readLine().charAt(0);
                userChoice = Character.toLowerCase(userChoice);
            } while (userChoice != 'y' && userChoice != 'n');
        } catch (Exception e){
            Afghan_Trail.getOutFile().print("Error reading input: " + e.getMessage());
        }
        return userChoice;
    }
}
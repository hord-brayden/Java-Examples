/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.controller.shopKeeperController;
import byui.cit260.afghan_trail.exceptions.shopKeeperControllerException;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import byui.cit260.afghan_trail.view.EnterTownView;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizky
 */
public class ShopKeeperView extends BasicView{
    
    private ShopKeeper shopKeeper = new ShopKeeper();
    
    public ShopKeeperView() {
        super();
        char keys[] = {'B','S','R','P','V','H','E'};
        String[] options = {
           "Buy",
           "Sell",
           "Rob",
           "View Player Inventory",
           "View Shopkeeper Inventory",
           "Shopkeeper Help",
           "Exit Store"
        };
        String message = "Shopkeeper Menu";       
        setOptions(options);
        setMessage(message);
        setKeys(keys);
    }
    
    public ShopKeeperView(String options[], String message){
        super(options, message);
    }
    
    public ShopKeeperView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    public void setShopKeeper(ShopKeeper shopKeeper){
        this.shopKeeper = shopKeeper;
    }
    
    public ShopKeeper getShopKeeper(){
        return shopKeeper;
    }
    
    @Override
    public void displayHelp(){
        this.console.println("This is the shopkeeper! \n"
                + "Here you can buy and sell goods for money\n"
                + "Money can buy you different kinds of goods if you like\n"
                + "\n"
                + "Also, the shopkeeper is placed within a town where you\n"
                + "can save your game is you so desire. Additionally, the\n"
                + "shopkeeper's inventory can be displayed by selecting the\n"
                + "correct menu item from the output! Enjoy your stay!\n"
                + "\n");
    }
    
    @Override
    public void display(Game game) {
        
        //hacky way of customizing the view player inv op
        options[3] = "View " + game.getPlayer().getName() + " Inventory";
        int opLen = options.length;
        char lastKeyChar = keys[opLen - 1];  //exit
        char robChar = keys[2];              //rob
        lastKeyChar = Character.toUpperCase(lastKeyChar);
        robChar = Character.toUpperCase(robChar);
        char userInput = lastKeyChar;
        do {
            this.console.println(message + '\n');
            userInput = getUserChar(options);
            doAction(options, userInput, game);
        } while (userInput != lastKeyChar && 
                 userInput != robChar);
    }
    
    @Override
    public void doAction(String[] options, 
                         char action, 
                         Game game)
    {
        int actionInt = getFunctionNumberFromChar(action);
        boolean resume = true;
        switch (actionInt){
            
            // Buy
            case 0:
                
                this.console.print("You chose '" + options[0] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.buy(game.getPlayer(), shopKeeper);
                    } catch (shopKeeperControllerException e ) {
                        ErrorView.display(this.getClass().getName(),
                                e.getMessage());
                    } catch (NumberFormatException nf){
                        ErrorView.display(this.getClass().getName(),
                                nf.getCause() + " is not a member\n");
                    }
                } while (resume);
                break;
             
            // Sell  
            case 1:
                
                this.console.print("You chose '" + options[1] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.sell(game.getPlayer(), shopKeeper);
                    } catch (shopKeeperControllerException e) {
                        ErrorView.display(this.getClass().getName(),
                                e.getMessage());
                    }
                } while (resume);
                break;
             
            // Rob
            case 2:
                
                this.console.print("You chose '" + options[2] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.rob(game.getPlayer(), shopKeeper);
                    } catch (shopKeeperControllerException e) {
                        ErrorView.display(this.getClass().getName(), 
                                e.getMessage());
                    } catch (Throwable e) {
                        ErrorView.display(this.getClass().getName(),
                                "Please enter a valid number between 1 & 5\n");
                    } 
                } while (resume);
                break;
                
            // View Player Inventory    
            case 3:
                
                this.console.print("You chose '" + options[3] + "'\n");
                String[] sortOptions = {
                    "alphabetical",    // B
                    "categorical",     // S
                    "price Ascending", // R
                    "price Descending" // P
                };
                this.console.println("How would you like to sort?");
                char userChar = getUserChar(sortOptions);
                int sortCode = getFunctionNumberFromChar(userChar);
                game.getPlayer().showInventory(sortCode);
                break;
                
            // View Shop Keeper
            case 4:
                this.console.print("You chose '" + options[4] + "'\n");
                shopKeeper.showInventory();
                break;
            
            // Shopkeeper Help
            case 5:
                displayHelp();
                
                
            // Case 5 is Exit, handled in loop in display
        }
    }    
}

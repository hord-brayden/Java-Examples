/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.exceptions.BrokenWagonException;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.view.BasicView;
import byui.cit260.afghan_trail.model.Player;
import java.lang.Math;

/**
 *
 * @author rizky
 */
public class BrokenWagon {

    public static String fix(Player player) throws BrokenWagonException {
        String outcome = "";
        
        //first check if player even has parts
        boolean hasParts = player.getPlayerInventory().hasItemType("Parts");
        if (!hasParts){
            throw new BrokenWagonException("Oh no! You don't have parts!\n");
        }
        
        //otherwise calculate the odds of the fix working
        double staminaChance = player.getStamina() * 0.8;
        double chance = 20 + staminaChance;  
        String numStr = Double.toString(Math.ceil(Math.random() * 100));
        double num = Double.parseDouble(numStr);
        num = (int) Math.ceil(Math.random() * 100);
        num = 100;
        boolean isSuccessful = (num > chance);

        if (isSuccessful){

            int rand = (int) Math.ceil(Math.random() * 2);

            if (rand == 1){
                //wagon fixed
                outcome += "Your wagon is fixed\n";
                player.setIsWagonBroken(false);
                if (player.getStamina() - 5 < 0)
                    player.setStamina(0);
                else
                    player.setStamina(player.getStamina() - 5);
            } else {
                
                //wagon upgraded
                outcome += "Your wagon has been upgraded\n";
                player.setSpeed(player.getSpeed() + 1);
                
                //display speed
                outcome += "" +
                        "You're speed is up to " + 
                        player.getAdjustedSpeed()+"\n";
                
                player.setStamina(player.getStamina() - 5);
            }
        

            Item removedItem = player.getPlayerInventory().removeItemOfType("Parts");
            outcome += "Removed " + removedItem.getName() + 
            " from player inventory\n"; 
                
        } else {
            outcome += "You failed to fix your wagon\n";
            outcome += noRepair(player);
        }
        return outcome;
    }
    
    public static String ignore(Player player) throws BrokenWagonException {
        String outcome = "You don't wanna fix your wagon?\n";
        outcome += noRepair(player);
        return outcome;
    }
    
    public static String rest(Player player) throws BrokenWagonException {
        String outcome = "You don't wanna fix your wagon?\n";
        outcome += noRepair(player);
        return outcome;
    }
    
    private static String noRepair(Player player) throws BrokenWagonException {
        player.setIsWagonBroken(true);
        String speedStr = Integer.toString(player.getAdjustedSpeed());
        int speed = Integer.parseInt(speedStr);
        String outcome = "You're speed is down to " + speed + "\n";
        return outcome;
    }
    
    public static boolean brokenWagon(
            long stamina, 
            int wagonParts, 
            int progress) 
    {
        //if they don't have enough parts return false
        
        if (wagonParts > 5 && stamina > 5)
        {
            double baseChance = 0.1;
            double staminaChance = stamina * baseChance;
            double wagonChance = wagonParts * baseChance;
            double progressChance = progress * baseChance;
            double total = staminaChance + wagonChance + progressChance;
            double average = total / 3;
            if (average > 6)
                return true;   
        }
        return false;
    }

}

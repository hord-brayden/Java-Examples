/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.exceptions.BeingAttackedException;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public class BeingAttacked {
    
    public static String helpMsg = "Attack to defend yourself";
    
    public static String fightBack(Player player) throws BeingAttackedException {
        String outcome = "";
        
        //chance logic
        long stamina = player.getStamina();
        if (stamina > 100 || stamina < 0)
            throw new BeingAttackedException("Invalid Stamina");
        
        
        double staminaChance = stamina * 0.6;
        double chance = 20 + staminaChance;
        String numStr = Double.toString(Math.ceil(Math.random() * 100));
        double num = Double.parseDouble(numStr);
        boolean isSuccessful = (num > chance);

        if (isSuccessful){
            outcome += "You beat the bad guys!\n";
            player.setStamina(player.getStamina() + 10);
            outcome += "Your stamina is " +
            player.getStamina() + "\n";
        } else {
            outcome += loseFight(player, 5);
        }
        return outcome;
    }
    
    public static String runAway(Player player) throws BeingAttackedException {
        String outcome = "You are attempting to run away...";

        long stamina = player.getStamina();
        if (stamina > 100 || stamina < 0)
            throw new BeingAttackedException("Invalid Stamina");
        
        //chance logic
        double staminaChance = stamina * 0.7;
        double chance = 20 + staminaChance;
        int num = (int) Math.ceil(Math.random() * 100);
        boolean isSuccessful = (num > chance);
        
        if (isSuccessful){
            outcome += "You out ran them!\n" + 
                    "Better catch your breath\n";
            player.setStamina(player.getStamina() - 10);
            outcome += "Your stamina is " +
            player.getStamina() + "\n";
        } else {
            outcome += "You couldn't quite ditch 'em\n";
            outcome += loseFight(player, 5);
        }
        return outcome;
    }
    
    public static String beg(Player player) throws BeingAttackedException {
        String outcome = "You start begging for your life...";

        long stamina = player.getStamina();
        if (stamina > 100 || stamina < 0)
            throw new BeingAttackedException("Invalid Stamina");
        
        //chance logic
        double staminaChance = stamina * 0.7;
        double chance = 20 + staminaChance;
        int num = (int) Math.ceil(Math.random() * 100);
        boolean isSuccessful = (num > chance);
        
        if (isSuccessful){
            outcome += "Somehow it worked!\n" + 
                    "The only thing you lost is a little pride\n";
        } else {
            outcome += "The thugs aren't feeling merciful today\n";
            outcome += loseFight(player, 6);
        }
        return outcome;
    }
    
    
    
    private static String loseFight(Player player, int deductionDegree){
        String outcome = "You have been beaten and robbed\n";
        
        //take 1-deductionDegree out items out of player inventory
        int num = (int) Math.ceil(Math.random() * deductionDegree);
        for (int i = 0; i < num; i++){
            Inventory playerInv = player.getPlayerInventory();
            Item removedItem = playerInv.removeRandomItem();
            if (removedItem != null){
                outcome += "Removed " + removedItem.getName() + 
                        " from player inventory\n";   
            } else {
                outcome += "Inventory is Empty\n";
                return outcome;
            }
        }
        //reduce thier stamina by 5
        if (player.getStamina() - 5 < 0)
            player.setStamina(0);
        else
            player.setStamina(player.getStamina() - 5);
        return outcome;
    }

    //for class testing
   public static boolean attacked(int stamina, int progression, int bullets) {
       if (stamina > 5 && bullets > 5) {
           if (progression % 5 != 0) {
                double staminaChance = stamina * 0.6;
                double chance = 20 + staminaChance;
                int num = 90;
                boolean isSuccessful = (num > chance);
                return isSuccessful;
           }
           else 
               return false;
       } else 
           return false;
   }
}
   



   

            
       
   
 
  

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.exceptions.DiseaseContractionException;
import byui.cit260.afghan_trail.model.Player;
import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author Brayden
 */
public class DiseaseContraction {
    
    public static String takeMedicine(Player player) throws DiseaseContractionException {
        String outcome = "";
        
        //first check if player even has parts
        boolean hasMedicine = player.getPlayerInventory().hasItemType("Medicine");
        if (!hasMedicine){
            noHealing(player);
            throw new DiseaseContractionException("Oh no! You don't have any medicine!\n");
        }
        else {

            //Logic for calculating Medicine Bonus to your stamina, + Random INT
            //Also uses a large bonus modifier if you have a lot of medicine stocked up
            String healChanceStr = Double.toString(player.getStamina() * 0.5);
            double healChance = Double.parseDouble(healChanceStr);
            double healBonus = 1; // player.item.medicine * 10 
            double chanceToHeal = healBonus * healChance;            
            int num = (int) Math.ceil(Math.random() * 100);
            boolean isSuccessful = (num > chanceToHeal);

            if (isSuccessful){    
                //Sickness Cured, you recieve a bonus stamina boost for curing your illness
                outcome += "You are feeling better!\n";
                player.setIsSick(false);
                player.setStamina(player.getStamina() + 10);
            } 
            else {
                noHealing(player);
                outcome += "The medicine didn't really help\n";
            }

            //This also exhausts medcine supply
            player.getPlayerInventory().removeItemOfType("Medicine");
        }
        return outcome;
    }

    public static String ignore(Player player) {
        noHealing(player);
        return "Just going to ignore that you are sick then...okay\n";
    }

    public static String rest(Player player){
        noHealing(player);
        return "I guess you are going to rest and still be sick\n";
    }
    
    private static void noHealing(Player player){
        player.setIsSick(true);
    }


    
}

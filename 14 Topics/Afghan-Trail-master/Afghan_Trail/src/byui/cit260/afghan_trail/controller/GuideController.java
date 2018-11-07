/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.view.ErrorView;

/**
 *
 * @author jonsi
 */
public class GuideController {
    
    public static void showGoal(){
        
        Afghan_Trail.getOutFile().print("You are a refugee fleeing from the Al Qaeda"
                + "\nextremists in Southern Afghanistan! In this journey you'll"
                + "\nneed to procure goods, and make a journey throughout the"
                + "\ncountryside of Afghanistan. You will meet local shopkeepers"
                + "\nflee from the Taliban, brigands, and also fend off"
                + "\nmicro-biological attackers! This action packed text-based"
                + "\ngame will have you sitting on the edge of your seat as you"
                + "\nmake your way towards the southern border of the more"
                + "\ncivilized and policed country of Iran. As a refugee,"
                + "\nyou'll need to avoid conflict from NATO forces and their"
                + "\nquestioning, in addition to circumventing some of the"
                + "\nlargest provinces in Afghanistan!"
                + "\nGood luck, and always remember "
                + "\n\t- 'Allah Akbar!!' !\n");
    }
    
    public static void showStart(){
        Afghan_Trail.getOutFile().print("Start Game - Start Game on the main menu will\n" + 
                "start a new game.\n");
    }
    
    public static void showLoad(){
        Afghan_Trail.getOutFile().print("Load Game - Load Game on the main menu will allow\n" +
                "you to load a previously saved game.\n");
    } 
    
    public static void showExit(){
        Afghan_Trail.getOutFile().print("Exit - Exit on the main menu will exit the game\n");
    } 
}

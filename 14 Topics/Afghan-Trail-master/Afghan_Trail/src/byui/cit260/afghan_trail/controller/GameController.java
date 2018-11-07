/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.afghan_trail.controller;
import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.exceptions.BrokenWagonException;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.view.BeingAttackedView;
import byui.cit260.afghan_trail.view.BrokenWagonView;
import byui.cit260.afghan_trail.view.DiseaseContractionView;
import byui.cit260.afghan_trail.view.HuntView;
import java.io.Serializable;
import byui.cit260.afghan_trail.view.EnterTownView;
import byui.cit260.afghan_trail.view.NewGameView;
import byui.cit260.afghan_trail.exceptions.GameControllerException;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.view.GameMenuView;
import byui.cit260.afghan_trail.view.LoadGameView;
import byui.cit260.afghan_trail.view.SaveGameView;
import java.util.ArrayList;

/**
 *
 * @author jonsi
 */
public class GameController implements Serializable{

    public static void generateEvent(Game game) throws GameControllerException, BrokenWagonException{
       
        //get random on event
        int numOfEvents = 5;
        int eventId = (int) Math.ceil(Math.random() * numOfEvents);
        String message;
        //to debug change eventId
        //eventId = 3;

        switch(eventId){
            case 1:
                
                // Being Attacked
                BeingAttackedView beingAttackedView = new BeingAttackedView();
                beingAttackedView.display(game);
                
            break;
            case 2:
                
                // Hunt
                HuntView huntView = new HuntView();
                huntView.display(game);
                
            break;
            case 3:
                 
                // Broken Wagon
                message = "Your wagon is broken!";
                if (game.getPlayer().isIsWagonBroken())
                    message = "You still need to fix your wagon!";
                BrokenWagonView brokenWagonView = new BrokenWagonView(message);
                brokenWagonView.display(game);
            
            break;
            case 4:
                
                // Disease Contraction
                message = "You've fallen ill";
                if (game.getPlayer().isIsSick())
                    message = "You are still sick";
                DiseaseContractionView diseaseContractionView = new DiseaseContractionView(message);
                diseaseContractionView.display(game);
            
            break;
            case 5:
                 String outcome = FindItem.findItem(game.getPlayer());
                 Afghan_Trail.getOutFile().print(outcome);
            break;
            default:
                Afghan_Trail.getOutFile().print("Non eventful stop on the map\n");
        }
        
        //update progress | speed mechanism implemented here
        game.progressPlayer();
        
        //check if user should enter town
        if (game.getProgress() % 5 == 0){
            EnterTownView enterTownView = new EnterTownView();
            enterTownView.arrivalToTown(game);
            enterTownView.display(game);
        }    
    }
        
    public static Game initializeGame(Game game){  
        
        // this view sets up the character
        NewGameView newGameView = new NewGameView();
        newGameView.display(game);
        
        // first event should be the town of Kandahar
        String firstTownString = "" +
                "Your adventure starts in the town of Kandahar\n" + 
                "It would probably be smart to stock up on some supplies\n";
        Afghan_Trail.getOutFile().print(firstTownString);
        
        
        EnterTownView enterTownView = new EnterTownView();
        enterTownView.arrivalToTown(game);
        enterTownView.display(game);
       // game.setProgress(1); //this is so we don't repeat this town
        
        return game;
    }
    
    public static void startGame(Game game){  
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display(game);
    }  
    
    
    public static void loadGame(){
        LoadGameView loadGameView = new LoadGameView();
        loadGameView.display(null);
    }

    public static void saveGame(Game game){
        // Start the SaveGameView
        SaveGameView saveGameView = new SaveGameView();
        saveGameView.display(game);
    }
     


    
};
    
   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.BeingAttacked;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.exceptions.BeingAttackedException;
import byui.cit260.afghan_trail.model.Game;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Brayden
 */
public class BeingAttackedView extends BasicView {
   
    public BeingAttackedView(){
        super();
        char keys[] = {'F','R','B','H'};
        String[] options = {
            "Fight back",
            "Run away",
            "Beg for mercy",
            "Event Help"
        };
        String message = "You're being attacked";    
        setOptions(options);
        setMessage(message);
        setKeys(keys);
    }
    public BeingAttackedView(String[] options, String message){
        this.options = options;
        this.message = message;
    }
    public BeingAttackedView(char keys[]){
        this();
        if (keys.length < options.length)
            ErrorView.display(this.getClass().getName(),"view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    public void displayHelp(){  
        //display event help for each event option
this.console.print("Being Attacked Help\n");
this.console.print("FIGHT BACK lets you throw down against the assailants\n" ); 
this.console.print("RUN AWAY means you make a run for it and proceed to the next\n" 
        + "event, and  lose street cred\n");
this.console.print("BEG FOR MERCY means you try and beg and hope they let you go\n");
    }
    
    public void doAction(String[] options, char action,
                         Game game){
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            //Fight Back
            case 0:
                
                this.console.print("You chose '" + options[0] + "'\n");
                try {
                    String outcome = BeingAttacked.fightBack(game.getPlayer());
                    this.console.print(outcome);
                } catch (BeingAttackedException e) {
                    ErrorView.display(this.getClass().getName(),e.getMessage());
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(),nf.getCause() + " is not a number\n");
                }
                break;
             
            //Ignore    
            case 1:
                
                this.console.print("You chose '" + options[1] + "'\n");
                try {
                   String outcome = BeingAttacked.runAway(game.getPlayer());
                   this.console.print(outcome);
                } catch  (BeingAttackedException e) {
                   ErrorView.display(this.getClass().getName(),e.getMessage());
                }
                break;
             
            //Rest    
            case 2:
                
                this.console.print("You chose '" + options[2] + "'\n");
                try {
                    String outcome = BeingAttacked.beg(game.getPlayer());
                    this.console.print(outcome);
                } catch (BeingAttackedException e) {
                    ErrorView.display(this.getClass().getName(),e.getMessage()); 
                }
                break;
        }
    }
}
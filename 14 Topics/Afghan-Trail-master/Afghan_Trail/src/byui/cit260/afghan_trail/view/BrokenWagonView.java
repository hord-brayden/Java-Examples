/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.BrokenWagon;
import byui.cit260.afghan_trail.exceptions.BrokenWagonException;
import byui.cit260.afghan_trail.model.Game;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Brayden
 */
public class BrokenWagonView extends BasicView{
    
    public BrokenWagonView(){
        super();
        
        char keys[] = {'F','I','R','E'};
        String[] options = {
            "Fix",
            "Ignore",
            "Rest",
            "Event Help"
        };
        String message = "Your wagon is broken";
        setOptions(options);
        setMessage(message);
        setKeys(keys);
        
    }
    
    public BrokenWagonView(String message){
        super();
        
        char keys[] = {'F','I','R','E'};
        String[] options = {
            "Fix",
            "Ignore",
            "Rest",
            "Event Help"
        };
        setOptions(options);
        setMessage(message);
        setKeys(keys);
    }
    
    public BrokenWagonView(String[] options, String message){
        super(options, message);
    }
    public BrokenWagonView(char keys[]) throws BrokenWagonException{
        this();
        if (keys.length < options.length)
            throw new BrokenWagonException("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    public void displayHelp(){
        //display event help for each event option
this.console.print("Broken Wagon Help\n");
this.console.print("FIX WAGON exhaust your wagon supplies, and some\n"
        + "stamina in order to try and fix up your wagon!\n" ); 
this.console.print("IGNORE means you really don't care that your wagon is broken, \n"
        + "because you're a strong independant woman, who don't need no wagon.\n"
        + "It also progresses to the next stage of the game.\n");
this.console.print("REST This means a broken wagon can wait - you need a nap!\n");
    }
   
    public void doAction(String[] options, char action,
                         Game game){
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            //Fix
            case 0:
                
                this.console.print("You chose '" + options[0] + "'\n");
                try {
                    String outcome = BrokenWagon.fix(game.getPlayer());
                    this.console.print(outcome);
                } catch (BrokenWagonException e) {
                    ErrorView.display(this.getClass().getName(),e.getMessage());
                } catch (NumberFormatException nf){
                    ErrorView.display(this.getClass().getName(),nf.getCause() + " is not a number\n");
                }
                break;
             
            //Ignore    
            case 1:
                
                 this.console.print("You chose '" + options[1] + "'\n");
                try {
                    String outcome = BrokenWagon.ignore(game.getPlayer());
                    this.console.print(outcome);
                } catch (BrokenWagonException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                } catch (NumberFormatException nf){
                    ErrorView.display(this.getClass().getName(),nf.getCause() + " is not a number\n");
                }
                break;
             
            //Rest    
            case 2:
                
                this.console.print("You chose '" + options[2] + "'\n");
                try {
                    String outcome = BrokenWagon.rest(game.getPlayer());
                    this.console.print(outcome);
                } catch (BrokenWagonException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                } catch (NumberFormatException nf){
                    ErrorView.display(this.getClass().getName(),nf.getCause() + " is not a number\n");
                }
                break;
        }
    }
}
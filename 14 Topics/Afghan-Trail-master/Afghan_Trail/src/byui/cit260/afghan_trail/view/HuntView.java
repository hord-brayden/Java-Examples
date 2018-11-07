/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.Hunt;
import byui.cit260.afghan_trail.model.Game;
/**
 *
 * @author Brayden
 */
public class HuntView extends BasicView {
    
    public HuntView() {
        super();
        char keys[] = {'H','I','R','E'};
        String[] options = {
           "Hunt",
           "Ignore",
           "Rest",
           "Event Help",
           
        };
        String message = "Looks like a good place to hunt";       
        setOptions(options);
        setMessage(message);
        setKeys(keys);
    }
    
    public HuntView(String options[], String message){
        super(options, message);
    }
    
    public HuntView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    @Override
    public void displayHelp(){
        //display event help for each event option
        this.console.print("Hunt Help\n");
        this.console.print("HUNT lets you kill some animals, and anger some vegans \n" ); 
        this.console.print("IGNORE means animals being present don't phase you, and you got \n"
                + "better things to do. The game wil progress to its \n"
                + "next stage as well.\n");
        this.console.print("REST menas you kick back, let the animals do their thing, \n"
                + "and gain back some stamina\n");
    }
    
    public void doAction(String[] options, 
                         char action, 
                         Game game)
    {
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            //Hunt
            case 0:
                
                this.console.print("You chose '" + options[0] + "'\n");
                Hunt.hunt(game.getPlayer());
                break;
             
            //Ignore    
            case 1:
                
                this.console.print("You chose '" + options[1] + "'\n");
                Hunt.ignore(game.getPlayer());
                break;
             
            //Rest    
            case 2:
                
                this.console.print("You chose '" + options[2] + "'\n");
                Hunt.rest(game.getPlayer());
                break;
        }
    }
}
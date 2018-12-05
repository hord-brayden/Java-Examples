/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.DiseaseContraction;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.exceptions.DiseaseContractionException;
import byui.cit260.afghan_trail.model.Game;
import java.util.logging.Level;
import java.util.logging.Logger;
//import bui.cit260.afghan_trail.controller.DiseaseContraction.isSuccessful;
/**
 *
 * @author Brayden
 */
public class DiseaseContractionView extends BasicView {
    
   
    
    public DiseaseContractionView(){
        super();
        char keys[] = {'T','I','R','E'};
        String[] options = {
            "Take Medicine",
            "Ignore",
            "Rest",
            "Event Help"
        };
        String message = "You've fallen ill";      
        setOptions(options);
        setMessage(message);
        setKeys(keys);
    }
    
    public DiseaseContractionView(String message){
        super();
        char keys[] = {'T','I','R','E'};
        String[] options = {
            "Take Medicine",
            "Ignore",
            "Rest",
            "Event Help"
        };     
        setOptions(options);
        setMessage(message);
        setKeys(keys);
    }
    
    public DiseaseContractionView(String[] options, String message){
        super(options, message);
    }
    
    public DiseaseContractionView(char keys[]){
        this();
        if (keys.length < options.length)
            ErrorView.display(this.getClass().getName(),"view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    public void displayHelp(){
//display event help for each event option, this is so people have a good idea of what it is they are trying to do
//Within the application, and don't just willy nilly click buttons throughout the program.
this.console.print("Disease Contracation Help \n");
this.console.print("TAKE MEDICINE lets you exhause some of your medicine\n"
        + "supply, but has the chance to heal your herp-aids\n" ); 
this.console.print("IGNORE means you let the disease/sickness ravage your body,\n "
        + "also you will progress to the next stage of the game, while your\n "
        + "brain rots away from syphilis \n");
this.console.print("REST menas you kick back and gain some stamina \n");
    }    
    
    public void doAction(String[] options, char action,
                         Game game){
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            //Take Medicine
            //This is mapped to the first item in the array, take medicine. This should help you fight off any illness
            case 0:
  
                this.console.print("You chose '" + options[0] + "'\n");
                try {
                    String outcome = DiseaseContraction.takeMedicine(game.getPlayer());
                    this.console.print(outcome);
                } catch (DiseaseContractionException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(),nf.getCause() + " is not a number\n");
                }

                break;
             
            //Ignore and do nothing. 
            case 1:
                
                this.console.print("You chose '" + options[1] + "'\n");
                try {
                    DiseaseContraction.ignore(game.getPlayer());
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(),nf.getMessage());
                }
                break;
             
            //Rest and build up your stamina so that youhave a fighting chance at beating this cold!
            //Clicking this option will essentially give you 
            case 2:
                
                this.console.print("You chose '" + options[2] + "'\n");
                try {
                    DiseaseContraction.rest(game.getPlayer());
                } catch (NumberFormatException nf) {
                    ErrorView.display(this.getClass().getName(),nf.getMessage());
                }
                break;
        }
    }
}

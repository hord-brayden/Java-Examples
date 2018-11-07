/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.GuideController;
import byui.cit260.afghan_trail.controller.SaveGameController;
import byui.cit260.afghan_trail.model.Game;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author jonsi
 */
public class SaveGameView extends BasicView {

    public SaveGameView() {
        super();
        
        /*
            read file names in savedGames folder
            to create correct number of keys
            and correct option names
        */
       
        File folder = new File("saved_games");
        File[] listOfFiles = folder.listFiles();
        int len = listOfFiles.length;
        char[] keys = new char[len + 3];
        String[] options = new String[len + 3];
        for (int i = 0; i < len; i++){
            if (listOfFiles[i].isFile()){
                
                //this magically converts the int i to a char in keys[i]
                keys[i] = (char)((i + 1) + '0'); 
                options[i] = listOfFiles[i].getName();
            }
        }
        keys[len + 0] = (char)((len + 1) + '0');
        keys[len + 1] = (char)((len + 2) + '0');
        keys[len + 2] = (char)((len + 3) + '0');
        options[len + 0] = "New Slot";
        options[len + 1] = "Help";
        options[len + 2] = "Exit Menu";

        
        String message = "Save Game Menu";       
        setOptions(options);
        setMessage(message);
        setKeys(keys);
    }
    
    public SaveGameView(String options[], String message){
        super(options, message);
    }
    
    public SaveGameView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    @Override
    public void displayHelp(){
        this.console.print("Game help\n"
                + ""
                + "Save your game where it says 'New Slot', and you'll see it\n"
                + "the next time you decide to load your game!\n"
                + ""
                + "\n");
    }
    
    @Override
    public void display(Game game) {
        int opLen = options.length;
        char helpOp = keys[opLen - 2];
        char exitOp = keys[opLen - 1];
        
        char userInput = helpOp;
        do {
            this.console.println(message + '\n'); 
            userInput = getUserChar(options);
            if (userInput != exitOp)
                doAction(options, userInput, game); //exit takes no action   
        } while (userInput == helpOp); //only reloop on display help
    }
    
    public void doAction(String[] options, 
                         char input, 
                         Game game)
    {
 
        //Path filename = Paths.get(URI.create("file:///Users/savegame.txt"));
        int index = Character.getNumericValue(input);
        String filename = options[index - 1];
        char action = getAction(index, options);
        switch (action){
            
            //New Slot
            case 'n':
                String prompt = "What is the new slot's filename: ";
                boolean isValid = false;
                do {
                    filename = getUserString(prompt);
                    isValid = validateFilename(filename);
                } while (!isValid);
                SaveGameController.saveInSlot(filename, game);
                break;
             
            //Help    
            case 'h':
                displayHelp();
                break;
                
            //Existing Slot
            default:
                SaveGameController.saveInSlot(filename, game);
                
                
            //Exit handled in display loop
        }
    }   
    
    private char getAction(int input, String[] options){
        char action = 'e';
        if (options.length - 2 == input){
            action = 'n';
        } else if (options.length - 1 == input)
            action = 'h';
        return action;
    }
    
    private boolean validateFilename(String filename){
        if (filename != null)
            return true;
        else {
            this.console.print("Invalid Filename");
            return false;
        }
    }
}

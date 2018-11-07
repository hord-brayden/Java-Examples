/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.controller.LoadGameController;
import byui.cit260.afghan_trail.model.Game;
import java.io.File;

/**
 *
 * @author jonsi
 */
public class LoadGameView extends BasicView{

    public LoadGameView() {
        super();
        
        /*
            read file names in savedGames folder
            to create correct number of keys
            and correct option names
        */
       
        File folder = new File("saved_games");
        File[] listOfFiles = folder.listFiles();
        int len = listOfFiles.length;
        char[] keys = new char[len + 2];
        String[] options = new String[len + 2];
        for (int i = 0; i < len; i++){
            if (listOfFiles[i].isFile()){
                
                //this magically converts the int i to a char in keys[i]
                keys[i] = (char)((i + 1) + '0'); 
                options[i] = listOfFiles[i].getName();
            }
        }
        keys[len + 0] = (char)((len + 1) + '0');
        keys[len + 1] = (char)((len + 2) + '0');
        options[len + 0] = "Help";
        options[len + 1] = "Exit Menu";

        
        String message = "Load Game Menu";       
        setOptions(options);
        setMessage(message);
        setKeys(keys);
    }
    
    public LoadGameView(String options[], String message){
        super(options, message);
    }
    
    public LoadGameView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    @Override
    public void displayHelp(){
        this.console.print("Choose a file from which to load a saved game.\n");
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
            if (userInput != exitOp){
                doAction(options, userInput, game); //exit takes no action   
            }
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
            case 'l':
                
                // perform load
                try {
                    LoadGameController.loadGame(filename);
                } catch (NullPointerException np){
                     ErrorView.display(this.getClass().getName(),"Error loading file");
                }
                // display load
                displayLoad();
                break;
             
            //Help    
            case 'h':
                displayHelp();
                break;
                
                
            //Exit handled in display loop
        }
    }   
    
    private char getAction(int input, String[] options){
        char action = 'l';
        if (options.length - 1 == input)
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
    
    private void displayLoad(){
        Game curGame = Afghan_Trail.getCurrentGame();
        String welcomeBackMsg = "Welcome back, " + curGame.getPlayer().getName() +
                "\nYou're game progress is " + (curGame.getProgress() + 1) + 
                "/25\nHere are your stats:\n";
        this.console.print(welcomeBackMsg);
        curGame.getPlayer().showStats();
    }
}

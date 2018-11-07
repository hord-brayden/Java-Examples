/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.model.Player;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public abstract class BasicView implements BasicViewInterface {
    
    // I/0
    protected final BufferedReader keyboard = Afghan_Trail.getInFile();
    protected final PrintWriter console = Afghan_Trail.getOutFile();
    
    // default properties for all views. 
    // these should be overwritten in the views constructor
    String[] options = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"}; 
    String message = "This is the default menu";
    
    //default keys can optionally be overwritten
    char[] keys = {'W', 'A', 'S', 'D', 'Q', 'E', 'Z','X','C'};
    
    BasicView(){}
    BasicView(String options[], String message){
        this.options = options;
        this.message = message;
    }
    BasicView(char[] keys){
        this.keys = keys;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public char[] getKeys() {
        return keys;
    }

    public void setKeys(char[] keys) {
        this.keys = keys;
    }
    
    public void display(Game game) {
        this.console.println(message + '\n');
        int opLen = options.length;
        char lastKeyChar = keys[opLen - 1];
        lastKeyChar = Character.toUpperCase(lastKeyChar);
        char userInput = lastKeyChar;
        do {
            userInput = getUserChar(options);
            if (userInput == lastKeyChar)
                this.displayHelp();
        } while (userInput == lastKeyChar);
        
        doAction(options, userInput, game);
    }
    
    /*
        return uppercase userChar
    
    */
    public char getUserChar(String[] options){
        int numOfOptions = options.length;
        String menuString = buildOptionsString(options);
        this.console.println(menuString);
        char userChar = '\u0000'; //userChar == 0 -> returns true
        boolean validChar = false;
        try {
            do {
                userChar = this.keyboard.readLine().charAt(0);
                userChar = Character.toUpperCase(userChar);
                validChar = validateUserChar(numOfOptions, userChar);
                if (!validChar)
                    ErrorView.display(this.getClass().getName(),"INVALID COMMAND, TRY AGAIN");
            } while (!validChar);
        } catch (Exception e){
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        } 
        return userChar;
    }
    
    private boolean validateUserChar(int numberOfOptions, char userChar){
        for (int i = 0; i < numberOfOptions; i++){
            char compareKey = Character.toUpperCase(keys[i]);
            if (userChar == compareKey)
                return true;
        }
        return false;
    }
    
    public int getUserInt(String[] options){
        int numOfOptions = options.length;
        String menuString = buildOptionsString(options);
        this.console.println(menuString);
        int userInt = 0;
        boolean validInt = false;
        try {
            do {
                String inputString = this.keyboard.readLine();
                userInt = Integer.parseInt(inputString);
                validInt = (userInt <= numOfOptions && userInt > 0);
                if (!validInt)
                    ErrorView.display(this.getClass().getName(), "INVALID COMMAND, TRY AGAIN");
            } while (!validInt);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        return userInt;
    }
    
    private String buildOptionsString(String[] options){
        assert(keys.length == options.length);
        String optionsString = "";
        for (int i = 0; i < options.length; i++){
            String line = keys[i] + " - " + options[i] + "\n";
            optionsString += line;
        }
        optionsString += ">>>";
        return optionsString;
    }
    
    protected int getFunctionNumberFromChar(char userResponse){
        int functionNum = 0;
        userResponse = Character.toUpperCase(userResponse);
        for (int i = 0; i < keys.length; i++){
            if (userResponse == keys[i]){
                functionNum = i;
                break;
            }
        }
        return functionNum;
    }
    
    public String getUserString(String prompt){
        this.console.println(prompt);
        String userString = null;
        boolean goodString = true;
        try {
            do {
                userString = Afghan_Trail.getInFile().readLine();
                userString = userString.trim();
            } while (!goodString);
        } catch (Exception e){
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
            return null;
        }
        return userString;
    }
}

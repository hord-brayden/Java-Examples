/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.controller.GuideController;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.model.Player;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author jonsi
 */
public class GuideView extends BasicView {
    
    String[] options = {
            "Log Game Items",
            "Goal of the Game",
            "Start Game Help",
            "Load Game Help",
            "Exit Game Help"
        };
    String message = "Afghan Trail Game Guide";
    
    GuideView(){}
    GuideView(String[] options, String message){
        this.options = options;
        this.message = message;
    }
    
    @Override
    public void displayHelp(){
        // no guide for the guide
    }
    
    @Override
    public void display(Game game) {
        this.console.println(message + '\n'); 
        char userInput = getUserChar(options);
        doAction(this.options, userInput, game);
    }
    
    public void doAction(String[] options, 
                         char action, 
                         Game game)
    {
        int actionInt = getFunctionNumberFromChar(action);
        switch(actionInt){
            case 0:
                //Item List
                String filename = getFilename();
                logItems(filename, game);
                break;
            case 1:
                //Goal of the Game
                GuideController.showGoal();
                break;
            case 2:
                //Show Start
                GuideController.showStart();
                break;
            case 3:
                //Show Load
                GuideController.showLoad();
                break;
            case 4:
                //Show Exit
                GuideController.showExit();
                break;
        }
    }
    
    public String getFilename(){
        String prompt = "Where do you want to log this information?";
        String filename = getUserString(prompt);
        return filename;
    }
    
    public void logItems(String filename, Game game){

        // declare file variables
        FileWriter fileWriter = null;
        BufferedWriter out = null;
        this.console.println("Writing to " + filename);
        
        try {
            
            // initialize file variables
            fileWriter = new FileWriter(filename);
            out = new BufferedWriter(fileWriter);
            String[][] types = Item.itemTypes;
            
            //build string
            String separator = System.getProperty("line.separator");
            String output = "All Game Items" +
                        separator + separator;
           
            output += String.format("%-12s %-12s %-12s %-12s %-12s %-12s %n",
                    "Item Types",
                    "First Item",
                    "Second Item",
                    "Third Item",
                    "Fourth Item",
                    "Fifth Item"
            );
            
            String[] categoryNames = {
                "Medicine",
                "Food",
                "Parts",
                "Ammo"
            };
            
            int catInd = 0;
            for (String[] category : types){
                output += String.format("%-12s %-12s %-12s %-12s %-12s %-12s %n",
                        categoryNames[catInd] + ":",
                        category[0],
                        category[1],
                        category[2],
                        category[3],
                        category[4]
                );     
                catInd++;
            }

            // write to file
            out.write(output);
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("C:\\Windows\\notepad.exe " + filename);
            
        } catch (IOException ex){
            String errorMsg = "Error writing to " + filename;
            ErrorView.display(this.getClass().getName(), errorMsg);
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException ex){
                String errorMsg = "Error closing file";
                ErrorView.display(this.getClass().getName(), errorMsg);
                return;
            }
        }
        this.console.println("Open " + filename + " to view game items");
    }
}

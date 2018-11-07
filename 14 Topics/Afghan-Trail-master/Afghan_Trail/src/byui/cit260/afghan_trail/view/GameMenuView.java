/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.controller.Map;
import byui.cit260.afghan_trail.exceptions.BrokenWagonException;
import byui.cit260.afghan_trail.exceptions.GameControllerException;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.model.Player;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.load;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jonsi
 */
public class GameMenuView extends BasicView {
    
    
    public String winMsg = "\n"
            + "\n"
            + "$$\\     $$\\                                                                   $$\\     $$\\                                                                         $$\\       $$\\ \n" +
"\\$$\\   $$  |                                                                  $$ |    $$ |                                                                        $$ |      $$ |\n" +
" \\$$\\ $$  /$$$$$$\\  $$\\   $$\\       $$\\  $$\\  $$\\  $$$$$$\\  $$$$$$$\\        $$$$$$\\   $$$$$$$\\   $$$$$$\\         $$$$$$\\   $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\        $$ |      $$ |\n" +
"  \\$$$$  /$$  __$$\\ $$ |  $$ |      $$ | $$ | $$ |$$  __$$\\ $$  __$$\\       \\_$$  _|  $$  __$$\\ $$  __$$\\       $$  __$$\\  \\____$$\\ $$  _$$  _$$\\ $$  __$$\\       $$ |      $$ |\n" +
"   \\$$  / $$ /  $$ |$$ |  $$ |      $$ | $$ | $$ |$$ /  $$ |$$ |  $$ |        $$ |    $$ |  $$ |$$$$$$$$ |      $$ /  $$ | $$$$$$$ |$$ / $$ / $$ |$$$$$$$$ |      \\__|      \\__|\n" +
"    $$ |  $$ |  $$ |$$ |  $$ |      $$ | $$ | $$ |$$ |  $$ |$$ |  $$ |        $$ |$$\\ $$ |  $$ |$$   ____|      $$ |  $$ |$$  __$$ |$$ | $$ | $$ |$$   ____|                    \n" +
"    $$ |  \\$$$$$$  |\\$$$$$$  |      \\$$$$$\\$$$$  |\\$$$$$$  |$$ |  $$ |        \\$$$$  |$$ |  $$ |\\$$$$$$$\\       \\$$$$$$$ |\\$$$$$$$ |$$ | $$ | $$ |\\$$$$$$$\\       $$\\       $$\\ \n" +
"    \\__|   \\______/  \\______/        \\_____\\____/  \\______/ \\__|  \\__|         \\____/ \\__|  \\__| \\_______|       \\____$$ | \\_______|\\__| \\__| \\__| \\_______|      \\__|      \\__|\n" +
"                                                                                                                $$\\   $$ |                                                      \n" +
"                                                                                                                \\$$$$$$  |                                                      \n" +
"                                                                                                                 \\______/                                                       "
            + "\n"
            + "\n"
            + "\n"
            + "\n";
    public String loseMsg = "\n"
            + "\n"
            + "__   __            _           _     _   _                                                   \n" +
"\\ \\ / /           | |         | |   | | | |                                                  \n" +
" \\ V /___  _   _  | | ___  ___| |_  | |_| |__   ___    __ _  __ _ _ __ ___   ___             \n" +
"  \\ // _ \\| | | | | |/ _ \\/ __| __| | __| '_ \\ / _ \\  / _` |/ _` | '_ ` _ \\ / _ \\            \n" +
"  | | (_) | |_| | | | (_) \\__ \\ |_  | |_| | | |  __/ | (_| | (_| | | | | | |  __/  _   _   _ \n" +
"  \\_/\\___/ \\__,_| |_|\\___/|___/\\__|  \\__|_| |_|\\___|  \\__, |\\__,_|_| |_| |_|\\___| (_) (_) (_)\n" +
"                                                       __/ |                                 \n" +
"                                                      |___/                                  \n"
            + "\n"
            + "\n"
            + "\n"
            + "\n";
    
    
    
    public GameMenuView() {
        super();
        char gameOptionKeys[] = {'C','M','S','I','G','E'};
        String[] options = {
            "Continue",
            "Map",
            "Log Player Stats",
            "Log Player Inventory",
            "Guide",
            "Exit without saving"
        }; 
        String message = "Game Menu";       
        setOptions(options);
        setMessage(message);
        setKeys(gameOptionKeys);
    }
    
    public GameMenuView(String options[], String message){
        super(options, message);
    }
    
    public GameMenuView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }    
    
    @Override
    public void displayHelp(){
        this.console.print("" +
            "GAME MENU GUIDE\n\n" + 
            "\tPressing "+this.keys[0]+"\n\n" +
            "Continue will move your character\n" +
            "to thier next adventure event\n\n" + 
            "\tPressing "+this.keys[1]+"\n\n" + 
            "Map will show the map of the\n" +
            "afghan trail and your character's position\n\n" +
            "\tPressing "+this.keys[2]+"\n\n" +
            "Player Stats will show your\n" +
            "character's stats\n" + 
            "\tPressing "+this.keys[3]+"\n\n" +
            "Player inventory will be shown\n" +
            "\tPressing "+this.keys[4]+"\n\n" +
            "Displays this game guide\n" +
            "\tPressing "+this.keys[5]+"\n\n" +
            "Exits the game without saving\n" + 
            "Saving can only be done in towns\n");
    }
    
    @Override
    public void display(Game game) {
        
        while ((game.getProgress() < 24 && 
       !game.getPlayer().isIsDead() &&
       !game.isIsQuit()))
        {
            this.console.print("\n\n" + message + "\n");
            char userInput = getUserChar(options);
            doAction(options, userInput, game);
        }
        
        if (game.getProgress() >= 24){
            //player won
            gameWin();
        } else if (game.getPlayer().isIsDead()) {
            //player is dead
            gameLose();
        }
    }
    
    public void doAction(String[] options, 
                         char action, 
                         Game game)
    {
        int actionInt = getFunctionNumberFromChar(action);
        String filename;
        switch (actionInt){
           case 0:

                try {
                    //Continue
                    GameController.generateEvent(game);
                } catch (GameControllerException ex) {
                    ErrorView.display(this.getClass().getName(),
                            "Can't generate game event");
                } catch (BrokenWagonException ex) {
                    ErrorView.display(this.getClass().getName(),
                            "Can't generate game event");
                }

               break;

           case 1:

               //Map
               int progress = game.getProgress();
               String mapString = Map.displayMap(progress);
               this.console.print(mapString);
               break;

           case 2:

               //Player Stats
               filename = getFilename();
               logStats(filename, game);
               //call get filepath method
               //pass filepath to show stats 
               
               
               break;

           case 3:

               //Player Inventory
               filename = getFilename();
               logInventory(filename, game);
               break;

           case 4: 

               //Game Help
               displayHelp();
               break;
                
           case 5:
               
               //Exit GameController without saving
               game.setIsQuit(true);
               break;
               
           default: 
               this.console.println("INVALID OPTION\n");
               break;
        }
    }
    
    public void gameWin(){
        this.console.print(winMsg);
    }
    
    public void gameLose(){
        this.console.print(loseMsg);
    }
    
    public void logInventory(String filename, Game game){
        Inventory playerInv = game.getPlayer().getPlayerInventory();
        ArrayList<Item> playerItems = playerInv.getInventoryItems();
        FileWriter fileWriter = null;
        BufferedWriter out = null;
        this.console.println("Writing to " + filename);
        
        try {
            fileWriter = new FileWriter(filename);
            out = new BufferedWriter(fileWriter);
            int itemNum = 1;
            String separator = System.getProperty("line.separator");
            String outputString = game.getPlayer().getName() + 
                    "'s Inventory" +
                    separator + separator;
            
            outputString += String.format("%-4s", "#");
            outputString += String.format("%-15s", "Name");
            outputString += String.format("%-15s", "Type");
            outputString += String.format("%-15s", "Price");
            outputString += separator;
            
            for (Item item : playerItems){  
               
                String header = String.format("%-4s", Integer.toString(itemNum) + ": ");
                String itemString = item.getDisplayString();
                outputString += header + itemString + separator;
                //out.write(header + itemString + separator);
                itemNum++;    
            }
            out.write(outputString);
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("C:\\Windows\\notepad.exe " + filename);
            
            
        } catch (IOException ex) {
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
        
        this.console.println("Open " + filename + " to view player inventory");
    }
    
    
    public void logStats(String filename, Game game){

        // declare file variables
        FileWriter fileWriter = null;
        BufferedWriter out = null;
        
        try {
            
            // initialize file variables
            fileWriter = new FileWriter(filename);
            out = new BufferedWriter(fileWriter);
            
            // setup stats array
            Player p = game.getPlayer();
            ArrayList<String> statsArr = new ArrayList<>();
            statsArr.add(String.format("%-10s %10s%n", "Type:", p.getPlayerClass()));
            statsArr.add(String.format("%-10s %10s%n", "Money:", p.getMoney().toString()));
            statsArr.add(String.format("%-10s %10s%n", "Health:", ((p.isIsSick()) ? "Sick":"Good")));
            statsArr.add(String.format("%-10s %10d%n", "Stamina:", p.getStamina()));
            statsArr.add(String.format("%-10s %10d%n", "Speed:", p.getAdjustedSpeed()));
            statsArr.add(String.format("%-10s %10s%n", "Wagon:", ((p.isIsWagonBroken()) ? "Broken":"Good")));

            // build output string
            String separator = System.getProperty("line.separator");
            String output = game.getPlayer().getName() + 
                        "'s Player Stats" +
                        separator + separator;
            output += String.format("%-10s %10s%n", "Stat Name", "Stat");
            
            // loop over statsArr to add each stat to output
            for (String stat : statsArr){
                output += stat;
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
    }
    
    
    public String getFilename(){
        String prompt = "Where do you want to log this information?";
        String filename = getUserString(prompt);
        return filename;
    }
}

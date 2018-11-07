/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import afghan_trail.Afghan_Trail;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.model.Banker;
import byui.cit260.afghan_trail.model.Blacksmith;
import byui.cit260.afghan_trail.model.Carpenter;
import byui.cit260.afghan_trail.model.Characters;
import byui.cit260.afghan_trail.model.Farmer;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.model.Player;

/**
 *
 * @author jonsi
 */
public class NewGameView extends BasicView{
    
    /*
        Properties
    */
    public String introduction = "AFGHAN TRAIL!!!!!!!!!!!!\n" +
        "You are reading some sort of really, really\n" + 
        "heroic introduction. It is moving you to tears.\n" +
        "You are considering actually moving to afghanistan \n" +
        "in efforts to make your life more like the game you are \n" +
        "about to play, but you'll settle for this...for now.\n";
    public String namePrompt = "Name your character: ";

    public NewGameView() {
        super();
        char characterKeys[] = {'B','S','C','F','H'};
        String[] options = {
            "Banker",
            "Blacksmith",
            "Carpenter",
            "Farmer",
            "Class Descriptions"
        };
        String message = "\nChoose Character:";       
        setOptions(options);
        setMessage(message);
        setKeys(characterKeys);
    }
    
    public NewGameView(String options[], String message){
        super(options, message);
    }    
    
    public NewGameView(char keys[]){
        this();
        if (keys.length < options.length)
            ErrorView.display(this.getClass().getName(),"view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }   

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    
    public String getIntroduction(){
        return introduction;
    }
    
    public void setNamePrompt(String namePrompt){
        this.namePrompt = namePrompt;
    }
    
    public String getNamePrompt(){
        return namePrompt;
    }
    
    /*
        Methods
    */
    
    @Override
    public void displayHelp(){
        /*
            "Banker",
            "Blacksmith",
            "Carpenter",
            "Farmer",
        */
        Afghan_Trail.getOutFile().printf("CLASS DESCRIPTIONS\n"
               + "\n"
               + "-- -- -- BANKER -- -- --\n"
               + "As a banker, you'll see a beginning increase to your monetary\n"
               + "funds. Embarking on this journey as a banker will be a \n"
               + "difficult journey, as you are accustomed to a desk, however\n"
               + "take pride in knowing that it may be difficult!\n"
               + "-- -- -- BLACKSMITH -- -- --\n"
               + "As a blacksmith, you have a long history of working with your\n"
               + "hands. You are a tough individually with markedly more stamina\n"
               + "thank your desk-bound brethren at the bank.\n"
               + "-- -- -- CARPENTER -- -- --\n"
               + "You share a profession with the savior, however don't mention\n"
               + "that you are a christian around these parts! You will see an\n"
               + "added bonus when trying to fix your wagon, in addition to a\n"
               + "small bonus to stamina.\n"
               + "-- -- -- FARMER -- -- --\n"
               + "You are of the common middle class of the region. Farmers are\n"
               + "jacks of all trades, masters of none. You could potentially\n"
               + "see an increase to stats, or wagon fix attempts. This class\n"
               + "starts out with more food potentially.\n");
    }
    
    @Override
    public void display(Game game){
        
        //intro and character name
        this.console.println(introduction);
        
        this.console.println(namePrompt);
        String name = null;
        boolean goodString = true;
        try {
            do {
                name = Afghan_Trail.getInFile().readLine();
                name = name.trim();
            } while (!goodString);
        } catch (Exception e){
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        }
                
        //choose character class
        int opLen = options.length;
        char guideOp = keys[opLen - 1];  //last
        guideOp = Character.toUpperCase(guideOp);
        char userInput = guideOp;
        
        do {
            this.console.println(message + '\n');
            userInput = getUserChar(options);
            if (userInput == guideOp)
                this.displayHelp();
        } while (userInput == guideOp);
        
        //set up player
        Player player = setUpPlayer(userInput, name); 
        game.setPlayer(player);
    }
    

        
    public Player setUpPlayer(char action, String name)
    {
        int actionInt = getFunctionNumberFromChar(action);
        Player player = null;
        switch (actionInt){
                    case 0:
                        this.console.print("You chose '" + options[0] + "'\n");
                        player = new Banker(name);
                        player.setPlayerClass("Banker");
                    break;
                    case 1:
                        this.console.print("You chose '" + options[1] + "'\n");
                        player = new Blacksmith(name);
                        player.setPlayerClass("Blacksmith");
                    break;
                    case 2:
                        this.console.print("You chose '" + options[2] + "'\n");
                        player = new Carpenter(name);
                        player.setPlayerClass("Carpenter");
                    break;
                    case 3:
                        this.console.print("You chose '" + options[3] + "'\n");
                        player = new Farmer(name);
                        player.setPlayerClass("Farmer");
                    break;
        }
        
        return player;
    }
    
    @Override
    public void doAction(String[] options, char action, Game game){};
}

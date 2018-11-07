/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import afghan_trail.Afghan_Trail;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jonsi
 */
public class Game implements Serializable {
    private int progress;
    private boolean isQuit;
    private Player player = new Player();
    public static String winMsg = "You Won!";
    public static String loseMsg = "You Are Dead!";
    
    public Game(){
        setProgress(0);
        setIsQuit(false);
    }
    
    public Game(Player player){
        setProgress(0);
        setIsQuit(false);
        this.player = player;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        if (progress < 0)
            progress = 0;
        else if (progress > 24)
            progress = 24;
        
        this.progress = progress;
    }

    public boolean isIsQuit() {
        return isQuit;
    }

    public void setIsQuit(boolean isQuit) {
        this.isQuit = isQuit;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void displayPlayer(){
        Afghan_Trail.getOutFile().print(player.toString());
    }

    public static String getWinMsg() {
        return winMsg;
    }

    public static void setWinMsg(String winMsg) {
        Game.winMsg = winMsg;
    }

    public static String getLoseMsg() {
        return loseMsg;
    }

    public static void setLoseMsg(String loseMsg) {
        Game.loseMsg = loseMsg;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.progress;
        hash = 23 * hash + (this.isQuit ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.player);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.progress != other.progress) {
            return false;
        }
        if (this.isQuit != other.isQuit) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        return true;
    }
    
    
    
    /*
        The most a player can be moved forward is 1 position of 25 on the map.
        This way the player does not skip any towns. 
        Whether he is moved after this event is decided on various factors:
            - speed 
            - wagon status
            - sick
            - stamina
     
        Adjustments to the speed are made in getAdjustedSpeed and do not effect
        the players speed property
     
        speed: The higher the speed the higher the chance is that the user
        will progress to the next position. The lowest it can go is 1 which
        corresponds to a 10 % chance. The highest it can go is 10.
    
//        Things effect the users progression are as follows
//     
//        speed: The higher the speed the higher the chance is that the user
//        will progress to the next position. The lowest it can go is 1 which
//        corresponds to a 10 % chance. The highest it can go is 10.
//     
//        (the next three variables effect the speed when progress is updated)
//     
//        wagon status: if the wagon is broken the speed is lowered by 2
//                      if the wagon is upgraded speed is up 1 at time of upgrade
//     
//        sick: if the player is sick his speed is brough down by 1
//
//        stamina: if the stamina is above 70 then speed is increased by 1
//                 if the stamina is above 80 then speed is increased by 2
    */ 
    public void progressPlayer(){
        PrintWriter outFile = Afghan_Trail.getOutFile();
        
        int speed = getPlayer().getAdjustedSpeed();
        
        //debug line that shows the chances of moving forward
        outFile.print("\n\nOn the road again\n");
        outFile.print("Your chance of progressing is " + speed * 10 + "%\n");

        if (!player.isResting()){
            int rand = (int) Math.ceil(Math.random() * 10);
            
        
            
            if (rand <= speed){
                outFile.print("You were able to make it a short distance\n");
                setProgress(getProgress() + 1);
                getPlayer().setStamina(getPlayer().getStamina() - 3);
            }
            else{
                outFile.print("You were too slow to make any progress\n");
            }
        }
        else if (player.isResting()){
            outFile.print("You chose to rest this turn.\n");
            outFile.print(player.getName() + " is now rested up.\n");
            outFile.print("Stamina is at 100.\n");
            player.setResting(false);
            player.setStamina(100);
        }
        
        //report progress
        outFile.print("Progress: " + (getProgress() + 1) + "/25\n");
        

    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import java.io.Serializable;


/**
 *
 * @author rizky
 */
public enum Characters implements Serializable{
    
    Banker("Warren", false, 90, 15, "Banker", 100, false),
    Blacksmith("Souron", false, 100, 20, "Blacksmith", 100, false),
    Carpenter("Gepetto", false, 90, 20, "Carpenter",100,  false ),
    Farmer("OldMcDonald", false, 100, 15, "Farmer", 100,  false);
    
    
    private String name;
    private boolean isSick;
    private long stamina;
    private int numOfItems;
    //private Item inventoryItems[] = new Item[numOfItems];
    private String playerClass;
    private long healthPoints;
    //private BigDecimal money;
    private boolean isWagonBroken;

    Characters(String name, boolean isSick, long stamina, int numOfItems, String playerClass, long healthPoints, boolean isWagonBroken) {
        this.name = name;
        this.isSick = isSick;
        this.stamina = stamina;
        this.numOfItems = numOfItems;
        this.playerClass = playerClass;
        this.healthPoints = healthPoints;
        this.isWagonBroken = isWagonBroken;
}
    
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isIsSick() {
        return isSick;
    }

    public long getStamina() {
        return stamina;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public long getHealthPoints() {
        return healthPoints;
    }

    public boolean isIsWagonBroken() {
        return isWagonBroken;
    }

    @Override
    public String toString() {
        return "Characters{" + "name=" + name + ", isSick=" + isSick + ", stamina=" + stamina + ", numOfItems=" + numOfItems + ", playerClass=" + playerClass + ", healthPoints=" + healthPoints + ", isWagonBroken=" + isWagonBroken + '}';
    }

        

}

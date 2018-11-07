/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import afghan_trail.Afghan_Trail;
import java.util.Objects;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

//TODO import item class

/**
 *
 * @author jonsi
 */
public class Player implements Serializable {
    private String name;
    private boolean isDead = false;
    private boolean isSick = false;
    private long stamina = 100;
    public  Inventory playerInventory;
    private String playerClass;
    private long healthPoints;
    private BigDecimal money;
    private boolean isWagonBroken = false;
    private int speed = 8;
    private boolean resting = false;
    
    public Player() {
        initializeMoney();
        playerInventory = new Inventory();
    }

    public Player(String name, String playerClass) {
        initializeMoney();
        playerInventory = new Inventory();
        this.name = name;
        this.playerClass = playerClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean isIsSick() {
        return isSick;
    }

    public void setIsSick(boolean isSick) {
        this.isSick = isSick;
    }

    public long getStamina() {
        return stamina;
    }

    public void setStamina(long stamina) {
        stamina = validateStamina(stamina);
        this.stamina = stamina;
    }
    
    private long validateStamina(long stamina){
        if (stamina > 100)
            stamina = 100;
        else if (stamina < 0)
            stamina = 0;
        return stamina;
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(Inventory playerInventory) {
        this.playerInventory = playerInventory;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public long getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(long healthPoints) {
        this.healthPoints = healthPoints;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    
    private void initializeMoney(){
        //range from 50 to 75
        int rangeSize = 25;
        int rangeOffset = 50;
        
        double num = Math.ceil(Math.random() * rangeSize) + rangeOffset;
        BigDecimal money = new BigDecimal(num);
        setMoney(money);
    }

    public boolean isIsWagonBroken() {
        return isWagonBroken;
    }

    public void setIsWagonBroken(boolean isWagonBroken) {
        this.isWagonBroken = isWagonBroken;
    }
  
    public int  getSpeed(){ return speed; }
    
    public void setSpeed(int speed){
        if (speed < 1)
            speed = 1;
        if (speed > 10)
            speed = 10;
        this.speed = speed;
    }
    
    private int validateSpeed(int speed){
        if (speed < 1)
            speed = 1;
        if (speed > 10)
            speed = 10;
        return speed;
    }
    
    public int getAdjustedSpeed(){
        int speed = getSpeed();
        
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
        

        if (isIsSick())
            speed--;
        if (getStamina() > 70)
            speed += 1;
        if (getStamina() > 80)
            speed += 1;
        if (isIsWagonBroken())
            speed -= 2;
        speed = validateSpeed(speed);
        return speed;
    }

    public boolean isResting() {
        return resting;
    }

    public void setResting(boolean resting) {
        this.resting = resting;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + (this.isSick ? 1 : 0);
        hash = 71 * hash + (int) (this.stamina ^ (this.stamina >>> 32));
    //  hash = 71 * hash + Arrays.deepHashCode(this.inventoryItems);
        hash = 71 * hash + Objects.hashCode(this.playerClass);
        hash = 71 * hash + (int) (this.healthPoints ^ (this.healthPoints >>> 32));
        hash = 71 * hash + Objects.hashCode(this.money);
        hash = 71 * hash + (this.isWagonBroken ? 1 : 0);
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
        final Player other = (Player) obj;
        if (this.isDead != other.isDead) {
            return false;
        }
        if (this.isSick != other.isSick) {
            return false;
        }
        if (this.stamina != other.stamina) {
            return false;
        }
        if (this.healthPoints != other.healthPoints) {
            return false;
        }
        if (this.isWagonBroken != other.isWagonBroken) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.playerClass, other.playerClass)) {
            return false;
        }
        if (!Objects.equals(this.playerInventory, other.playerInventory)) {
            return false;
        }
        if (!Objects.equals(this.money, other.money)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", isDead=" + isDead + ", isSick=" + isSick + ", stamina=" + stamina + ", playerInventory=" + playerInventory + ", playerClass=" + playerClass + ", healthPoints=" + healthPoints + ", money=" + money + ", isWagonBroken=" + isWagonBroken + ", speed=" + speed + '}';
    }

    public Item generateRandomItem(int typeInt){
        
        double money = Math.ceil(Math.random() * 5);
        BigDecimal price = new BigDecimal(money);
        
        int ind = (int) Math.floor(Math.random() * 5);
        String name = Item.itemTypes[typeInt][ind];
        
        Item newItem = new Item(name, typeInt, price);
        return newItem;
    }
  
    public void generateInventory(int stats[]){
        
        //medicine
        for (int i = 0; i < stats[0]; i++){
            Item newItem = generateRandomItem(0);
            playerInventory.addNewItem(newItem);
        }
        //food
        for (int i = 0; i < stats[1]; i++){
            Item newItem = generateRandomItem(1);
            playerInventory.addNewItem(newItem);
        }
        //parts
        for (int i = 0; i < stats[2]; i++){
            Item newItem = generateRandomItem(2);
            playerInventory.addNewItem(newItem);
        }
        //ammo
        for (int i = 0; i < stats[3]; i++){
            Item newItem = generateRandomItem(3);
            playerInventory.addNewItem(newItem);
        }
    }
    
    public void showStats(){
        Afghan_Trail.getOutFile().printf("\nPlayer Stats\n");
        Afghan_Trail.getOutFile().printf("%-10s %10s%n", "Name:", getName());
        Afghan_Trail.getOutFile().printf("%-10s %10s%n", "Type:", getPlayerClass());
        Afghan_Trail.getOutFile().printf("%-10s %10s%n", "Money:", getMoney().toString());
        Afghan_Trail.getOutFile().printf("%-10s %10s%n", "Health:", ((isIsSick()) ? "Sick":"Good"));
        Afghan_Trail.getOutFile().printf("%-10s %10d%n", "Stamina:", getStamina());
        Afghan_Trail.getOutFile().printf("%-10s %10d%n", "Speed:", getAdjustedSpeed());
        Afghan_Trail.getOutFile().printf("%-10s %10s%n", "Wagon:", ((isIsWagonBroken()) ? "Broken":"Good"));
    }
    
    public void showInventory(){
        Afghan_Trail.getOutFile().print("\n");
        playerInventory.display();
        Afghan_Trail.getOutFile().print("\n");
    }
    
    /*
        Sort Code
        0 alphabetically
        1 categories
        2 price
    */
    public void showInventory(int sortCode){
        ArrayList<Item> itemsToSort = playerInventory.getInventoryItems();
        switch(sortCode){
            case 0:
                Afghan_Trail.getOutFile().println("Items Sorted Alphabetically");
                Collections.sort(itemsToSort, Item.ItemNameComparator);
                break;
            case 1:
                Afghan_Trail.getOutFile().println("Items Sorted by Category");
                Collections.sort(itemsToSort, Item.ItemTypeComparator);
                break;
            case 2:
                Afghan_Trail.getOutFile().println("Items Sorted by Price Ascending");
                Collections.sort(itemsToSort, Collections.reverseOrder());
                break;
            case 3:
                Afghan_Trail.getOutFile().println("Items Sorted by Price Descending");
                Collections.sort(itemsToSort);
                break;      
        }
        playerInventory.setInventoryItems(itemsToSort);
        showInventory();
    }
}

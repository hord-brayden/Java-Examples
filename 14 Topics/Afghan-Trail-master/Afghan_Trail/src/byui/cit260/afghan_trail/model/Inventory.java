/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import afghan_trail.Afghan_Trail;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author jonsi
 */
public class Inventory implements Serializable{
    private int capacity = 12;
    private ArrayList<Item> inventoryItems = new ArrayList<Item>(12); 
    
    public Inventory(){
    }
    
    public Inventory(int capacity){
        this.capacity = 12;
        inventoryItems.ensureCapacity(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<Item> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
    
    public void addNewItem(Item item){
        inventoryItems.add(item);
    }
    
    public Item removeRandomItem(){
        if (inventoryItems.size() > 0){
            int rand = (int) Math.floor(Math.random() * inventoryItems.size());
            Item removedItem = inventoryItems.get(rand);
            inventoryItems.remove(rand);
            return removedItem;
        } else {
            return null;
        }
    }
    
    public Item removeItemOfType(String type){
        Item removedItem = null;
        if (inventoryItems.size() > 0 && hasItemType(type))
        {
            Item lastItemOfType = null;
            Iterator<Item> iterator = inventoryItems.iterator();
            while (iterator.hasNext()) {
                Item thisItem = iterator.next();
                if (thisItem.getType() == type){
                    lastItemOfType = thisItem;
                    break;
                }
            }
            if (lastItemOfType != null){
                removedItem = lastItemOfType;
                inventoryItems.remove(lastItemOfType);
            }
        }
        return removedItem;
    }
    
    public void removeItem(Item item){
        inventoryItems.remove(item);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.capacity;
        hash = 37 * hash + Objects.hashCode(this.inventoryItems);
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
        final Inventory other = (Inventory) obj;
        if (this.capacity != other.capacity) {
            return false;
        }
        if (!Objects.equals(this.inventoryItems, other.inventoryItems)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Inventory{" + "capacity=" + capacity + ", inventoryItems=" + inventoryItems + '}';
    } 
    
    public void display(){
        Afghan_Trail.getOutFile().printf("%30s%n","Inventory");
        Afghan_Trail.getOutFile().printf("%-15s %-15s %-15s%n", "Name", "Type", "Price");
        Iterator<Item> iterator = inventoryItems.iterator();
        while (iterator.hasNext()) {
            Item thisItem = iterator.next();
            thisItem.display();
        }
    }
    
    public boolean hasItemType(String type){
        Iterator<Item> iterator = inventoryItems.iterator();
        boolean hasParts = false;
        while (iterator.hasNext()) {
            Item thisItem = iterator.next();
            String itemType = thisItem.getType();
            if (itemType == type)
                hasParts = true;
        }
        return hasParts;
    }
    
    public int getNumberOfItemsOfType(String type){
        Iterator<Item> iterator = inventoryItems.iterator();
        int numOfItems = 0;
        for (Item item : inventoryItems){
            String itemType = item.getType();
            if (itemType == type)
                numOfItems++;
        }
        return numOfItems;
    }
    
}

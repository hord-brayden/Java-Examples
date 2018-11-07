/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import afghan_trail.Afghan_Trail;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;
/**
 *
 * @author jonsi
 */
public class Item implements Serializable, Comparable {
    private String name;
    private String type;
    private int typeInt;
    private int quantity;
    private BigDecimal price;
    
    //med
    //food
    //parts
    //amo
    public static String[][] itemTypes = {
        //mediciine
        {"Penecillin","Advil","Cola","Tylenol","Leeches"},
        //food
        {"Lamb","Gyro","Beef","Mango","Carrot"},
        //parts
        {"Wheel","Axle","Strut","Spoke","Saddle"},
        //ammo
        {"round","shot","Shell","pellet","Bullet"}
    };

    public Item(){
        this.quantity = 1;
    }
    
    public Item(String name,int typeInt,BigDecimal price) {
        this.name = name;
        String type = "Food";
        switch (typeInt){
            case 0:
                type = "Medicine";
                break;
            case 1:
                type = "Food";
                break;
            case 2: 
                type = "Parts";
                break;
            case 3:
                type = "Ammo";
                break;
        }
        this.type = type;
        this.typeInt = typeInt;
        this.price = price;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.price);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", type=" + type + ", price=" + price + '}';
    }
    
    public void display(){
        Afghan_Trail.getOutFile().printf("%-15s %-15s %-15s%n", 
                name, type, "$" + String.format("%.2f", price));
    }
    
    public String getDisplayString(){
        String displayString = "";
        displayString += String.format("%-15s", name); 
        displayString += String.format("%-15s", type);
        displayString += "$" + String.format("%-15.2f", price);
        displayString += "\n";
        return displayString;
    }

    public static Comparator<Item> ItemNameComparator 
                      = new Comparator<Item>() {

        public int compare(Item item1, Item item2) {

          String name1 = item1.getName().toUpperCase();
          String name2 = item2.getName().toUpperCase();

          //ascending order
          return name1.compareTo(name2);
        }
    };
    
    public static Comparator<Item> ItemTypeComparator 
                      = new Comparator<Item>() {

        public int compare(Item item1, Item item2) {

          String type1 = item1.getType().toUpperCase();
          String type2 = item2.getType().toUpperCase();

          //ascending order
          return type1.compareTo(type2);
        }
    };

    @Override
    public int compareTo(Object compareItem) {
        String thisPriceStr = getPrice().toString();
        int thisPrice = (int) Double.parseDouble(thisPriceStr);
        String priceStr = ((Item) compareItem).getPrice().toString();
        int comparePrice = (int) Double.parseDouble(priceStr);
        return comparePrice - thisPrice;
    }
    
    
}

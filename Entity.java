import java.util.*;
/**
 * Character.java
 * This class describes a character.
 * @author Deniz Sert, Nic Campanile
 * @version February 20, 2018
 */
public class Entity extends NamedThing{
    private int health;
    private ArrayList<Item> backpack = new ArrayList<Item>();

    /**
     * @return returns the inventory as an ArrayList 
     */
    public ArrayList getBackpack(){
        return backpack;
    }
    

    public void setHealth(int h){
        this.health=h;
    }

    public int getHealth(){
        return health;
    }
    
    /**
     * adds items to inventory
     * @param i an item
     */
    public void addItem(Item i){ //adds item to backpack
        this.backpack.add(i);
        System.out.println("You've added this item to your backpack.");
    }
}
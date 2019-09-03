import java.util.*;
/**
 * Player.java
 * This class represents the perspective the user will have.
 * @author Deniz Sert, Nic Campanile
 * @version February 27, 2018
 */
public class Player extends Entity{
    public Player(){
        
    }
    
    public ArrayList getInventory(){
        return super.getBackpack();
    }

}
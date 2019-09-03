import java.util.*;
/**
 * Item.java
 * This class describes items characters can use.
 * @author Deniz Sert, Nic Campanile
 * @version February 20, 2018
 */
public class Item{
    //private Place place;
    private Character owner;
    private String soundFileName;
    
    
    public void makeSound(){
        Mp3Player player = new Mp3Player("/sounds/"+soundFileName);
        player.play();
    }
    
}
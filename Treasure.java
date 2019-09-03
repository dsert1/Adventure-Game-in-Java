/**
 * Treasure.java
 * This class represents the treasure object.
 * @author Deniz Sert, Nic Campanile
 * @version March 5, 2018
 */
public class Treasure extends Item{
    private int worth;
    
    
    public Treasure(){
       worth = (int)(Math.random()*100+1);
    }
    
    public void makeSound(){
        Mp3Player mp3 = new Mp3Player("coin.mp3");
        mp3.play();
    }
    
    public String toString(){
     return "Gems";   
    }
    
    public int getValue(){
     return worth;   
    }
}
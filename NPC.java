/**
 * NPC.java
 * This class represents a non player character
 * @author Deniz Sert, Nic Campanile
 * @verison February 27, 2018
 */
public class NPC extends Entity{
    private int AggressiveLevel;
    
    public NPC(){
        this.AggressiveLevel = (int)(Math.random() * 10) + 1;
    }
    
    public boolean fight() {
       double results = this.AggressiveLevel * Math.random();
       
       if (results > 5)
        return true;
       else
        return false;
       
    }
        
        
}

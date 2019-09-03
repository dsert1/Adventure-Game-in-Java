/**
 * Foe.java
 * This class represents a non player character
 * @author Deniz Sert, Nic Campanile
 * @verison February 27, 2018
 */
public class Foe extends Entity{
    private int AggressiveLevel;

    public Foe(){
        this.AggressiveLevel = (int)(Math.random() * 10) + 1;
    }

    
    /**
     * This method makes the NPC fight the player
     * @return true if the player won the fight
     * @return false if the player lost the fight
     */
    public boolean fight(int backpackItems) {
        double results = this.AggressiveLevel * Math.random();
        results-= (backpackItems * (Math.random() + 1));
        if (results > 5){
            System.out.println("You won!");
            return true;
        }
        else{
            System.out.println("You lose!");   
            return false;
        }
    }

}

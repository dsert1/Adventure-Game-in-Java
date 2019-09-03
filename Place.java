import java.util.*;
/**
 * Place.java
 * This class represents the various places things can be in
 * @author Deniz Sert, Nic Campanile
 * @version February 27, 2018
 */
public class Place extends NamedThing{
    private String name;
    private Weapon weapon=new Weapon();
    private Note n = new Note();

    /**
     * Constructs a Place object with a random weapon
     * @param _name the name of the place
     */
    public Place(String _name){
        name = _name;
        int r = (int)(Math.random()*3);
        if(r==0)
            weapon.setName("Bow");
        else if (r==1)
            weapon.setName("Sword");
        else if (r==2)
            weapon.setName("Dagger");
    }

    public String toString(){
        return name;
    }

    public Weapon getWeapon(){
        return weapon;
    }
    
    public String getName(){
        return name;
    }
}

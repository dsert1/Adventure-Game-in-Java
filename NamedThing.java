/**
 * NamedThing.java
 * This abstract class sets up more specialized classes.
 * @author Deniz Sert, Nic Campanile
 * @version February 20, 2018
 */
public abstract class NamedThing {
    private String name;
    private String description;

    public String getName(){
        return name;
    }

    public String toString(){
        return "Name: " + name + "\tDescription: " + description;
    }

}
